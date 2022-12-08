package com.example.villageplanner;

import static org.junit.Assert.*;

import junit.framework.TestCase;

import org.jetbrains.annotations.TestOnly;
import org.junit.Before;
import org.junit.Test;

public class QueueTimeTest extends TestCase {
    RestaurantsQueueTimeRetriever queueTimeCalculator;
    
    @Before
    public void setUp() throws Exception {
        queueTimeCalculator = new RestaurantsQueueTimeRetriever();
    }

    // Test 11
    @Test
    public void testQueueTimeRestaurant1() {
        assertEquals("0", Integer.toString(queueTimeCalculator.getQueueTime("Cava", 0)));
        assertEquals("0", Integer.toString(queueTimeCalculator.getQueueTime("Cava", 1)));
        assertEquals("0", Integer.toString(queueTimeCalculator.getQueueTime("Cava", 2)));
        assertEquals("0", Integer.toString(queueTimeCalculator.getQueueTime("Cava", 3)));
        assertEquals("0", Integer.toString(queueTimeCalculator.getQueueTime("Cava", 4)));
        assertEquals("0", Integer.toString(queueTimeCalculator.getQueueTime("Cava", 5)));
        assertEquals("0", Integer.toString(queueTimeCalculator.getQueueTime("Cava", 6)));
        assertEquals("5", Integer.toString(queueTimeCalculator.getQueueTime("Cava", 7)));
        assertEquals("10", Integer.toString(queueTimeCalculator.getQueueTime("Cava", 8)));
        assertEquals("15", Integer.toString(queueTimeCalculator.getQueueTime("Cava", 9)));
        assertEquals("15", Integer.toString(queueTimeCalculator.getQueueTime("Cava", 10)));
        assertEquals("20", Integer.toString(queueTimeCalculator.getQueueTime("Cava", 11)));
        assertEquals("20", Integer.toString(queueTimeCalculator.getQueueTime("Cava", 12)));
        assertEquals("20", Integer.toString(queueTimeCalculator.getQueueTime("Cava", 13)));
        assertEquals("15", Integer.toString(queueTimeCalculator.getQueueTime("Cava", 14)));
        assertEquals("10", Integer.toString(queueTimeCalculator.getQueueTime("Cava", 15)));
        assertEquals("15", Integer.toString(queueTimeCalculator.getQueueTime("Cava", 16)));
        assertEquals("15", Integer.toString(queueTimeCalculator.getQueueTime("Cava", 17)));
        assertEquals("15", Integer.toString(queueTimeCalculator.getQueueTime("Cava", 18)));
        assertEquals("20", Integer.toString(queueTimeCalculator.getQueueTime("Cava", 19)));
        assertEquals("15", Integer.toString(queueTimeCalculator.getQueueTime("Cava", 20)));
        assertEquals("20", Integer.toString(queueTimeCalculator.getQueueTime("Cava", 21)));
        assertEquals("0", Integer.toString(queueTimeCalculator.getQueueTime("Cava", 22)));
        assertEquals("0", Integer.toString(queueTimeCalculator.getQueueTime("Cava", 23)));
    }

    // Test 12
    public void testQueueTimeRestaurant2() {
        assertEquals("0", Integer.toString(queueTimeCalculator.getQueueTime("Ramen Kenjo", 0)));
        assertEquals("0", Integer.toString(queueTimeCalculator.getQueueTime("Ramen Kenjo", 1)));
        assertEquals("0", Integer.toString(queueTimeCalculator.getQueueTime("Ramen Kenjo", 2)));
        assertEquals("0", Integer.toString(queueTimeCalculator.getQueueTime("Ramen Kenjo", 3)));
        assertEquals("0", Integer.toString(queueTimeCalculator.getQueueTime("Ramen Kenjo", 4)));
        assertEquals("0", Integer.toString(queueTimeCalculator.getQueueTime("Ramen Kenjo", 5)));
        assertEquals("0", Integer.toString(queueTimeCalculator.getQueueTime("Ramen Kenjo", 6)));
        assertEquals("6", Integer.toString(queueTimeCalculator.getQueueTime("Ramen Kenjo", 7)));
        assertEquals("8", Integer.toString(queueTimeCalculator.getQueueTime("Ramen Kenjo", 8)));
        assertEquals("13", Integer.toString(queueTimeCalculator.getQueueTime("Ramen Kenjo", 9)));
        assertEquals("14", Integer.toString(queueTimeCalculator.getQueueTime("Ramen Kenjo", 10)));
        assertEquals("17", Integer.toString(queueTimeCalculator.getQueueTime("Ramen Kenjo", 11)));
        assertEquals("21", Integer.toString(queueTimeCalculator.getQueueTime("Ramen Kenjo", 12)));
        assertEquals("17", Integer.toString(queueTimeCalculator.getQueueTime("Ramen Kenjo", 13)));
        assertEquals("13", Integer.toString(queueTimeCalculator.getQueueTime("Ramen Kenjo", 14)));
        assertEquals("13", Integer.toString(queueTimeCalculator.getQueueTime("Ramen Kenjo", 15)));
        assertEquals("12", Integer.toString(queueTimeCalculator.getQueueTime("Ramen Kenjo", 16)));
        assertEquals("18", Integer.toString(queueTimeCalculator.getQueueTime("Ramen Kenjo", 17)));
        assertEquals("14", Integer.toString(queueTimeCalculator.getQueueTime("Ramen Kenjo", 18)));
        assertEquals("18", Integer.toString(queueTimeCalculator.getQueueTime("Ramen Kenjo", 19)));
        assertEquals("14", Integer.toString(queueTimeCalculator.getQueueTime("Ramen Kenjo", 20)));
        assertEquals("20", Integer.toString(queueTimeCalculator.getQueueTime("Ramen Kenjo", 21)));
        assertEquals("0", Integer.toString(queueTimeCalculator.getQueueTime("Ramen Kenjo", 22)));
        assertEquals("0", Integer.toString(queueTimeCalculator.getQueueTime("Ramen Kenjo", 23)));
    }

