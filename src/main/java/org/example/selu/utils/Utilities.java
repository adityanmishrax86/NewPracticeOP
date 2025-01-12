package org.example.selu.utils;

import java.time.Duration;

public class Utilities {

    public static void measureExecutionTime(Duration duration) {
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;

        System.out.println(duration.toString());

        System.out.println("Execution took: " + hours + " hours " + minutes + " minutes " + seconds + " seconds");

    }
}
