package com.example.taza.activitytwo.fragment.searchbyname.presenter;

import com.example.taza.activitytwo.fragment.searchbyname.view.ViewFilter;
import com.example.taza.activitytwo.fragment.searchbyname.view.ViewShowArea;

public interface PresenterAreaShoww {
    void getFilterArea(String name);
    void attachVieww(ViewShowArea viewShowArea);
}
