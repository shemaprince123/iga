package com.example.igareg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SearchResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        // Retrieve the search query from the intent
        String searchQuery = getIntent().getStringExtra("searchQuery");
        Log.d("SearchResult", "Received search query: " + searchQuery);

        // Retrieve the search query from the intent
        //String searchQuery = getIntent().getStringExtra("searchQuery");

        // Get the LinearLayout where you want to add search results
        LinearLayout resultsLayout = findViewById(R.id.resultsLayout);

        // Get the main LinearLayout containing the course ImageViews
        LinearLayout coursesLayout = findViewById(R.id.coursesLayout);

        // Loop through the ImageViews and check for matching tags
        for (int i = 0; i < coursesLayout.getChildCount(); i++) {
            if (coursesLayout.getChildAt(i) instanceof ImageView) {
                ImageView imageView = (ImageView) coursesLayout.getChildAt(i);
                String tag = String.valueOf(imageView.getTag());

                // Check if the tag matches the search query
                if (tag != null && tag.toLowerCase().contains(searchQuery.toLowerCase())) {
                    // Create a new ImageView and set its properties to match the matched ImageView
                    ImageView resultImageView = new ImageView(this);
                    resultImageView.setLayoutParams(new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT));
                    resultImageView.setImageDrawable(imageView.getDrawable());

                    // Add the matched ImageView to the resultsLayout
                    resultsLayout.addView(resultImageView);
                    // Set a click listener on the resultImageView to navigate to the corresponding course
                    resultImageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Perform the navigation based on the clicked search result
                            // Get the tag of the clicked ImageView and start the corresponding activity
                            String clickedTag = String.valueOf(v.getTag());
                            navigateToCourse(clickedTag);
                        }
                    });
                }
            }
        }
    }

    private void navigateToCourse(String tag) {
        Log.d("SearchResult", "Clicked tag: " + tag);
        // Depending on the tag or identifier of the clicked search result,
        // start the corresponding activity here using Intent
        Intent intent;
        if (tag != null) {
            if (tag.equals("imageView1")) {
                intent = new Intent(SearchResultActivity.this, course.class);
            } else if (tag.equals("kinyarwanda")) {
                intent = new Intent(SearchResultActivity.this, kinya.class);
            } else if (tag.equals("Data")) {
                intent = new Intent(SearchResultActivity.this, dat.class);
            } else if (tag.equals("full")) {
                intent = new Intent(SearchResultActivity.this, fsd.class);
            } else {
                // Default action if no match found for tag
                Log.d("SearchResult", "No matching course found for tag: " + tag);
                return;
            }
            startActivity(intent);
        } else {
            Log.d("SearchResult", "Clicked tag is null");
        }
    }
}