package com.sklee.asd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity {

    private TextView countdownText;
    private Button countdownButton;

    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds=300000;
    private boolean timerRuning;
    private SoundPool sound_pool;
    private int sound_beep;
    private Button btn_pre;
    private Button btn_next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer2);

        initSound();
        btn_next=findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TimerActivity.this,course10Activity.class);
                startActivity(intent);
            }
        });
        btn_pre=findViewById(R.id.btn_pre);
        btn_pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TimerActivity.this,course9Activity.class);
                startActivity(intent);
            }
        });
        countdownText=findViewById(R.id.countdown_text);
        countdownButton=findViewById(R.id.countdown_button);
        countdownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startStop();
            }
        });

    }

    public void startStop(){
        if(timerRuning){
            stopTimer();
        }
        else
        {
            startTimer();
        }
    }

    public void startTimer()
    {
        countDownTimer=new CountDownTimer(timeLeftInMilliseconds,1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMilliseconds=l;
                updateTimer();
            }

            @Override
            public void onFinish() {

                playSound();

            }
        }.start();

        countdownButton.setText("PAUSE");
        timerRuning=true;
    }


    public void stopTimer(){

        playSound();
        countDownTimer.cancel();
        countdownButton.setText("START");
        timerRuning=false;

    }
    public  void updateTimer()
    {
     int minutes=(int)timeLeftInMilliseconds/60000;
     int seconds=(int)timeLeftInMilliseconds%60000/1000;

     String timeLeftText;

     timeLeftText=""+minutes;
     timeLeftText+=":";
     if(seconds<10)timeLeftText+="0";
     timeLeftText+=seconds;
     countdownText.setText(timeLeftText);
    }
    private void initSound()
    {
        sound_pool=new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        sound_beep=sound_pool.load(getBaseContext(),R.raw.dingdong,1);
    }
    public void playSound()
    {
        sound_pool.play(sound_beep,1f,1f,0,0,1f);
    }








}
