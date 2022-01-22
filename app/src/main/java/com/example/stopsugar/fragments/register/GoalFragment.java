package com.example.stopsugar.fragments.register;

import android.annotation.SuppressLint;
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
        firstCard.setOnClickListener(view12 -> {
            goalChoice = 1;
            changeColorCard();
        });

        secondCard = view.findViewById(R.id.choice_2);
        secondCard.setOnClickListener(view1 -> {
            goalChoice = 2;
            changeColorCard();
        });

        changeColorCard();

        return view;
    }

    private void changeColorCard() {
        if (goalChoice == 1) {
            nextButton.setEnabled(true);
            firstCard.setCardBackgroundColor(R.color.app_green);
            secondCard.setCardBackgroundColor(R.color.black);
        }

        if (goalChoice == 2) {
            nextButton.setEnabled(true);
            secondCard.setCardBackgroundColor(R.color.app_green);
            firstCard.setCardBackgroundColor(R.color.black);
        }
    }

    public void setNextButton(Button button) {
        nextButton = button;
    }
}
