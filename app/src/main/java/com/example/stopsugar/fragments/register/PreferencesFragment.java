package com.example.stopsugar.fragments.register;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.stopsugar.R;
import com.example.stopsugar.activities.RegisterActivity;

public class PreferencesFragment extends Fragment {

    public PreferencesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_preferences, container, false);
        return view;
    }
}
