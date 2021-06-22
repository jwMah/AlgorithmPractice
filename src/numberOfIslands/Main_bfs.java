package numberOfIslands;

import java.util.LinkedList;
import java.util.Queue;

public class Main_bfs {
    public static void main(String[] args) {
        int[][] grid = {{1,1,1,0,1},
                {1,1,0,0,0},
                {1,1,0,0,1},
                {0,0,0,0,1}};
        Main_bfs mainbfs = new Main_bfs();
        System.out.println(mainbfs.solve(grid));
    }

    public int solve (int[][] grid){
        if(grid == null || grid.length == 0) return 0;
        int count = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    count++;
                    bfs(grid,i,j);
                }
            }
        }

        return count;
    }
    int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
    void bfs(int[][] grid, int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x,y});
        while(!queue.isEmpty()){
            int[] point = queue.poll();
            for(int[] dir : dirs){
                int x1 = point[0] + dir[0];
                int y1 = point[1] + dir[1];
                if(x1>=0 && y1>=0 && x1 < grid.length && y1 < grid[0].length && grid[x1][y1] == 1){
                    grid[x1][y1]=0;
                    queue.offer(new int[] {x1,y1});
                }
            }
        }
    }
}
