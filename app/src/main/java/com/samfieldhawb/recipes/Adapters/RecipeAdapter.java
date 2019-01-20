package com.samfieldhawb.recipes.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.samfieldhawb.recipes.DetailActivity;
import com.samfieldhawb.recipes.Models.Recipe;
import com.samfieldhawb.recipes.R;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeHolder> {

    List<Recipe> mRecipes;
    Context mContext;


    public RecipeAdapter( Context context,List<Recipe> recipes) {
        mRecipes = recipes;
        mContext = context;
    }

    @NonNull
    @Override
    public RecipeHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recipe_card,viewGroup,false);

        return new RecipeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeHolder recipeHolder, int i) {

        Recipe recipe = mRecipes.get(i);
        recipeHolder.mRecipeName.setText(recipe.getName());
        if(recipe.getRating() == null){
            recipeHolder.mRecipeRating.setRating(0);
        }else {
            recipeHolder.mRecipeRating.setRating((float) (recipe.getRating()/1));
        }
        Glide.with(mContext).load(recipe.getImage()).into(recipeHolder.mRecipeImage);

    }

    @Override
    public int getItemCount() {
        return mRecipes != null?mRecipes.size():0;
    }

    public void addRecipes(List<Recipe> recipes){
        for(Recipe recipe:recipes){
            addRecipe(recipe);
        }
    }
    public void addRecipe(Recipe recipe){
        mRecipes.add(recipe);
        notifyItemInserted(mRecipes.size());

    }

    class RecipeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView mRecipeImage;
        TextView mRecipeName;
        RatingBar mRecipeRating;
        public RecipeHolder(@NonNull View itemView) {
            super(itemView);
            mRecipeImage = itemView.findViewById(R.id.recipe_image);
            mRecipeName = itemView.findViewById(R.id.recipe_name);
            mRecipeRating = itemView.findViewById(R.id.recipe_rating);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mContext,DetailActivity.class);
            intent.putExtra(DetailActivity.RECIPE_POSITION,getAdapterPosition());
            mContext.startActivity(intent);
        }
    }
}
