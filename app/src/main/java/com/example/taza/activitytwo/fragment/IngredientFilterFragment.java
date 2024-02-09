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
import com.example.taza.activitytwo.fragment.searchbyname.presenter.PresenterAreaShow;
import com.example.taza.activitytwo.fragment.searchbyname.presenter.PresenterIngredientShow;
import com.example.taza.activitytwo.fragment.searchbyname.view.ViewShowIngredient;
import com.example.taza.activitytwo.model.FilterCatory;
import com.example.taza.activitytwo.remoteApi.RetrofitClient;

import java.util.ArrayList;


public class IngredientFilterFragment extends Fragment implements ViewShowIngredient {

    RecyclerView searchByIngredient;
    AdapterFilterCategory adapterFilterCategory;
    PresenterIngredientShow presenterIngredientShow;
    ArrayList<FilterCatory> meals;

    public IngredientFilterFragment() {
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
        return inflater.inflate(R.layout.fragment_ingredient_filter, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        meals=new ArrayList<>();
        searchByIngredient = view.findViewById(R.id.recyclerViewShowIngredient);
        adapterFilterCategory=new AdapterFilterCategory(meals);
        presenterIngredientShow=new PresenterIngredientShow(RetrofitClient.getInstance(),this);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        LinearLayoutManager layoutManagerr = new LinearLayoutManager(getContext());
        layoutManagerr.setOrientation(RecyclerView.VERTICAL);
        searchByIngredient.setLayoutManager(layoutManagerr);
        String getDataa= Search_by_nameFragmentArgs.fromBundle(getArguments()).getData();
        Log.i("TAG", "onViewCreated5242: "+getDataa);
        searchByIngredient.setAdapter(adapterFilterCategory);
        Log.i("TAG", "onViewCreated: "+getDataa);
        presenterIngredientShow.getFilterIngredient(getDataa);
        presenterIngredientShow.attachVieww(this);


    }

    @Override
    public void displayFilteIngredient(ArrayList<FilterCatory> meals) {
        adapterFilterCategory.setList(meals);
        adapterFilterCategory.notifyDataSetChanged();
    }

    @Override
    public void displayError(String errorMessage) {

    }
}