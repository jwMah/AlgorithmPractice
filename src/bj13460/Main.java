package bj13460;

import java.util.Scanner;

public class Main {
    static char[][] grid;
    static int max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        grid = new char[N][M];
        max = 0;
        for(int i=0;i<N;i++) {
            String line = sc.nextLine();
            for(int j=0;j<M;j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        int red_y = 0;
        int red_x = 0;
        int blue_y = 0;
        int blue_x = 0;

        for(int i=0;i< grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 'R') {
                    red_y = i;
                    red_x = j;
                }
                if(grid[i][j] == 'B') {
                    blue_y = i;
                    blue_x = j;
                }
            }
        }

        Main a = new Main();
        a.dfs(red_y,red_x,blue_y,blue_x,0, 0);
    }
    public void dfs(int red_y, int red_x, int blue_y, int blue_x, int dir, int count) {
        if(count >= 10) {
            return;
        }
//        switch (dir) {
//            case 0: //위
//                for(int i=)
//        }
    }
}
