package com.example.stopsugar.fragments;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stopsugar.R;
import com.example.stopsugar.fragments.FoodManagement.FoodConsommationAdapter;
import com.example.stopsugar.fragments.FoodManagement.FoodListAdapter;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private View rootView;
    private int[] sugarStats = new int[3];
    private int sugarState = 0;
    ImageView homeImage;

    FoodConsommationAdapter foodConsommationAdapter;
    FoodListAdapter foodListAdapter;

    ArrayList<String> foodsConsommation;
    ArrayList<String> foodsList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home, container, false);

        homeImage = rootView.findViewById(R.id.home_image);
        Button addSugar = rootView.findViewById(R.id.button_add_sugar);

        sugarStats[0] = R.drawable.home_stat_0;
        sugarStats[1] = R.drawable.home_stat_1;
        sugarStats[2] = R.drawable.home_stat_2;

        addSugar.setOnClickListener(view -> {
            showPopUp();
        });

        changeImageStat(sugarState);

        configureRecyclerView();

        return rootView;
    }

    private void showPopUp() {
        View popupView = LayoutInflater.from(this.getContext()).inflate(R.layout.popup_add_food, null);
        AlertDialog.Builder popup = new AlertDialog.Builder(this.getContext());
        popup.setView(popupView);
        AlertDialog popUp = popup.create();

        RecyclerView recyclerView = (RecyclerView) popupView.findViewById(R.id.foodSearchRecycler);
        foodsList = new ArrayList<>();
        foodsList.add("Banane");
        foodsList.add("Fraises");
        foodsList.add("Pizza");
        foodsList.add("Gratin de pâtes");
        foodsList.add("Avocat");
        foodsList.add("Burger");
        foodListAdapter = new FoodListAdapter(this.getContext(),foodsList, this, popUp);
        recyclerView.setAdapter(foodListAdapter);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(popupView.getContext());
        recyclerView.setLayoutManager(mLayoutManager);

        setSearchBarListener(popupView);

        popUp.show();
    }

    private void setSearchBarListener(View view){
        EditText searchPrograms = view.findViewById(R.id.food_search_bar);
        searchPrograms.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }

    private void filter(String text) {
        ArrayList<String> filteredFoodList = new ArrayList<>();

        for (String info : foodsList) {
            if (info.toLowerCase().contains(text.toLowerCase())) {
                filteredFoodList.add(info);
            }
        }
        foodListAdapter.filterList(filteredFoodList);
    }

    public void changeImageStat(int sugarState) {
        this.sugarState = sugarState;
        homeImage.setImageResource(sugarStats[this.sugarState]);
    }


    private void configureRecyclerView() {
        foodsConsommation = new ArrayList<>();

        RecyclerView recyclerViewFood = rootView.findViewById(R.id.foodRecycler);
        recyclerViewFood.setLayoutManager(new LinearLayoutManager(this.getContext()));
        foodConsommationAdapter = new FoodConsommationAdapter(this.getContext(), foodsConsommation, this);
        recyclerViewFood.setAdapter(foodConsommationAdapter);
    }

    public void addFood(String foodName) {
        foodsConsommation.add(foodName);
        foodConsommationAdapter.notifyItemRangeInserted(foodsConsommation.size() - 1, foodsConsommation.size());
    }

    public void removeFood(String foodName) {
        for (int i = 0; i < foodsConsommation.size(); i++) {
            if (foodsConsommation.get(i).equals(foodName)) {
                foodsConsommation.remove(i);
                foodConsommationAdapter.notifyItemRemoved(i);
                return;
            }
        }
    }
}
