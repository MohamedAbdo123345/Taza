package com.example.taza.activitytwo.RemoteDataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.taza.activitytwo.model.FoodRandomDTO;
import com.example.taza.activitytwo.model.FoodRandomPojo;

@Database(entities = {FoodRandomDTO.class, FoodRandomPojo.class},version = 1,exportSchema = false)
public abstract class MealDataBase extends RoomDatabase {
    private static MealDataBase instance = null;
    public abstract MealDao getMealDao();
    public static synchronized  MealDataBase getInstance(Context context){
        if(instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(), MealDataBase.class,"mealsdb").build();
        }
        return instance;
}
}
