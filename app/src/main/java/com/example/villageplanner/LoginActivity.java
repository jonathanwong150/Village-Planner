package com.example.villageplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    FirebaseDatabase root;
    DatabaseReference usersReference;
    Boolean login_successful = false;
    Boolean register_successful = true;
    String user_key = "";
    Boolean finished = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        root = FirebaseDatabase.getInstance();
        usersReference = root.getReference("users");
    }

    //
    public interface MyCallBack {
        void onCallBack(ArrayList<User> users);
    }

    // Login functionality
    public void checkLogin(View view) {

        // Getting user input
        EditText email = (EditText) findViewById(R.id.editTextTextEmailAddress);
        String emailString = email.getText().toString();
        EditText password = (EditText) findViewById(R.id.editTextTextPassword);
        String passwordString = password.getText().toString();

        // LOGIN
        // Checking if user is in database and updating login_successful accordingly
        Intent intent = new Intent(this, MapsActivity.class);
        checkUserLogin(emailString, passwordString, new MyCallBack() {
            @Override
            public void onCallBack(ArrayList<User> users) {
                for (User user: users) {
                    if (user.getUsername().equals(emailString) && user.getPassword().equals(passwordString)) {
                        login_successful = true;
                        System.out.println("Login successful");
                        TextView tv = (TextView)findViewById(R.id.editTextTextEmailAddress);
                        tv.setText("Success!");
                        tv = (TextView)findViewById(R.id.editTextTextPassword);
                        tv.setText("");
                    }
                }

                // If user not found displays error message
                if (!login_successful) {
                    TextView error_msg = (TextView) findViewById(R.id.errorDisplay);
                    error_msg.setText("Incorrect login information!");
                }
                else {
                    intent.putExtra("userKey", user_key);
                    intent.putExtra("emailKey", emailString);
                    startActivity(intent);
                }
            }
        });
    }

    // Register functionality
    public void checkRegister(View view) {

        // Getting user input
        EditText email = (EditText) findViewById(R.id.editTextTextEmailAddress);
        String emailString = email.getText().toString();
        EditText password = (EditText) findViewById(R.id.editTextTextPassword);
        String passwordString = password.getText().toString();

        // REGISTER
        // Checking if user has already registered by searching for username and setting register_successful accordingly
        Intent intent = new Intent(this, MapsActivity.class);
        checkUserRegister(emailString, passwordString, new MyCallBack() {
            @Override
            public void onCallBack(ArrayList<User> users) {
                for (User user: users) {
                    if (user.getUsername().equals(emailString)) {
                        register_successful = false;
                    }
                }
                // If user already exists, displays error message
                if (!register_successful) {
                    TextView error_msg = (TextView) findViewById(R.id.errorDisplay);
                    error_msg.setText("User already exists!");
                    register_successful = true;
                }
                // Successfully registers and pushes new user information onto database
                else {
                    Map<String, Reminder> reminders = new HashMap<>();
                    for (int i = 1; i < 11; i += 1) {
                        Reminder r = new Reminder();
                        reminders.put(Integer.toString(i), r);
                    }

                    User user = new User(emailString, passwordString);
                    String new_user_key = usersReference.push().getKey();
                    user_key = new_user_key;
                    usersReference.child(new_user_key).setValue(user);
                    usersReference.child(new_user_key).child("reminders").setValue(reminders);

                    // Goes to Map Activity
                    intent.putExtra("userKey", user_key);
                    intent.putExtra("emailKey", emailString);
                    TextView tv = (TextView)findViewById(R.id.editTextTextEmailAddress);
                    tv.setText("Success!");
                    tv = (TextView)findViewById(R.id.editTextTextPassword);
                    tv.setText("");
                    startActivity(intent);
                }
            }
        });
    }


    // Checks if user is in database with correct inputted password
    void checkUserLogin(String username, String password, MyCallBack mcb) {

        // Checking if user is in database
        usersReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<User> users = new ArrayList<User>();
                for (DataSnapshot ds: snapshot.getChildren()) {
                    User user = (User) ds.getValue(User.class);
                    users.add(user);
                    if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                        user_key = ds.getKey();
                        System.out.println(user_key);
                    }
                }
                mcb.onCallBack(users);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    // Checks if user is in database
    void checkUserRegister(String username, String password, MyCallBack mcb) {

        // Checking if user is in database
        usersReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<User> users = new ArrayList<User>();
                for (DataSnapshot ds: snapshot.getChildren()) {
                    User user = (User) ds.getValue(User.class);
                    users.add(user);
                }
                mcb.onCallBack(users);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}