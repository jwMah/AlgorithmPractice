package bj20056;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int N,M,K;
    static int[][] grid;
    static ArrayList<int[]> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        list = new ArrayList<>();
        N = sc.nextInt();
        grid = new int[N+1][N+1];
        M = sc.nextInt();
        K = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int m = sc.nextInt();
            int s = sc.nextInt();
            int d = sc.nextInt();
            grid[r][c] += 1;
            list.add(new int[]{r,c,m,s,d});
        }

        for (int i = 0; i < K; i++) {
            move();
            check();
        }
        int ans = 0;
        for (int[] info : list) {
            ans += info[2];
        }
        System.out.println(ans);
    }

    static int[][] dirs = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}}; //{y,x}

    public static void move() {
        for (int[] info : list) {
            int speed = info[3];
            int dir = info[4];
            int y = info[0];
            int x = info[1];
            int next_y = y + dirs[dir][0] * speed;
            int next_x = x + dirs[dir][1] * speed;
            if(next_y < 1) {
                next_y += N;
            }
            if(next_y > N) {
                next_y -= N;
            }
            if(next_x < 1) {
                next_x += N;
            }
            if(next_x > N) {
                next_x -= N;
            }

            grid[next_y][next_x]++;
            grid[y][x]--;
            info[0] = next_y;
            info[1] = next_x;
        }
    }

    public static void check() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] >= 2) {
                    break_ball(i,j);
                }
            }
        }
    }

    public static void break_ball(int r,int c) {
        ArrayList<int[]> temp = new ArrayList<>();

        for (int[] info : list) {
            if(info[0] == r && info[1] == c)
                temp.add(info);
        }
        for (int[] ints : temp) {
            list.remove(ints);
        }


        int mass_sum = 0;
        int speed_sum = 0;
        int even_count = 0;
        int odd_count = 0;
        for (int[] info : temp) {
            mass_sum += info[2];
            speed_sum += info[3];
            if(info[4] % 2 == 0)
                even_count++;
            else
                odd_count++;
        }

        if(Math.floor(mass_sum / 5) <= 0) {
            return;
        }
        int mass = (int) Math.floor(mass_sum / 5);
        int speed = speed_sum / temp.size();
        int[] direction = new int[4];
        if((even_count > 0 && odd_count == 0) || (even_count == 0 && odd_count > 0)){
            direction[0] = 0;
            direction[1] = 2;
            direction[2] = 4;
            direction[3] = 6;
        }else {
            direction[0] = 1;
            direction[1] = 3;
            direction[2] = 5;
            direction[3] = 7;
        }
        for (int i = 0; i < direction.length; i++) {
            list.add(new int[]{r,c,mass,speed,direction[i]});
        }
    }
}
