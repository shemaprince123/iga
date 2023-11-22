package com.example.igareg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class kinya extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kinya);

        // Find the Enroll Now Button
        Button enrollNowButton = findViewById(R.id.enrollNowButton);

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
    }
}
