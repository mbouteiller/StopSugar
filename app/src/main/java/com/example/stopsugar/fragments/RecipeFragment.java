package com.example.stopsugar.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stopsugar.FragmentChangeListener;
import com.example.stopsugar.R;
import com.example.stopsugar.fragments.RecipesManagement.RecipeAdapter;

import java.util.ArrayList;

public class RecipeFragment extends Fragment {

    private View rootView;
    private Button buttonChoco;

    private RecyclerView recyclerViewDeserts, recyclerViewStarters, recyclerViewMeals;
    ArrayList<String> deserts, meals, starters;

    RecyclerView.LayoutManager RecyclerViewLayoutManagerDeserts, RecyclerViewLayoutManagerMeals, RecyclerViewLayoutManagerStarters;
    RecipeAdapter recipeAdapterDeserts, recipeAdapterMeals, recipeAdapterStarters;
    LinearLayoutManager HorizontalLayoutDeserts, HorizontalLayoutMeals, HorizontalLayoutStarters;

    SelectRecipeFragment selectRecipeFragment = new SelectRecipeFragment();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_recipes, container, false);

        buttonChoco =rootView.findViewById(R.id.buttonChoco);
        buttonChoco.setOnClickListener(chocoClick);

        recyclerViewStarters = rootView.findViewById(R.id.starterRecycler);
        recyclerViewMeals = rootView.findViewById(R.id.mealRecycler);
        recyclerViewDeserts = rootView.findViewById(R.id.desertRecycler);

        RecyclerViewLayoutManagerStarters = new LinearLayoutManager(getContext());
        RecyclerViewLayoutManagerMeals = new LinearLayoutManager(getContext());
        RecyclerViewLayoutManagerDeserts = new LinearLayoutManager(getContext());


        // Set LayoutManager on Recycler View
        recyclerViewStarters.setLayoutManager(RecyclerViewLayoutManagerStarters);
        recyclerViewMeals.setLayoutManager(RecyclerViewLayoutManagerMeals);
        recyclerViewDeserts.setLayoutManager(RecyclerViewLayoutManagerDeserts);

        // Adding items to RecyclerView.
        AddItemsToRecyclerViewArrayList();

        // calling constructor of adapter
        // with source list as a parameter
        recipeAdapterStarters = new RecipeAdapter(starters);
        recipeAdapterMeals = new RecipeAdapter(meals);
        recipeAdapterDeserts = new RecipeAdapter(deserts);

        // Set Horizontal Layout Manager
        // for Recycler view
        HorizontalLayoutStarters = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false);
        HorizontalLayoutMeals = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false);
        HorizontalLayoutDeserts = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false);
        recyclerViewStarters.setLayoutManager(HorizontalLayoutStarters);
        recyclerViewMeals.setLayoutManager(HorizontalLayoutMeals);
        recyclerViewDeserts.setLayoutManager(HorizontalLayoutDeserts);

        // Set adapter on recycler view
        recyclerViewStarters.setAdapter(recipeAdapterStarters);
        recyclerViewMeals.setAdapter(recipeAdapterMeals);
        recyclerViewDeserts.setAdapter(recipeAdapterDeserts);

        return rootView;
    }

    public View.OnClickListener chocoClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            selectRecipe();
        }
    };

    public void selectRecipe() {
        FragmentChangeListener fc = (FragmentChangeListener) getActivity();
        assert fc != null;
        fc.replaceFragment(selectRecipeFragment);
    }

    public void AddItemsToRecyclerViewArrayList()
    {
        starters = new ArrayList<>();
        starters.add("Salade César");
        starters.add("Asperges au parmesan");
        starters.add("Croissant jambon-fromage");
        starters.add("Salade grecque");

        meals = new ArrayList<>();
        meals.add("Pavé de saumon");
        meals.add("Steak tartare");
        meals.add("Boeuf bourguignon");
        meals.add("Lasagnes");

        // Adding items to ArrayList
        deserts = new ArrayList<>();
        deserts.add("Mousse au chocolat");
        deserts.add("Baba au rhum");
        deserts.add("Galette des rois");
        deserts.add("Crèpes");
    }
}
