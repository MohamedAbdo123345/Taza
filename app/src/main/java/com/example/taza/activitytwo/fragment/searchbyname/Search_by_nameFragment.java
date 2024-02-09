package com.example.taza.activitytwo.fragment.searchbyname;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taza.R;
import com.example.taza.activitytwo.Presenter.Presenter;
import com.example.taza.activitytwo.fragment.AdapterFilterCategory;
import com.example.taza.activitytwo.fragment.FilterAreaAdapter;
import com.example.taza.activitytwo.fragment.MyAdapter;
import com.example.taza.activitytwo.fragment.SearchFragmentDirections;
import com.example.taza.activitytwo.fragment.searchbyname.presenter.PrasenterFilter;
import com.example.taza.activitytwo.fragment.searchbyname.presenter.PrasenterFilterr;
import com.example.taza.activitytwo.fragment.searchbyname.view.ViewFilter;
import com.example.taza.activitytwo.model.FilterCatory;
import com.example.taza.activitytwo.model.FoodRandomDTO;
import com.example.taza.activitytwo.model.ListfoodRandom;
import com.example.taza.activitytwo.onclichListenerfav.OnClickListenerAreaToDetails;
import com.example.taza.activitytwo.remoteApi.RetrofitClient;

import java.util.ArrayList;


public class Search_by_nameFragment extends Fragment implements ViewFilter, OnClickListenerAreaToDetails {

RecyclerView searchByNameCat,searchByArea;
AdapterFilterCategory adapterFilterCategory;
FilterAreaAdapter filterAreaAdapter;
PrasenterFilterr presenterr,presenter;
Presenter searchByname;
ArrayList<FilterCatory>meals;
ArrayList<FilterCatory>mealsf;
ArrayList<FoodRandomDTO> mealsll;
    public Search_by_nameFragment() {
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
        return inflater.inflate(R.layout.fragment_search_by_name, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        meals=new ArrayList<>();
        searchByNameCat = view.findViewById(R.id.searchByNameCat);
        adapterFilterCategory=new AdapterFilterCategory(meals);
        presenterr=new PrasenterFilter(RetrofitClient.getInstance(),this);

        mealsf=new ArrayList<>();
        searchByArea=view.findViewById(R.id.serachByArea);
        filterAreaAdapter=new FilterAreaAdapter(meals);
        presenter=new PrasenterFilter(RetrofitClient.getInstance(),this);
        searchByname=new Presenter(RetrofitClient.getInstance());

///////////////////////////////////////////////////////////////////////////////////////////////////////////
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        searchByNameCat.setLayoutManager(layoutManager);
        String getData=Search_by_nameFragmentArgs.fromBundle(getArguments()).getData();
        searchByNameCat.setAdapter(adapterFilterCategory);
        Log.i("TAG", "onViewCreated: "+getData);
       presenterr.getFiltercategory(getData);
       presenterr.attachVieww(this);
       mealsll=new ArrayList<>();
       /////////////////////////////////////////////////////////////////////////////////////////////////


    }

    @Override
    public void displayFiltercatgory(ArrayList<FilterCatory> meals) {
        adapterFilterCategory.setList(meals);
        adapterFilterCategory.notifyDataSetChanged();
    }



    @Override
    public void displayError(String errorMessage) {

    }

    @Override
    public void onclick(String name) {
       // View view = getView();
//        searchByname.getSaearchName(name,view);
//        Search_by_nameFragmentDirections.ActionSearchByNameFragmentToDatilesFragment action=Search_by_nameFragmentDirections
//                .actionSearchByNameFragmentToDatilesFragment(item.meals.get(0));
//        Navigation.findNavController().navigate(action);


    }
}