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
import com.example.taza.activitytwo.model.FoodRandomDTO;

import java.util.ArrayList;
import java.util.List;

public class MyAdapterSname extends RecyclerView.Adapter<MyAdapterSname.ViewHolder> {
    OnClickListener listener;

    public void setList(List<FoodRandomDTO> meals){
        this.meals=meals;
        notifyDataSetChanged();
    }
    private List<FoodRandomDTO>meals=new ArrayList<>();
    public MyAdapterSname(ArrayList<FoodRandomDTO>meals){this.meals=meals; }
    public MyAdapterSname(ArrayList<FoodRandomDTO>meals, OnClickListener listener){this.meals=meals; this.listener=listener;}
    public class ViewHolder extends RecyclerView.ViewHolder{

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
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.ctagoryreckle, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textView1.setText(meals.get(position).getStrMeal());
        //holder.imageView.setImageBitmap(item.get(position).getStrCategoryThumb());
        FoodRandomDTO dto = meals.get(position);
        String imagePath = (String) meals.get(position).strMealThumb;
        Glide.with(holder.imageView.getContext())
                .load(imagePath)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.imageView);
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(dto);
            }
        });
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }
}
