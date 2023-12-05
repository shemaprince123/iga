package com.example.igareg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;

public class kinya extends AppCompatActivity {
    Button button;

    private static final String CLIENT_ID = "AdSBmJNjSzDJjiifz_FklctekP0PfIdqRVJ3kXoVp5GjD2JQhD1xpyA8ZbAyqPn1G46lcAmqDbLFSK89";
    private EditText amountEdt;
    private Button subscribeBtn;

    public static final int PAYPAL_REQUEST_CODE = 123;
    private static PayPalConfiguration config = new PayPalConfiguration().environment(PayPalConfiguration.ENVIRONMENT_SANDBOX).clientId(CLIENT_ID);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kinya);

        // Find the Enroll Now Button
        Button enrollNowButton = findViewById(R.id.enrollNowButton);

        //pay button
        subscribeBtn = findViewById(R.id.idBtnMakePayment);

        subscribeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePayment("1");
            }
        });

        // Set OnClickListener
        enrollNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform action when Enroll Now Button is clicked
                // For example, navigate to kinyac activity
                Intent intent = new Intent(kinya.this, kinyac.class);
                startActivity(intent);
            }
        });

        //logout
        button = findViewById(R.id.logoutButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent  = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });

        Intent intent = new Intent(this, PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        startService(intent);



    }

    private void makePayment(String amount) {
        // Convert the passed amount to BigDecimal if needed
        BigDecimal paymentAmount = new BigDecimal(amount);

        //PayPalPayment payment = new PayPalPayment(paymentAmount, "USD", "Course Fees", PayPalPayment.PAYMENT_INTENT_SALE);
        //payment.receiver(recipientEmail); // Set the recipient's email here

        PayPalPayment payment = new PayPalPayment(paymentAmount, "USD", "Course Fees", PayPalPayment.PAYMENT_INTENT_SALE);

        Intent intent = new Intent(this, PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, payment);
        startActivityForResult(intent, PAYPAL_REQUEST_CODE);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PAYPAL_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                PaymentConfirmation confirm = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
                if (confirm != null) {
                    try {
                        String paymentDetails = confirm.toJSONObject().toString(4);
                        JSONObject payObj = new JSONObject(paymentDetails);
                        String payID = payObj.getJSONObject("response").getString("id");
                        String state = payObj.getJSONObject("response").getString("state");
                        Toast.makeText(this, "Payment : " + state + " with payment id is : " + payID, Toast.LENGTH_SHORT).show();
                    } catch (JSONException e) {
                        Log.e("Error", "An unlikely failure occurred: ", e);
                    }
                }
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "User canceled the payment..", Toast.LENGTH_SHORT).show();
            } else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID) {
                Toast.makeText(this, "Invalid payment configuration submitted..", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
