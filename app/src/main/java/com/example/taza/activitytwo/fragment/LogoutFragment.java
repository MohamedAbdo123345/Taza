package com.example.taza.activitytwo.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.taza.R;
import com.example.taza.activtiystart.MainActivity;
import com.google.firebase.auth.FirebaseAuth;


public class LogoutFragment extends Fragment {


ImageView imagelogout;
FirebaseAuth firebaseAuth;
    public LogoutFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_logout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imagelogout=view.findViewById(R.id.imagelogout);
        imagelogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
//                Intent intent=new Intent(getActivity(), MainActivity.class);
//                startActivity(intent);
                getActivity().finish();

            }
        });

    }
}