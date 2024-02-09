package com.example.taza.activitytwo.fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taza.R;
import com.example.taza.activitytwo.model.Area;
import com.example.taza.activitytwo.model.Category;

import java.util.ArrayList;

public class MyAdapterr extends RecyclerView.Adapter<MyAdapterr.ViewHolder> {
    OnClickListener listener;

    public void setList(ArrayList<Area>listArea){this.listArea=listArea;}
    private ArrayList<Area>listArea=new ArrayList<>();
    public MyAdapterr(ArrayList<Area> listAraa) {
        this.listArea=listAraa;
    }
    public MyAdapterr(ArrayList<Area> listAraa, OnClickListener listener) {
        this.listArea=listAraa;
        this.listener=listener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textViewarea;
        ConstraintLayout constraintLayout;

        public ViewHolder(View itemview){
            super(itemview);

            textViewarea=itemview.findViewById(R.id.textAreaview);
            constraintLayout=itemview.findViewById(R.id.FalgConstraintLayout);


        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.area, parent, false);
        return new MyAdapterr.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String dto=listArea.get(position).getStrArea();

    holder.textViewarea.setText(listArea.get(position).getStrArea());
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickArea(dto);
                Log.i("TAG", "onBindViewHolder5454545: "+dto);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listArea.size();
    }
}
