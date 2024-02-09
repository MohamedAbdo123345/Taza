package com.example.taza.activitytwo.remoteApi;

import com.example.taza.activitytwo.model.Category;
import com.example.taza.activitytwo.model.ListCategory;

import java.util.ArrayList;

import io.reactivex.rxjava3.core.Single;

public interface Apiclientinterface {
  void make (ProductCallback productCallback, String ingr);
  void makee (ProductCallback productCallback, String ingr);
  void  makearea(ProductCallback productCallback,String ingr);
  void serachName(ProductCallback productCallback,String ingr);

}
