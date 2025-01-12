package org.example.selu.ArraysPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwoSumOp {

    public int[] twoSumOpOne(int[] arr, int target) {
        int[] sums = new int[2];

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (i + j == target) {
                    sums[0] = i;
                    sums[1] = j;
                }
            }
        }

        return sums;
    }

    public int[] twoSumOpTwo(int[] arr, int target) {
        HashMap<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (res.containsKey(target - arr[i])) {
                return new int[]{res.get(target - arr[i]), i};
            } else {
                res.put(arr[i], i);

            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public List<int[]> twoSumOpThree(int[] arr, int target) {
        List<int[]> lists = new ArrayList<>();
        HashMap<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (res.containsKey(target - arr[i])) {
                lists.add(new int[]{res.get(target - arr[i]), i});
            } else {
                res.put(arr[i], i);

            }
        }


        return lists;
    }

}
