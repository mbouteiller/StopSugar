package com.example.stopsugar.fragments.register;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.stopsugar.R;
import com.example.stopsugar.activities.RegisterActivity;

import java.util.Arrays;

public class DietParticularityFragment extends Fragment {

    private boolean[] dietParticularities = new boolean[6];
    private ImageView[] dietParticularitiesViews = new ImageView[6];


    public DietParticularityFragment() {
        Arrays.fill(dietParticularities, false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_diet_particularity, container, false);
        dietParticularitiesViews[0] = view.findViewById(R.id.glutenfree);
        dietParticularitiesViews[0].setOnClickListener(view1 -> {
            dietParticularities[0] = !dietParticularities[0];
            changeColor();
        });

        dietParticularitiesViews[1] = view.findViewById(R.id.milk);
        dietParticularitiesViews[1].setOnClickListener(view1 -> {
            dietParticularities[1] = !dietParticularities[1];
            changeColor();
        });

        dietParticularitiesViews[2] = view.findViewById(R.id.pork);
        dietParticularitiesViews[2].setOnClickListener(view1 -> {
            dietParticularities[2] = !dietParticularities[2];
            changeColor();
        });

        dietParticularitiesViews[3] = view.findViewById(R.id.plante);
        dietParticularitiesViews[3].setOnClickListener(view1 -> {
            dietParticularities[3] = !dietParticularities[3];
            changeColor();
        });

        dietParticularitiesViews[4] = view.findViewById(R.id.carrot);
        dietParticularitiesViews[4].setOnClickListener(view1 -> {
            dietParticularities[4] = !dietParticularities[4];
            changeColor();
        });

        dietParticularitiesViews[5] = view.findViewById(R.id.pescovegetarien);
        dietParticularitiesViews[5].setOnClickListener(view1 -> {
            dietParticularities[5] = !dietParticularities[5];
            changeColor();
        });

        changeColor();
        return view;
    }

    private void changeColor() {
        for (int i = 0; i < dietParticularities.length; i++) {
            if (dietParticularities[i]) {
                dietParticularitiesViews[i].setColorFilter(R.color.highlight);
            } else {
                dietParticularitiesViews[i].setColorFilter(R.color.black);
            }
        }
    }
}
