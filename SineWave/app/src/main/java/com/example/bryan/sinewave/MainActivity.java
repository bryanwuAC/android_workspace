package com.example.bryan.sinewave;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {

    private Button connect;
    private Button getData;
    private EditText etIp;
    private String ip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connect= (Button) findViewById(R.id.btnConnect);
        getData= (Button) findViewById(R.id.btnGetData);
        etIp=(EditText)findViewById(R.id.ip);
        ip=etIp.getText().toString();

        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connect();
            }
        });
        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connect();
                sendData(data);

            }
        });
    }

    private void sendData(String data){
        Intent i=new Intent(MainActivity.this, GraphProcess.class);
        i.putExtra("20points",data);
        startActivity(i);
    }

    //----------------------------------------------------------------------

    private Socket socket=null;
    private BufferedReader reader=null;
    private String data="";
    private boolean socketFlag=false;
    private   byte[] sData=new byte[1024];//
    private int rlRead;

    private void connect() {
        AsyncTask<Void, String, Void> read = new AsyncTask<Void, String, Void>() {
            @Override
            protected Void doInBackground(Void... params) {


                try {
                    if (!socketFlag) {
                        socket = new Socket(ip, 8899); // ip地址，端口号
                        publishProgress("@success");
                    }

                } catch (UnknownHostException e) {
                    Toast.makeText(MainActivity.this, "无法创建连接", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(MainActivity.this, "无法创建连接", Toast.LENGTH_SHORT).show();
                }


                try {
                    if (socketFlag) {
                        rlRead = socket.getInputStream().read(sData);

                        if (rlRead > 0) {
                            //data = "";
                            for (int i = 0; i < rlRead; i++) {
                                data = data + ((char) sData[i]);
                            }
                        }
                    } else socketFlag = true;
                } catch (IOException e) {

                    e.printStackTrace();
                }
                return null;
            }


            @Override
            protected void onProgressUpdate(String... values) {
                if (values[0].equals("@success")) {
                    Toast.makeText(MainActivity.this, "连接成功！", Toast.LENGTH_SHORT).show();
                }
                super.onProgressUpdate(values);
            }
        };
        read.execute();
    }
}
