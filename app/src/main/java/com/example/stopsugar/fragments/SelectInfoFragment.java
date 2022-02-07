package com.example.stopsugar.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.stopsugar.FragmentChangeListener;
import com.example.stopsugar.R;

public class SelectInfoFragment extends Fragment {

    private View rootView;

    InfoFragment infoFragment = new InfoFragment();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_selected_info, container, false);

        ImageView returnButton = rootView.findViewById(R.id.info_return);
        returnButton.setOnClickListener(returnClick);

        return rootView;
    }

    public View.OnClickListener returnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            returnToInfoSelection();
        }
    };

    public void returnToInfoSelection() {
        FragmentChangeListener fc = (FragmentChangeListener) getActivity();
        assert fc != null;
        fc.replaceFragment(infoFragment);
    }
}
