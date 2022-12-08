package com.example.villageplanner;

import java.util.HashMap;

public class Restaurant {

    private String restaurant_name;
    private String hours;

    public Restaurant() {
    }

    public Restaurant(String restuarant_name, String hours) {
        this.restaurant_name = restuarant_name;
        this.hours = hours;
    }

    public String getRestaurantName() {
        return this.restaurant_name;
    }

    public String getHours() {
        return this.hours;
    }
}
