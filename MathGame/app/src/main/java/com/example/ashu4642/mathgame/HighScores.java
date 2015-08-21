package com.example.ashu4642.mathgame;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
/**
 * Created by ashu4642 on 9/18/2014.
 */
public class HighScores extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high);
        TextView scoreView = (TextView)findViewById(R.id.highscore);
        SharedPreferences scorePrefs = getSharedPreferences(PlayGame.GAME_PREFS, 0);
        String[] savedScores = scorePrefs.getString("highScores", "").split("\\|");
        StringBuilder scoreBuild = new StringBuilder("");
        for(String score : savedScores){
            scoreBuild.append(score+"\n");
        }
        scoreView.setText(scoreBuild.toString());
    }
}
