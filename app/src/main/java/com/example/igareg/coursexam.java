package com.example.igareg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.google.firebase.auth.FirebaseAuth;

public class coursexam extends AppCompatActivity {

    Button button;

    // Variables to track correct answers
    int score = 0;
    int totalQuestions = 2; // Total number of questions


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coursexam);

        // Finding the "Done" button by its ID
        Button buttonDone = findViewById(R.id.doneButton);

        // Setting an OnClickListener for the "Done" button
        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Check if Option A is selected for Question 1
                RadioButton optionARadioButton1 = findViewById(R.id.optionARadioButton1);
                if (optionARadioButton1.isChecked()) {
                    score++;
                }

                // Check if Option A is selected for Question 2
                RadioButton optionARadioButton2 = findViewById(R.id.optionARadioButton2);
                if (optionARadioButton2.isChecked()) {
                    score++;
                }

                // Intent to navigate to courseres
                Intent intent = new Intent(coursexam.this, courseres.class);
                // Sending the results and score to courseres activity
                intent.putExtra("result1", optionARadioButton1.isChecked() ? "A" : "Not A");
                intent.putExtra("result2", optionARadioButton2.isChecked() ? "A" : "Not A");
                intent.putExtra("score", score + "/" + totalQuestions); // Sending the score
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