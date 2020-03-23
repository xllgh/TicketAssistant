package com.yly.trainsystem.ui.order;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;



import com.yly.trainsystem.R;
import com.yly.trainsystem.databinding.FragmentOrderListBinding;

import java.util.ArrayList;
import java.util.List;

public class OrderListFragment extends Fragment {

    private static OrderListAdapter adapter;

    List<OrderItem> orderItems;



    public OrderListFragment(@NonNull List<OrderItem> orderItems ) {
        this.orderItems = orderItems;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("OrderListFragment", "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("OrderListFragment", "onCreateView");
        FragmentOrderListBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_order_list, container, false);
        adapter = new OrderListAdapter(orderItems, inflater.getContext());
        binding.setLayoutManage(new LinearLayoutManager(inflater.getContext(), LinearLayoutManager.VERTICAL, false));
        binding.setOrderListAdapter(adapter);
        return binding.getRoot();


      /* View view =  inflater.inflate(R.layout.fragment_order_list, container);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem("G101", "2020-3-14"));
        orderItems.add(new OrderItem("G101", "2020-3-14"));
        orderItems.add(new OrderItem("G101", "2020-3-14"));
        orderItems.add(new OrderItem("G101", "2020-3-14"));
        orderItems.add(new OrderItem("G101", "2020-3-14"));
        orderItems.add(new OrderItem("G101", "2020-3-14"));
        recyclerView.setLayoutManager(new LinearLayoutManager(inflater.getContext()));
        recyclerView.setAdapter(new OrderListAdapter_(orderItems, inflater.getContext()));
        return view;
        */


    }
}
