package com.samfieldhawb.recipes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    public static final String RECIPE_POSITION = "recipe_pos";
    ImageView mRecipeImage;
    TextView mRecipeName,mRecipeHeadline,mRecipeDescription,mRecipeIngredient, mProtein,
            mCalories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }
}
