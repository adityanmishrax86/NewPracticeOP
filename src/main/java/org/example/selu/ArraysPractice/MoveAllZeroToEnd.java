package org.example.selu.ArraysPractice;

public class MoveAllZeroToEnd {

    static void moveToEnd2(int[] arr) {
        int count = 0;
        for (int i=0; i < arr.length;i++) {
            if(arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;
                count++;

            }
        }

        for(int i: arr)
            System.out.println(i);
    }

    static void moveToEnd1(int[] arr) {
        int[] temp2 = new int[arr.length];
        int counter = 0;

        for(int i: arr) {
            if(i != 0) {
                temp2[counter] = i;
                counter++;
            }
        }

        for(int i: temp2)
            System.out.println(i);
    }

    static void moveToEnd3(int[] arr) {

    }


    public static void main(String[] args) {
        int[] arr = {1,2,0,3,5,0,6,9,0};
        moveToEnd2(arr);
    }
}
