package com.example.stopsugar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.stopsugar.R;
import com.example.stopsugar.fragments.register.CookingToolsFragment;
import com.example.stopsugar.fragments.register.DietParticularityFragment;
import com.example.stopsugar.fragments.register.GoalFragment;

public class RegisterActivity extends AppCompatActivity {

    //ImageView
    ImageView[] imageviews = new ImageView[4];

    //Fragments
    Fragment[] fragments = new Fragment[3];
    GoalFragment goalFragment = new GoalFragment();
    DietParticularityFragment dietParticularityFragment = new DietParticularityFragment();
    CookingToolsFragment cookingToolsFragment = new CookingToolsFragment();

    int currentFragment = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fragments[0] = goalFragment;
        fragments[1] = dietParticularityFragment;
        fragments[2] = cookingToolsFragment;
        switchFragment(goalFragment);

        findViewById(R.id.step_before).setOnClickListener(view -> switchPreviousFragment());

        imageviews[0] = findViewById(R.id.inscription_1);
        imageviews[1] = findViewById(R.id.inscription_2);
        imageviews[2] = findViewById(R.id.inscription_3);
        changeActiveProgression(currentFragment);

        Button nextButton = findViewById(R.id.next_button);
        goalFragment.setNextButton(nextButton);
        nextButton.setOnClickListener(newView -> switchNextFragment());
        nextButton.setEnabled(false);
    }

    public void switchPreviousFragment() {
        changeInactiveProgression(currentFragment);
        currentFragment--;
        if (currentFragment == -1) {
            changeActivity(MenuActivity.class);
        } else {
            changeActiveProgression(currentFragment);
            switchFragment(fragments[currentFragment]);
        }
    }

    public void switchNextFragment() {
        changeInactiveProgression(currentFragment);
        currentFragment++;
        if (currentFragment == fragments.length) {
            changeActivity(MainActivity.class);
        } else {
            changeActiveProgression(currentFragment);
            switchFragment(fragments[currentFragment]);
        }
    }

    public void switchFragment(Fragment fragment) {
        this.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in, R.anim.fade_out).replace(R.id.frame_container, fragment).commit();
    }

    private void changeActiveProgression(int index) {
        imageviews[index].setColorFilter(getColor(R.color.app_green));
    }

    private void changeInactiveProgression(int index) {
        imageviews[index].setColorFilter(getColor(R.color.black));
    }

    private void changeActivity(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK ) {
            switchPreviousFragment();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
