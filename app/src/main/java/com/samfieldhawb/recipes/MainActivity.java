package com.samfieldhawb.recipes;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.samfieldhawb.recipes.Adapters.RecipeAdapter;
import com.samfieldhawb.recipes.Api.Client;
import com.samfieldhawb.recipes.Api.Service;
import com.samfieldhawb.recipes.Models.Recipe;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecipeRv;
    RecipeAdapter mAdapter;
    static List<Recipe> mRecipes;
    Service mService;
    ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("fetching recipes");
        mProgressDialog.setCancelable(false);
        mRecipes = new ArrayList<>();
        mAdapter = new RecipeAdapter(this,mRecipes);
        mRecipeRv = findViewById(R.id.recipe_rv);
        mRecipeRv.setAdapter(mAdapter);
        mRecipeRv.setLayoutManager(new GridLayoutManager(this,2));
        mService = Client.getInstance().create(Service.class);
        fetchRecipes();
    }
    public void fetchRecipes(){
        mProgressDialog.show();
        Call<List<Recipe>> getRecipes = mService.getRecipes();
        getRecipes.enqueue(new Callback<List<Recipe>>() {
            @Override
            public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
                mRecipes = response.body();
                mAdapter.addRecipes(mRecipes);
                mProgressDialog.dismiss();

            }

            @Override
            public void onFailure(Call<List<Recipe>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Fail Loading Recipes",Toast.LENGTH_SHORT).show();
            }
        });
    }


    public static Recipe getRecipe(int pos){
        return mRecipes.get(pos);
    }
}
