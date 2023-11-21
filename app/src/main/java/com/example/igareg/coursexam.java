package com.example.igareg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class coursexam extends AppCompatActivity {

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
                startActivity(intent);
            }
        });
    }
}