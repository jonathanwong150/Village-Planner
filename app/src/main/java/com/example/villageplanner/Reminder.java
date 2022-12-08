package com.example.villageplanner;
public class Reminder {
    private String reminderString;
    private String restaurantName;

    public Reminder() {
        this.reminderString = "null";
        this.restaurantName = "null";
    }

    public Reminder(Integer month, Integer day, Integer hour, Integer minute, String restaurant_name) {
        String time = month + "/" + day + " at " + hour + ":" + minute;
        this.reminderString = "Your reminder to eat " + restaurant_name + " on " + time + "!";
        this.restaurantName = restaurant_name;
    }

    public String getReminderString() {
        return this.reminderString;
    }
    public String getRestaurantName() {
        return this.restaurantName;
    }
}
