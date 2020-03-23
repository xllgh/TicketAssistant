package com.yly.trainsystem.ui.order;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.yly.trainsystem.R;
import com.yly.trainsystem.databinding.OrderItemBinding;

import java.util.ArrayList;
import java.util.List;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.OrderItemViewHolder> {

    private List<OrderItem> orderItems = new ArrayList<>();
    private Context context;

    public OrderListAdapter(List<OrderItem> orderItems, Context context) {
        this.orderItems.addAll(orderItems);
        this.context = context;
    }

    @NonNull
    @Override
    public OrderItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       OrderItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.order_item, parent, false);
       return new OrderItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderItemViewHolder holder, int position) {
        holder.binding.setOrderItem(orderItems.get(position));
    }

    @Override
    public int getItemCount() {
        return orderItems.size();
    }


    static class OrderItemViewHolder extends RecyclerView.ViewHolder {

        OrderItemBinding binding;

        public OrderItemBinding getBinding() {
            return binding;
        }

        OrderItemViewHolder(@NonNull OrderItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }


        public void setOrderItem(OrderItem orderItem) {
            binding.setOrderItem(orderItem);
        }
    }
}
