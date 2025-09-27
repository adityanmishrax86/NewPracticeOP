package org.example.selu.ArraysPractice;

/**
 * Given an array of points on the X-Y plane points where points[i] = [xi, yi],
 * return the area of the largest triangle that can be formed by any three different points.
 * Answers within 10-5 of the actual answer will be accepted.
 * Example:
 * Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * Output: 2.00000
 * Explanation: The five points are shown in the above figure. The red triangle is the largest.
 */
public class FindMaxTriangleArea {

    /**
     * There are different methods to find the solution of this
     * 1st will use Brute force with Shoelace Formula
     */

    private double area(int[] p1, int[] p2, int[] p3) {
        return Math.abs((p1[0] * (p2[1] - p3[1]) +
                         p2[0] * (p3[1] - p1[1]) +
                         p3[0] * (p1[1] - p2[1])) / 2.0);
    }


    public double getMaxTriangleArea(int[][] points) {
        double maxArea = 0;

        if(points.length == 3)
            return Math.max(0, area(points[0], points[1], points[2]));
        else {
            // Will apply brute force approach with each indices
            int n = points.length;
            for (int i = 0; i < n; i++) {
                for(int j = i+1; j < n; j++) {
                    for(int k = j+1; k < n; k++) {
                        System.out.println("loop: "+ i + " " + " " + j + " " + k);
                        int[] a = new int[]{points[i][0], points[i][1]};
                        int[] b = new int[]{points[j][0], points[j][1]};
                        int[] c = new int[]{points[k][0], points[k][1]};
                        double areaT = area(a,b,c);
                        System.out.println("Area: " + areaT);
                        maxArea = Math.max(maxArea, areaT);
                    }
                }
            }

            return maxArea;

        }

    }


    public double getMaxTriangleAreaHeron(int[][] points) {
        double maxArea = 0;

        if(points.length == 3)
            return Math.max(0, area(points[0], points[1], points[2]));
        else {
            // Will apply brute force approach with each indices
            int n = points.length;
            for (int i = 0; i < n; i++) {
                for(int j = i+1; j < n; j++) {
                    for(int k = j+1; k < n; k++) {
                        double sideA = getEucledianDistance(points[i], points[j]);
                        double sideB = getEucledianDistance(points[j], points[k]);
                        double sideC = getEucledianDistance(points[k], points[i]);


                        double S = ( sideA + sideB + sideC)/ 2.0;
                        double areaSq = S * (S -sideA) * (S - sideB) * (S - sideC);
                        maxArea = Math.max(maxArea, Math.sqrt(areaSq));
                    }
                }
            }

            return maxArea;

        }

    }

    private double getEucledianDistance(int[] p1, int[] p2){
        int dx = p1[0] - p2[0];
        int dy = p1[1] - p2[1];
        return Math.sqrt(dx*dx+dy*dy);
    }

}
