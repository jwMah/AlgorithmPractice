package bj3190;

import java.util.*;

public class Main {
    static int[][] grid;
    static int head_y,head_x,tail_y,tail_x, count,dir_y,dir_x;
    static Map<Integer,String> map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        grid = new int[N+1][N+1];
        map = new HashMap<>();
        int K = sc.nextInt();
        for (int i = 0; i < K; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            grid[r][c] = 1;
        }

        int L = sc.nextInt();
        for (int i = 0; i < L; i++) {
            int X = sc.nextInt();

            String C = sc.next();
            map.put(X,C);
        }

        head_y = 1;
        head_x = 1;
        tail_y =1 ;
        tail_x = 1;
        grid[head_y][head_x] = 2;
        //grid[tail_y][tail_x] = 2;
        count = 0;
        dir_y = 0;
        dir_x = 1;

        move();
        System.out.println(count);

    }

    private static void move() {
        int move_count = 0;
        Queue<int[]> queue = new LinkedList<>();
        while(true) {
            head_y += dir_y;
            head_x += dir_x;

            move_count++;

            //System.out.println("count: " + move_count);
            //System.out.println("head : " + head_y + "," + head_x);

            if(head_y < 1 || head_y >= grid.length || head_x < 1 || head_x >= grid[0].length) {
                //hit the wall or hit itself
                break;
            }
            if(grid[head_y][head_x] == 2)
                break;

            if(grid[head_y][head_x] == 1) {
                //apple found
                grid[head_y][head_x] = 2;
                queue.offer(new int[]{head_y,head_x});

            } else {
                //empty space
                grid[head_y][head_x] = 2;
                grid[tail_y][tail_x] = 0;
                queue.offer(new int[]{head_y,head_x});
                if(!queue.isEmpty()) {
                    int[] next = queue.poll();
                    tail_y = next[0];
                    tail_x = next[1];
                    grid[tail_y][tail_x] = 2;
                }
            }

            if(map.containsKey(move_count)) {
                String direction = map.get(move_count);
                //System.out.println(direction);
                if(direction.equals("L")) {
                    //left
                    if(dir_y == 0 && dir_x == 1) {
                        //오른쪽으로 가던중
                        dir_y = -1;
                        dir_x = 0;
                    } else if(dir_y == 0 && dir_x == -1) { //왼쪽으로 가던중
                        dir_y = 1;
                        dir_x = 0;
                    } else if(dir_y == -1 && dir_x == 0) { //위쪽으로 가던중
                        dir_y = 0;
                        dir_x = -1;
                    } else { //아래로 가던중
                        dir_y = 0;
                        dir_x = 1;
                    }

                } else {
                    //right
                    if(dir_y == 0 && dir_x == 1) {
                        //오른쪽으로 가던중
                        dir_y = 1;
                        dir_x = 0;
                    } else if(dir_y == 0 && dir_x == -1) { //왼쪽으로 가던중
                        dir_y = -1;
                        dir_x = 0;
                    } else if(dir_y == -1 && dir_x == 0) { //위쪽으로 가던중
                        dir_y = 0;
                        dir_x = 1;
                    } else { //아래로 가던중
                        dir_y = 0;
                        dir_x = -1;
                    }
                }
                map.remove(move_count);
            }

            //grid_print();
        }
        count = move_count;
    }

    private static void grid_print() {
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
