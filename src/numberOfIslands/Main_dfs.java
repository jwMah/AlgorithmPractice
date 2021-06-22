package numberOfIslands;

public class Main_dfs {
    public static void main(String[] args) {
        int[][] grid = {{1,1,1,0,1},
                        {1,1,0,0,0},
                        {1,1,0,0,1},
                        {0,0,0,0,1}};
        Main_dfs mainDfs = new Main_dfs();
        System.out.println(mainDfs.solve(grid));

    }
    public int solve(int[][] grid){

        //1. 오류 제어
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        //2
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                 if(grid[i][j] == 1){
                     count++;
                     dfs(grid,i,j);
                 }
            }
        }

        return count;
    }

    public void dfs(int[][] grid,int i,int j){
        int m = grid.length;
        int n = grid[0].length;
        if(i<0 || i>=m || j>=n || j<0 || grid[i][j] != 1)
            return ;
        grid[i][j] = 2;

        dfs(grid, i+1,j);
        dfs(grid, i-1,j);
        dfs(grid, i, j+1);
        dfs(grid, i,j-1);
    }
}
