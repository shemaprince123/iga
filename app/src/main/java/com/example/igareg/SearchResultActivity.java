package com.example.igareg;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
            if (coursesLayout.getChildAt(i) instanceof LinearLayout) {
                LinearLayout rowLayout = (LinearLayout) coursesLayout.getChildAt(i);
                for (int j = 0; j < rowLayout.getChildCount(); j++) {
                    if (rowLayout.getChildAt(j) instanceof ImageView) {
                        ImageView imageView = (ImageView) rowLayout.getChildAt(j);
                        String tag = String.valueOf(imageView.getTag());

                        // Check if the tag matches the search query
                        if (tag != null && tag.toLowerCase().contains(searchQuery.toLowerCase())) {
                            // Create a new ImageView and set its properties to match the matched ImageView
                            ImageView resultImageView = new ImageView(this);
                            resultImageView.setLayoutParams(imageView.getLayoutParams());
                            resultImageView.setImageDrawable(imageView.getDrawable());

                            // Add the matched ImageView to the resultsLayout
                            resultsLayout.addView(resultImageView);
                        }
                    }
                }
            }
        }
    }
}
