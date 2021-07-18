package bj11724;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] grid;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        grid = new int[N+1][N+1];
        visited = new boolean[N+1];
        int count = 0;
        for(int i=0;i<M;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            grid[u][v] = 1;
            grid[v][u] = 1;
        }
        for(int i=1;i<N+1;i++){
            if(!visited[i]) {
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    public static void dfs(int start) {
        visited[start] = true;

        for(int i=1;i<grid[0].length;i++) {
            if(grid[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

//    public static void bfs(int u,int v){
//        Queue<Integer> queue = new LinkedList<>();
//        queue.offer(v);
//        grid[u][v] = 0;
//        grid[v][u] = 0;
//        while(!queue.isEmpty()){
//            int row = queue.poll();
//            for(int i=1;i<grid[0].length;i++){
//                if(grid[row][i] == 1){
//                    queue.offer(i);
//                    grid[row][i] = 0;
//                    grid[i][row] = 0;
//                }
//            }
//        }
//
//    }
}
