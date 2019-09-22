package com.github.king.android_stickynavlayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void btnClick(View view) {
        startActivity(new Intent(this, StCoorToolBarActivity.class));

    }

    public void btnClick2(View view) {
        startActivity(new Intent(this, AppBarActivity.class));
    }
}
