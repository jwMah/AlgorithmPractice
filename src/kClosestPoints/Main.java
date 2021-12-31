package kClosestPoints;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int[][] points = {{1,3},{-2,2}};
        int k = 1;
        Queue<int[]> queue = new PriorityQueue<>((a,b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0]*b[0] + b[1] * b[1]));

        for (int i = 0; i < points.length; i++) {
            queue.offer(points[i]);
        }

        int[] top = queue.peek();
        System.out.println(top[0] + "," + top[1]);

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int dist1 = (int) (Math.pow(o1[0],2) + Math.pow(o1[1],2));
                int dist2 = (int) (Math.pow(o2[0],2) + Math.pow(o2[1],2));
                return dist1 - dist2;
            }
        });

        for (int i = 0; i < k; i++) {
            System.out.println(points[i][0] + "," + points[i][1]);
        }


    }
}
