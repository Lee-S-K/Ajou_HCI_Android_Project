package com.sklee.asd;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class course5Activity extends AppCompatActivity {
    private TextToSpeech textToSpeech;
    private Button btnEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course5);

        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = textToSpeech.setLanguage(Locale.KOREA);
                    //언어 데이터가 없거나 혹은 언어가 지원하지 않으면
                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Toast.makeText(course5Activity.this, "이 언어는 지원하지 않습니다.", Toast.LENGTH_SHORT).show();
                    } else {
                        btnEnter.setEnabled(true);
                        //음성 톤
                        textToSpeech.setPitch(0.7f);
                        //읽는 속도
                        textToSpeech.setSpeechRate(1.2f);
                    }
                }
            }
        });
        btnEnter = (Button) findViewById(R.id.btn_ent);
        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Speech();
            }
        });

        Button pre = (Button) findViewById(R.id.pre);
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("name", "이전 페이지입니다.");

                setResult(Activity.RESULT_OK, intent);

                finish();
            }
        });
        Button next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), course6Activity.class);
                startActivityForResult(intent, 106);
            }
        });

        Button tip = (Button) findViewById(R.id.tip);
        tip.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                showMessage();
            }
        });
    }

    private void Speech() {
        String text = "볼에 분량의 고춧가루를 넣고 온수 1/3컵을 넣어 섞어주세요.";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
        else
            textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);

    }

    protected void onStop() {
        super.onStop();
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
    }

    public void showMessage(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Tip");
        builder.setMessage("고춧가루를 미리 불린 후 만들어주면 국물에 떠다니지 않고 깔끔하답니다.");
        builder.setIcon(android.R.drawable.ic_dialog_alert);

        builder.setPositiveButton("화이팅", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==106){
            String name = data.getStringExtra("name");
            Toast.makeText(getApplicationContext(), name, Toast.LENGTH_LONG).show();
        }
    }

}
