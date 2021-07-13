package bj7562;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] grid;
    static boolean[][] visited;
    static int count;
    int[] dx = {1,2,2,1,-1,-2,-2,-1};
    int[] dy = {-2,-1,1,2,2,1,-1,-2};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            count = 0;
            int l = sc.nextInt();
            grid = new int[l][l];
            visited = new boolean[l][l];
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            //grid[x1][y1] = 1;
            //grid[y2][x2] = 2;
            Main a = new Main();
            System.out.println(a.bfs(y1, x1, y2, x2));
        }
    }

    public int bfs(int y, int x, int arrive_y, int arrive_x){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {y,x});
        visited[y][x] = true;
        int count = 0;
        while(!queue.isEmpty()){
            int[] point = queue.poll();
            if(point[0] == arrive_y && point[1] == arrive_x){
                return grid[point[0]][point[1]];
            }
            for(int i=0;i<dx.length;i++){
                int next_y = point[0] + dy[i];
                int next_x = point[1] + dx[i];
                if((next_x >= 0 && next_x < grid.length && next_y >= 0 && next_y < grid.length) && !visited[next_y][next_x]){
                    visited[next_y][next_x] = true;
                    grid[next_y][next_x] = grid[point[0]][point[1]] + 1;
                    queue.offer(new int[] {next_y,next_x});
                }
            }
        }
        return 0;
    }

//    public void dfs(int y, int x){
//        if(temp_count > min)
//            return;
//        if(x < 0 || y < 0 || x >= grid[0].length || y >= grid.length)
//            return;
//        if(grid[y][x] == 2){
//            temp_count++;
//            count = Math.max(temp_count, count);
//            return;
//        }
//
//        temp_count++;
//        dfs(y-2,x+1);
//        dfs(y-1,x+2);
//        dfs(y+1,x+2);
//        dfs(y+2,x+1);
//        dfs(y+2,x-1);
//        dfs(y+1,x-2);
//        dfs(y-1,x-2);
//        dfs(y-2,x-1);
//
//    }
}
