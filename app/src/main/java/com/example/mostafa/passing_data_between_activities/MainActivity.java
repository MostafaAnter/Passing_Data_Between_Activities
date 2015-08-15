package com.example.mostafa.passing_data_between_activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static EditText message;
    private static EditText message2;
    private static EditText message3;
    private static EditText message4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = (EditText) findViewById(R.id.edit_text);
        message2 = (EditText) findViewById(R.id.edit_text2);
        message3 = (EditText) findViewById(R.id.edit_text3);
        message4 = (EditText) findViewById(R.id.edit_text4);
    }

    public void sent(View view) {
        // retrieve text inside EditText
        String message = this.message.getText().toString();
        String message2 = this.message2.getText().toString();
        String message3 = this.message3.getText().toString();
        String message4 = this.message4.getText().toString();

        Intent intent = new Intent(getApplicationContext(), Activity2.class);
        //---use putExtra() to add new key/value pairs---
        intent.putExtra("message", message);
        intent.putExtra("message2", message2);
        //---use a Bundle object to add new key/values
        // pairs---

        Bundle bundle = new Bundle();
        bundle.putString("message3", message3);
        bundle.putString("message4", message4);
        //last step put bundle object as intent extras
        intent.putExtras(bundle);

        startActivityForResult(intent, 1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == 1){
            if (resultCode == RESULT_OK){
                //---get the result using getIntExtra()---
                Toast.makeText(this, data.getStringExtra("returnMessage"),
                        Toast.LENGTH_LONG).show();
            }
        }
    }
}
