package com.yly.trainsystem.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.yly.trainsystem.R;
import com.yly.trainsystem.adapter.AdRecyclerAdapter;
import com.yly.trainsystem.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.Objects;


public class HomeFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);


        FragmentHomeBinding binding =  DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);

        ArrayList<String> list = new ArrayList<>();
        list.add("https://cn.bing.com/images/search?view=detailV2&ccid=Hwcistb%2f&id=E143FB328C0FB706E708ADFA5BD1FE054694F22E&thid=OIP.Hwcistb_c1Os3fQOxPwCIgHaE8&mediaurl=https%3a%2f%2fgss0.baidu.com%2f-4o3dSag_xI4khGko9WTAnF6hhy%2fzhidao%2fpic%2fitem%2fd833c895d143ad4bf59bb19d84025aafa40f0631.jpg&exph=672&expw=1008&q=%e9%a3%8e%e6%99%af%e5%8c%ba&simid=608029040634693663&selectedIndex=66&ajaxhist=0");
        list.add("https://cn.bing.com/images/search?view=detailV2&ccid=FEd%2bjyCS&id=FCFABCC4151E82DF532212C7FCADFDB77F0325B2&thid=OIP.FEd-jyCSYrMTLb2jGo0n0gHaE8&mediaurl=http%3a%2f%2fpic37.nipic.com%2f20140107%2f9129085_174209434189_2.jpg&exph=683&expw=1024&q=%e9%a3%8e%e6%99%af%e5%8c%ba&simid=608039082309847900&selectedIndex=118&ajaxhist=0");
        list.add("https://cn.bing.com/images/search?view=detailV2&ccid=DmE5FRK%2f&id=3762E25624B7356E5A5E5AD70799A845A5B6E20C&thid=OIP.DmE5FRK_QKmSutTtQuU_aAHaFk&mediaurl=http%3a%2f%2fwww.chinadaily.com.cn%2fzgzx%2fhenanfc8%2fimages%2fattachement%2fjpg%2fsite1%2f20090520%2f0013729ed1480b7dad4249.jpg&exph=350&expw=466&q=%e9%a3%8e%e6%99%af%e5%8c%ba&simid=608042290633442868&selectedIndex=133&ajaxhist=0");
        binding.setBookTicket(homeViewModel);
        binding.setHandler(new HomeEventHandler());
        binding.setAdRecyclerAdapter(new AdRecyclerAdapter(list, Objects.requireNonNull(getActivity())));
        return binding.getRoot();



    }


}
