package com.example.taza.activtiystart;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.taza.R;
import com.example.taza.activitytwo.MainActivity2;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginFragment extends Fragment {

    View v;
    EditText editTextemail,editTextpassword;
    Button buttonhome,btnregsiter;
    FirebaseAuth mAuth;
    String email, password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        return  inflater.inflate(R.layout.fragment_login, container, false);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editTextemail=view.findViewById(R.id.logemail);

        editTextpassword=view.findViewById(R.id.logpass);
        buttonhome=view.findViewById(R.id.login);
        btnregsiter=view.findViewById(R.id.register);
        mAuth= FirebaseAuth.getInstance();
        buttonhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = String.valueOf(editTextemail.getText());
                password = String.valueOf(editTextpassword.getText());
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getActivity(), "Enter email please", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getActivity(), "please enter password", Toast.LENGTH_SHORT).show();
                    return;

                }
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Intent intent = new Intent(getActivity(), MainActivity2.class);
                                    startActivity(intent);
                                    // Login success
                                    Toast.makeText(getActivity(), "LOGIN succeeded.", Toast.LENGTH_SHORT).show();
                                } else {
                                    // Login failed, display a message to the user.
                                    Toast.makeText(getActivity(), "LOGIN failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });





            }});
        btnregsiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view)
                        .navigate(R.id.action_loginFragment2_to_registerFragment2);

            }
        });
    }
}