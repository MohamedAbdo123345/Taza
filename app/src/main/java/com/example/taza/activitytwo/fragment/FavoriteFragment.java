package com.example.taza.activitytwo.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taza.R;
import com.example.taza.activitytwo.RemoteDataBase.MealDataBase;
import com.example.taza.activitytwo.fragment.searchbyname.presenter.PresenterAreaShow;
import com.example.taza.activitytwo.fragment.searchbyname.presenter.Presenterfav;
import com.example.taza.activitytwo.fragment.searchbyname.view.FavoriteViewInterface;
import com.example.taza.activitytwo.model.FilterCatory;
import com.example.taza.activitytwo.model.FoodRandomDTO;
import com.example.taza.activitytwo.onclichListenerfav.OnclicklistenerFavorite;
import com.example.taza.activitytwo.remoteApi.RetrofitClient;
import com.example.taza.activitytwo.remoteApi.realfire.FireBaseRealTimeWrapper;

import java.util.ArrayList;
import java.util.List;


public class FavoriteFragment extends Fragment implements FavoriteViewInterface, OnclicklistenerFavorite {

    RecyclerView favoriteRecylerview;
   FavoriteAdaoter favoriteAdaoter;
    ArrayList<FoodRandomDTO>meals;

    Presenterfav presenterfav;
    public FavoriteFragment() {
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
        presenterfav=Presenterfav.getInstance(getActivity());
        return inflater.inflate(R.layout.fragment_favorite, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        meals=new ArrayList<>();
        favoriteRecylerview = view.findViewById(R.id.recyclerviewfavorite);
        favoriteAdaoter=new FavoriteAdaoter(this,meals);
        favoriteRecylerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        favoriteRecylerview.setAdapter(favoriteAdaoter);
        presenterfav.getAllFavMeals(this);
    }

    @Override
    public void DisplayData(LiveData<List<FoodRandomDTO>> meals) {
        meals.observe(getViewLifecycleOwner(), new Observer<List<FoodRandomDTO>>() {
            @Override
            public void onChanged(List<FoodRandomDTO> foodRandomDTOS) {
                favoriteAdaoter.setList(foodRandomDTOS);
            }
        });
    }

    @Override
    public void onclick(FoodRandomDTO dto) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                MealDataBase.getInstance(getContext()).getMealDao().deleteMealFromFavorite(dto);
                FireBaseRealTimeWrapper.getInstance().removeMealFromFav(dto.idMeal);
            }
        }).start();

    }
}