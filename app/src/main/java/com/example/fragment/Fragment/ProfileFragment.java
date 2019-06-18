package com.example.fragment.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragment.Activity.LoginActivity;
import com.example.fragment.R;
import com.example.fragment.SharedPreferences.UserSessionManager;


import java.util.HashMap;

public class ProfileFragment extends Fragment {


UserSessionManager userSessionManager;
TextView button;
TextView name,email,number;
    @Nullable
    @Override

    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view= inflater.inflate(R.layout.fragment_profile, container, false);

        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        userSessionManager=new UserSessionManager(getContext());

        name=(TextView) view.findViewById(R.id.name);
        email=(TextView) view.findViewById(R.id.email);
        number=(TextView) view.findViewById(R.id.number);



        HashMap<String, String> profile = userSessionManager.getUserDetails();



        name.setText(profile.get("name"));
        email.setText(profile.get("email"));
        number.setText(profile.get("number"));
        button=(TextView) view.findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getContext(),"Successfully Logout", Toast.LENGTH_SHORT).show();


                userSessionManager.clearSession();

                Intent intent=new Intent(getActivity(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                startActivity(intent);

            }
        });



        return view;
    }


}
