package org.example.selu.ArraysPractice;

public class MaxSubArray {

    public static int maxSubarraySum(int[] arr) {
        if(arr.length == 1)
            return arr[0];
        else if (arr.length == 0)
            return 0;

        int sum = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++) {
            int max = 0;
            for(int j = i; j < arr.length; j++) {
                    max += arr[j];
                sum = Math.max(max, sum);

            }

        }

        return sum;
    }

    public static int maxSubArraySum(int[] arr) {
        if(arr.length == 1)
            return arr[0];
        else if (arr.length == 0)
            return 0;

        int sum =  Integer.MIN_VALUE;
        int local = 0;
        for(int i=0; i < arr.length; i++) {
            local = Math.max(arr[i], arr[i] + local);
            if(local > sum)
                sum = local;
        }

        return sum;
    }
}
