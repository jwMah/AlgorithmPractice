package maxOfIslands;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {{1,1,0,1,1,},
                        {0,1,1,0,0},
                        {0,0,0,0,0}};
//                        {1,1,0,1,1},
//                        {1,0,1,1,1},
//                        {1,0,1,1,1}};

        Main a = new Main();
        System.out.println(a.maxAreaOfIslands(grid));
    }
    int m,n;
    public int maxAreaOfIslands(int[][] grid){
        if(grid == null || grid.length == 0)
            return 0;
        m = grid.length;
        n = grid[0].length;
        int max = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    max = Math.max(max,dfs(grid,i,j,0));
                    //max = Math.max(max,bfs(grid,i,j,0));
                }
            }
        }
        return max;
    }
    public int dfs(int[][] grid, int i, int j, int area){
        if(grid == null || i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0)
            return area;
        grid[i][j] = 0;
        int temp = area;
        temp++;
        int val;

        temp = dfs(grid, i+1,j,temp);
        temp = dfs(grid, i-1,j,temp);
        temp = dfs(grid,i,j+1,temp);
        temp = dfs(grid,i,j-1,temp);

        return temp;
    }
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public int bfs(int[][] grid, int i, int j, int area){
        if(grid == null || i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0)
            return area;
        grid[i][j] = 0;
        area++;
        for(int[] dir : dirs){
            area = bfs(grid,i+dir[0],j+dir[1],area);
        }
        return area;
    }
}
