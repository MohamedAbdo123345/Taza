package com.example.taza.activitytwo.fragment.searchbyname.presenter;

import android.content.Context;

import com.example.taza.activitytwo.RemoteDataBase.MealDataBase;
import com.example.taza.activitytwo.RemoteDataBase.MealLocalDataSource;
import com.example.taza.activitytwo.fragment.searchbyname.view.FavoriteViewInterface;
import com.example.taza.activitytwo.fragment.searchbyname.view.ViewCalenderInterFace;

public class CalenderShow implements CalenderInterface {
    MealDataBase mealDataBase;
    MealLocalDataSource mealLocalDataSource;
    private static CalenderShow instance = null;
    private CalenderShow(Context context){
        mealDataBase=MealDataBase.getInstance(context);
        mealLocalDataSource = MealLocalDataSource.getInstance(context);
    }
    public static synchronized CalenderShow getInstance(Context context){
        if(instance == null){
            instance=new CalenderShow(context);
        }
        return instance;
    }

    @Override
    public void getAllPlanMeal(ViewCalenderInterFace view,String date) {
        view.DisplayData(mealLocalDataSource.getAllPlannedMeals(date));
    }
}