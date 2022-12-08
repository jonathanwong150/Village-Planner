package com.example.villageplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ReminderActivity extends AppCompatActivity {

    FirebaseDatabase root;
    DatabaseReference reminders;
    String user_key;
    String email_key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        Intent intent = getIntent();
        user_key = intent.getStringExtra("userKey");
        email_key = intent.getStringExtra("emailKey");
        System.out.println("\n" + user_key + "\n");

        // Getting reminders
        // Getting reference to users list
        root = FirebaseDatabase.getInstance();
        reminders = root.getReference("users").child(user_key).child("reminders");
        // Finding reminders
        reminders.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // Getting valid reminders
                List<Reminder> valid_reminders = new ArrayList<Reminder>();
                for (DataSnapshot ds: snapshot.getChildren()) {
                    Reminder r = (Reminder) ds.getValue(Reminder.class);
                    if (r.getReminderString().equals("null")) {
                        continue;
                    }
                    valid_reminders.add(r);
                }
                // Putting valid reminders onto textviews
                for (int i = 1; i <= valid_reminders.size(); i += 1) {
                    Reminder r = valid_reminders.get(i-1);
                    String textview_string = "textView" + Integer.toString(i);
                    int id = getResources().getIdentifier(textview_string, "id", getPackageName());
                    TextView tv = (TextView) findViewById(id);
                    tv.setText(Integer.toString(i) +". " + r.getReminderString());
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

    }

    public void editReminders(View view) {
        Intent intent = new Intent(this, AddReminder.class);
        intent.putExtra("userKey", user_key);
        intent.putExtra("emailKey",email_key);
        startActivity(intent);

    }

    public void returnToMap(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("userKey",user_key);
        intent.putExtra("emailKey",email_key);
        startActivity(intent);
    }
}