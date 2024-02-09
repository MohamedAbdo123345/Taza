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
import com.example.taza.activitytwo.model.Area;
import com.example.taza.activitytwo.model.Ingredient;

import java.util.ArrayList;

public class MyAdaptert extends RecyclerView.Adapter<MyAdaptert.ViewHolder> {
    OnClickListener listener;

    public void setList(ArrayList<Ingredient> listIngredient){
        this.listIngredient = listIngredient;
    }
    private ArrayList<Ingredient> listIngredient=new ArrayList<>();
    public MyAdaptert(ArrayList<Ingredient> listIngredient) {
        this.listIngredient=listIngredient;
    }
    public MyAdaptert(ArrayList<Ingredient> listIngredient,OnClickListener listener) {
        this.listIngredient=listIngredient;
        this.listener=listener;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textViewingredient;
        ImageView imageViewingradient;
        ConstraintLayout constraintLayout;

        public ViewHolder(View itemview){
            super(itemview);

            textViewingredient=itemview.findViewById(R.id.textViewIngredientMeasureItem);
            imageViewingradient=itemview.findViewById(R.id.imageViewIngredientImageItem_mealDetails);
            constraintLayout=itemview.findViewById(R.id.ingredientconstraint);


        }
    }
    @NonNull
    @Override
    public MyAdaptert.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.ingredients_item_meal_details, parent, false);
        return new MyAdaptert.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String dto=listIngredient.get(position).getStrIngredient();
        String image="https://www.themealdb.com/images/ingredients/"+listIngredient.get(position).getStrIngredient()+".png";

        holder.textViewingredient.setText(listIngredient.get(position).getStrIngredient());
        Glide.with(holder.imageViewingradient.getContext())
                .load(image)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.imageViewingradient);
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickIngredient(dto);
            }
        });
    }



    @Override
    public int getItemCount() {
        return listIngredient.size();
    }
}
