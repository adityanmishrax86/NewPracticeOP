package org.example.selu.ArraysPractice;

import java.util.Arrays;
import java.util.HashSet;

public class FindSmallestMissingPostive {

    //{2, -3, 4, 1, 1, 7}
    // {-3,1,1,2,4,7}
    @Deprecated
    static int findSmallestOne(int[] arr) {
        int i = 0;
        Arrays.sort(arr);

        for(int x = 0; x < arr.length-1; x++) {
            if(arr[x] < 0 && arr[x+1] < 0)
                continue;

            if (arr[x] - arr[x+1] < -1 && arr[x] >=0 && arr[x+1] >= 0){
               i = arr[x]+1;
               break;
            }

        }

        if(i == 0)
            i = arr[arr.length-1] + 1;

        return i;
    }

    public static int findSmallestTwo(int[] arr) {
        // don't consider -ve numbers
        // check if 1 is not present then 1 would be the smallest positive integer
        // if 1 is there then look for the next item if it is present or not until you get it
        // Here we are going without sorting
        // complexity o(n) and space o(1)
        // passed all the tests
        int i =1;
        boolean isFound = false;
        if(arr.length == 0)
            return i;
        while(!isFound) {
            for (int j : arr) {
                if (j == i) {
                    i += 1;
                    isFound = false;
                    break;
                } else {
                    isFound = true;
                }

            }

        }
        return i;
    }


    public static int findSmallestThree(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int i: arr) {
            if(i > 0)
                set.add(i);
        }

        int k =1;
        while(true) {
            if(!set.contains(k))
                return k;
            k++;
        }
    }

    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int replaceIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == val) {
                n--;
            }

            if(nums[i] != val) {
                int temp = nums[replaceIndex];
                nums[replaceIndex] = nums[i];
                nums[i] = temp;
                replaceIndex++;
            }
        }

        return n;
    }


    public static String findLongestSubString(String[] strs) {
       if(strs.length == 0)
           return "";

       if(strs.length == 1)
           return strs[0];

        // Find the minimum length string to limit comparisons
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }

        StringBuilder stringBuilder = new StringBuilder();
        // Compare character by character
        for (int i = 0; i < minLength; i++) {
            char currentChar = strs[0].charAt(i); // Take the character from the first string

            for (String str : strs) {
                if (str.charAt(i) != currentChar) { // Mismatch found
                    return stringBuilder.toString();
                }
            }

            // If all strings match at the current position, append to prefix
            stringBuilder.append(currentChar);
        }

        return stringBuilder.toString();

    }

 



    public static void main(String[] args) {
//        System.out.println(removeElement(new int[]{3,2,2,3}, 2));
        System.out.println(findLongestSubString(new String[]{"flower", "flow", "flight"}));
    }

}
