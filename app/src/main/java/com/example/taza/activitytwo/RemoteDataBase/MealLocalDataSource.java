package com.example.taza.activitytwo.RemoteDataBase;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.taza.activitytwo.model.FoodRandomDTO;
import com.example.taza.activitytwo.model.FoodRandomPojo;

import java.util.List;

public class MealLocalDataSource implements MealLocalDataSourceInterface {
    private MealDao dao;
    private static  MealLocalDataSource instance = null;
    private LiveData<List<FoodRandomDTO>> storedMeals;

    private MealLocalDataSource(Context context){
        MealDataBase db =MealDataBase.getInstance(context.getApplicationContext());
        dao = db.getMealDao();
        storedMeals = dao.getAllFavMeals();
    }
    public static MealLocalDataSource getInstance(Context context){
        if(instance==null){
            instance = new MealLocalDataSource(context);
        }
        return instance;
    }



    @Override
    public void insertMealToFav(FoodRandomDTO meal) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                dao.insertMealToFavorite(meal);
            }
        }).start();
    }

    @Override
    public void deleteMealFromFav(FoodRandomDTO meal) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                dao.deleteMealFromFavorite(meal);
            }
        }).start();

    }

    @Override
    public LiveData<List<FoodRandomDTO>> getAllStoredMeals() {
        return storedMeals;
    }

    @Override
    public LiveData<List<FoodRandomPojo>> getAllPlannedMeals(String date) {
        return dao.getAllPlannerMealsAtDate(date);
    }


    @Override
    public void insertMealToPlanner(FoodRandomPojo meal) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                dao.insertMealToPlanner(meal);
            }
        }).start();
    }

    @Override
    public void deleteMealFromPlanner(FoodRandomPojo meal) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                dao.deleteMealFromPlanner(meal);
            }
        }).start();
}
}
