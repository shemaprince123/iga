package com.example.igareg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class coursexam extends AppCompatActivity {

    Button button;


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
                // Intent to navigate to courseres
                Intent intent = new Intent(coursexam.this, courseres.class);
                // Sending the results to courseres activity
                intent.putExtra("result1", "A");
                intent.putExtra("result2", "A");
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