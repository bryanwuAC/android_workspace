package com.example.administrator.myfragment610;

import android.support.v4.app.FragmentActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState==null){
             getSupportFragmentManager().beginTransaction().replace(R.id.container,new PlaceholderFragment()).commit();
        }
    }



}
