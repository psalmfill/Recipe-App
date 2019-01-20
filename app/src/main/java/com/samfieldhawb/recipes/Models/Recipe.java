package com.samfieldhawb.recipes.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Recipe {
    @SerializedName("calories")
    @Expose
    private String calories;
    @SerializedName("carbos")
    @Expose
    private String carbos;
    @SerializedName("card")
    @Expose
    private String card;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("deliverable_ingredients")
    @Expose
    private List<String> deliverableIngredients = null;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("difficulty")
    @Expose
    private Integer difficulty;
    @SerializedName("fats")
    @Expose
    private String fats;
    @SerializedName("favorites")
    @Expose
    private Integer favorites;
    @SerializedName("fibers")
    @Expose
    private String fibers;
    @SerializedName("headline")
    @Expose
    private String headline;
    @SerializedName("highlighted")
    @Expose
    private Boolean highlighted;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("incompatibilities")
    @Expose
    private Object incompatibilities;
    @SerializedName("ingredients")
    @Expose
    private List<String> ingredients = null;
    @SerializedName("keywords")
    @Expose
    private List<String> keywords = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("products")
    @Expose
    private List<String> products = null;
    @SerializedName("proteins")
    @Expose
    private String proteins;
    @SerializedName("rating")
    @Expose
    private Double rating;
    @SerializedName("ratings")
    @Expose
    private Integer ratings;
    @SerializedName("thumb")
    @Expose
    private String thumb;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("undeliverable_ingredients")
    @Expose
    private List<Object> undeliverableIngredients = null;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("weeks")
    @Expose
    private List<String> weeks = null;

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }
}
