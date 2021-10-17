package bj20057;
import java.util.Scanner;

public class Main {
    static int[][] grid;
    static int N;
    static int[][] dirs = {{0,-1},{1,0},{0,1},{-1,0}};
    static int t_y,t_x;
    static int sum;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sum = 0;
        grid= new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        t_y = (N - 1) /2;
        t_x = (N - 1) /2;

        int[] turn = new int[N * 2 -1];
        turn[0] = 1;
        turn[1] = 1;
        int count = 2;
        for (int i = turn.length - 3; i < turn.length; i++) {
            turn[i] = N-1;
        }
        for (int i = 2; i < turn.length - 3; i++) {
           turn[i] = count;
            if(i % 2 != 0)
                count++;
        }

        for (int i = 0; i < turn.length; i++) {
            move(i % 4,turn[i]);
        }
        System.out.println(sum);
    }

    public static void move(int dir, int count) {
        for (int i = 0; i < count; i++) {
            tornado(dir);
        }
    }

    static int[][] dy = {{-2,-1,-1,-1,2,1,1,1},{0,1,0,-1,0,1,0,-1},{2,1,1,1,-2,-1,-1,-1},{0,-1,0,1,0,-1,0,1}} ; //좌, 하, 우, 상
    static int[][] dx = {{0,-1,0,1,0,-1,0,1},{-2,-1,-1,-1,2,1,1,1},{0,1,0,-1,0,1,0,-1},{2,1,1,1,-2,-1,-1,-1}}; // 좌, 하, 우, 상
    static int[] percent = {2,10,7,1,2,10,7,1};

    public static void tornado(int dir) {

        t_y = t_y + dirs[dir][0];
        t_x = t_x + dirs[dir][1];
        int sand_amount = grid[t_y][t_x];
        grid[t_y][t_x] = 0;

        int alpha_y = t_y + dirs[dir][0];
        int alpha_x = t_x + dirs[dir][1];
        int five_y = alpha_y + dirs[dir][0];
        int five_x = alpha_x + dirs[dir][1];
        int five_sand = sand_amount * 5 / 100;
        out_check(five_y,five_x,five_sand);

        int sand_count = 0;

        for (int i = 0; i < 8; i++) {
            int y = t_y + dy[dir][i];
            int x = t_x + dx[dir][i];
            int sand = sand_amount * percent[i] / 100;
            if(y < 0 || y >= N || x < 0 || x >= N) {
                sum += sand;
            } else {
                grid[y][x] += sand;
            }
            sand_count += sand;
        }
        sand_count += five_sand;

        int alpha_sand = sand_amount - sand_count;
        out_check(alpha_y,alpha_x,alpha_sand);
        //grid_print();
    }

    public static void out_check(int y, int x, int sand_amount) {
        if(y < 0 || y >= N || x < 0 || x >= N) {
            sum += sand_amount;
        } else {
            grid[y][x] += sand_amount;
        }

    }

//    public static void grid_print() {
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid.length; j++) {
//                System.out.print(grid[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }
}
