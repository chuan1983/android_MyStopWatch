package org.iii.tw.mystopwatch;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private TextView clock;
    private Button btnLeft,btnRight;       //這邊不用VIEW 因為要讓按鈕可以變動文字
    private boolean isRunning;             //小寫boolean是基本型別  Boolean是物件型別
    private int counter;
    private Timer timer;
    private UIHandler handler;        //控制全部UI
    private CounTask counTask;
    private ListView lapList;
    private SimpleAdapter adapter;
    private String[] from = {"title"};
    private int[] to = {R.id.lapitem_title};
    LinkedList<HashMap<String,String>> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLeft = (Button)findViewById(R.id.btnLeft);
        btnRight = (Button)findViewById(R.id.btnRight);
        clock = (TextView)findViewById(R.id.clock);
        timer = new Timer();         //考慮何時停止
        handler = new UIHandler();
        lapList = (ListView)findViewById(R.id.LapList);
        initListView();
    }

    @Override                  //控制timer 不讓在背景一直被執行
    public void finish() {
        timer.purge();
        timer.cancel();
        timer=null;
        super.finish();
    }

    private void initListView(){
        data = new LinkedList<>();
        adapter = new SimpleAdapter(this, null, R.layout.layout_lapitem, from, to);
        lapList.setAdapter(adapter);
    }

    //Rest /Lap
    public void doLeft(View v){
        if(isRunning){
            doReset();
        }else{
            doLap();
        }
    }
    //Start / Stop
    public void doRight(View v){
        isRunning = !isRunning;
        btnRight.setText(isRunning?"Stop":"Start");
        btnLeft.setText(isRunning?"Lap":"Rest");
        if(isRunning){
            doStart();
        }else{
            doStop();
        }
    }
    private void doStart(){
        counTask = new CounTask();
        timer.schedule(counTask,0,10);
    }
    private void doStop(){
        if(counTask != null) {
            counTask.cancel();
            counTask = null;
        }
        counter = 0;
        handler.sendEmptyMessage(0);    //這邊的值也是都可以 觸發動作
    }
    private void doReset(){

    }
    private void doLap(){

    }
    private class CounTask extends TimerTask{
        @Override
        public void run() {
            counter++;   //時間到就做這件事  週期任務
            handler.sendEmptyMessage(0);  //這裡的值都可以,這只做觸發動作
        }
    }
    private class UIHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            clock.setText(":" + counter);  //clock 秀出counter
        }
    }
}

