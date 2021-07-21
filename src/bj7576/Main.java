package bj7576;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] grid;
    static int day_count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        grid = new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                grid[i][j] = sc.nextInt();
            }
        }
        day_count = 0;
//        for(int i=0;i<N;i++){
//            for(int j=0;j<M;j++){
//                if(grid[i][j] == 1){
//                    bfs(i,j);
//                }
//            }
//        }
        bfs();

        int result = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(grid[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result,grid[i][j]);
            }
        }

        System.out.println(result - 1);
    }


    static int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    queue.offer(new int[] {i,j});
                }
            }
        }
        while(!queue.isEmpty()){
            int[] point = queue.poll();
            for(int[] dir: dirs){
                int y = point[0] + dir[0];
                int x = point[1] + dir[1];
                if(y >= 0 && x >= 0 && y < grid.length && x < grid[0].length && grid[y][x] == 0){
                    grid[y][x] = grid[point[0]][point[1]] + 1;
                    queue.offer(new int[] {y,x});
                }
            }
            for(int i=0;i< grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    System.out.print(grid[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
