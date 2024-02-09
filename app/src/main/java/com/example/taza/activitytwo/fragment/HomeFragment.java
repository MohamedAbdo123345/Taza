package com.example.taza.activitytwo.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.taza.R;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.taza.activitytwo.model.Area;
import com.example.taza.activitytwo.model.Category;
import com.example.taza.activitytwo.model.Ingredient;
import com.example.taza.activitytwo.model.ListArea;
import com.example.taza.activitytwo.model.ListCategory;
import com.example.taza.activitytwo.model.ListIdIngredient;
import com.example.taza.activitytwo.remoteApi.RetrofitMealsAPI;
import com.example.taza.activitytwo.model.FoodRandomDTO;
import com.example.taza.activitytwo.model.ListfoodRandom;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment implements OnClickListener {
ImageView imageView;
TextView namemeal;
TextView descraption;
ListfoodRandom listfoodd;
FoodRandomDTO foodDTO;
ListfoodRandom listfood;
    RecyclerView recyclerView;
MyAdapter myAdapter;
CardView cardView;
//ArrayList<Category>data;

    public static final String TAG = "TAG";
    Retrofit retrofit,retrofitt,retrofitk,retrofitl;
    ArrayList<Ingredient>listIngredient;

    ArrayList<FoodRandomDTO>list;
    ArrayList<Category>listt;
    ArrayList<Area>listAraa;
    ArrayList<FoodRandomDTO>myDtoList;
    public static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        data=new ArrayList<>();
        listt=new ArrayList<Category>();
        listAraa=new ArrayList<Area>();
        listIngredient=new ArrayList<>();
        imageView=view.findViewById(R.id.imgViewdetailes);
        namemeal=view.findViewById(R.id.MealName11);
        descraption=view.findViewById(R.id.meal_description);
        cardView=view.findViewById(R.id.cardView2);
        listfoodd=new ListfoodRandom();
        myDtoList=new ArrayList<FoodRandomDTO>();
         retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
         RetrofitMealsAPI apiServices=retrofit.create(RetrofitMealsAPI.class);
        Call<ListfoodRandom> call = apiServices.doGetListResources();
        call.enqueue(new Callback<ListfoodRandom>() {
            @Override
            public void onResponse(Call<ListfoodRandom> call, Response<ListfoodRandom> response) {
                if (response.isSuccessful()) {
                    Log.i("TAG", "onResponse: "+response);
                    list = new ArrayList<FoodRandomDTO>();
                    list.addAll(response.body().meals);


                    if (!list.isEmpty()) {
                        namemeal.setText(list.get(0).strMeal);
                        descraption.setText(list.get(0).strArea);
                        String imagePath = (String) list.get(0).strMealThumb;
                        Glide.with(getContext())
                                .load(imagePath)
                                .centerCrop()
                                .placeholder(R.drawable.ic_launcher_foreground)
                                .into(imageView);
                        cardView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                HomeFragmentDirections.ActionHomeFragmentToDatilesFragment action = HomeFragmentDirections
                                        .actionHomeFragmentToDatilesFragment(list.get(0));
//                                SenderDirections.ActionSenderToReciver action=SenderDirections.actionSenderToReciver(gf);
                                Navigation.findNavController(v).navigate(action);

                            }
                        });




                        Log.i(TAG, "onResponse: " + list.get(0).strMeal);
                    } else {
                        Log.e(TAG, "List is empty");
                    }
                } else {
                    Log.e(TAG, "Response is not successful or body is null");
                }

            }

            @Override
            public void onFailure(Call<ListfoodRandom> call, Throwable t) {

            }




        });
        ////////////////////////////////////////////////////////////////////////

        RecyclerView recyclerView = view.findViewById(R.id.recyclervieww);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        retrofitt=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        RetrofitMealsAPI apiServicess=retrofitt.create(RetrofitMealsAPI.class);
        Call<ListCategory> calll = apiServicess.doGetListResourcess();
        calll.enqueue(new Callback<ListCategory>() {
            @Override
            public void onResponse(Call<ListCategory> calll, Response<ListCategory> response) {
                if (response.isSuccessful()) {
                    Log.i("TAG", "onResponse33: "+response);
                   // listt = new ArrayList<Category>();
                    listt.addAll(response.body().categories);

                    MyAdapter adapter = new MyAdapter(listt,HomeFragment.this);

                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                    if (!listt.isEmpty()) {
//                        namemeal.setText(list.get(0).strMeal);
//                        descraption.setText(list.get(0).strArea);
//                        String imagePath = (String) list.get(0).strMealThumb;
//                        Glide.with(requireContext())
//                                .load(imagePath)
//                                .centerCrop()
//                                .placeholder(R.drawable.ic_launcher_foreground)
//                                .into(imageView);



                       // Log.i(TAG, "onResponse: " + listt.get(0).getStrCategory());
                    } else {
                        Log.e(TAG, "List is empty");
                    }
                } else {
                    Log.e(TAG, "Response is not successful or body is null");
                }

            }

            @Override
            public void onFailure(Call<ListCategory> call, Throwable t) {

            }






        });
        ///////////////////////////////////////////////
        RecyclerView recyclerVieww = view.findViewById(R.id.recyclerview2);
        LinearLayoutManager layoutManagerr = new LinearLayoutManager(requireContext());
        layoutManagerr.setOrientation(RecyclerView.HORIZONTAL);
        recyclerVieww.setLayoutManager(layoutManagerr);
        retrofitk=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        RetrofitMealsAPI apiServicesl=retrofitk.create(RetrofitMealsAPI.class);
        Call<ListArea> callk = apiServicesl.doGetListAea();
        callk.enqueue(new Callback<ListArea>() {
            @Override
            public void onResponse(Call<ListArea> callk, Response<ListArea> response) {
                if (response.isSuccessful()) {
                    Log.i("TAG", "onResponse33: "+response);
                    // listt = new ArrayList<Category>();
                    listAraa.addAll(response.body().meals);

                    MyAdapterr adapter = new MyAdapterr(listAraa);

                    recyclerVieww.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                    if (!listAraa.isEmpty()) {
//                        namemeal.setText(list.get(0).strMeal);
//                        descraption.setText(list.get(0).strArea);
//                        String imagePath = (String) list.get(0).strMealThumb;
//                        Glide.with(requireContext())
//                                .load(imagePath)
//                                .centerCrop()
//                                .placeholder(R.drawable.ic_launcher_foreground)
//                                .into(imageView);



                        // Log.i(TAG, "onResponse: " + listt.get(0).getStrCategory());
                    } else {
                        Log.e(TAG, "List is empty");
                    }
                } else {
                    Log.e(TAG, "Response is not successful or body is null");
                }

            }

            @Override
            public void onFailure(Call<ListArea> call, Throwable t) {

            }







        });
        ///////////////////////////////////
        RecyclerView recyclerViewl = view.findViewById(R.id.recyclerview3);
        LinearLayoutManager layoutManagerl = new LinearLayoutManager(requireContext());
        layoutManagerl.setOrientation(RecyclerView.HORIZONTAL);
        recyclerViewl.setLayoutManager(layoutManagerl);
        retrofitl=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        RetrofitMealsAPI apiServicesll=retrofitl.create(RetrofitMealsAPI.class);
        Call<ListIdIngredient> callkl = apiServicesll.doListIdIngredient();
        callkl.enqueue(new Callback<ListIdIngredient>() {
            @Override
            public void onResponse(Call<ListIdIngredient> callkl, Response<ListIdIngredient> response) {
                if (response.isSuccessful()) {
                    Log.i("TAG", "onResponse33: "+response);
                    // listt = new ArrayList<Category>();
                    listIngredient.addAll(response.body().meals);

                    MyAdaptert adapter = new MyAdaptert(listIngredient);

                    recyclerViewl.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                    if (!listIngredient.isEmpty()) {
//                        namemeal.setText(list.get(0).strMeal);
//                        descraption.setText(list.get(0).strArea);
//                        String imagePath = (String) list.get(0).strMealThumb;
//                        Glide.with(requireContext())
//                                .load(imagePath)
//                                .centerCrop()
//                                .placeholder(R.drawable.ic_launcher_foreground)
//                                .into(imageView);



                        // Log.i(TAG, "onResponse: " + listt.get(0).getStrCategory());
                    } else {
                        Log.e(TAG, "List is empty");
                    }
                } else {
                    Log.e(TAG, "Response is not successful or body is null");
                }

            }

            @Override
            public void onFailure(Call<ListIdIngredient> call, Throwable t) {

            }









        });




    }

    @Override
    public void onClick(FoodRandomDTO dto) {

    }

    @Override
    public void onClickk(String dto) {
        Log.i("TAG", "onClickk: "+dto);
        HomeFragmentDirections.ActionHomeToSearchByNameFragment action=HomeFragmentDirections
                .actionHomeToSearchByNameFragment(dto);
        Navigation.findNavController(getView()).navigate(action);
    }

    @Override
    public void onClickArea(String dto) {

    }

    @Override
    public void onClickIngredient(String dto) {

    }
}