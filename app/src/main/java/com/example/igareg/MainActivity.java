package com.example.igareg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;
    Button button;
    TextView textView;
    FirebaseUser user;
    EditText searchEditText;
    Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();
        button = findViewById(R.id.logout);
        textView = findViewById(R.id.user_details);
        user = auth.getCurrentUser();
        if (user==null){
            Intent intent  = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        }
        else {
            textView.setText(user.getEmail());
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent  = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });

        // Inside onCreate method after initializing your views
        ImageView imageView1 = findViewById(R.id.imageView1);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, course.class);
                startActivity(intent);
            }
        });


        ImageView imageView2 = findViewById(R.id.imageView2);

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, kinya.class);
                startActivity(intent);
            }
        });


        ImageView imageView3 = findViewById(R.id.imageView3);

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, dat.class);
                startActivity(intent);
            }
        });


        ImageView imageView4 = findViewById(R.id.imageView4);

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, fsd.class);
                startActivity(intent);
            }
        });


        // Initialize search views
        searchEditText = findViewById(R.id.editText_search);
        searchButton = findViewById(R.id.button_search);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchQuery = searchEditText.getText().toString().trim();

                if (!searchQuery.isEmpty()) {
                    // Perform search based on the query
                    performSearch(searchQuery);
                } else {
                    // Handle empty search query
                    Toast.makeText(MainActivity.this, "Please enter a search term", Toast.LENGTH_SHORT).show();
                }
            }
        });





    }

//
//    // Method to perform the search action
    private void performSearch(String searchQuery) {
        Intent searchIntent = new Intent(MainActivity.this, SearchResultActivity.class);
        searchIntent.putExtra("searchQuery", searchQuery);
        startActivity(searchIntent);

        LinearLayout coursesLayout = findViewById(R.id.coursesLayout);

        for (int i = 0; i < coursesLayout.getChildCount(); i++) {
            if (coursesLayout.getChildAt(i) instanceof LinearLayout) {
                LinearLayout rowLayout = (LinearLayout) coursesLayout.getChildAt(i);
                for (int j = 0; j < rowLayout.getChildCount(); j++) {
                    if (rowLayout.getChildAt(j) instanceof ImageView) {
                        ImageView imageView = (ImageView) rowLayout.getChildAt(j);
                        String tag = String.valueOf(imageView.getTag());

                        // Check if the tag matches the search query
                        if (tag != null && tag.toLowerCase().contains(searchQuery.toLowerCase())) {
                            Log.d("SearchResult", "Match found: " + tag);

                            // Perform your desired action with the matched ImageView here
                            // For example, change the ImageView's appearance or store the result
                            // imageView.setBackgroundColor(Color.YELLOW);
                        } else {
                            Log.d("SearchResult", "No match for: " + searchQuery + " in tag: " + tag);
                        }
                    }
                }
            }
        }
        // Start the SearchResultActivity after the loop finishes (outside the loop)
        //startActivity(searchIntent);
    }

}

