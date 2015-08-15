package com.example.mostafa.passing_data_between_activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Mostafa on 8/15/2015.
 */
public class Activity2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        //---get the data passed in using getStringExtra()---
        Toast.makeText(this,getIntent().getStringExtra("message"),
                Toast.LENGTH_SHORT).show();
        //---get the data passed in using getIntExtra()---
        Toast.makeText(this,getIntent().getStringExtra("message2"),
                Toast.LENGTH_SHORT).show();
        //---get the Bundle object passed in---
        Bundle bundle = getIntent().getExtras();
       //---get the data using the getString()---
        Toast.makeText(this, bundle.getString("message3"),
                Toast.LENGTH_SHORT).show();
       //---get the data using the getInt() method---
        Toast.makeText(this, bundle.getString("message4"),
                Toast.LENGTH_SHORT).show();
    }

    public void finishTask(View view) {
        Intent intent = new Intent();
        intent.putExtra("returnMessage", "all is Ok :)");
        setResult(RESULT_OK, intent);
        finish();
    }
}
