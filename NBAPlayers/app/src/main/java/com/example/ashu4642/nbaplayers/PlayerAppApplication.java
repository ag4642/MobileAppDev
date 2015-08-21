package com.example.ashu4642.nbaplayers;

/**
 * Created by ashu4642 on 11/11/2014.
 */

import android.app.Application;

import com.parse.Parse;

public class PlayerAppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

         Parse.initialize(this, "zBf2Qmv1sIsaPa7amgOJLXb0iKtlINA6ANC2ipYR", "T1J5qPy4csSamWCDPsXz5HqC6oVi4cX3EILwDAmb");
       /* ParseObject LBJ = new ParseObject("NBAPlayers");
        LBJ.addUnique("NBARank", "Lebron James");
        ParseObject KD = new ParseObject("NBAPlayers");
        KD.addUnique("NBARank", "Kevin Durant");
        ParseObject CP3 = new ParseObject("NBAPlayers");
        CP3.addUnique("NBARank", "Chris Paul");
        ParseObject AD = new ParseObject("NBAPlayers");
        AD.addUnique("NBARank", "Anthony Davis");
        ParseObject BG = new ParseObject("NBAPlayers");
        BG.addUnique("NBARank", "Blake Griffin");
        LBJ.saveInBackground();
        KD.saveInBackground();
        CP3.saveInBackground();
        AD.saveInBackground();
        BG.saveInBackground(); */
    }

}
