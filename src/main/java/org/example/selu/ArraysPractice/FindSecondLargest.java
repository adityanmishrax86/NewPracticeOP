package org.example.selu.ArraysPractice;

import org.example.selu.utils.DataProvider;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.example.selu.utils.Utilities.measureExecutionTime;

public class FindSecondLargest {

    static int getLargestNum(int[] arr) {
        int large = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > large) {
                large = arr[i];
            }
        }
        return large;
    }

    /**
     * This will only work when input array has distinct items
     * It handles single and double cases too
     * It wont work with duplicate values
     * @param arr
     * @return
     */
    static int getSecondLargestNumMethod1(int[] arr) {
        int result = 0;
        int large = 0;
        int secondLarge = -1;

        if(arr.length == 1) {
            result = -1;
        } else if (arr.length == 2) {
            result = Math.min(arr[0], arr[1]);
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > large) {
                    large = arr[i];
                }
            }

            for(int n = 0; n < arr.length; n++) {
                if(arr[n] > secondLarge && arr[n] != large) {
                    secondLarge = arr[n];
                }
            }
            result = secondLarge;

        }

        return result;
    }


    static int getSecondLargestNumMethod2(int[] arr) {
        int result = -1;
        if(arr.length == 1) {
            result = -1;
        } else if (arr.length == 2) {
            result = Math.min(arr[0], arr[1]);
        } else {

            Arrays.sort(arr);

            for (int n = arr.length-2; n >= 0; n--) {
                if(arr[n] != arr[n+1])
                    return arr[n];
            }
        }
        return result;
    }

    static int getSecondLargestNumMethod3(int[] arr) {
        int largest = -1;
        int secondLarge = -1;

        if (arr.length == 1) {
            return -1;
        } else if (arr.length == 2) {
            return Math.min(arr[0], arr[1]);
        } else {
            for (int j : arr) {
                if (j > largest)
                    largest = j;
                else if (j > secondLarge && j < largest)
                    secondLarge = j;
            }

            return secondLarge;
        }
    }

    public static void main(String[] args) {
        int[] arr = DataProvider.generateLargeArray(500000, 1000);

        LocalTime startTime = LocalTime.now();
        // Execute Method here
        System.out.println(getSecondLargestNumMethod1(arr));

        LocalTime endTime = LocalTime.now();
        Duration duration = Duration.between(startTime, endTime);
        measureExecutionTime(duration);
    }

}
