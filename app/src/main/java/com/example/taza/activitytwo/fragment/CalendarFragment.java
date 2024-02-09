package com.example.taza.activitytwo.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import com.example.taza.R;
import com.example.taza.activitytwo.RemoteDataBase.MealDataBase;
import com.example.taza.activitytwo.fragment.searchbyname.presenter.CalenderShow;
import com.example.taza.activitytwo.fragment.searchbyname.view.ViewCalenderInterFace;
import com.example.taza.activitytwo.model.FoodRandomDTO;
import com.example.taza.activitytwo.model.FoodRandomPojo;
import com.example.taza.activitytwo.onclichListenerfav.OnclicklistenerCalender;
import com.example.taza.activitytwo.remoteApi.realfire.FireBaseRealTimeWrapper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class CalendarFragment extends Fragment implements ViewCalenderInterFace, OnclicklistenerCalender {

    RecyclerView favoriteRecylerview;
 CalenderAdapter calenderAdapter;
    ArrayList<FoodRandomPojo> meals;
    CalenderShow calenderShow;
    CalendarView calendarView;
    MealDataBase mealDataBase;




    public CalendarFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            calenderShow=CalenderShow.getInstance(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calendar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        meals=new ArrayList<>();
        favoriteRecylerview = view.findViewById(R.id.mealWeekPlan_recyclerView_weekplan);

        calendarView = view.findViewById(R.id.calendarView);

        calenderAdapter=new CalenderAdapter(this,meals);
        favoriteRecylerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        favoriteRecylerview.setAdapter(calenderAdapter);

        Calendar selectedDate = Calendar.getInstance();
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                calenderShow.getAllPlanMeal(CalendarFragment.this, String.valueOf(dayOfMonth + "/" + (month + 1) + "/" + year));
            }
        });
    }


    @Override
    public void DisplayData(LiveData<List<FoodRandomPojo>> meals) {
        meals.observe(getViewLifecycleOwner(), new Observer<List<FoodRandomPojo>>() {
            @Override
            public void onChanged(List<FoodRandomPojo> foodRandomPojos) {
                if (foodRandomPojos != null && !foodRandomPojos.isEmpty()) {
                    calenderAdapter.setList(foodRandomPojos);
                    Log.i("TAG", "onChanged: " + foodRandomPojos.get(0).id);
                    calenderAdapter.notifyDataSetChanged();
                } else {
                    Log.i("TAG", "onChanged: List is empty");
                }
            }
        });
    }

    @Override
    public void onclick(FoodRandomPojo pojo) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                MealDataBase.getInstance(getContext()).getMealDao().deleteMealFromPlanner(pojo);
                FireBaseRealTimeWrapper.getInstance().removeMealFromPlanner(pojo.id);
            }
        }).start();
    }
}