package com.atsera.hackcbs;


import com.atsera.hackcbs.Models.ResponseforLogin;
import com.atsera.hackcbs.Models.User;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface RetrofitInterface {

    @POST("login-app")
    Observable<ResponseforLogin> login(@Body User user);
}
