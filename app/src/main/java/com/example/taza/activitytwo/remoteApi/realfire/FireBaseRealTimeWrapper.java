package com.example.taza.activitytwo.remoteApi.realfire;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.taza.activitytwo.model.FoodRandomDTO;
import com.example.taza.activitytwo.model.FoodRandomPojo;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FireBaseRealTimeWrapper {
    private static final String TAG = "TAG";
    private FirebaseDatabase database;
    private DatabaseReference referenceWeekPlanner;
    private DatabaseReference referenceFavorite;
    private FirebaseAuth auth;
    private static FireBaseRealTimeWrapper fireBaseRealTimeWrapper;

    public static synchronized FireBaseRealTimeWrapper getInstance() {
        if (fireBaseRealTimeWrapper == null) {
            fireBaseRealTimeWrapper = new FireBaseRealTimeWrapper();
        }
        return fireBaseRealTimeWrapper;
    }

    private FireBaseRealTimeWrapper() {
        database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
//        Log.i(TAG, "FireBaseRealTimeWrapper: ================="+auth.getUid());
//        if (auth.getCurrentUser() !=null) {
            referenceFavorite = database.getReference().child("users").child(auth.getUid()).child("favoritesMeal");
            referenceWeekPlanner = database.getReference().child("users").child(auth.getUid()).child("weekPlannerMeal");
//        }
    }

    public void addToFav(FoodRandomDTO meal) {
//        if (authenticationFireBaseRepo.isAuthenticated()) {
            referenceFavorite.child(meal.idMeal).setValue(meal)
                    .addOnCompleteListener(task -> Log.i(TAG, "addToFav: done"))
                    .addOnFailureListener(e -> Log.i(TAG, "addToFav: err "+e.getMessage()));
//        }
    }

    public void addToWeekPlanner(FoodRandomPojo mealPlanner) {
//        if (authenticationFireBaseRepo.isAuthenticated()) {
            String key = referenceWeekPlanner.push().getKey();
            referenceWeekPlanner.child(mealPlanner.id).setValue(mealPlanner)
                    .addOnCompleteListener(task -> Log.i(TAG, "addToWeekPlanner: done"))
                    .addOnFailureListener(e -> Log.i(TAG, "addToWeekPlanner: err "+e.getMessage()));

//        }
    }

    public void removeMealFromFav(String mealId) {
        referenceFavorite.child(mealId).removeValue(new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {

//                        fireBaseRemovingDelegate.onSuccess();
                    }
                }).start();
                //fireBaseRemovingDelegate.onSuccess();
            }
        });
    }


    public void removeMealFromPlanner(String id) {
        referenceWeekPlanner.child(id).removeValue(new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
//                fireBaseRemovingDelegate.onSuccess();
            }
        });
    }


    public void getFavMeals() {//FireBaseFavDelegate fireBaseFavDelegate
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<FoodRandomDTO> meals = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    meals.add(snapshot.getValue(FoodRandomDTO.class));
                }
//                fireBaseFavDelegate.onSuccess(meals);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
//                fireBaseFavDelegate.onFailure(databaseError.toException().toString());
            }
        };
        Log.d(TAG, "getFavMeals: " + database.getReference()
                .child("users")
                .child(auth.getUid())
                .child("favoritesMeal").getKey());
        referenceFavorite.addValueEventListener(postListener);
    }

    public void getWeekPlanner() {//FireBasePlannerDelegate fireBasePlannerDelegate
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<FoodRandomPojo> mealPlanners = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    mealPlanners.add(snapshot.getValue(FoodRandomPojo.class));
                }
                Log.i(TAG, "onDataChange: getWeekPlanner" + mealPlanners.size());
//                fireBasePlannerDelegate.onSuccess(mealPlanners);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
//                fireBasePlannerDelegate.onFailure(databaseError.toException().toString());
            }
        };
        referenceWeekPlanner.addValueEventListener(postListener);
    }
}

