package com.example.taza.activitytwo.fragment.searchbyname.presenter;

import com.example.taza.activitytwo.fragment.searchbyname.view.ViewShowArea;
import com.example.taza.activitytwo.fragment.searchbyname.view.ViewShowIngredient;

public interface PresenterIngredientShowface {
    void getFilterIngredient(String name);
    void attachVieww(ViewShowIngredient viewShowIngredient);
}
