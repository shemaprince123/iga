package com.example.igareg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.firebase.auth.FirebaseAuth;

public class pay extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        // Initialize WebView
        webView = findViewById(R.id.webView);

        // Enable JavaScript (if required for your web content)
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Load a URL into WebView
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://shemaprince123.github.io/paystack.github.io/");

        // Logout button
        findViewById(R.id.logout).setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            // Replace 'Login' with your login activity
            startActivity(new Intent(pay.this, Login.class));
            finish();
        });

    }
}