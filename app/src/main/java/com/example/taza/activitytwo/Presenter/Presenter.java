package com.example.taza.activitytwo.Presenter;

import android.view.View;

import com.example.taza.activitytwo.model.Area;
import com.example.taza.activitytwo.model.Category;
import com.example.taza.activitytwo.model.FilterCatory;
import com.example.taza.activitytwo.model.FoodRandomDTO;
import com.example.taza.activitytwo.model.Ingredient;
import com.example.taza.activitytwo.remoteApi.ProductCallBackFilter;
import com.example.taza.activitytwo.remoteApi.ProductCallback;
import com.example.taza.activitytwo.remoteApi.RetrofitClient;
import com.example.taza.activitytwo.view.Viewk;

import java.util.ArrayList;

import retrofit2.Retrofit;

public class Presenter implements repo, ProductCallback {
    private RetrofitClient apiClient;
    private Viewk view;

    public Presenter(RetrofitClient apiClient) {
        this.apiClient = apiClient;
    }

    @Override
    public void getIngredients() {
        apiClient.make( this, "list");
    }

    @Override
    public void getCategory() {apiClient.makee( this, "list");

    }





    public void getArea(){apiClient.makearea(this,"list");}
    public void getSaearchName(String name, View view){apiClient.doSerachName(this,name,view);}


    public void attachView(Viewk view) {
        this.view = view;
    }

    public void detachView() {
        this.view = null;
    }

    @Override
    public void onSuccessResult(ArrayList<Ingredient> meals) {
        if (view != null) {
            view.displayIngredients(meals);
        }

    }

    @Override
    public void onSuccessResultt(ArrayList<Category> categories) {
        if (view != null) {
            view.displayCatagory(categories);
        }

    }

    @Override
    public void onSuccessResultarea(ArrayList<Area> meals) {
        if (view != null) {
            view.disPlayArea(meals);
        }

    }

    @Override
    public void onSuccessResultSreachName(ArrayList<FoodRandomDTO> meals) {
        if (view != null) {
            view.displaySearchName(meals);
        }

    }



    @Override
    public void onFailureResult(String errorMessage) {
        if (view != null) {
            view.displayError(errorMessage);
        }
    }
}
