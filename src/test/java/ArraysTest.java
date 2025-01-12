import org.example.selu.ArraysPractice.TwoSumOp;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArraysTest {

    TwoSumOp twoSumOp = new TwoSumOp();

    @Test
    public void testTwoSumApproach() {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSumOp.twoSumOpTwo(arr, target);
        assertArrayEquals(new int[]{0, 1}, result, "Failed on basic test case");

    }

    @Test
    public void testWithNegativeNumbers() {
        int[] arr = {-3, 4, 3, 90};
        int target = 0;
        int[] result = twoSumOp.twoSumOpTwo(arr, target);
        assertArrayEquals(new int[]{0, 2}, result, "Failed on negative numbers");
    }

    @Test
    public void testWithDuplicates2() {
        int[] arr = {3, 3};
        int target = 6;
        int[] result = twoSumOp.twoSumOpTwo(arr, target);
        assertArrayEquals(new int[]{0, 1}, result, "Failed on duplicate numbers");
    }

    @Test
    public void testWithZeros() {
        int[] arr = {0, 4, 3, 0};
        int target = 0;
        int[] result = twoSumOp.twoSumOpTwo(arr, target);
        assertArrayEquals(new int[]{0, 3}, result, "Failed on zero elements");
    }

    @Test
    public void testWithLargeNumbers() {
        int[] arr = {1000000000, 3, 1000000000};
        int target = 2000000000;
        int[] result = twoSumOp.twoSumOpTwo(arr, target);
        assertArrayEquals(new int[]{0, 2}, result, "Failed on large numbers");
    }

    @Test
    public void testNoSolution() {
        int[] arr = {1, 2, 3};
        int target = 7;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            twoSumOp.twoSumOpTwo(arr, target);
        });
        assertEquals("No two sum solution", exception.getMessage());
    }


    @Test
    public void testBasicCase() {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 6;
        List<int[]> result = twoSumOp.twoSumOpThree(arr, target);

        assertEquals(2, result.size(), "Should return two pairs");
        assertArrayEquals(new int[] {0, 4}, result.get(1), "First pair mismatch");
        assertArrayEquals(new int[] {1, 3}, result.get(0), "Second pair mismatch");
    }

    @Test
    public void testWithDuplicates() {
        int[] arr = {3, 3, 4, 4};
        int target = 6;
        List<int[]> result = twoSumOp.twoSumOpThree(arr, target);

        assertEquals(1, result.size(), "Should return two pairs");
        assertArrayEquals(new int[] {0, 1}, result.get(0), "First pair mismatch");
    }

    @Test
    public void testSinglePair() {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        List<int[]> result = twoSumOp.twoSumOpThree(arr, target);

        assertEquals(1, result.size(), "Should return one pair");
        assertArrayEquals(new int[] {0, 1}, result.get(0), "Pair mismatch");
    }

    @Test
    public void testNoPairs() {
        int[] arr = {1, 2, 3};
        int target = 7;
        List<int[]> result = twoSumOp.twoSumOpThree(arr, target);

        assertTrue(result.isEmpty(), "Should return an empty list when no pairs found");
    }

    @Test
    public void testMultiplePairsWithOverlap() {
        int[] arr = {3, 2, 4, 3};
        int target = 6;
        List<int[]> result = twoSumOp.twoSumOpThree(arr, target);

        assertEquals(2, result.size(), "Should return two pairs");
        assertArrayEquals(new int[] {1, 2}, result.get(0), "Second pair mismatch");
        assertArrayEquals(new int[] {0, 3}, result.get(1), "First pair mismatch");
    }
}
