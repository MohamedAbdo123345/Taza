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
import com.example.taza.activitytwo.model.Category;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    OnClickListener listener;
   public void setList(ArrayList<Category>categories){
       this.categories=categories;
   }
    private ArrayList<Category>categories=new ArrayList<>();
    public MyAdapter(ArrayList<Category> categories){this.categories=categories;}
    public MyAdapter(ArrayList<Category> categories,OnClickListener listener){
        this.categories=categories;
        this.listener=listener;

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
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        //ArrayList<Category>item= categories;
        String dto= categories.get(position).getStrCategory();

        holder.textView1.setText(categories.get(position).getStrCategory());
        //holder.imageView.setImageBitmap(item.get(position).getStrCategoryThumb());
        String imagePath = (String) categories.get(position).getStrCategoryThumb();
        Glide.with(holder.imageView.getContext())
                .load(imagePath)
                .centerCrop()
              .placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.imageView);
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickk(dto);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
