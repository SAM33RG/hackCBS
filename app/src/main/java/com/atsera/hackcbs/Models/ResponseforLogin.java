package com.atsera.hackcbs.Models;

import com.google.gson.annotations.SerializedName;

public class ResponseforLogin {

    @SerializedName("message")
    private String message;
    private Integer code;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
