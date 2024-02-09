package com.example.taza.activitytwo.remoteApi;

import com.example.taza.activitytwo.model.FilterCatory;

import java.util.ArrayList;

public interface ProductCallBackFilter {
    void onSuccessResultFilterCategory(ArrayList<FilterCatory> meals);

    void onFailureResult(String errorMessage);
}
