package com.yly.trainsystem.ui.order;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.tabs.TabLayout;
import com.yly.trainsystem.R;
import com.yly.trainsystem.databinding.FragmentOrderBinding;
import com.yly.trainsystem.volley.HttpUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class OrderFragment extends Fragment {

    private OrderViewModel orderViewModel;



    public View onCreateView(@NonNull final LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        orderViewModel =
                ViewModelProviders.of(this).get(OrderViewModel.class);
        FragmentOrderBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_order, container, false);
        binding.setOrderViewModel(orderViewModel);
        HashMap<String, String> map = new HashMap<>();
        map.put("userId", "1");
        HttpUtils.post(HttpUtils.QUERY_USER_TICKET, map);

        List<OrderListFragment> list = new ArrayList<>();
        List<OrderItem> orderItems1 = new ArrayList<>();
        orderItems1.add(new OrderItem("G101", "2020-3-14"));
        orderItems1.add(new OrderItem("G101", "2020-3-14"));
        orderItems1.add(new OrderItem("G101", "2020-3-14"));
        orderItems1.add(new OrderItem("G101", "2020-3-14"));
        orderItems1.add(new OrderItem("G101", "2020-3-14"));
        orderItems1.add(new OrderItem("G101", "2020-3-14"));

        List<OrderItem> orderItems2 = new ArrayList<>();
        orderItems2.add(new OrderItem("G19098", "2020-3-14"));
        orderItems2.add(new OrderItem("G19098", "2020-3-14"));
        orderItems2.add(new OrderItem("G101", "2020-3-14"));


        list.add(new OrderListFragment(orderItems1));
        list.add(new OrderListFragment(orderItems2));
        final OrderAdapter orderAdapter = new OrderAdapter(Objects.requireNonNull(getActivity()), list);
        binding.setOrderAdapter(orderAdapter);

        TabLayout.OnTabSelectedListener tabSelectedListener = new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

               if (tab.getText().equals(inflater.getContext().getString(R.string.future_order))) {
                    orderViewModel.currentPage.set(0);
                } else {
                   orderViewModel.currentPage.set(1);
               }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        };

        binding.setTabSelectListener(tabSelectedListener);

        return binding.getRoot();
    }
}
