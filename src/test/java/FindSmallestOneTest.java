import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.selu.ArraysPractice.FindSmallestMissingPostive;
import org.junit.jupiter.api.Test;

public class FindSmallestOneTest {

    @Test
    void testAllPositiveNumbersWithGap() {
        int[] arr = {3, 4, -1, 1};
        assertEquals(2, FindSmallestMissingPostive.findSmallestThree(arr));
    }

    @Test
    void testAllPositiveNumbersNoGap() {
        int[] arr = {1, 2, 3};
        assertEquals(4, FindSmallestMissingPostive.findSmallestThree(arr));
    }

    @Test
    void testOnlyNegativeNumbers() {
        int[] arr = {-1, -2, -3};
        assertEquals(1, FindSmallestMissingPostive.findSmallestThree(arr));
    }

    @Test
    void testMixedPositiveAndNegativeWithGap() {
        int[] arr = {-1, -2, 0, 1, 3, 5};
        assertEquals(2, FindSmallestMissingPostive.findSmallestThree(arr));
    }

    @Test
    void testAllZeros() {
        int[] arr = {0, 0, 0};
        assertEquals(1, FindSmallestMissingPostive.findSmallestThree(arr));
    }

    @Test
    void testLargeGapBetweenNumbers() {
        int[] arr = {10, 11, 12};
        assertEquals(1, FindSmallestMissingPostive.findSmallestThree(arr));
    }

    @Test
    void testUnorderedArray() {
        int[] arr = {7, 8, 1, 4, 2};
        assertEquals(3, FindSmallestMissingPostive.findSmallestThree(arr));
    }

    @Test
    void testArrayWithDuplicates() {
        int[] arr = {1, 1, 2, 2};
        assertEquals(3, FindSmallestMissingPostive.findSmallestThree(arr));
    }

    @Test
    void testSingleElementArrayPositive() {
        int[] arr = {5};
        assertEquals(1, FindSmallestMissingPostive.findSmallestThree(arr));
    }

    @Test
    void testSingleElementArrayNegative() {
        int[] arr = {-5};
        assertEquals(1, FindSmallestMissingPostive.findSmallestThree(arr));
    }

    @Test
    void testEmptyArray() {
        int[] arr = {};
        assertEquals(1, FindSmallestMissingPostive.findSmallestThree(arr));
    }

    @Test
    void testAllNumbersFromOneToN() {
        int[] arr = {1, 2, 3, 4, 5};
        assertEquals(6, FindSmallestMissingPostive.findSmallestThree(arr));
    }

    @Test
    void testArrayWithZeroAndPositiveNumbers() {
        int[] arr = {0, 1, 2, 3};
        assertEquals(4, FindSmallestMissingPostive.findSmallestThree(arr));
    }

    @Test
    void testArrayWithBigGapNumbers() {
        int[] arr = {-192, -99,100,2200, 1, 2, 3,99,4,5,6,7,8,9,0,100,66};
        assertEquals(10, FindSmallestMissingPostive.findSmallestThree(arr));
    }
}