package org.example.selu.utils;

import java.util.Random;

public class DataProvider {

    public static int[] generateLargeArray(int size, int bound) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(bound); // Generate random integers between 0 and 999
        }
        return array;
    }
}
