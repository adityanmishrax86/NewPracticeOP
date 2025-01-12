package org.example.selu.ArraysPractice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class RotateNTimes {

    static void rotateNTimesWithAList(int[] arr, int d) {
        List<Integer> list = new java.util.ArrayList<>(IntStream.of(arr).boxed().toList());
        int loop = 0;
        if(d < list.size())
            loop = d;
        else
            loop = d % list.size();

        for(int i = 0; i < loop; i++) {
            int x = list.getFirst();
            list.removeFirst();
            list.add(x);
        }

        System.out.println(list);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        rotateNTimesWithAList(arr, 255);
    }
}
