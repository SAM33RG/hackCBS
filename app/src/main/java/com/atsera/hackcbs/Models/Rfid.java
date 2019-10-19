package com.atsera.hackcbs.Models;

import com.google.gson.annotations.SerializedName;

public class Rfid {
    @SerializedName("Rfid")
    String rfid;

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public Rfid(String rfid) {
        this.rfid = rfid;
    }
}
