package org.iii.tw.mystopwatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnLeft,btnRight;
    private boolean isRunning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLeft = (Button)findViewById(R.id.btnLeft);
        btnRight = (Button)findViewById(R.id.btnRight);

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
}

