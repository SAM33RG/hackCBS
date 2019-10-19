package com.atsera.hackcbs;


import com.atsera.hackcbs.Models.ResponseforLogin;
import com.atsera.hackcbs.Models.User;
import com.atsera.hackcbs.Models.Rfid;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface RetrofitInterface {

    @POST("login-app")
    Observable<ResponseforLogin> login(@Body User user);
    @POST("Rfid")
    Observable<ResponseforLogin> rfid(@Body Rfid rfid);

}
