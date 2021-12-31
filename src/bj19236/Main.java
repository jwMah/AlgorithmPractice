package bj19236;

import java.util.*;

public class Main {
    static int[][] grid;
    static Map<Integer,Integer> map;
    static int shark_y, shark_x, shark_dir;
    static int sum;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        grid = new int[4][4];
        map = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int num = sc.nextInt();
                int dir = sc.nextInt();
                grid[i][j] = num;
                map.put(num,dir-1);
            }
        }
        sum = 0;
        sum += grid[0][0];
        int start_sum = grid[0][0];
        shark_y = 0;
        shark_x = 0;
        shark_dir = map.get(grid[0][0]);
        map.remove(grid[0][0]);
        grid[0][0] = 0;
        

        fish_move();
        grid_print();
        shark_move();

    }

    private static void grid_print() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void shark_move() {
        if(shark_y < 0 || shark_y >= 4 || shark_x < 0 || shark_x >= 4) {

        }
    }

    static int[][] dirs = {{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
    
    private static void fish_move() {
        for (int i = 1; i <= 16; i++) {
            //grid_print();
            if(!map.containsKey(i))
                continue;

            int num = i;
            int dir = map.get(num);
            int y = -1;
            int x = -1;

            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if(grid[j][k] == num){
                        y = j;
                        x = k;
                    }
                }
            }

            for (int j = 0; j < 7; j++) {
                int ny = y + dirs[dir][0];
                int nx = x + dirs[dir][1];
                //System.out.println(ny + "," + nx);

                if(ny < 0 || ny >= 4 || nx < 0 || nx >= 4) {
                    if(dir == 7)
                        dir = 0;
                    else
                        dir += 1;
                    continue;
                }

                if(ny == shark_y && nx == shark_x) {
                    if(dir == 7)
                        dir = 0;
                    else
                        dir += 1;
                    continue;
                }

                int temp = grid[ny][nx];
                grid[ny][nx] = grid[y][x];
                grid[y][x] = temp;
                break;

            }

        }
    }

    
}
