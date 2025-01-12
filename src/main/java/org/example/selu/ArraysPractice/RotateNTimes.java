package org.example.selu.ArraysPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class RotateNTimes {

    static void rotateNTimesWithAList(int[] arr, int d) {
        List<Integer> list = new ArrayList<>(IntStream.of(arr).boxed().toList());

        int loop =0;
        if(d < list.size()) {
            loop = d;
        } else {
            loop = d % list.size();
        }

        for(int i =0; i < list.size(); i++) {
            int x = list.getFirst();
            list.removeFirst();
            list.add(x);
        }

        arr = list.stream().mapToInt(Integer::intValue).toArray();

        System.out.println(list);
    }

    static void rotateNTimesOneByOne(int[] arr, int d) {
        int loop = 0;
        if(d < arr.length)
            loop = d;
        else
            loop = d % arr.length;
        for(int i =0;i < loop;i++) {
            int tempBefore = arr[0];

            for(int j = 0; j < arr.length-1; j++) {
                arr[j] = arr[j+1];
            }
            arr[arr.length - 1] = tempBefore;
        }

        for(int n: arr)
            System.out.println(n);
    }

    static void rotateNTimesEfficient(int[] arr, int d) {
       d =  d % arr.length;

       if(d == 0) {
           Arrays.stream(arr).forEach(System.out::println);
           return;
       }
       // for first half
        reverse(arr, 0, d-1);

        // for second half
        reverse(arr, d, arr.length-1);

        //reverse entire
        reverse(arr, 0, arr.length-1);



    }

    private static void reverse(int[] arr, int start, int end) {
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        rotateNTimesEfficient(arr,3);
    }
}
