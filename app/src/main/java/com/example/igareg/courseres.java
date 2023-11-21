package com.example.igareg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class courseres extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courseres);

        // Finding the "Back To Home Page" button by its ID
        Button buttonBackToHome = findViewById(R.id.viewResultsButton);

        // Setting an OnClickListener for the "Back To Home Page" button
        buttonBackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to navigate back to MainActivity
                Intent intent = new Intent(courseres.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
