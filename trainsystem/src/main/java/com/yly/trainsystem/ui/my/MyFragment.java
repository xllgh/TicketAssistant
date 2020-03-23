package com.yly.trainsystem.ui.my;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import com.yly.trainsystem.R;

public class MyFragment extends PreferenceFragmentCompat {


    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.my_preferences, rootKey);
    }


}
