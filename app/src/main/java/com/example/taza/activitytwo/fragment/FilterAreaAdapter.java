package com.example.taza.activitytwo.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.taza.R;
import com.example.taza.activitytwo.Presenter.Presenter;
import com.example.taza.activitytwo.model.FilterCatory;

import java.util.ArrayList;

public class FilterAreaAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    ArrayList<FilterCatory>meals=new ArrayList<>();
    Presenter presenterSearchByname;


    public FilterAreaAdapter(ArrayList<FilterCatory> meals) {this.meals=meals;}

    public void setList(ArrayList<FilterCatory> meals){
        this.meals=meals;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView textView1;
        ImageView imageView;
        ConstraintLayout constraintLayout;
        public ViewHolder(View itemview){
            super(itemview);
            // searcheditText = itemView.findViewById(R.id.searchtext);
            textView1=itemview.findViewById(R.id.MealName11);
            imageView=itemview.findViewById(R.id.imgViewdetailes);
            constraintLayout=itemview.findViewById(R.id.meal_constraint_layout);


        }
    }
    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.ctagoryreckle, parent, false);
        return new MyAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        holder.textView1.setText(meals.get(position).getStrMeal());
        //holder.imageView.setImageBitmap(item.get(position).getStrCategoryThumb());
        String imagePath = (String) meals.get(position).getStrMealThumb();
        Glide.with(holder.imageView.getContext())
                .load(imagePath)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }
}
