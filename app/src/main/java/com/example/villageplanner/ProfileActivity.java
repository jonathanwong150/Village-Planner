package com.example.villageplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    Intent intent;
    String user_key;
    String email_key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        intent = getIntent();
        user_key = intent.getStringExtra("userKey");
        email_key = intent.getStringExtra("emailKey");
        TextView tv = findViewById(R.id.textView15);
        tv.setText("Hello, " +email_key + "!");
    }
    public void toMap(View view) {
        Intent toMap = new Intent(this, MapsActivity.class);
        toMap.putExtra("userKey",user_key);
        toMap.putExtra("emailKey",email_key);
        startActivity(toMap);
    }
    public void logOut(View view) {
        Intent exit = new Intent(this, LoginActivity.class);
        startActivity(exit);
    }
}