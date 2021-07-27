package bj11660;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    static int[][] grid;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        grid = new int[N+1][N+1];
        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                grid[i][j] = sc.nextInt();
            }
        }
        for(int i=0;i<M;i++){
            int sum = 0;
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            for(int a = x1;a<=x2;a++){
                for(int b = y1;b<=y2;b++){
                    sum += grid[a][b];
                }
            }
            System.out.println(sum);
        }
    }
}
