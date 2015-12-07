package com.bryanwu95.layoutchangeanimation;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class MainActivity extends Activity {
    private LinearLayout rootView;
    private View.OnClickListener btn_onClickListener=new View.OnClickListener() {

        public void onClick(View v) {
            rootView.removeView(v);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        rootView=(LinearLayout)findViewById(R.id.rootView);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void addButton() {
        Button btn=new Button(this);
        btn.setText("Remove me");
        rootView.addView(btn);
        btn.setOnClickListener(btn_onClickListener);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch(item.getItemId()){
            case R.id.action_settings:
                return true;
            case R.id.action_add:
                addButton();
                break;
            default:
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
