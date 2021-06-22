package bj1012;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Main a = new Main();
        for(int i=0;i<t;i++){
            int count = 0;
            int m = sc.nextInt();
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] grid = new int[n][m];

            for(int j=0;j<k;j++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                grid[y][x] = 1;
            }

            for(int l=0;l<n;l++){
                for(int o=0;o<m;o++){
                    if(grid[l][o] == 1){
                        count++;
                        a.dfs(grid,l,o);
                    }
                }
            }
            System.out.println(count);
        }
    }
    public void dfs(int[][] grid, int l, int o){
        int a = grid.length;
        int b = grid[0].length;
        if(l >= a || o >= b || l < 0 || o < 0)
            return ;
        if(grid[l][o] != 1)
            return ;
        grid[l][o] = 2;
        dfs(grid, l+1,o);
        dfs(grid,l-1,o);
        dfs(grid,l,o+1);
        dfs(grid,l,o-1);
    }
}
