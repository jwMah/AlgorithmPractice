package bj14502;

import java.util.*;

public class Main {
    static int[][] grid;
    static int[][] temp;
    static int area;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        grid = new int[N][M];
        temp = new int[N][M];
        int area = 0;
        int max = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                grid[i][j] = sc.nextInt();
            }
        }



        for(int i=0;i< temp.length;i++){
            for(int j=0;j<temp[0].length;j++){

            }
        }

        area = getArea(area);
        max = Math.max(max,area);

    }

    private static int getArea(int area) {
        for(int i=0;i< temp.length;i++){
            for(int j=0;j<temp[0].length;j++){
                if(grid[i][j] == 0){
                    area++;
                }
            }
        }
        return area;
    }

    static int[][] dirs = {{0,-1},{0,1},{1,0},{-1,0}};
    static void virus() {
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i< temp.length;i++){
            for(int j=0;j<temp[0].length;j++){
                if(temp[i][j] == 2){
                    queue.offer(new int[] {i,j});
                    while(!queue.isEmpty()){
                        int[] point = queue.poll();
                        for(int[] dir : dirs){
                            int x = point[0] + dir[0];
                            int y = point[1] + dir[1];
                            if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 0){
                                queue.offer(new int[] {x,y});
                                grid[x][y] = 2;
                            }
                        }
                    }
                }
            }
        }


    }
}
