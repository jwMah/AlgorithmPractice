package bj2075;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] grid = new int[N][N];
        int ans = 0;
        for(int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<N;i++) {
            for (int j=N-1;j>=0;j--) {
                queue.offer(grid[j][i]);
            }
        }

        for(int i=0;i<N;i++) {
            ans = queue.poll();
        }
        System.out.println(ans);
    }
}
