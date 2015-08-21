package com.example.ashu4642.nbaplayers;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ListActivity {
    private List<Player> posts;
    private String rank;
    private String player;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_main);
        posts = new ArrayList<Player>();
        ArrayAdapter<Player> adapter = new ArrayAdapter<Player>(this,R.layout.list_item_layout, posts);
        setListAdapter(adapter);
        refreshPostList();
    Button newplayer= (Button)findViewById(R.id.button);
    newplayer.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        LinearLayout lila1= new LinearLayout(context);
        lila1.setOrientation(LinearLayout.VERTICAL);
        alert.setTitle("Which player would you like to add?");
        final EditText playerrank = new EditText(context);
        final EditText playername = new EditText(context);
        lila1.addView(playerrank);
        lila1.addView(playername);
        alert.setView(lila1);
            alert.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                player = playername.getText().toString();
                rank = playerrank.getText().toString();
                ParseObject newplayer = new ParseObject("NBAPlayers");
                Player note = new Player(newplayer.getObjectId(), rank, player);
                                posts.add(note);
                newplayer.add("Rank", rank);
                newplayer.add("Player", player);
                newplayer.saveInBackground();

                         }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Canceled.
            }
        });

        alert.show();
    }
});
}

        private void refreshPostList() {

        ParseQuery<ParseObject> query = ParseQuery.getQuery("NBAPlayers");
        query.whereEqualTo("author", ParseUser.getCurrentUser());

        setProgressBarIndeterminateVisibility(true);

        query.findInBackground(new FindCallback<ParseObject>() {

            @SuppressWarnings("unchecked")
            @Override
            public void done(List<ParseObject> postList, ParseException e) {
                setProgressBarIndeterminateVisibility(false);
                if (e == null) {
                    // If there are results, update the list of posts
                    // and notify the adapter
                    posts.clear();
                    for (ParseObject post : postList) {
                        Player note = new Player(post.getObjectId(), post.getString("Rank"), post.getString("Player"));
                        posts.add(note);
                    }
                    ((ArrayAdapter<Player>) getListAdapter())
                            .notifyDataSetChanged();
                } else {

                    Log.d(getClass().getSimpleName(), "Error: " + e.getMessage());
                }

            }

        });
    }
}
