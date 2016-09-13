package org.iii.tw.mystopwatch;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private TextView clock;
    private Button btnLeft,btnRight;
    private boolean isRunning;
    private int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLeft = (Button)findViewById(R.id.btnLeft);
        btnRight = (Button)findViewById(R.id.btnRight);
        clock = (TextView)findViewById(R.id.clock);

    }
    //Rest /Lap
    public void doLeft(View v){
        if(isRunning){
            doRest();
        }else{
            doLap();
        }
    }
    //Start / Stop
    public void doRight(View v){
        isRunning = !isRunning;
        btnLeft.setText(isRunning?"Stop":"Start");
        btnRight.setText(isRunning?"Lap":"Rest");
        if(isRunning){
            doStart();
        }else{
            doStop();
        }
    }
    private void doStart(){

    }
    private void doStop(){

    }
    private void doRest(){

    }
    private void doLap(){

    }
    private class CounTask extends TimerTask{
        @Override
        public void run() {
            counter++;   //時間到就做這件事  週期任務
        }
    }
    private class UITask extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            clock.setText("" + counter);  //clock 秀出counter
        }
    }
}

