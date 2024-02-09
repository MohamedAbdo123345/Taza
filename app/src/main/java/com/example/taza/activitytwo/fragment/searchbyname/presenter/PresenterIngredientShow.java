package com.example.taza.activitytwo.fragment.searchbyname.presenter;

import com.example.taza.activitytwo.fragment.searchbyname.view.ViewShowArea;
import com.example.taza.activitytwo.fragment.searchbyname.view.ViewShowIngredient;
import com.example.taza.activitytwo.model.FilterCatory;
import com.example.taza.activitytwo.remoteApi.ProductShowIngradiantCallback;
import com.example.taza.activitytwo.remoteApi.RetrofitClient;

import java.util.ArrayList;

public class PresenterIngredientShow implements PresenterIngredientShowface, ProductShowIngradiantCallback {
    private RetrofitClient apiClient;
    private ViewShowIngredient view;

    public PresenterIngredientShow(RetrofitClient apiClient, ViewShowIngredient viewShowIngredient) {
        this.apiClient = apiClient;
        this.view = viewShowIngredient;
    }

    @Override
    public void getFilterIngredient(String name) {apiClient.filterIngredient(this,name);

    }

    @Override
    public void attachVieww(ViewShowIngredient viewShowIngredient) {
         this.view=viewShowIngredient;
    }
    public void detachView() {
        this.view = null;
    }

    @Override
    public void onSuccessResultFilterIngredient(ArrayList<FilterCatory> meals) {
        if (view != null) {
            view.displayFilteIngredient(meals);
        }
    }

    @Override
    public void onFailureResult(String errorMessage) {

    }
}
