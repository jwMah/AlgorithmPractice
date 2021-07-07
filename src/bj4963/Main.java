package bj4963;

import java.util.Scanner;

//섬의 개수
public class Main {
    static int[][] grid;
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int w = sc.nextInt();
            int h = sc.nextInt();

            if(w == 0 && h == 0)
                break;
            count = 0;
            grid = new int[h][w];
            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    grid[i][j] = sc.nextInt();
                }
            }

            Main a = new Main();
            for(int i=0;i<h;i++){
                for(int j= 0;j<w;j++){
                    if(grid[i][j] == 1){
                        count++;
                        a.dfs(i,j);
                    }
                }
            }

            System.out.println(count);

        }
    }
    public void dfs(int y, int x) {
        if(x < 0 || y < 0 || x >= grid[0].length || y >= grid.length)
            return;
        if(grid[y][x] != 1)
            return;
        grid[y][x] = 2;
        dfs(y,x-1);
        dfs(y+1,x-1);
        dfs(y+1,x);
        dfs(y+1,x+1);
        dfs(y,x+1);
        dfs(y-1,x+1);
        dfs(y-1,x);
        dfs(y-1,x-1);
    }
}
