package edu.itstep.myapplic11.models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Address {
    @Expose
    @SerializedName("city")
    private String city;

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }
}

