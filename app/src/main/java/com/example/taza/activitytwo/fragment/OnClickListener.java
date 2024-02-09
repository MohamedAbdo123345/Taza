package com.example.taza.activitytwo.fragment;

import com.example.taza.activitytwo.model.Category;
import com.example.taza.activitytwo.model.FoodRandomDTO;

public interface OnClickListener {
    public void onClick(FoodRandomDTO dto);
    public void onClickk(String dto);
    public void onClickArea(String dto);
    public  void onClickIngredient(String dto);
}
