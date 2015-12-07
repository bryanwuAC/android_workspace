package com.bryanwu95.anotherapp;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.bryanwu95.startservicefromout.IAppServiceRemoteBinder;


public class MainActivity extends Activity implements View.OnClickListener, ServiceConnection {
    private Intent serviceIntent;
    private EditText etInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etInput=(EditText)findViewById(R.id.etInput);
        serviceIntent=new Intent();
        serviceIntent.setComponent(new ComponentName("com.bryanwu95.startservicefromout", "com.bryanwu95.startservicefromout.AppService"));
        findViewById(R.id.btnStartService).setOnClickListener(this);
        findViewById(R.id.btnStopService).setOnClickListener(this);
        findViewById(R.id.bindAppService).setOnClickListener(this);
        findViewById(R.id.unbindAppService).setOnClickListener(this);
        findViewById(R.id.btnSync).setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnStartService:
                //startService(serviceIntent);
                break;
            case R.id.btnStopService:
                //stopService(serviceIntent);
                break;
            case R.id.bindAppService:
                bindService(serviceIntent,this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.unbindAppService:
                unbindService(this);
                break;
            case R.id.btnSync:
                if(binder!=null){
                    try {
                        binder.setData(etInput.getText().toString());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                break;

        }

    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        System.out.println("Service has bind");
        System.out.println(service);
        binder=IAppServiceRemoteBinder.Stub.asInterface(service);

    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        binder=null;

    }

    private IAppServiceRemoteBinder binder=null;
}
