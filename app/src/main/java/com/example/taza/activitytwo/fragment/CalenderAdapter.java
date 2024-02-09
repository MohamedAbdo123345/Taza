package com.example.taza.activitytwo.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.taza.R;
import com.example.taza.activitytwo.model.FoodRandomDTO;
import com.example.taza.activitytwo.model.FoodRandomPojo;
import com.example.taza.activitytwo.onclichListenerfav.OnclicklistenerCalender;

import java.util.ArrayList;
import java.util.List;

public class CalenderAdapter extends RecyclerView.Adapter<CalenderAdapter.MyViewHolder> {
    OnclicklistenerCalender onclicklistenerCalender;

    public CalenderAdapter(OnclicklistenerCalender onclicklistenerCalender, List<FoodRandomPojo> meals) {
        this.onclicklistenerCalender = onclicklistenerCalender;
        this.meals = meals;
    }

    public CalenderAdapter(List<FoodRandomPojo> meals) {
        this.meals = meals;
    }

    public List<FoodRandomPojo>meals=new ArrayList<>();
    public void setList(List<FoodRandomPojo> meals){
        this.meals=meals;
        notifyDataSetChanged();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView1;
        ImageView imageView;
        Button RemoveButton;
        ConstraintLayout constraintLayout;
        public MyViewHolder(View itemview){
            super(itemview);
            // searcheditText = itemView.findViewById(R.id.searchtext);
            textView1=itemview.findViewById(R.id.MealName11);
            imageView=itemview.findViewById(R.id.imgViewdetailes);
            RemoveButton=itemview.findViewById(R.id.removebutton);
           // constraintLayout=itemview.findViewById(R.id.meal_constraint_layout);

        }
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.favandcalender, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView1.setText(meals.get(position).strMeal);
        //holder.imageView.setImageBitmap(item.get(position).getStrCategoryThumb());

        String imagePath = (String) meals.get(position).strMealThumb;
        Glide.with(holder.imageView.getContext())
                .load(imagePath)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.imageView);
        holder.RemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclicklistenerCalender.onclick(meals.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }
}
