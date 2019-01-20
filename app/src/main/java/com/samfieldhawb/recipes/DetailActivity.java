package com.samfieldhawb.recipes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.samfieldhawb.recipes.Models.Recipe;

public class DetailActivity extends AppCompatActivity {
    public static final String RECIPE_POSITION = "recipe_pos";
    ImageView mRecipeImage;
    TextView mRecipeName,mRecipeHeadline,mRecipeDescription,mRecipeIngredient, mProtein,
            mCalories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mRecipeImage = findViewById(R.id.recipe_image);
        mRecipeName = findViewById(R.id.recipe_name);
        mRecipeHeadline = findViewById(R.id.recipe_headline);
        mRecipeDescription = findViewById(R.id.recipe_description);
        mRecipeIngredient = findViewById(R.id.recipe_ingredient);
        mProtein = findViewById(R.id.protein);
        mCalories = findViewById(R.id.calories);
        Intent intent= getIntent();
        if(intent != null){
            int pos = intent.getIntExtra(RECIPE_POSITION,0);
            Recipe recipe = MainActivity.getRecipe(pos);
            Glide.with(this).load(recipe.getImage()).into(mRecipeImage);
            mRecipeName.setText(recipe.getName());
            mRecipeHeadline.setText(recipe.getHeadline());
            mRecipeDescription.setText(recipe.getDescription());
            mRecipeIngredient.setText(recipe.getIngredients().toString());
            mProtein.setText(recipe.getProteins());
            mCalories.setText(recipe.getCalories());



        }
    }
}
