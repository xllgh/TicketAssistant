package com.yly.trainsystem.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.yly.trainsystem.R;
import com.yly.trainsystem.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.Objects;


public class HomeFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);


        FragmentHomeBinding binding =  DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(R.drawable.ad1);
        list.add(R.drawable.ad2);
        list.add(R.drawable.ad3);
       binding.setBookTicket(homeViewModel);
        binding.setHandler(new HomeEventHandler());
        binding.setAdRecyclerAdapter(new AdRecyclerAdapter(list, Objects.requireNonNull(getActivity())));
        return binding.getRoot();



    }


}
