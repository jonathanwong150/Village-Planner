package com.example.villageplanner;

import java.util.HashMap;

public class RestaurantsQueueTimeRetriever {

    private HashMap<String, Restaurant> restaurants;

    public RestaurantsQueueTimeRetriever() {
        restaurants = new HashMap<String, Restaurant>();
        Restaurant cava = new Restaurant("Cava", "0 0 0 0 0 0 0 5 10 15 15 20 20 20 15 10 15 15 15 20 15 20 0 0");
        Restaurant ramen_kenjo = new Restaurant("Ramen Kenjo","0 0 0 0 0 0 0 6 8 13 14 17 21 17 13 13 12 18 14 18 14 20 0 0");
        Restaurant dulce = new Restaurant("Dulce", "0 0 0 0 0 0 0 7 15 15 10 19 25 22 18 8 19 11 12 26 12 17 0 0");
        Restaurant honeybird = new Restaurant("Honeybird", "0 0 0 0 0 0 0 8 15 12 8 17 24 24 19 6 19 10 9 28 14 16 0 0");
        Restaurant kobunga = new Restaurant("Kobunga", "0 0 0 0 0 0 0 11 15 13 10 18 24 23 18 3 19 10 9 26 11 17 0 0");
        Restaurant trader_joes = new Restaurant("Trade Joe's", "0 0 0 0 0 0 0 9 18 15 7 16 21 25 16 1 18 9 6 28 10 19 0 0");
        Restaurant insomnia_cookies = new Restaurant("Insomnia Cookies","0 0 0 0 0 0 0 7 15 18 5 16 21 25 14 3 21 9 9 31 12 18 0 0" );
        Restaurant target = new Restaurant("Target","0 0 0 0 0 0 0 5 17 20 7 15 21 24 15 1 22 8 6 28 9 20 0 0" );
        Restaurant stout = new Restaurant("Stout Burgers & Beers","0 0 0 0 0 0 0 6 17 22 6 13 21 24 16 -1 21 11 4 28 11 18 0 0" );
        restaurants.put(cava.getRestaurantName(), cava);
        restaurants.put(ramen_kenjo.getRestaurantName(), ramen_kenjo);
        restaurants.put(dulce.getRestaurantName(), dulce);
        restaurants.put(honeybird.getRestaurantName(), honeybird);
        restaurants.put(kobunga.getRestaurantName(), kobunga);
        restaurants.put(trader_joes.getRestaurantName(), trader_joes);
        restaurants.put(insomnia_cookies.getRestaurantName(), insomnia_cookies);
        restaurants.put(target.getRestaurantName(), target);
        restaurants.put(stout.getRestaurantName(), stout);

    }

    // Get queue time of a restaurant given a
    public Integer getQueueTime(String restaurant_name, Integer hour) {
        if (!restaurants.containsKey(restaurant_name)) {
            return -1;
        }
        if (hour < 0 || hour > 23) {
            return -1;
        }
        String hours_times = restaurants.get(restaurant_name).getHours();
        String[] hours_split = hours_times.split(" ");
        return Integer.parseInt(hours_split[hour]);
    }

    public HashMap<String, Restaurant> getRestaurants() {
        return this.restaurants;
    }
}
