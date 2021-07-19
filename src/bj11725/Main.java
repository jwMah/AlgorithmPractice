package bj11725;

import java.util.Scanner;

public class Main {
    static int[][] grid;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        grid = new int[N+1][N+1];
        for(int i=0;i<N-1;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            grid[u][v] = 1;
            grid[v][u] = 1;
        }
    }
}
