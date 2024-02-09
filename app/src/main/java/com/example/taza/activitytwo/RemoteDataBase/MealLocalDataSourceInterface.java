package com.example.taza.activitytwo.RemoteDataBase;

import androidx.lifecycle.LiveData;

import com.example.taza.activitytwo.model.FoodRandomDTO;
import com.example.taza.activitytwo.model.FoodRandomPojo;

import java.util.List;

public interface MealLocalDataSourceInterface {

    void insertMealToFav(FoodRandomDTO meal);
    void deleteMealFromFav(FoodRandomDTO meal);
    LiveData<List<FoodRandomDTO>> getAllStoredMeals();
    LiveData<List<FoodRandomPojo>> getAllPlannedMeals(String date);
    void insertMealToPlanner(FoodRandomPojo meal);
    void deleteMealFromPlanner(FoodRandomPojo meal);
}
