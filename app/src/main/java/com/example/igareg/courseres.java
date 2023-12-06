package com.example.igareg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class courseres extends AppCompatActivity {
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courseres);

        // Finding the "Back To Home Page" button by its ID
        Button buttonBackToHome = findViewById(R.id.viewResultsButton);

        // Retrieving results from Intent extras
        Intent intent = getIntent();
        String result1 = intent.getStringExtra("result1");
        String result2 = intent.getStringExtra("result2");
        String score = intent.getStringExtra("score"); // Retrieve the score


        // Displaying results
        TextView resultTextView = findViewById(R.id.user_details);
        resultTextView.setText("The Correct answers \n\n Q1 - " + result1 + "\n\n Q2 - " + result2 + "\n\n Score: " + score);

        // Setting an OnClickListener for the "Back To Home Page" button
        buttonBackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to navigate back to MainActivity
                Intent intent = new Intent(courseres.this, MainActivity.class);
                startActivity(intent);
            }
        });

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
