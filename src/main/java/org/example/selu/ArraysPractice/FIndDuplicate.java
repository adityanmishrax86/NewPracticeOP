package org.example.selu.ArraysPractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class FIndDuplicate {

    static void findDuplicate(int[] arr) {
        // brute force
        for(int i=0; i < arr.length;i++) {
            for(int k = i+1; k < arr.length-2;k++) {
                if(arr[i] == arr[k])
                    System.out.format("Duplicate No: %d at index: %d \n",arr[i], k);
            }
        }
    }

    static void findDuplicate2(int[] arr) {
        // Using set
        HashSet<Object> set = new HashSet<>();
        for(int i=0; i < arr.length;i++){
            if(!set.add(arr[i]))
                System.out.format("Duplicate No: %d at index: %d \n",arr[i], i);
        }
    }


    static void findDuplicate3(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: arr){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        for(int key: map.keySet()) {
            if(map.get(key) > 1)
                System.out.format("Duplicate No: %d \n",arr[key]);
        }
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,1,1,2,3,4,1,6};
        findDuplicate3(arr);
    }
}
