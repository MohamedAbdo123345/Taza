package com.example.taza.activitytwo.view;

import com.example.taza.activitytwo.model.Area;
import com.example.taza.activitytwo.model.Category;
import com.example.taza.activitytwo.model.FilterCatory;
import com.example.taza.activitytwo.model.FoodRandomDTO;
import com.example.taza.activitytwo.model.Ingredient;

import java.util.ArrayList;

public interface Viewk {
    void displayIngredients(ArrayList<Ingredient> ingredients);
    void displayCatagory(ArrayList<Category> categories);
    void disPlayArea(ArrayList<Area>meals);
    void displaySearchName(ArrayList<FoodRandomDTO>meals);
    void displayFiltercatgory(ArrayList<FilterCatory>meals);
    void displayError(String errorMessage);
}
