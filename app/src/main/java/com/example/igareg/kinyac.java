package com.example.igareg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class kinyac extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kinyac);

        Button doneButton = findViewById(R.id.button_done_kinyac);

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to kinyaxam activity
                Intent intent = new Intent(kinyac.this, kinyaxam.class);
                startActivity(intent);
            }
        });

        Button goBackButton = findViewById(R.id.button_go_back_kinyac);

        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the current activity to go back
                finish();
            }
        });
    }
}