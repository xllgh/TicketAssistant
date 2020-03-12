package com.yly.trainsystem.ui.home;

import android.app.DatePickerDialog;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.DatePicker;

import androidx.databinding.ObservableField;

public class HomeEventHandler {

    public void onQueryClick(HomeViewModel homeViewModel) {
        Log.e("HomeFragment", homeViewModel.departure.get()+ "");
        Log.e("HomeFragment", homeViewModel.departureTime.get()  + "");
        Log.e("HomeFragment", homeViewModel.destination.get() + "");
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
                viewModel.departureTime.set( year + "年" + month + "月" + dayOfMonth + "日");
            }
        });
        dpd.show();

    }
}
