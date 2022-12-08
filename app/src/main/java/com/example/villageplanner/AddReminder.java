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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AddReminder extends AppCompatActivity {

    FirebaseDatabase root;
    DatabaseReference reminders;
    String user_key;
    String email_key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reminder);
        Intent intent = getIntent();
        user_key = intent.getStringExtra("userKey");
        email_key = intent.getStringExtra("emailKey");
        System.out.println("\n" + user_key + "\n");

        // Getting reminders
        // Getting reference to users list
        root = FirebaseDatabase.getInstance();
        reminders = root.getReference("users").child(user_key).child("reminders");
    }

    public interface MyCallBack {
        void onCallBack(String index_to_add);
    }

    public void addReminder(View view) {
        // Error Text View
        TextView errortv = (TextView) findViewById(R.id.errorMessage);
        // Getting user input
        EditText restaurantEditText = (EditText) findViewById(R.id.restaurantNameTextField);
        String restaurant_name = restaurantEditText.getText().toString();
        EditText monthEditText = (EditText) findViewById(R.id.monthTextField);
        EditText dayEditText = (EditText) findViewById(R.id.dayTextField);
        EditText hourEditText = (EditText) findViewById(R.id.hourTextField);
        EditText minuteEditText = (EditText) findViewById(R.id.minuteTextField);
        Integer month = null; Integer day = null; Integer hour = null; Integer minute = null;
        try {
            month = Integer.parseInt(monthEditText.getText().toString());
            day = Integer.parseInt(dayEditText.getText().toString());
            hour = Integer.parseInt(hourEditText.getText().toString());
            minute = Integer.parseInt(minuteEditText.getText().toString());
        }
        catch (Exception error) {
            errortv.setText("Input Error! Please double check values.");
            return;
        }
        if ((month < 1 || month > 12) || (day < 1 || day > 31) || (hour < 0 || hour > 23) || (minute < 0 || minute > 59)) {
            errortv.setText("Input Error! Please double value ranges.");
            return;
        }

        // Adding new reminder to reminders
        Reminder new_reminder = new Reminder(month, day, hour, minute, restaurant_name);

        // Adding reminder
        Intent intent = new Intent(this, ReminderActivity.class);
        addReminderDataBase(new_reminder, new MyCallBack() {
            @Override
            public void onCallBack(String index_to_add) {
                if (Integer.parseInt(index_to_add) > 10) {
                    errortv.setText("You already have set a max of 10 reminders at once!");
                    return;
                }
                reminders.child(index_to_add).setValue(new_reminder);
                intent.putExtra("userKey", user_key);
                intent.putExtra("emailKey", email_key);
                startActivity(intent);
            }
        });
    }

    void addReminderDataBase(Reminder new_reminder, MyCallBack mcb) {
        // Finding reminders
        reminders.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // Getting valid reminders
                ArrayList<Reminder> valid_reminders = new ArrayList<Reminder>();
                for (DataSnapshot ds: snapshot.getChildren()) {
                    Reminder r = (Reminder) ds.getValue(Reminder.class);
                    if (r.getReminderString().equals("null")) {
                        break;
                    }
                    valid_reminders.add(r);
                }
                String key_reminder_insert = Integer.toString(valid_reminders.size()+1);
                System.out.println("insert: " +key_reminder_insert);
                mcb.onCallBack(key_reminder_insert);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void deleteReminder(View view) {
        // Error Text View
        TextView errortv = (TextView) findViewById(R.id.errorMessage);
        // Getting user input
        EditText deleteReminderEditText = (EditText) findViewById(R.id.deleteReminderTextField);
        Integer deleteNumber = null;
        try {
            deleteNumber = Integer.parseInt(deleteReminderEditText.getText().toString());
        } catch (Exception error) {
            errortv.setText("Invalid input reminder number to delete!");
            return;
        }

        if (deleteNumber < 1 || deleteNumber > 10) {
            errortv.setText("Reminder number out of range!");
            return;
        }

        // Deleting from database
        Intent intent = new Intent(this, ReminderActivity.class);
        deleteReminderDatabase(deleteNumber, new MyCallBack() {
            @Override
            public void onCallBack(String index_to_add) {
                if (index_to_add == "-1") {
                    errortv.setText("Reminder does not exist for you!");
                    return;
                }
                intent.putExtra("userKey", user_key);
                intent.putExtra("emailKey", email_key);
                startActivity(intent);
            }
        });
    }

    void deleteReminderDatabase(Integer toDelete, MyCallBack mcb) {
        // Finding reminders
        reminders.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // Getting valid reminders
                ArrayList<Reminder> valid_reminders = new ArrayList<Reminder>();
                for (DataSnapshot ds: snapshot.getChildren()) {
                    Reminder r = (Reminder) ds.getValue(Reminder.class);
                    if (r.getReminderString().equals("null")) {
                        break;
                    }
                    valid_reminders.add(r);
                }
                // If selected number greater than current size, return
                if (toDelete > valid_reminders.size()) {
                    mcb.onCallBack("-1");
                    return;
                }
                // Deleting reminder and then repopulating reminders in database
                Map<String, Reminder> reminders_new_list = new HashMap<>();
                valid_reminders.remove(toDelete-1);
                for (int i = 0; i < valid_reminders.size(); i +=1) {
                    reminders_new_list.put(Integer.toString(i+1), valid_reminders.get(i));
                }
                for (int i = 1; i < 11; i += 1) {
                    if (reminders_new_list.containsKey(Integer.toString(i))) {
                        continue;
                    }
                    Reminder r = new Reminder();
                    reminders_new_list.put(Integer.toString(i), r);
                }
                reminders.setValue(reminders_new_list);

                mcb.onCallBack("1");
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}