package bj16236;

import java.util.*;

public class Main {
    static int[][] grid;
    static int N;
    static int mom_call;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<int[]> list = new LinkedList<>();
        N = sc.nextInt();
        mom_call = 0;
        grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(grid[i][j] ==  9) {
                    list.add(new int[]{i,j});
                    grid[i][j] = 0;
                }
            }
        }

//        while(true) {
//
//        }

        System.out.println(mom_call);
    }

    static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

    public static void bfs(int i,int j, int baby_size) {
        int shark_size = baby_size;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        grid[i][j] = 0;
        while(!queue.isEmpty()) {
            if(eat_check(shark_size).isEmpty()) {
                break;
            } else {
                int[] start = queue.poll();
                for(int[] dir : dirs) {
                    int dy = start[0] + dir[0];
                    int dx = start[0] + dir[0];
                    if(dy < 0 || dx < 0 || dx >= N || dy >= N )
                        continue;
                    //먹음
                    if(grid[dy][dx] == shark_size){
                        grid[dy][dx] = 0;
                        shark_size++;
                    }
                    queue.offer(new int[]{dy,dx});

                }
                mom_call++;
            }
        }


    }

    public static List<int[]> eat_check(int shark_size) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(grid[i][j] != 0 || grid[i][j] != 0)
                    list.add(new int[]{i,j});
            }
        }
        return list;
    }
}
