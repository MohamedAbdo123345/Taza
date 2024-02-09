package com.example.taza.activitytwo.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.taza.R;
import com.example.taza.activitytwo.Presenter.Presenter;
import com.example.taza.activitytwo.fragment.searchbyname.onMealClickListener;
import com.example.taza.activitytwo.model.Area;
import com.example.taza.activitytwo.model.Category;
import com.example.taza.activitytwo.model.FilterCatory;
import com.example.taza.activitytwo.model.FoodRandomDTO;
import com.example.taza.activitytwo.model.Ingredient;
import com.example.taza.activitytwo.model.ListArea;
import com.example.taza.activitytwo.model.ListCategory;
import com.example.taza.activitytwo.model.ListIdIngredient;
import com.example.taza.activitytwo.remoteApi.RetrofitClient;
import com.example.taza.activitytwo.remoteApi.RetrofitMealsAPI;
import com.example.taza.activitytwo.view.Viewk;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class SearchFragment extends Fragment implements Viewk,OnClickListener {
Presenter presenter,presenterr,presenteru,presentername;
    Retrofit retrofitt,retrofitk,retrofitl;
    ArrayList<Category> listt;
    ArrayList<FoodRandomDTO>list;
    RecyclerView recyclerView, recyclerVieww, recyclerViewl ,recyclerViewname ;
    ArrayList<Area>listAraa;
    ArrayList<FoodRandomDTO>meals;
    ArrayList<Ingredient>listIngredient;
    EditText searchText;
    MyAdaptert myAdaptert;
    MyAdapter myAdapter;
    MyAdapterr myAdapterr;
    MyAdapterSname myAdapterSname;
    ArrayList<Ingredient> ingredients;
    CardView cardView;
    public static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listIngredient=new ArrayList<>();
        recyclerViewname=new RecyclerView(getContext());
        recyclerView=new RecyclerView(getContext());
        list=new ArrayList<FoodRandomDTO>();
        recyclerVieww=new RecyclerView(getContext());
        recyclerViewl=new RecyclerView(getContext());
        myAdaptert=new MyAdaptert( listIngredient,this);
        presenter=new Presenter(RetrofitClient.getInstance());
        presenterr=new Presenter(RetrofitClient.getInstance());
        presenteru=new Presenter(RetrofitClient.getInstance());
        ingredients=new ArrayList<>();
        listt=new ArrayList<Category>();
        myAdapter=new MyAdapter(listt,this);
        listAraa=new ArrayList<Area>();
        myAdapterr=new MyAdapterr(listAraa,this);
        meals=new ArrayList<FoodRandomDTO>();
        myAdapterSname=new MyAdapterSname(meals,this);
        presentername=new Presenter(RetrofitClient.getInstance());




//        listIngredient=new ArrayList<>();

       searchText=view.findViewById(R.id.textsearch);
       searchText.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {
               presentername.getSaearchName(searchText.getText().toString(),view);
               recyclerView.setVisibility(View.GONE);
               recyclerVieww.setVisibility(View.GONE);
               recyclerViewl.setVisibility(View.GONE);
           }

           @Override
           public void afterTextChanged(Editable s) {

           }
       });
/////////////////////////////////////////////
        recyclerView = view.findViewById(R.id.recyclerView5);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        Log.i("TAG", "onViewCreated5245: "+"jcnjnckjs");
     recyclerView.setAdapter(myAdapter);
        Log.i("TAG", "onViewCreated5245: "+"mmmmmmmmmmmmm");
     presenterr.attachView(this);
        presenterr.getCategory();
        ///////////////////////////////

         recyclerVieww = view.findViewById(R.id.recycleriewcounterysearch);
        LinearLayoutManager layoutManagerr = new LinearLayoutManager(requireContext());
        layoutManagerr.setOrientation(RecyclerView.HORIZONTAL);
        recyclerVieww.setLayoutManager(layoutManagerr);
        recyclerVieww.setAdapter(myAdapterr);
        presenteru.attachView(this);
        presenteru.getArea();



        ///////////////////////////////////
        recyclerViewl = view.findViewById(R.id.recycleriewingredientsearch);
        LinearLayoutManager layoutManagerl = new LinearLayoutManager(getContext());
        layoutManagerl.setOrientation(RecyclerView.HORIZONTAL);
        recyclerViewl.setLayoutManager(layoutManagerl);
        recyclerViewl.setAdapter(myAdaptert);

        presenter.attachView(this);

        presenter.getIngredients();
        //////////////////////////////////////////
         recyclerViewname = view.findViewById(R.id.searchnbyname);
        LinearLayoutManager layoutManagername = new LinearLayoutManager(getContext());
        layoutManagername.setOrientation(RecyclerView.VERTICAL);
        recyclerViewname.setLayoutManager(layoutManagername);
        recyclerViewname.setAdapter(myAdapterSname);

        presentername.attachView(this);




        //////////////////////////////////////////////////////////



    }

    @Override
    public void displayIngredients(ArrayList<Ingredient>ingredients) {

        myAdaptert.setList(ingredients);
        myAdaptert.notifyDataSetChanged();

    }

    @Override
    public void displayCatagory(ArrayList<Category> categories) {

        myAdapter.setList(categories);

        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void disPlayArea(ArrayList<Area> meals) {
        Log.i("TAG", "displayIngredients: "+"8547521569");
        myAdapterr.setList(meals);
        Log.i("TAG", "disPlayArea: "+meals.get(0).getStrArea());
        Log.i("TAG", "displayIngredients: "+"8547521569");
        myAdapterr.notifyDataSetChanged();

    }

    @Override
    public void displaySearchName(ArrayList<FoodRandomDTO> meals) {


        myAdapterSname.setList(meals);

        myAdapterSname.notifyDataSetChanged();
    }

    @Override
    public void displayFiltercatgory(ArrayList<FilterCatory> meals) {

    }

    @Override
    public void displayError(String errorMessage) {

    }


    @Override
    public void onClick(FoodRandomDTO dto) {
        SearchFragmentDirections.ActionSearchToDatilesFragment action= SearchFragmentDirections
                .actionSearchToDatilesFragment(dto);
        Navigation.findNavController(getView()).navigate(action);
    }

    @Override
    public void onClickk(String dto) {
        Log.i("TAG", "onClickk: "+dto);
        SearchFragmentDirections.ActionSearchToSearchByNameFragment action=SearchFragmentDirections
                .actionSearchToSearchByNameFragment(dto);
        Log.i("TAG", "onClickk: "+dto);
        Navigation.findNavController(getView()).navigate(action);

    }

    @Override
    public void onClickArea(String dto) {
        SearchFragmentDirections.ActionSearchToShowAreaDetailesFragment action=SearchFragmentDirections
                .actionSearchToShowAreaDetailesFragment(dto);
        Navigation.findNavController(getView()).navigate(action);

    }

    @Override
    public void onClickIngredient(String dto) {
        SearchFragmentDirections.ActionSearchToIngredientFilterFragment action=SearchFragmentDirections
                .actionSearchToIngredientFilterFragment(dto);
        Navigation.findNavController(getView()).navigate(action);
    }


}