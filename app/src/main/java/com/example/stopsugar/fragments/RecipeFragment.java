package com.example.stopsugar.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.stopsugar.FragmentChangeListener;
import com.example.stopsugar.R;

public class RecipeFragment extends Fragment {

    private View rootView;
    private Button buttonChoco;

    SelectRecipeFragment selectRecipeFragment = new SelectRecipeFragment();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_recipes, container, false);

        buttonChoco =rootView.findViewById(R.id.buttonChoco);
        buttonChoco.setOnClickListener(chocoClick);

        return rootView;
    }

    private View.OnClickListener chocoClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            selectRecipe();
        }
    };

    private void selectRecipe() {
        FragmentChangeListener fc = (FragmentChangeListener) getActivity();
        assert fc != null;
        fc.replaceFragment(selectRecipeFragment);
    }
}
