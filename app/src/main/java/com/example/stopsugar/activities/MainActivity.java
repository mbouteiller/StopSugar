package com.example.stopsugar.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;

import com.example.stopsugar.FragmentChangeListener;
import com.example.stopsugar.R;
import com.example.stopsugar.fragments.FriendsFragment;
import com.example.stopsugar.fragments.HomeFragment;
import com.example.stopsugar.fragments.InfoFragment;
import com.example.stopsugar.fragments.RecipeFragment;
import com.example.stopsugar.fragments.ScanFragment;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener, FragmentChangeListener {

    private MaterialToolbar materialToolbar;
    private NavigationBarView navigationBarView;
    private Fragment actualFragment;

//  Fragments
    HomeFragment homeFragment = new HomeFragment();
    ScanFragment scanFragment = new ScanFragment();
    RecipeFragment recipeFragment = new RecipeFragment();
    InfoFragment infoFragment = new InfoFragment();
    FriendsFragment friendsFragment = new FriendsFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        materialToolbar = findViewById(R.id.title);
        materialToolbar.setTitle("Home");
        materialToolbar.setTitleCentered(true);

        navigationBarView = findViewById(R.id.activity_main_bottom_navigation);
        navigationBarView.setOnItemSelectedListener(this);
        navigationBarView.setSelectedItemId(R.id.home_button);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();

        switch (id) {
            case R.id.home_button:
                switchFragment(homeFragment);
                materialToolbar.setTitle("Accueil");
                return true;

            case R.id.scan_button:
                switchFragment(scanFragment);
                materialToolbar.setTitle("Scan");
                return true;

            case R.id.recipe_button:
                switchFragment(recipeFragment);
                materialToolbar.setTitle("Recettes");
                return true;

            case R.id.info_button:
                switchFragment(infoFragment);
                materialToolbar.setTitle("Informations");
                return true;

            case R.id.friends_button:
                switchFragment(friendsFragment);
                materialToolbar.setTitle("Amis");
                return true;
        }
        return false;
    }

    private void switchFragment(Fragment fragment) {
        actualFragment = fragment;
        this.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in, R.anim.fade_out).replace(R.id.frame_container, fragment).commit();
    }

    @Override
    public void replaceFragment(Fragment fragment) {
        switchFragment(fragment);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK ) {
            if (actualFragment.equals(homeFragment)) {
                Intent intent = new Intent(this, MenuActivity.class);
                startActivity(intent);
            } else {
                navigationBarView.setSelectedItemId(R.id.home_button);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}