package com.example.taza.activitytwo.RemoteDataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.taza.activitytwo.model.FoodRandomDTO;
import com.example.taza.activitytwo.model.FoodRandomPojo;

import java.util.List;

@Dao
public interface MealDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertMealToFavorite(FoodRandomDTO meal);

    @Query("SELECT * From meals_table")
    LiveData<List<FoodRandomDTO>> getAllFavMeals();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAllMealsToFavorite(List<FoodRandomDTO> meals);

    @Query("SELECT * FROM meals_table where idMeal =:idMeal")
    LiveData<FoodRandomDTO> getFavMealById(String idMeal);

    @Delete
    void deleteMealFromFavorite(FoodRandomDTO meal);

    @Query("delete From meals_table")
    void deleteAllMealsFromFavorite();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertMealToPlanner(FoodRandomPojo meal);

    @Query("SELECT * FROM planner where date=:date")
    LiveData<List<FoodRandomPojo>> getAllPlannerMealsAtDate(String date);

    @Query("SELECT * FROM planner")
    LiveData<List<FoodRandomPojo>> getAllPlannerMeals();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAllMealsToPlanner(List<FoodRandomPojo> planners);

    @Query("SELECT * FROM planner where id=:id")
    LiveData<FoodRandomPojo> getPlannerMealById(String id);

    @Delete
    void deleteMealFromPlanner(FoodRandomPojo planner);

    @Query("delete from planner")
    void deleteAllPlannerMeals();


}
