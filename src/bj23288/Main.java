package bj23288;

import java.util.Scanner;

public class Main {
    static int[][] grid;
    static boolean[][] visited;
    static int score = 0;
    static int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}}; //동 남 서 북
    static int[] dice = {6,3,4,5,2,1};
    static int y, x, dir_idx;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        //int n = 4; int m = 5; int k = 4;
        grid = new int[n][m];
        //grid = new int[][]{{4, 1, 2, 3, 3}, {6, 1, 1, 3, 3}, {5, 6, 1, 3, 2}, {5, 5, 6, 5, 5}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        y = 0;
        x = 0;
        dir_idx = 0;
        for (int i = 0; i < k; i++) {
            move(); //주사위 굴리기
            get_score(); //점수 계산하기
        }

        System.out.println(score);
    }

    private static void get_score() {
        int num = grid[y][x];
        visited = new boolean[grid.length][grid[0].length];
        dfs(num, y, x);
    }

    private static void dfs(int num, int temp_y, int temp_x) {
        if(temp_y < 0 || temp_y >= grid.length || temp_x < 0 || temp_x >= grid[0].length || visited[temp_y][temp_x] || grid[temp_y][temp_x] != num) {
            return;
        }
        score+=num;
        visited[temp_y][temp_x] = true;
        for (int i = 0; i < dirs.length; i++) {
            dfs(num,temp_y+dirs[i][0], temp_x+dirs[i][1]);
        }
    }

    private static void move() {
        //이동 방향이 막혀 있으면 방향 반대로 돌리기
        int ny = y + dirs[dir_idx][0];
        int nx = x + dirs[dir_idx][1];
        if(ny < 0 || ny >= grid.length || nx < 0 || nx >= grid[0].length) {
            dir_idx -= 2;
            if(dir_idx < 0)
                dir_idx += 4;
        }
        y = y + dirs[dir_idx][0];
        x = x + dirs[dir_idx][1];
        
        dice_move();
        dir_move();
    }

    private static void dir_move() {
        if(dice[0] > grid[y][x]) {
            dir_idx++;
        } else if (dice[0] < grid[y][x]) {
            dir_idx--;
        } else { }
        if(dir_idx > 3) {
            dir_idx = 0;
        }
        if(dir_idx < 0) {
            dir_idx = 3;
        }
    }

    private static void dice_move() {
        int[] temp = dice.clone();
        switch (dir_idx) {
            case 0 : //동
                dice[0] = temp[1];
                dice[1] = temp[5];
                dice[2] = temp[0];
                dice[5] = temp[2];
                break;
            case 1 : //남
                dice[0] = temp[3];
                dice[3] = temp[5];
                dice[4] = temp[0];
                dice[5] = temp[4];
                break;
            case 2 : //서
                dice[0] = temp[2];
                dice[1] = temp[0];
                dice[2] = temp[5];
                dice[5] = temp[1];
                break;
            case 3: //북
                dice[0] = temp[4];
                dice[3] = temp[0];
                dice[4] = temp[5];
                dice[5] = temp[3];
                break;
        }
    }
}
