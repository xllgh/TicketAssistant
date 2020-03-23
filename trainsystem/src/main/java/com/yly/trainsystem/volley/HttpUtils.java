package com.yly.trainsystem.volley;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.yly.trainsystem.MyApplication;
import com.yly.trainsystem.ui.home.HomeViewModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class HttpUtils<T> {

    public static final String QUERY_TICKET = "http://192.168.1.110:8080/queryTicket";
    public static final String QUERY_USER_TICKET = "http://192.168.1.110:8080/queryUserOrder";


    public static void post(String url, final HashMap<String, String> requestParam) {

        RequestQueue queue = Volley.newRequestQueue(MyApplication.getMyApplication());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.e("response", response);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("response", "error" + error.getMessage());

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return requestParam;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("Content-Type", "application/x-www-form-urlencoded");
                return map;
            }
        };
        queue.add(stringRequest);
    }
}