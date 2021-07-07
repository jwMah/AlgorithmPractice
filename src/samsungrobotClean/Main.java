package samsungrobotClean;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] grid;
    static int area = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        grid = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j] = sc.nextInt();
            }
        }
        Main a = new Main();
        a.dfs(r,c,d);
        System.out.println(area);
    }

    int[][] dirs = {{0,-1},{1,0},{0,1},{-1,0}};
    public void dfs(int r, int c, int d){
    }

}
