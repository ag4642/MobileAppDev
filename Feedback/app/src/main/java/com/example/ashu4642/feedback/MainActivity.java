package com.example.ashu4642.feedback;

import android.app.Activity;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button button1;
    private Button button2;
    private Button button3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button)findViewById(R.id.myView);
        button2 = (Button)findViewById(R.id.myView2);
        button3 = (Button)findViewById(R.id.myView3);
        button1.setOnClickListener(new View.OnClickListener() {
            Vibrator vibe = (Vibrator) getSystemService(VIBRATOR_SERVICE);

            public void onClick(View v) {
                if (v == button1) {
                    vibe.vibrate(300);
                }
            }
        });
        button2.setOnLongClickListener(new View.OnLongClickListener()
        {
            Vibrator vibe2 = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                       public boolean onLongClick(View v) {
                if (v == button2) {
                    vibe2.vibrate(300);
                                   }
                           return false;
                       }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            Vibrator vibe = (Vibrator) getSystemService(VIBRATOR_SERVICE);

            public void onClick(View v) {
                if (v == button3) {
                    vibe.vibrate(1000000000);
                }
            }
        });
    }

}