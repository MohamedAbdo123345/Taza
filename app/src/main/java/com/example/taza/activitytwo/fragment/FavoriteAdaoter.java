package com.example.taza.activitytwo.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.taza.R;
import com.example.taza.activitytwo.model.FoodRandomDTO;
import com.example.taza.activitytwo.onclichListenerfav.OnclicklistenerFavorite;

import java.util.ArrayList;
import java.util.List;

public class FavoriteAdaoter extends RecyclerView.Adapter<FavoriteAdaoter.ViewHolder> {
    public FavoriteAdaoter(OnclicklistenerFavorite onclicklistenerFavorite, List<FoodRandomDTO> meals) {
        this.onclicklistenerFavorite = onclicklistenerFavorite;
        this.meals = meals;
    }

    OnclicklistenerFavorite onclicklistenerFavorite;
    private List<FoodRandomDTO>meals=new ArrayList<>();




    public FavoriteAdaoter(List<FoodRandomDTO> meals) {
        this.meals = meals;
    }

    public void setList(List<FoodRandomDTO> meals){
        this.meals=meals;
        notifyDataSetChanged();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textView1;
        ImageView imageView;

        Button RemoveButton;
        Button tttt;
        public ViewHolder(View itemview){
            super(itemview);
            // searcheditText = itemView.findViewById(R.id.searchtext);
            textView1=itemview.findViewById(R.id.MealName11);
            imageView=itemview.findViewById(R.id.imgViewdetailes);

            RemoveButton=itemview.findViewById(R.id.removebutton);

        }
    }
    @NonNull
    @Override
    public FavoriteAdaoter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.favandcalender,parent,false);
   return new FavoriteAdaoter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteAdaoter.ViewHolder holder, int position) {
        holder.textView1.setText(meals.get(position).getStrMeal());
        //holder.imageView.setImageBitmap(item.get(position).getStrCategoryThumb());
        FoodRandomDTO dto = meals.get(position);

        String imagePath = (String) meals.get(position).strMealThumb;
        Glide.with(holder.imageView.getContext())
                .load(imagePath)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.imageView);
        holder.RemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclicklistenerFavorite.onclick(meals.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return meals.size();
    }
}
