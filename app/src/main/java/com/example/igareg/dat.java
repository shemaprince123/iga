package com.example.igareg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class dat extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat);

        Button buttonEnrollNow = findViewById(R.id.button_enroll_now);

        buttonEnrollNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to navigate to datc activity
                Intent intent = new Intent(dat.this, datc.class);
                startActivity(intent);
            }
        });
        //logoutButton
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