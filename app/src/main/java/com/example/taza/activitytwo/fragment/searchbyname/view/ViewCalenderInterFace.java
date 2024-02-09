package com.example.taza.activitytwo.fragment.searchbyname.view;

import androidx.lifecycle.LiveData;

import com.example.taza.activitytwo.model.FoodRandomDTO;
import com.example.taza.activitytwo.model.FoodRandomPojo;

import java.util.List;

public interface ViewCalenderInterFace {
    public void DisplayData(LiveData<List<FoodRandomPojo>> meals);
}
