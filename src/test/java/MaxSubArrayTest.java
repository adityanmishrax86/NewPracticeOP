import org.example.selu.ArraysPractice.MaxSubArray;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MaxSubArrayTest {

    @Test
    public void testPositiveNumbers() {
        int[] arr = {1, 2, 3, 4, 5};
        int expected = 15; // The entire array sums to the maximum subarray
        assertEquals(expected, MaxSubArray.maxSubArraySum(arr));
    }

    @Test
    public void testAllNegativeNumbers() {
        int[] arr = {-1, -2, -3, -4};
        int expected = -1; // The maximum subarray is the least negative number
        assertEquals(expected, MaxSubArray.maxSubArraySum(arr));
    }

    @Test
    public void testMixedPositiveAndNegativeNumbers() {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int expected = 6; // The subarray [4, -1, 2, 1] has the largest sum
        assertEquals(expected, MaxSubArray.maxSubArraySum(arr));
    }

    @Test
    public void testSingleElementArray() {
        int[] arr = {5};
        int expected = 5; // Single element, the sum is the element itself
        assertEquals(expected, MaxSubArray.maxSubArraySum(arr));
    }

    @Test
    public void testSingleNegativeElementArray() {
        int[] arr = {-5};
        int expected = -5; // Single negative element, the sum is the element itself
        assertEquals(expected, MaxSubArray.maxSubArraySum(arr));
    }

    @Test
    public void testLargeArrayWithAlternatingPositiveAndNegativeNumbers() {
        int[] arr = {10, -10, 10, -10, 10, -10, 10, -10, 10};
        int expected = 10; // The maximum sum comes from a single positive number
        assertEquals(expected, MaxSubArray.maxSubArraySum(arr));
    }

    @Test
    public void testArrayWithZero() {
        int[] arr = {-2, 0, 3, -1, 4};
        int expected = 6; // Subarray [0, 3, -1, 4] has the largest sum
        assertEquals(expected, MaxSubArray.maxSubArraySum(arr));
    }

    @Test
    public void testArrayWithOneNegativeAndOnePositive() {
        int[] arr = {-2, 1};
        int expected = 1; // The maximum subarray is just the positive number 1
        assertEquals(expected, MaxSubArray.maxSubArraySum(arr));
    }

    @Test
    public void testAllZeroes() {
        int[] arr = {0, 0, 0, 0};
        int expected = 0; // All zeroes, so the largest sum is 0
        assertEquals(expected, MaxSubArray.maxSubArraySum(arr));
    }

    @Test
    public void testEmptyArray() {
        int[] arr = {};
        int expected = 0; // Edge case: No elements, expected sum is 0 (although the problem specifies at least 1 element)
        assertEquals(expected, MaxSubArray.maxSubArraySum(arr));
    }

    @Test
    public void testLargeArray() {
        int[] arr = new int[100000];
        // Fill the array with alternating 1's and -1's
        for (int i = 0; i < 100000; i++) {
            arr[i] = (i % 2 == 0) ? 1 : -1;
        }
        int expected = 1; // The largest subarray sum is 1, as we can always pick one element
        assertEquals(expected, MaxSubArray.maxSubArraySum(arr));
    }
}
