package com.example.fragment.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fragment.Model.DefaultResponse;
import com.example.fragment.R;
import com.example.fragment.api.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    private EditText editTextName, editTextEmail, editTextPassword, getEditTextNumber;
    private Button buttonSignUp;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        getEditTextNumber = findViewById(R.id.editTextNumber);
        buttonSignUp = findViewById(R.id.buttonSignUp);
        buttonLogin = findViewById(R.id.buttonLogin);


        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userSignUp();
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void userSignUp() {

//        String re = "^[6-9]{2}\\d{9}$";
String re="^[7-9][0-9]{9}$";

        String name = editTextName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String number = getEditTextNumber.getText().toString().trim();


        if (name.isEmpty()) {
            editTextName.setError("Name required");
            editTextName.requestFocus();
        } else if (email.isEmpty()) {
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Enter a valid email");
            editTextEmail.requestFocus();
        } else if (password.isEmpty()) {
            editTextPassword.setError("Password required");
            editTextPassword.requestFocus();
        } else if (password.length() < 6) {
            editTextPassword.setError("Password should be atleast 6 character long");
            editTextPassword.requestFocus();
        }
//        else if (number.isEmpty()) {
//            getEditTextNumber.setError("Number required");
//            getEditTextNumber.requestFocus();
//        }
        else if(getEditTextNumber.getText().toString().length()<10 || getEditTextNumber.length()>10 || number.matches(re)==false ) {

            getEditTextNumber.setError("enter a valid phone number");
        }
//        else if (number.length() < 10) {
//            getEditTextNumber.setError("Please enter a valid ph number");
//            getEditTextNumber.requestFocus();
//        }
        else {

            Call<DefaultResponse> Call = RetrofitClient
                    .getInstance()
                    .getApi()
                    .createUser(name, email, password, number);


            Call.enqueue(new Callback<DefaultResponse>() {
                @Override
                public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {

                    DefaultResponse defaultResponse = response.body();

                    if ((defaultResponse != null ? defaultResponse.getStatus() : 0) == 1) {
                        String im = defaultResponse.getMessage();
                        Toast.makeText(RegisterActivity.this, "" + im, Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);
                    } else if ((defaultResponse != null ? defaultResponse.getStatus() : 0) == 3) {
                        String im = defaultResponse.getMessage();
                        Toast.makeText(RegisterActivity.this, "" + im, Toast.LENGTH_LONG).show();
                    }

                }

                @Override
                public void onFailure(Call<DefaultResponse> call, Throwable t) {


                }
            });


        }
    }
}

