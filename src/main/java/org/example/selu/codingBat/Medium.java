package org.example.selu.codingBat;

import java.util.stream.IntStream;

public class Medium {

    /**
     * Given an array of scores, return true if each score is equal or greater than the one before. The array will be length 2 or more.
     * @param scores
     * @return
     */
    public static boolean scoresIncreasing(int[] scores) {
        boolean result = true;
        for(int i = 0; i < scores.length-1; i++)  {
            if(scores[i] > scores[i+1]) {
                result = false;
                break;
            }

        }

        return result;
    }

    public static boolean scoresIncreasing2(int[] scores) {

        return IntStream.range(0, scores.length -1).allMatch((x) -> scores[x] > scores[x+1]);
    }

    public static void main(String[] args) {
        System.out.println(scoresIncreasing2(new int[]{1, 2, 1}));
    }
}
