package com.example.fragment.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.fragment.Model.LoginResponse;
import com.example.fragment.R;
import com.example.fragment.SharedPreferences.UserSessionManager;
import com.example.fragment.api.RetrofitClient;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText editTexEmail;
    private EditText editTextPassword;
    private TextView forgot;
    private Button buttonLogin, buttonSignUp;
    String id, cname, cemail,cnum;

    UserSessionManager userSessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTexEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        forgot = findViewById(R.id.forgot);
        //findViewById(R.id.buttonLogin).setOnClickListener(this);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonSignUp = findViewById(R.id.buttonSignUp);

        userSessionManager = new UserSessionManager(this);
        if (userSessionManager.isLoggedIn()) {

            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, UpdatePasswordActivity.class);
                startActivity(intent);
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userLogin();
            }
        });

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }




        private void userLogin() {

        final String email = editTexEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (email.isEmpty()) {
            editTexEmail.setError("Email is required");
            editTexEmail.requestFocus();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTexEmail.setError("Enter a valid email");
            editTexEmail.requestFocus();
        } else if (password.isEmpty()) {
            editTextPassword.setError("Password required");
            editTextPassword.requestFocus();
        } else if (password.length() < 6) {
            editTextPassword.setError("Password should be atleast 6 character long");
            editTextPassword.requestFocus();

        } else {


            Call<LoginResponse> Call = RetrofitClient.getInstance().getApi().userLogin(email, password);

            Call.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    LoginResponse loginResponse = response.body();
                    Log.e("enter1", "enter");

                    if ((loginResponse != null ? loginResponse.getStatus() : 0) == 1) {
                        List<LoginResponse.DataBean> dataBeans = response.body() != null ? response.body().getData() : null;
                        for (LoginResponse.DataBean mn : dataBeans) {
                            id = mn.getUserId();
                            cname = mn.getName();
                            cemail = mn.getEmail();
                            cnum=mn.getNumber();
                        }


                        userSessionManager.createLogin(id, cemail, cname,cnum);

                        Log.e("UserId", "" + id);
                        Log.e("UserId", "" + cemail);
                        Log.e("UserId", "" + cname);

                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }
                    else {
                        int im = loginResponse.getStatus();
                        Toast.makeText(LoginActivity.this, "User Not Found", Toast.LENGTH_LONG).show();
                    }

                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, "User Not Found", Toast.LENGTH_LONG).show();
                }
            });
        }

    }
}
