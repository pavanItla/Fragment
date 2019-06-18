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
import com.example.fragment.Model.UpdatePasswordResponse;
import com.example.fragment.R;
import com.example.fragment.api.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdatePasswordActivity extends AppCompatActivity {

    private EditText editTexEmail;
    private EditText editTextNumber;
    private EditText editTextPassword;

    private Button UserValid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_password);

        editTexEmail = findViewById(R.id.editTextEmail);
        editTextNumber = findViewById(R.id.editTextNumber);
        editTextPassword = findViewById(R.id.editTextPassword);
        UserValid = findViewById(R.id.Valid);

        UserValid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UserValid();
            }
        });
    }

    private void UserValid() {

        String email = editTexEmail.getText().toString().trim();
        String number = editTextNumber.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (email.isEmpty()) {
            editTexEmail.setError("Email is required");
            editTexEmail.requestFocus();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTexEmail.setError("Enter a valid email");
            editTexEmail.requestFocus();
        } else if (number.isEmpty()) {
            editTextNumber.setError("Password required");
            editTextNumber.requestFocus();
        } else if (number.length() < 6) {
            editTextNumber.setError("Password should be atleast 6 character long");
            editTextNumber.requestFocus();

        } else if (password.isEmpty()) {
            editTextPassword.setError("Password required");
            editTextPassword.requestFocus();
        } else if (password.length() < 6) {
            editTextPassword.setError("Password should be atleast 6 character long");
            editTextPassword.requestFocus();
        } else {

            Call<UpdatePasswordResponse> Call = RetrofitClient
                    .getInstance()
                    .getApi()
                    .updateUser(email,number,password);


            Call.enqueue(new Callback<UpdatePasswordResponse>() {
                @Override
                public void onResponse(Call<UpdatePasswordResponse> call, Response<UpdatePasswordResponse> response) {

                    UpdatePasswordResponse defaultResponse = response.body();

                    if ((defaultResponse != null ? defaultResponse.getStatus() : 0) == 1) {
                        String im = defaultResponse.getMessage();
                        Toast.makeText(UpdatePasswordActivity.this, "" + im, Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(UpdatePasswordActivity.this, LoginActivity.class);
                        startActivity(intent);
                    } else if ((defaultResponse != null ? defaultResponse.getStatus() : 0) == 3) {
                        String im = defaultResponse.getMessage();
                        Toast.makeText(UpdatePasswordActivity.this, "" + im, Toast.LENGTH_LONG).show();
                    }

                }



                @Override
                public void onFailure(Call<UpdatePasswordResponse> call, Throwable t) {


                }
            });


        }
    }
}
