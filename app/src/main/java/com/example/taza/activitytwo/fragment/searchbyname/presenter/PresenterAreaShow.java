package com.example.taza.activitytwo.fragment.searchbyname.presenter;

import com.example.taza.activitytwo.fragment.searchbyname.view.ViewFilter;
import com.example.taza.activitytwo.fragment.searchbyname.view.ViewShowArea;
import com.example.taza.activitytwo.model.FilterCatory;
import com.example.taza.activitytwo.remoteApi.ProductShowAreaCallback;
import com.example.taza.activitytwo.remoteApi.RetrofitClient;

import java.util.ArrayList;

public class PresenterAreaShow implements PresenterAreaShoww, ProductShowAreaCallback {
    private RetrofitClient apiClient;
    private ViewShowArea view;

    public PresenterAreaShow(RetrofitClient apiClient, ViewShowArea viewShowArea) {
        this.apiClient = apiClient;
        this.view = viewShowArea;
    }

    @Override
    public void getFilterArea(String name) {
        apiClient.filterArea(this ,name);
    }

    @Override
    public void attachVieww(ViewShowArea viewShowArea) {
        this.view=viewShowArea;

    }
    public void detachView() {
        this.view = null;
    }

    @Override
    public void onSuccessResultFilterarea(ArrayList<FilterCatory> meals) {
        if (view != null) {
            view.displayFilterArea(meals);
        }
    }

    @Override
    public void onFailureResult(String errorMessage) {

    }
}
