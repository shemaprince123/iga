package com.example.igareg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class kinyares extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kinyares);

        Button viewResultsButton = findViewById(R.id.viewResultsButton);

        viewResultsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to MainActivity or the home page
                Intent intent = new Intent(kinyares.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}