package com.example.villageplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;
import java.util.HashMap;

public class QueueTimesActivity extends AppCompatActivity {

    private Intent intent;
    private String user_key;
    private String email_key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        RestaurantsQueueTimeRetriever queueTimeCalculator = new RestaurantsQueueTimeRetriever();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queue_times);
        intent = getIntent();
        String restaurant = intent.getStringExtra("res");
        user_key = intent.getStringExtra("userKey");
        email_key = intent.getStringExtra("emailKey");
        TextView tv = (TextView)findViewById(R.id.textView);
        String s="Wait time for ";
        Calendar rightNow = Calendar.getInstance();
        int hour = rightNow.get(Calendar.HOUR_OF_DAY);
        // Add time
        s = s + restaurant + " is " + queueTimeCalculator.getQueueTime(restaurant, hour) + " minutes!";
        tv.setText(s);
    }
    public void returnToMap(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("userKey",user_key);
        intent.putExtra("emailKey",email_key);
        startActivity(intent);
    }
}