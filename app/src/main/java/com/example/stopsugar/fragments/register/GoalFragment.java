package com.example.stopsugar.fragments.register;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.stopsugar.R;
import com.example.stopsugar.activities.RegisterActivity;

public class GoalFragment extends Fragment {

    private int goalChoice;

    //CardView
    CardView firstCard;
    CardView secondCard;

    Button nextButton;

    public GoalFragment() {
        this.goalChoice = 0;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_goal, container, false);

        firstCard = view.findViewById(R.id.choice_1);
        firstCard.setOnClickListener(view1 -> {
            goalChoice = 1;
            changeColorCardChoice1();
        });

        secondCard = view.findViewById(R.id.choice_2);
        secondCard.setOnClickListener(view1 -> {
            goalChoice = 2;
            changeColorCardChoice2();
        });

        if (goalChoice == 1) {
            changeColorCardChoice1();
        } else if (goalChoice == 2) {
            changeColorCardChoice2();
        }

        return view;
    }

    @SuppressLint("ResourceAsColor")
    private void changeColorCardChoice1() {
        nextButton.setEnabled(true);
        firstCard.setCardBackgroundColor(Color.GREEN);
        secondCard.setCardBackgroundColor(Color.WHITE);
    }

    @SuppressLint("ResourceAsColor")
    private void changeColorCardChoice2() {
        nextButton.setEnabled(true);
        secondCard.setCardBackgroundColor(Color.GREEN);
        firstCard.setCardBackgroundColor(Color.WHITE);
    }

    public void setNextButton(Button button) {
        nextButton = button;
    }
}
