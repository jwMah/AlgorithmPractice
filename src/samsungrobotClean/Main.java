package samsungrobotClean;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] grid;
    static int area = 0;
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
        if(grid[r][c] == 0){
            grid[r][c] = 2;
            area++;
        }

        boolean flag = false;
        int origin_dir = d;
        for(int i=0;i<4;i++){
            int dir = (d+3) % 4;
            int next_x = r + dirs[dir][0];
            int next_y = c + dirs[dir][1];
            if(next_x > 0 && next_x < grid[0].length && next_y > 0 && next_y < grid.length && grid[next_x][next_y] == 0){
                dfs(next_x,next_y,dir);
                flag = true;
                break;
            }
            d = (d+3) % 4;
        }
        if(!flag){ //4방향 다 벽
            int back_dir = (d+2) % 4;
            int back_x = r + dirs[back_dir][0];
            int back_y = c + dirs[back_dir][1];
            if(back_x > 0 && back_x < grid[0].length && back_y > 0 && back_y < grid.length && grid[back_x][back_y] == 0){
                dfs(back_x,back_y,origin_dir);
            }
        }
    }

}
