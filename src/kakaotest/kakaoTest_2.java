package kakaotest;


class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        char[][] grid = new char[5][5];
        for(int i=0;i<places.length;i++){
            int ans = 0;
            for(int j=0;j<places[0].length;j++){
                for(int k=0;k<places[i][j].length();k++){
                    grid[j][k] = places[i][j].charAt(k);
                }
                ans += dfs(grid,0,0, 0);
            }
            answer[i] = ans;
        }
        return answer;
    }

    public int dfs(char[][] grid, int row, int column, int val){
        if(row > grid.length && column > grid[0].length && row < 0 && column < 0){
            return val;
        }

        dfs(grid,row+1,column,val);

        return 0;
    }
}



public class kakaoTest_2 {
    public static void main(String[] args) {
        Solution a = new Solution();
    }
}
