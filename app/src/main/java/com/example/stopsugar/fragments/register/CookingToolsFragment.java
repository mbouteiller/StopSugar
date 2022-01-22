package com.example.stopsugar.fragments.register;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.stopsugar.R;

import java.util.Arrays;

public class CookingToolsFragment extends Fragment {

    private final boolean[] cookingTools = new boolean[6];
    private final ImageView[] cookingToolsViews = new ImageView[6];

    public CookingToolsFragment() {
        Arrays.fill(cookingTools, false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_cooking_tools, container, false);

        cookingToolsViews[0] = view.findViewById(R.id.microwaveoven);
        cookingToolsViews[0].setOnClickListener(view1 -> {
            cookingTools[0] = !cookingTools[0];
            changeColor();
        });

        cookingToolsViews[1] = view.findViewById(R.id.blender);
        cookingToolsViews[1].setOnClickListener(view1 -> {
            cookingTools[1] = !cookingTools[1];
            changeColor();
        });

        cookingToolsViews[2] = view.findViewById(R.id.cooktop);
        cookingToolsViews[2].setOnClickListener(view1 -> {
            cookingTools[2] = !cookingTools[2];
            changeColor();
        });

        cookingToolsViews[3] = view.findViewById(R.id.microwave);
        cookingToolsViews[3].setOnClickListener(view1 -> {
            cookingTools[3] = !cookingTools[3];
            changeColor();
        });

        cookingToolsViews[4] = view.findViewById(R.id.deepfryer);
        cookingToolsViews[4].setOnClickListener(view1 -> {
            cookingTools[4] = !cookingTools[4];
            changeColor();
        });

        cookingToolsViews[5] = view.findViewById(R.id.cooker);
        cookingToolsViews[5].setOnClickListener(view1 -> {
            cookingTools[5] = !cookingTools[5];
            changeColor();
        });

        changeColor();
        return view;
    }

    private void changeColor() {
        for (int i = 0; i < cookingTools.length; i++) {
            if (cookingTools[i]) {
                cookingToolsViews[i].setColorFilter(R.color.highlight);
            } else {
                cookingToolsViews[i].setColorFilter(R.color.black);
            }
        }
    }
}
