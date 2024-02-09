package com.example.taza.activitytwo.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.taza.R;
import com.example.taza.activitytwo.RemoteDataBase.MealDataBase;
import com.example.taza.activitytwo.model.FoodRandomDTO;
import com.example.taza.activitytwo.model.FoodRandomPojo;
import com.example.taza.activitytwo.model.Ingredient;
import com.example.taza.activitytwo.model.MealPlannerAndMealConverter;
import com.example.taza.activitytwo.remoteApi.realfire.FireBaseRealTimeWrapper;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;
import java.util.Calendar;


public class datilesFragment extends Fragment {
TextView dectextView;
TextView strMealview;
TextView strAreaview;
TextView strCategoryview;
YouTubePlayerView youTubePlayerView;
    String selectedDate;
boolean isFav = false ;
ImageView strMealThumbview;
ImageView imageViewFav,imageViewclander;
ArrayList<Ingredient> listIngredient;
    public String getVideoLink(String link) {
        if (link != null && link.split("\\?v=").length > 1)
            return link.split("\\?v=")[1];
        else return "";
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_datiles, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listIngredient=new ArrayList<>();
        dectextView=view.findViewById(R.id.textViewProcedures);
        strMealview= view.findViewById(R.id.txtViewMealNameItemDetails);
        strAreaview=view.findViewById(R.id.textViewMealCountryItemDetails);
        strCategoryview=view.findViewById(R.id.textViewMealCateItemDetails);
        strMealThumbview=view.findViewById(R.id.mealImage);
        youTubePlayerView=view.findViewById(R.id.ytPlayer);
        imageViewFav=view.findViewById(R.id.imageViewAddToFavITemDetails);
        imageViewclander=view.findViewById(R.id.imageViewAddToCalendarItemDetails);
        selectedDate=new String();
        imageViewFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isFav){
                    imageViewFav.setImageDrawable(getResources().getDrawable(R.drawable.baseline_favorite_border_48));
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            MealDataBase.getInstance(getContext()).getMealDao().deleteMealFromFavorite(datilesFragmentArgs.fromBundle(getArguments()).getData());
                        }
                    }).start();
                }else{
                    Log.i("TAG", "onClick: "+datilesFragmentArgs.fromBundle(getArguments()).getData().strMeal);
                    FireBaseRealTimeWrapper.getInstance().addToFav(datilesFragmentArgs.fromBundle(getArguments()).getData());
                    imageViewFav.setImageDrawable(getResources().getDrawable(R.drawable.baseline_favorite_24));
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            MealDataBase.getInstance(getContext()).getMealDao().insertMealToFavorite(datilesFragmentArgs.fromBundle(getArguments()).getData());
                        }
                    }).start();
                }
                isFav = !isFav;
            }
        });
        /////////////////////////////////////////////////////////////
        imageViewclander.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                showDatePickerDialog();


            }
        });




        /////////////////////////////////////////////////////////////
        String username=datilesFragmentArgs.fromBundle(getArguments()).getData().getStrInstructions();
        dectextView.setText(username);
        String usernamee=datilesFragmentArgs.fromBundle(getArguments()).getData().getStrMeal();
        strMealview.setText(usernamee);
        String usernamea=datilesFragmentArgs.fromBundle(getArguments()).getData().getStrArea();
        strAreaview.setText(usernamea);
        String usernameaa=datilesFragmentArgs.fromBundle(getArguments()).getData().getStrCategory();


//        String ingr1=datilesFragmentArgs.fromBundle(getArguments()).getData().getStrIngredient1();
//        listIngredient.add(ingr1)
//        String ingr2=datilesFragmentArgs.fromBundle(getArguments()).getData().getStrIngredient2();
//        String ingr3=datilesFragmentArgs.fromBundle(getArguments()).getData().getStrIngredient3();
//        String ingr4=datilesFragmentArgs.fromBundle(getArguments()).getData().getStrIngredient4();
//        String ingr5=datilesFragmentArgs.fromBundle(getArguments()).getData().getStrIngredient5();
//        String ingr6=datilesFragmentArgs.fromBundle(getArguments()).getData().getStrIngredient6();
//        String ingr7=datilesFragmentArgs.fromBundle(getArguments()).getData().getStrIngredient7();
//        String ingr8=datilesFragmentArgs.fromBundle(getArguments()).getData().getStrIngredient8();
//        String ingr9=datilesFragmentArgs.fromBundle(getArguments()).getData().getStrIngredient9();
//        String ingr10=datilesFragmentArgs.fromBundle(getArguments()).getData().getStrIngredient10();
//        String ingr11=datilesFragmentArgs.fromBundle(getArguments()).getData().getStrIngredient11();
//        String ingr12=datilesFragmentArgs.fromBundle(getArguments()).getData().getStrIngredient12();
//        String ingr13=datilesFragmentArgs.fromBundle(getArguments()).getData().getStrIngredient13();
//        String ingr14=datilesFragmentArgs.fromBundle(getArguments()).getData().getStrIngredient14();
//        String ingr15=datilesFragmentArgs.fromBundle(getArguments()).getData().getStrIngredient15();
//        String ingr16=datilesFragmentArgs.fromBundle(getArguments()).getData().getStrIngredient16();
//        String ingr17=datilesFragmentArgs.fromBundle(getArguments()).getData().getStrIngredient17();
//        String ingr18=datilesFragmentArgs.fromBundle(getArguments()).getData().getStrIngredient18();
//        String ingr19=datilesFragmentArgs.fromBundle(getArguments()).getData().getStrIngredient19();
//        String ingr20=datilesFragmentArgs.fromBundle(getArguments()).getData().getStrIngredient20();
//


        strCategoryview.setText(usernameaa);
        String usernamel=datilesFragmentArgs.fromBundle(getArguments()).getData().getStrMealThumb();
        Glide.with(requireContext())
                .load(usernamel)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(strMealThumbview);
        String link=datilesFragmentArgs.fromBundle(getArguments()).getData().getStrYoutube();



        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                super.onReady(youTubePlayer);
                String link = datilesFragmentArgs.fromBundle(getArguments()).getData().getStrYoutube();
                String videoMealDetail = getVideoLink(link);
                youTubePlayer.cueVideo(videoMealDetail, 0);
            }
        });


    }
    private void showDatePickerDialog() {
        // Get current date to initialize the DatePickerDialog
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        // Create a DatePickerDialog and set the listener for date selection
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                        Toast.makeText(getContext(), "Selected Date: " + selectedDate, Toast.LENGTH_SHORT).show();

                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                FoodRandomPojo mealPlanner = MealPlannerAndMealConverter.getMealPlannerFromMealAndDate(
                                        datilesFragmentArgs.fromBundle(getArguments()).getData(), selectedDate, dayOfMonth);
                                FireBaseRealTimeWrapper.getInstance().addToWeekPlanner(mealPlanner);
                                MealDataBase.getInstance(getContext()).getMealDao().insertMealToPlanner(mealPlanner);
                            }
                        }).start();
                    }
                }, year, month, dayOfMonth);

        // Show the DatePickerDialog
        datePickerDialog.show();
    }
}