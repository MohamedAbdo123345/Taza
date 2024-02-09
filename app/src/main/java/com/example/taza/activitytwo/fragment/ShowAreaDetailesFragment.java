package com.example.taza.activitytwo.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taza.R;
import com.example.taza.activitytwo.fragment.searchbyname.Search_by_nameFragmentArgs;
import com.example.taza.activitytwo.fragment.searchbyname.presenter.PrasenterFilter;
import com.example.taza.activitytwo.fragment.searchbyname.presenter.PresenterAreaShow;
import com.example.taza.activitytwo.fragment.searchbyname.presenter.PresenterAreaShoww;
import com.example.taza.activitytwo.fragment.searchbyname.view.ViewFilter;
import com.example.taza.activitytwo.fragment.searchbyname.view.ViewShowArea;
import com.example.taza.activitytwo.model.FilterCatory;
import com.example.taza.activitytwo.remoteApi.RetrofitClient;

import java.util.ArrayList;


public class ShowAreaDetailesFragment extends Fragment implements ViewShowArea {
    RecyclerView searchByArea;
    AdapterFilterCategory adapterFilterCategory;
    PresenterAreaShow presenterAreaShoww;
    ArrayList<FilterCatory>meals;
    String getSearch;


    public ShowAreaDetailesFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_area_detailes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        meals=new ArrayList<>();
        searchByArea = view.findViewById(R.id.recyclerviewshowArea);
        adapterFilterCategory=new AdapterFilterCategory(meals);
        presenterAreaShoww=new PresenterAreaShow(RetrofitClient.getInstance(),this);

/////////////////////////////////////////////////////////////////////////////////////////////

        LinearLayoutManager layoutManagerr = new LinearLayoutManager(getContext());
        layoutManagerr.setOrientation(RecyclerView.VERTICAL);
        searchByArea.setLayoutManager(layoutManagerr);
        String getDataa= Search_by_nameFragmentArgs.fromBundle(getArguments()).getData();
        Log.i("TAG", "onViewCreated5242: "+getDataa);
        searchByArea.setAdapter(adapterFilterCategory);
        Log.i("TAG", "onViewCreated: "+getDataa);
        presenterAreaShoww.getFilterArea(getDataa);
        presenterAreaShoww.attachVieww(this);
        ///////////////////////////////////////////////////////////////////////////////
    }


    @Override
    public void displayFilterArea(ArrayList<FilterCatory> meals) {

        adapterFilterCategory.setList(meals);
        adapterFilterCategory.notifyDataSetChanged();
    }

    @Override
    public void displayError(String errorMessage) {

    }
}