package maze_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] maze = {{0,0,1,0,0},
                            {0,0,0,0,0},
                            {0,0,0,1,0},
                            {1,1,1,1,1},
                            {0,0,0,0,0}};
    static boolean[][] visited;
    static int[] start = {0,4};
    static int[] dest = {4,4};
    public static void main(String[] args) {
        visited = new boolean[maze.length][maze[0].length];
        System.out.println(bfs());
    }

    static int dirs[][] = {{-1,0},{1,0},{0,-1},{0,1}};

    public static boolean bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        while(!queue.isEmpty()) {
            int index[] = queue.poll();

            for(int[] dir : dirs) {
                int y = index[0];
                int x = index[1];
                boolean check = false;

                while(y >= 0 && y < maze.length && x >= 0 && x < maze[0].length && maze[y][x] == 0) {
                    y += dir[0];
                    x += dir[1];
                }

                y -= dir[0];
                x -= dir[1];

                if(visited[y][x])
                    continue;
                visited[y][x] = true;


                if(y == dest[0] && x == dest[1])
                    return true;
                queue.offer(new int[]{y,x});

            }
        }
        return false;
    }
}
