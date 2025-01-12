package org.example.selu.ArraysPractice;


import java.util.function.Function;

public class ReverseArray {

    static void reverseArray1(int[] arr) {
        int length = arr.length;
        int[] temp = new int[length];
        int counter = 0;
        for(int i=length-1; i >= 0;i--) {
            temp[counter] = arr[i];
            counter++;
        }

        for(int k:temp)
            System.out.println(k);
    }

    static void reverseArray2(int[] arr) {
        int length = arr.length;
        int counter = arr.length-1;
        for(int i=0; i < length/2;i++) {
            int temp = arr[i];
            arr[i] = arr[counter];
            arr[counter] = temp;
            counter--;
        }

        for(int k:arr)
            System.out.println(k);
    }

    static void reverseArray3(int[] arr) {
        int left = 0,right = arr.length-1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        for(int k:arr)
            System.out.println(k);
    }

    static void reverseArray4(int[] arr, int left, int right) {
        if(left >= right)
            return;

        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        reverseArray4(arr, left + 1, right - 1);
        
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2,3, 6, 5};
        reverseArray4(arr, 0, arr.length-1);
        for(int k:arr)
            System.out.println(k);
    }
}
