package com.example.taza.activitytwo.fragment.searchbyname.presenter;

import com.example.taza.activitytwo.fragment.searchbyname.view.ViewFilter;

public interface PrasenterFilterr {
    void getFiltercategory(String name);

    void attachVieww(ViewFilter viewFilter);
}
