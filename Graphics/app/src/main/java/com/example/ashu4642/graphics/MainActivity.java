package com.example.ashu4642.graphics;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;


public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ArrayList<Demo> demos = new ArrayList<Demo>();
        demos.add(new Demo(this, RainbowGradientActivity.class, R.string.rainbow_gradient));
        ArrayAdapter<Demo> adapter = new ArrayAdapter<Demo>(
                this,
                android.R.layout.simple_list_item_1,
                demos);
        getListView().setAdapter(adapter);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                                    Demo demo = demos.get(position);
                    startActivity(new Intent(MainActivity.this, demo.activityClass));
            }
        });
    }

    public static class Demo {
        public final Class<?> activityClass;
        public final String title;

        public Demo(Context context, Class<?> activityClass, int titleId) {
            this.activityClass = activityClass;
            this.title = context.getString(titleId);
        }

        @Override
        public String toString() {
            return this.title;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
