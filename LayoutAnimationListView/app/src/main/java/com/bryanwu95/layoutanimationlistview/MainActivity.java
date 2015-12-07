package com.bryanwu95.layoutanimationlistview;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.LayoutAnimationController;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ArrayAdapter;


public class MainActivity extends ListActivity {
    private ArrayAdapter<String> adapter;
//    private LayoutAnimationController lac;
//    private ScaleAnimation sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,new String[] {"Hello","bryan","Wu"});
        setListAdapter(adapter);
        setContentView(R.layout.main);

//        sa=new ScaleAnimation(0,1,0,1);
//        sa.setDuration(1000);
//        lac=new LayoutAnimationController(sa,1.0f);
//        getListView().setLayoutAnimation(lac);

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
