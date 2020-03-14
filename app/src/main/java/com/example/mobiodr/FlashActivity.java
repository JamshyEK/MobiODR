package com.example.mobiodr;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class FlashActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flashscreen);

        new DbManager(this);



        TimerTask task =new TimerTask() {
            @Override
            public void run() {
                Intent intent=new Intent(FlashActivity.this,LoginActivity.class);
                startActivity(intent);
                finishscreen();
            }
        };
        Timer t =new Timer();
        t.schedule(task,1500);
    }
    private  void finishscreen(){
        this.finish();
    }
}
