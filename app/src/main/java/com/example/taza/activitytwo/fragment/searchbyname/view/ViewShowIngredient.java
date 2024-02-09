package com.example.taza.activitytwo.fragment.searchbyname.view;

import com.example.taza.activitytwo.model.FilterCatory;

import java.util.ArrayList;

public interface ViewShowIngredient {
    void displayFilteIngredient(ArrayList<FilterCatory> meals);

    void displayError(String errorMessage);
}
