package com.example.ashu4642.mathgame;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;


public class MyActivity extends Activity implements OnClickListener {
    private Button play, high;

    private String[] levelNames = {"Easy", "Medium", "Hard"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
               play = (Button)findViewById(R.id.play);
                high = (Button)findViewById(R.id.high);
        play.setOnClickListener(this);
                high.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.play){


            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Choose a level");
            builder.setSingleChoiceItems(levelNames, 0, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    startPlay(which);
                }
            });
            AlertDialog ad = builder.create();
            ad.show();
        }

        else if(view.getId()==R.id.high){
            Intent highIntent = new Intent(this, HighScores.class);
            this.startActivity(highIntent);
        }
    }
    private void startPlay(int chosenLevel)
    {
        Intent playIntent = new Intent(this, PlayGame.class);
        playIntent.putExtra("level", chosenLevel);
        this.startActivity(playIntent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
                int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
