package com.yly.trainsystem.ui.tickets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.yly.trainsystem.MainActivity;
import com.yly.trainsystem.R;
import com.yly.trainsystem.databinding.ActivityTicketDetailBinding;
import com.yly.trainsystem.volley.HttpUtils;
import com.yly.trainsystem.volley.PurchaseOrderResponse;

import java.util.HashMap;

public class TicketDetailActivity extends AppCompatActivity {

    private String oldOrderId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTicketDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_ticket_detail);
        Intent intent = getIntent();
       TicketInfo ticketInfo = (TicketInfo) intent.getSerializableExtra("ticketInfo");
       TicketViewModel viewModel = new TicketViewModel();
        oldOrderId = intent.getStringExtra("oldOrderId");
       if (ticketInfo != null) {
           final TrainInfo trainInfo= ticketInfo.getTrainInfo();
           viewModel.departure.set(trainInfo.getDeparture());
           viewModel.destination.set(trainInfo.getDestination());
           viewModel.departureTime.set(trainInfo.getDepartureTime().toString());
           viewModel.trainName.set(trainInfo.getTrainName());
            binding.setTicket(viewModel);
            binding.setListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    HashMap<String, String> param = new HashMap<>();
                    param.put("trainId", String.valueOf(trainInfo.getTrainId()));
                    param.put("userId", "1");
                    param.put("departure", trainInfo.getDeparture());
                    param.put("destination", trainInfo.getDestination());
                    param.put("departureTime", trainInfo.getDepartureTime().toString());

                    if (oldOrderId != null && !TextUtils.isEmpty(oldOrderId)) {
                        param.put("oldOrderId", oldOrderId);
                        HttpUtils.post(HttpUtils.CHANGE_TICKET, param, listener, errorListener);
                    } else {
                        HttpUtils.post(HttpUtils.SUBMIT_ORDER, param, listener, errorListener);
                    }

                }
            });
       }
    }


    Response.Listener<String> listener = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            Gson gson = new Gson();
            PurchaseOrderResponse purchaseOrderResponse = gson.fromJson(response, PurchaseOrderResponse.class);
            String success;
            String failed;
            if (oldOrderId != null && !TextUtils.isEmpty(oldOrderId)){
                success = "改签成功";
                failed = "改签失败";
            } else {
                success = "购票成功";
                failed = "购票失败";
            }
            if (purchaseOrderResponse != null) {
                int code = purchaseOrderResponse.getCode();
                if (code == PurchaseOrderResponse.SUCCESS) {
                    Toast.makeText(TicketDetailActivity.this,  success , Toast.LENGTH_LONG).show();
                    TicketDetailActivity.this.startActivity(new Intent(TicketDetailActivity.this, MainActivity.class));
                } else {
                    Toast.makeText(TicketDetailActivity.this,  failed , Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(TicketDetailActivity.this,  failed, Toast.LENGTH_LONG).show();
            }
        }
    };

    Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(TicketDetailActivity.this,  " 请求失败,请检查网络状况" , Toast.LENGTH_LONG).show();
        }
    };
}
