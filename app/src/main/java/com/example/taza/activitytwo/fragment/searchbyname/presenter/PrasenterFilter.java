package com.example.taza.activitytwo.fragment.searchbyname.presenter;

import com.example.taza.activitytwo.fragment.searchbyname.view.ViewFilter;
import com.example.taza.activitytwo.model.FilterCatory;
import com.example.taza.activitytwo.remoteApi.ProductCallBackFilter;
import com.example.taza.activitytwo.remoteApi.RetrofitClient;

import java.util.ArrayList;

public class PrasenterFilter implements PrasenterFilterr, ProductCallBackFilter {
    private RetrofitClient apiClient;
    private ViewFilter view;
    public PrasenterFilter(RetrofitClient apiClient,ViewFilter view) {this.apiClient = apiClient;
    this.view=view;}
    @Override
    public void getFiltercategory(String name) {apiClient.filterCategory(this,name);}

    public void attachVieww(ViewFilter viewFilter) {
        this.view=viewFilter;}

    public void detachView() {
        this.view = null;
    }

    @Override
    public void onSuccessResultFilterCategory(ArrayList<FilterCatory> meals) {
        if (view != null) {
            view.displayFiltercatgory(meals);
        }
    }



    @Override
    public void onFailureResult(String errorMessage) {

    }
}
