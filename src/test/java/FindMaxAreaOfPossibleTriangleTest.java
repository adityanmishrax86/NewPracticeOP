import org.example.selu.ArraysPractice.FindMaxTriangleArea;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalTime;

import static org.example.selu.utils.Utilities.measureExecutionTime;
import static org.junit.jupiter.api.Assertions.*;


public class FindMaxAreaOfPossibleTriangleTest {

    @Test
    public void baseTestWith3Vertices() {
        LocalTime startTime = LocalTime.now();
        FindMaxTriangleArea fmt = new FindMaxTriangleArea();
        int[][] indices = {{0,1},{0,0},{1,0}};
        double area = fmt.getMaxTriangleArea(indices);
        LocalTime endTime = LocalTime.now();
        Duration duration = Duration.between(startTime, endTime);
        measureExecutionTime(duration);
        System.out.printf("Area of the Triangle: %f",area);
        assertTrue(area > 0);
    }

    @Test
    public void baseTestWithMoreThan3Vertices() {
        LocalTime startTime = LocalTime.now();
        FindMaxTriangleArea fmt = new FindMaxTriangleArea();
        int[][] indices = {{0,1},{0,0},{1,0},{1,1}};
        double area = fmt.getMaxTriangleArea(indices);
        LocalTime endTime = LocalTime.now();
        Duration duration = Duration.between(startTime, endTime);
        measureExecutionTime(duration);
        System.out.printf("Area of the Triangle: %f",area);
        assertTrue(area > 0);
    }

    @Test
    public void baseTestWithMoreThan3Vertices1() {
        LocalTime startTime = LocalTime.now();
        FindMaxTriangleArea fmt = new FindMaxTriangleArea();
        int[][] indices = {{0,1},{0,0},{1,0},{1,1}};
        double area = fmt.getMaxTriangleAreaHeron(indices);
        LocalTime endTime = LocalTime.now();
        Duration duration = Duration.between(startTime, endTime);
        measureExecutionTime(duration);
        System.out.printf("Area of the Triangle: %f",area);
        assertTrue(area > 0);
    }


}
