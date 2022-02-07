package com.example.stopsugar.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stopsugar.FragmentChangeListener;
import com.example.stopsugar.R;
import com.example.stopsugar.fragments.SelectedRecipeManagement.IngredientsAdapter;
import com.example.stopsugar.fragments.SelectedRecipeManagement.PreparationAdapter;

import java.util.ArrayList;

public class SelectRecipeFragment extends Fragment {

    private View rootView;

    RecipeFragment recipeFragment = new RecipeFragment();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_recipe, container, false);

        ImageView returnButton = rootView.findViewById(R.id.recipe_return);
        returnButton.setOnClickListener(returnClick);

        configureRecyclerView();
        return rootView;
    }

    private void configureRecyclerView() {
        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add("Chocolat");
        ingredients.add("Oeufs");
        ingredients.add("Farine");
        ingredients.add("Beurre");

        ArrayList<String> steps = new ArrayList<>();
        steps.add("Faire fondre le beurre");
        steps.add("Faire fondre le chocolat");
        steps.add("Mélanger le tout");
        steps.add("Mettre au four 30 min");

        RecyclerView recyclerViewIngredients = rootView.findViewById(R.id.ingredientsRecycler);
        recyclerViewIngredients.setLayoutManager(new LinearLayoutManager(this.getContext()));
        IngredientsAdapter ingredientsAdapter = new IngredientsAdapter(this.getContext(), ingredients);
        recyclerViewIngredients.setAdapter(ingredientsAdapter);

        RecyclerView recyclerViewPreparation = rootView.findViewById(R.id.preparationRecycler);
        recyclerViewPreparation.setLayoutManager(new LinearLayoutManager(this.getContext()));
        PreparationAdapter preparationAdapter = new PreparationAdapter(this.getContext(), steps);
        recyclerViewPreparation.setAdapter(preparationAdapter);
    }

    public View.OnClickListener returnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            returnToRecipeSelection();
        }
    };

    public void returnToRecipeSelection() {
        FragmentChangeListener fc = (FragmentChangeListener) getActivity();
        assert fc != null;
        fc.replaceFragment(recipeFragment);
    }
}
