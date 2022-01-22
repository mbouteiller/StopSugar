package com.example.stopsugar.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stopsugar.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        findViewById(R.id.register).setOnClickListener(view -> changeActivity(RegisterActivity.class));
        findViewById(R.id.connection).setOnClickListener(view -> changeActivity(MainActivity.class));
    }

    private void changeActivity(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }
}
