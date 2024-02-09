package com.example.taza.activitytwo.fragment.searchbyname.view;

import androidx.lifecycle.LiveData;

import com.example.taza.activitytwo.model.FoodRandomDTO;

import java.util.List;

public interface FavoriteViewInterface {
    public void DisplayData(LiveData<List<FoodRandomDTO>> meals);
}
