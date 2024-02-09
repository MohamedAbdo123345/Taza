package com.example.taza.activtiystart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;
import com.example.taza.R;
import com.ramotion.paperonboarding.PaperOnboardingFragment;
import com.ramotion.paperonboarding.PaperOnboardingPage;

import java.util.ArrayList;

public class splachActivity extends AppCompatActivity {
    LottieAnimationView lottieAnimationView;
    Button skipBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach);
        lottieAnimationView = findViewById(R.id.animation_view);

        skipBtn = findViewById(R.id.skip_btn);

        skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(splachActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                lottieAnimationView.setVisibility(View.GONE);
                FragmentManager fragmentManager = getSupportFragmentManager();
                final PaperOnboardingFragment paperOnboardingFragment = PaperOnboardingFragment.newInstance(getDataforOnboarding());
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.splash_fragment, paperOnboardingFragment);
                fragmentTransaction.commit();
            }
        }, 2000);

    }
    private ArrayList<PaperOnboardingPage> getDataforOnboarding() {
        PaperOnboardingPage source = new PaperOnboardingPage(
                "Personalized Recipe Discovery\n",
                "Tell us your food preference and we'll serve you delicious",
                Color.parseColor("#F3F3F3"),
                R.drawable.bibimbap,
                R.drawable.bibimbap);

        PaperOnboardingPage source1 = new PaperOnboardingPage(
                "Grocery List for when you shop\n",
                "Take the grocery list from your cart to your nearest grocery store and buy the ingredient",
                Color.parseColor("#F3F3F3"),
                R.drawable.biryani,
                R.drawable.biryani);

        PaperOnboardingPage source2 = new PaperOnboardingPage(
                "All your favourite Recipes in one place\n",
                "Save time planning by having your favourite recipes within reach",
                Color.parseColor("#F3F3F3"),
                R.drawable.breakfast,
                R.drawable.breakfast);

        ArrayList<PaperOnboardingPage> elements = new ArrayList<>();
        elements.add(source);
        elements.add(source1);
        elements.add(source2);
        return elements;}
}