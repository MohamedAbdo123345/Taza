package com.example.taza.activitytwo.fragment.searchbyname.presenter;

import com.example.taza.activitytwo.model.FoodRandomDTO;
import com.example.taza.activitytwo.remoteApi.ProductCallBcklistfood;

import java.util.ArrayList;

public class PrersenterSearchCategory implements ProductCallBcklistfood {

    @Override
    public ArrayList<FoodRandomDTO> onSuccessResultlistfoode(ArrayList<FoodRandomDTO> meals) {




        return meals;
    }


}
