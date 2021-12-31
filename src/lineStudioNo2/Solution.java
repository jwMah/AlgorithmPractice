package lineStudioNo2;

public class Solution {
    static int[][] grid;
    static int[][] answer;
    static int count = 1;
    public int[][] solution(int r, int c) {
        answer = new int[r][c];
        grid = new int[r][c];
        answer[0][c-1] = count;
        dfs(0,c-1, 2);
        return answer;
    }
    static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

    public static void dfs(int y,int x, int dir) {
        while(true) {
            int ny = y + dirs[dir][0];
            int nx = x + dirs[dir][1];
            if(ny < 0 || ny >= grid.length || nx < 0 || nx >= grid[0].length || grid[ny][nx] != 0) {
                break;
            }
        }
        //dfs(ny,nx,dir);
    }
}
