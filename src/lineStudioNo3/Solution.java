package lineStudioNo3;

public class Solution {
    static int count;
    static int[][] grid;
    static int[][] dur;
    public int solution(int[][] board, int[][] durability) {
        int answer = -1;
        count = 0;
        grid = new int[board.length][board[0].length];
        dur = new int[durability.length][durability[0].length];
        for (int i = 0; i < board.length; i++) {
            grid[i] = board[i].clone();
        }
        for (int i = 0; i < durability.length; i++) {
            dur[i] = durability[i].clone();
        }
        dur = durability;
        int start[] = new int[2];

        if(grid[0][0] == 1 || grid[0][0] == 3 || grid[0][0] == 5)
            return 0;

        dfs(3,0,0);
        return count;
    }

    static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    static int[][] boxDirs = {{0,0,0,0},{3,0,1,2},{2,0,3,1},{1,3,0,2},{1,2,3,0},{1,0,3,2}};

    public static void dfs(int dir,int y,int x) {
        //범위 밖으로 나감

        //count++;
        int ny = y + dirs[dir][0];
        int nx = x + dirs[dir][1];

        if(ny < 0 || nx < 0 || ny >= grid.length || nx >= grid[0].length) {
            //count--;
            return;
        }

        count++;

        if(grid[ny][nx] > 0 && dur[ny][nx] > 0) {
            dir = boxDirs[grid[ny][nx]][dir];
            dur[ny][nx]--;
        }

        dfs(dir,ny,nx);
    }

    public static void main(String[] args) {
        int[][] board = {{0,0,2,0},{1,0,3,2},{0,0,0,0},{3,0,0,4}};
        int[][] dur = {{0,0,2,0},{5,0,2,5},{0,0,0,0},{5,0,0,5}};
        Solution a = new Solution();
        System.out.println(a.solution(board,dur));
    }
}
