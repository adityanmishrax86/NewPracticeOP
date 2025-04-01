package org.example.selu.StreamPractice;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StringStream {

    //Convert List of Strings to Uppercase or Lowercase using Streams
    public static List<String> convertString(boolean isUpperCase, List<String> input) {
        return
                input.stream().map(isUpperCase ? String::toUpperCase : String::toLowerCase).collect(Collectors.toList());

    }


    // Write a Java program to convert a list of strings to uppercase using streams and then join them into a single comma-separated string
    public static String convertString2(List<String> input) {
        return input.stream().map(String::toUpperCase).collect(Collectors.joining(","));
    }

    //Write a Java program to convert a list of strings to lowercase using streams and sort them by their lengths.
    public static List<String> convertString3(List<String> input) {
        return input.stream().map(String::toLowerCase).sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
    }

    //Write a Java program to process a list of mixed-case strings with streams to produce two lists: one entirely uppercase and one entirely lowercase.
    public static Map<String, List<String>> convertString4(List<String> mixedStrings) {
        List<String> onlyUpperCase = mixedStrings.stream().filter(x -> x.toUpperCase().equals(x)).toList();
        List<String> onlyLowerCase = mixedStrings.stream().filter(x -> x.toLowerCase().equals(x)).toList();

        return Map.of("uppercase", onlyUpperCase, "lowercase", onlyLowerCase);
    }

    //Write a Java program to convert each string in a list to uppercase if it starts with a vowel and to lowercase otherwise, using streams.
    private final static Set<String> VOWELS = Set.of("a","e","i","o","u");

    public static boolean isStartWithVowel(String s) {
        if(s.isEmpty() || s.isBlank())
            return false;

        return VOWELS.contains(s.substring(0,1));
    }

    public static List<String> convertString5(List<String> mixedString) {
        return mixedString.stream()
                .map(x -> isStartWithVowel(x) ? x.toUpperCase() : x.toLowerCase())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> colors = List.of("aeorta","yellow","orange");
        System.out.println(convertString5(colors));
    }
}
