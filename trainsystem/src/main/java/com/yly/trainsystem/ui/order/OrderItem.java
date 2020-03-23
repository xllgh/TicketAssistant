package com.yly.trainsystem.ui.order;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class OrderItem extends BaseObservable {

    String transportationNum;

    String departureTime;

    public OrderItem(String transportationNum, String departureTime) {
        this.transportationNum = transportationNum;
        this.departureTime = departureTime;
    }

    public String getTransportationNum() {
        return transportationNum;
    }

    @Bindable
    public void setTransportationNum(String transportationNum) {
        this.transportationNum = transportationNum;
    }
    @Bindable
    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
}
