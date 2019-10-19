package com.atsera.hackcbs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.atsera.hackcbs.Models.ResponseforLogin;
import com.atsera.hackcbs.Models.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import retrofit2.Response;
import retrofit2.adapter.rxjava.HttpException;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class Login extends AppCompatActivity {
    private CompositeSubscription mSubscriptions;

    EditText email, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mSubscriptions = new CompositeSubscription();

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

        login = (Button) findViewById(R.id.button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginProcess(new User(email.getText().toString(), password.getText().toString()));
            }
        });


    }

    private void loginProcess(User user) {

        mSubscriptions.add(NetworkUtil.getRetrofit().login(user)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse,this::handleError));
    }

    private void handleResponse(ResponseforLogin response) {

        Log.d("respone",response.toString());


        try{
            if (response.getCode() == 1){

                Toast.makeText(getApplicationContext(), "1" + response.getMessage(), Toast.LENGTH_SHORT).show();

            }else if(response.getCode() == 2){

                Toast.makeText(getApplicationContext(), "2" + response.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"error\nreinstall app or contact developer",Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(),e.getMessage().toString(),Toast.LENGTH_SHORT).show();

        }

    }
    private void handleError(Throwable error) {

        Log.d("error77",error.getMessage());


        if (error instanceof HttpException) {

            Gson gson = new GsonBuilder().create();

            try {

                if(((HttpException) error).code()==401){

                }
                else {
                    String errorBody = ((HttpException) error).response().errorBody().string();
                    Response response = gson.fromJson(errorBody,Response.class);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

            Log.e("error77",error.getMessage());
        }
    }
}
