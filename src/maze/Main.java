package maze;

public class Main {

    public static void main(String[] args) {
        int[][] maze = {{0,0,1,0,0},
                        {0,0,0,0,0},
                        {0,0,0,1,0},
                        {1,1,0,1,1},
                        {0,0,0,0,0}};
        int[] start = {0,4};
        int[] dest = {4,4};
        Main a = new Main();

        System.out.println(a.hasPath(maze,start,dest));
    }

    public boolean hasPath(int[][] maze, int[] start, int[] dest){
        if(maze==null || maze.length==0){
            return false;
        }
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze,start,dest,visited);
    }

    int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0}};

    public boolean dfs(int[][] maze, int[] start, int[] dest, boolean[][] visited){
        if(visited[start[0]][start[1]] || start[0] >= maze.length || start[1] >= maze[0].length || start[0] < 0 || start[1] < 0)
            return false;
        visited[start[0]][start[1]] = true;
        if(start[0] == dest[0] && start[1] == dest[1])
            return true;
        for(int[] dir : dirs){
            int x = start[0];
            int y = start[1];
            while(x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] != 1){
                x += dir[0];
                y += dir[1];
            }
            x -= dir[0];
            y -= dir[1];
            if(dfs(maze,new int[] {x,y},dest,visited)){
                return true;
            }
        }
        return false;
    }
}
