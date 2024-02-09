package com.example.taza.activitytwo.fragment.searchbyname.presenter;

import android.content.Context;

import com.example.taza.activitytwo.RemoteDataBase.MealDataBase;
import com.example.taza.activitytwo.RemoteDataBase.MealLocalDataSource;
import com.example.taza.activitytwo.fragment.searchbyname.view.FavoriteViewInterface;

public class Presenterfav implements PresenterFavInterface {
    MealDataBase mealDataBase;
    MealLocalDataSource mealLocalDataSource;
    private static Presenterfav instance = null;

    private Presenterfav(Context context) {
        mealLocalDataSource = MealLocalDataSource.getInstance(context);
       mealDataBase=MealDataBase.getInstance(context);
    }
    public static synchronized Presenterfav getInstance(Context context){
        if(instance == null){
            instance = new Presenterfav(context);
        }
        return instance;
    }

    @Override
    public void getAllFavMeals(FavoriteViewInterface view) {

//        view.DisplayData(mealDataBase.getMealDao().getAllFavMeals());
        view.DisplayData(mealLocalDataSource.getAllStoredMeals());
    }





}
