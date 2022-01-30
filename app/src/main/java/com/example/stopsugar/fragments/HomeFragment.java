package com.example.stopsugar.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.stopsugar.R;

public class HomeFragment extends Fragment {

    private View rootView;
    private int[] sugarStats = new int[3];
    private int sugarState = 0;
    ImageView homeImage;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home, container, false);

        homeImage = rootView.findViewById(R.id.home_image);
        Button addSugar = rootView.findViewById(R.id.button_add_sugar);

        sugarStats[0] = R.drawable.home_stat_0;
        sugarStats[1] = R.drawable.home_stat_1;
        sugarStats[2] = R.drawable.home_stat_2;

        addSugar.setOnClickListener(view -> {
            if(sugarState < 2) {
                sugarState++;
                changeImageStat();
            }
        });

        changeImageStat();

        return rootView;
    }

    private void changeImageStat() {
        homeImage.setImageResource(sugarStats[sugarState]);
    }
}
