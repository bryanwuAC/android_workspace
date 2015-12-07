package com.bryanwu95.activitylifecircle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnStartBAty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BActivity.class));
            }
        });
        System.out.println("This is onCreate");
    }

    protected void onStart(){
        super.onStart();
        System.out.println("This is onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("This is onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("This is onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("This is onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("This is onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("This is onRestart");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
