package com.yly.trainsystem.ui.my;

import android.content.Intent;
import android.os.Bundle;

import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import com.yly.trainsystem.R;
import com.yly.trainsystem.ui.login.LoginActivity;

import java.util.Objects;

public class MyFragment extends PreferenceFragmentCompat {


    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.my_preferences, rootKey);
       Preference preference = getPreferenceManager().findPreference(getString(R.string.key_login));

        if (preference != null) {
            preference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    Objects.requireNonNull(getActivity()).startActivity(intent);
                    return true;
                }
            });
        }
    }


}
