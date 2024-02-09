package com.example.taza.activitytwo.remoteApi;

import com.example.taza.activitytwo.model.Category;
import com.example.taza.activitytwo.model.ListArea;
import com.example.taza.activitytwo.model.ListCategory;
import com.example.taza.activitytwo.model.ListFilterCategory;
import com.example.taza.activitytwo.model.ListIdIngredient;
import com.example.taza.activitytwo.model.ListfoodRandom;

import java.util.ArrayList;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface RetrofitMealsAPI {
    @GET("random.php")
    Call<ListfoodRandom> doGetListResources() ;
    @GET("categories.php")
    Call<ListCategory> doGetListResourcess();
    @GET("list.php?a=list")
    Call<ListArea>doGetListAea();
    @GET("list.php?i=list")
    Call<ListIdIngredient>doListIdIngredient();
    @GET("list.php?i=list")
    public Single<ListIdIngredient> getIngredients();
    @GET("categories.php")
    public Single<ListCategory> getCategories();
    @GET("list.php?a=list")
    public Single<ListArea> getCuisines();
    @GET("search.php")
    public Single<ListfoodRandom>doSearchName(@Query("s") String mealName);
    @GET("search.php")
    public Single<ListfoodRandom>doSearchNamee(@Query("s") String mealName);
   @GET("filter.php")
    public  Single<ListFilterCategory>dogetFilterCatgory(@Query("c") String mealName);
    @GET("filter.php")
    public  Single<ListFilterCategory>dogetFilterArea(@Query("a") String mealName);
    @GET("filter.php")
    public  Single<ListFilterCategory>dogetFilterIngredient(@Query("i") String mealName);

     @GET("lookup.php")
    public Single<ListfoodRandom>doSearchByid(@Query("i")String mealName);

//    @GET("categories.php")
//    public Single<ArrayList<Category>> getCategories();



}
