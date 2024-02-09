package com.example.taza.activitytwo.remoteApi;

import android.util.Log;
import android.view.View;

import androidx.navigation.Navigation;

import com.example.taza.activitytwo.fragment.searchbyname.Search_by_nameFragment;
import com.example.taza.activitytwo.fragment.searchbyname.Search_by_nameFragmentDirections;
import com.example.taza.activitytwo.model.Category;
import com.example.taza.activitytwo.model.FilterCatory;
import com.example.taza.activitytwo.model.ListArea;
import com.example.taza.activitytwo.model.ListCategory;
import com.example.taza.activitytwo.model.ListFilterCategory;
import com.example.taza.activitytwo.model.ListIdIngredient;
import com.example.taza.activitytwo.model.ListfoodRandom;
import com.example.taza.activitytwo.remoteApi.realfire.ApiListFood;

import java.util.ArrayList;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient implements Apiclientinterface,ApiclientinterfaceFilter,ApiclientinterfaceShowarea
,ApiclientinterfaceShowingradient, ApiListFood {
    private static final String TAG = "MealsRepo";
    //public static final String TAG = "TAG";
    public static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";
    private static RetrofitClient retrofit=null;
    private RetrofitMealsAPI retrofitMealsAPI;
    public static synchronized RetrofitClient getInstance() {
        if(retrofit == null){
            retrofit= new RetrofitClient();
        }
        return retrofit;
    }

    private RetrofitClient(){
       Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
       retrofitMealsAPI = retrofit.create(RetrofitMealsAPI.class);
    }


    @Override
    public void make(ProductCallback productCallback, String ingr) {
        Single<ListIdIngredient> listIdIngredientSingle = retrofitMealsAPI.getIngredients();

        listIdIngredientSingle.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(item -> {
                            productCallback.onSuccessResult(item.meals);

                        },
                        error -> Log.i(TAG, "productCallback: " + error));
    }

    @Override
    public void makee(ProductCallback productCallback, String ingr) {
        Single<ListCategory> listCategorySingle=retrofitMealsAPI.getCategories();
        listCategorySingle.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(item -> {
                            productCallback.onSuccessResultt(item.categories);

                        },
                        error -> Log.i(TAG, "productCallback: " + error));
    }

    @Override
    public void makearea(ProductCallback productCallback, String ingr) {
        Single<ListArea> listAreaSingle=retrofitMealsAPI.getCuisines();
        listAreaSingle.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(item -> {
                            productCallback.onSuccessResultarea(item.meals);

                        },
                        error -> Log.i(TAG, "productCallback: " + error));

    }

    @Override
    public void serachName(ProductCallback productCallback, String ingr) {

        Single<ListfoodRandom> listfoodRandomSingle=retrofitMealsAPI.doSearchName(ingr);
        listfoodRandomSingle.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(item -> {

                            productCallback.onSuccessResultSreachName(item.meals);

                        },
                        error -> Log.i(TAG, "productCallback: " + error));
    }
    public void doSerachName(ProductCallback productCallback, String ingr, View view) {

        Single<ListfoodRandom> listfoodRandomSingle = retrofitMealsAPI.doSearchName(ingr);
        listfoodRandomSingle.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(item -> {



                        },
                        error -> Log.i(TAG, "productCallback: " + error));
    }


    @Override
    public void filterCategory(ProductCallBackFilter productCallBackFilter, String ingr) {
        Single<ListFilterCategory>listFilterCategorySingle=retrofitMealsAPI.dogetFilterCatgory(ingr);
        listFilterCategorySingle.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(item -> {
                            productCallBackFilter.onSuccessResultFilterCategory(item.meals);


                        },
                        error -> Log.i(TAG, "productCallback: " + error));

    }




    @Override
    public void filterArea(ProductShowAreaCallback productShowAreaCallback, String ingr) {
        Single<ListFilterCategory>listFilterCategorySinglee=retrofitMealsAPI.dogetFilterArea(ingr);
        listFilterCategorySinglee.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(item -> {
                            productShowAreaCallback.onSuccessResultFilterarea(item.meals);


                        },
                        error -> Log.i(TAG, "productCallback: " + error));

    }

    @Override
    public void filterIngredient(ProductShowIngradiantCallback productShowIngradiantCallback, String ingr) {
        Single<ListFilterCategory>listFilterCategorySinglet=retrofitMealsAPI.dogetFilterIngredient(ingr);
        listFilterCategorySinglet.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(item -> {
                            productShowIngradiantCallback.onSuccessResultFilterIngredient(item.meals);


                        },
                        error -> Log.i(TAG, "productCallback: " + error));
    }

    @Override
    public void serachName(ProductCallBcklistfood productCallBcklistfood, String ingr) {
        Single<ListfoodRandom>listfoodRandomSinglee=retrofitMealsAPI.doSearchNamee(ingr);
        listfoodRandomSinglee.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(item -> {
                            productCallBcklistfood.onSuccessResultlistfoode(item.meals);


                        },
                        error -> Log.i(TAG, "productCallback: " + error));
    }
}
