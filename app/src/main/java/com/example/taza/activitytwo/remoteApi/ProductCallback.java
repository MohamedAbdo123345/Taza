package com.example.taza.activitytwo.remoteApi;

import com.example.taza.activitytwo.model.Area;
import com.example.taza.activitytwo.model.Category;
import com.example.taza.activitytwo.model.FilterCatory;
import com.example.taza.activitytwo.model.FoodRandomDTO;
import com.example.taza.activitytwo.model.Ingredient;
import com.example.taza.activitytwo.model.ListIdIngredient;

import java.util.ArrayList;
import java.util.List;

public interface ProductCallback {
    void onSuccessResult(ArrayList<Ingredient> meals);
    void onSuccessResultt(ArrayList<Category> categories);
    void onSuccessResultarea(ArrayList<Area>meals);
    void onSuccessResultSreachName(ArrayList<FoodRandomDTO>meals);

    void onFailureResult(String errorMessage);
}