    // Test 13
    public void testQueueTimeRestaurant3() {
        assertEquals("0", Integer.toString(queueTimeCalculator.getQueueTime("Dulce", 0)));
        assertEquals("0", Integer.toString(queueTimeCalculator.getQueueTime("Dulce", 1)));
        assertEquals("0", Integer.toString(queueTimeCalculator.getQueueTime("Dulce", 2)));
        assertEquals("0", Integer.toString(queueTimeCalculator.getQueueTime("Dulce", 3)));
        assertEquals("0", Integer.toString(queueTimeCalculator.getQueueTime("Dulce", 4)));
        assertEquals("0", Integer.toString(queueTimeCalculator.getQueueTime("Dulce", 5)));
        assertEquals("0", Integer.toString(queueTimeCalculator.getQueueTime("Dulce", 6)));
        assertEquals("7", Integer.toString(queueTimeCalculator.getQueueTime("Dulce", 7)));
        assertEquals("15", Integer.toString(queueTimeCalculator.getQueueTime("Dulce", 8)));
        assertEquals("15", Integer.toString(queueTimeCalculator.getQueueTime("Dulce", 9)));
        assertEquals("10", Integer.toString(queueTimeCalculator.getQueueTime("Dulce", 10)));
        assertEquals("19", Integer.toString(queueTimeCalculator.getQueueTime("Dulce", 11)));
        assertEquals("25", Integer.toString(queueTimeCalculator.getQueueTime("Dulce", 12)));
        assertEquals("22", Integer.toString(queueTimeCalculator.getQueueTime("Dulce", 13)));
        assertEquals("18", Integer.toString(queueTimeCalculator.getQueueTime("Dulce", 14)));
        assertEquals("8", Integer.toString(queueTimeCalculator.getQueueTime("Dulce", 15)));
        assertEquals("19", Integer.toString(queueTimeCalculator.getQueueTime("Dulce", 16)));
        assertEquals("11", Integer.toString(queueTimeCalculator.getQueueTime("Dulce", 17)));
        assertEquals("12", Integer.toString(queueTimeCalculator.getQueueTime("Dulce", 18)));
        assertEquals("26", Integer.toString(queueTimeCalculator.getQueueTime("Dulce", 19)));
        assertEquals("12", Integer.toString(queueTimeCalculator.getQueueTime("Dulce", 20)));
        assertEquals("17", Integer.toString(queueTimeCalculator.getQueueTime("Dulce", 21)));
        assertEquals("0", Integer.toString(queueTimeCalculator.getQueueTime("Dulce", 22)));
        assertEquals("0", Integer.toString(queueTimeCalculator.getQueueTime("Dulce", 23)));
    }

    // Test 14
    public void testRestaurant1Hours() {
        String cava_hours = "0 0 0 0 0 0 0 5 10 15 15 20 20 20 15 10 15 15 15 20 15 20 0 0";
        assertEquals(cava_hours, queueTimeCalculator.getRestaurants().get("Cava").getHours());
    }

    // Test 15
    public void testRestaurant2Hours() {
        String kobunga = "0 0 0 0 0 0 0 11 15 13 10 18 24 23 18 3 19 10 9 26 11 17 0 0";
        assertEquals(kobunga, queueTimeCalculator.getRestaurants().get("Kobunga").getHours());
    }

}