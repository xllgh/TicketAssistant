package com.yly.trainsystem.ui.home;

import android.app.DatePickerDialog;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.DatePicker;

import androidx.databinding.DataBindingUtil;

import com.yly.trainsystem.volley.HttpUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class HomeEventHandler {

    public void onQueryClick(HomeViewModel homeViewModel) {
        Log.e("HomeFragment", homeViewModel.departure.get()+ "");
        Log.e("HomeFragment", homeViewModel.departureTime.get()  + "");
        Log.e("HomeFragment", homeViewModel.destination.get() + "");

        HashMap<String, String> map = new HashMap<>();
        map.put("departure", homeViewModel.departure.get());
        map.put("destination", homeViewModel.destination.get());
        map.put("departureTime", homeViewModel.departureTime.get());
        HttpUtils.post(HttpUtils.QUERY_TICKET, map);

    }

    public void onExchangeAddress(HomeViewModel homeViewModel) {
        if (TextUtils.isEmpty(homeViewModel.departure.get())&& TextUtils.isEmpty(homeViewModel.destination.get()))
            return;
        String temp = homeViewModel.departure.get();
        homeViewModel.departure.set(homeViewModel.destination.get());
        homeViewModel.destination.set(temp);
    }

    public void onPopUpTimePicker(final HomeViewModel viewModel, Context context) {
        DatePickerDialog dpd =  new DatePickerDialog(context);
        dpd.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, dayOfMonth);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                viewModel.departureTime.set(sdf.format(calendar.getTime()));
            }
        });
        dpd.show();

    }
}
