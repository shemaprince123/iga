package com.example.igareg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class coursec extends AppCompatActivity {
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coursec);

        Button buttonDone = findViewById(R.id.button_done);
        Button buttonGoBack = findViewById(R.id.button_go_back);

        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(coursec.this, coursexam.class);
                startActivity(intent);
            }
        });

        buttonGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle Go Back button click
                onBackPressed(); // This will simulate the back button press
            }
        });

        //----------------------------------
        // Find the TextView where you want to display the content
        TextView textView = findViewById(R.id.contento);

        // Retrieve the HTML content from strings.xml and set it to the TextView
        String htmlContent = getString(R.string.content);
        textView.setText(Html.fromHtml(htmlContent));
        //------------------------------------------


        button = findViewById(R.id.logout);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent  = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });

    }
}


