package bj7562;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] grid;
    static int count;
    static int temp_count;
    static double min = 1e9;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            count = 0;
            temp_count = 0;
            int l = sc.nextInt();
            grid = new int[l][l];
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            //grid[x1][y1] = 1;
            grid[y2][x2] = 2;
            Main a = new Main();
            a.bfs(y1,x1);
            System.out.println(count);
        }
    }

    public void bfs(int y, int x){
        Queue<int[]> queue = new LinkedList<>();

    }

//    public void dfs(int y, int x){
//        if(temp_count > min)
//            return;
//        if(x < 0 || y < 0 || x >= grid[0].length || y >= grid.length)
//            return;
//        if(grid[y][x] == 2){
//            temp_count++;
//            count = Math.max(temp_count, count);
//            return;
//        }
//
//        temp_count++;
//        dfs(y-2,x+1);
//        dfs(y-1,x+2);
//        dfs(y+1,x+2);
//        dfs(y+2,x+1);
//        dfs(y+2,x-1);
//        dfs(y+1,x-2);
//        dfs(y-1,x-2);
//        dfs(y-2,x-1);
//
//    }
}
