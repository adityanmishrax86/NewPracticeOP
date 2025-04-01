package org.example.selu.StreamPractice;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumbersStream {

    //Write a Java program to calculate the average of a list of integers using streams.
    public static void calculateAverage() {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);
        double avg = numbers.stream().mapToDouble(Integer::doubleValue).average().orElse(0);
        System.out.println(avg);
    }


    // Write a Java program to calculate the weighted average of a list of integers using streams, where each integer is weighted by its index
    public static void calculateWeightedAverage() {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);
        double sumOfWeight = IntStream.range(0, numbers.size()).asDoubleStream().sum();
        double avg = IntStream.range(0, numbers.size()).mapToDouble(x -> numbers.get(x) * x).sum();
        System.out.println(avg/sumOfWeight);
    }

    //Write a Java program to compute the average of even numbers in a list using streams and subtract it from the average of odd numbers.
    public static void computeAverageEvenNumbersSubtractAverageOfOddNumber() {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);
        double avgOfEvenNumbers = numbers.stream().filter(x -> x%2 == 0).mapToDouble(Integer::intValue).average().orElse(0.0);
        double avgOfOddNumbers = numbers.stream().filter(x -> x%2 != 0).mapToDouble(Integer::intValue).average().orElse(0.0);
        System.out.println(avgOfOddNumbers-avgOfEvenNumbers);
    }


    // Write a Java program to calculate the average of prime numbers from a list of integers using streams.
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        return IntStream.rangeClosed(2, (int) Math.sqrt(num))
                .allMatch(divisor -> num % divisor != 0);
    }

    public static boolean isPrimeNonStream(int x) {
        if(x < 2) return false;

        for(int i = 2; i <= (int)Math.sqrt(x); i++){
            if(x % i == 0)
                return false;
        }

        return true;
    }

    public static void averageOfPrimeNumbers() {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);
        List<Integer> primeNumbers = numbers.stream().filter(NumbersStream::isPrime).toList();
        System.out.println(primeNumbers.stream().mapToDouble(Integer::intValue).average().orElse(0.0));
    }


    public static void main(String[] args) {
//        calculateAverage();
//        calculateWeightedAverage();
//        computeAverageEvenNumbersSubtractAverageOfOddNumber();
//        averageOfPrimeNumbers();

    }

}
