package devMatching2021;

import java.util.ArrayList;

public class Solution {

    static int[][] grid;
    static int min;

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        grid = new int[rows][columns];
        int val = 1;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                grid[i][j] = val++;
            }
        }

        for(int i=0;i<queries.length;i++){
            answer[i] = rotation(queries[i]);
        }

        return answer;
    }

    public int rotation(int[] queries){

        int garo = queries[3] - queries[1] + 1;
        int sero = queries[2] - queries[0] + 1;
        int x = queries[1] - 1;
        int y = queries[0] - 1;

        int now = grid[x][y];

        min = now;

        for(int i=0;i<garo;i++){
            x++;
            now = move(x,y,now);
        }
        for(int i=0;i<sero;i++){
            y++;
            now = move(x,y,now);
        }
        for(int i=0;i<garo;i++){
            x--;
            now = move(x,y,now);
        }
        for(int i=0;i<sero;i++){
            y--;
            now = move(x,y,now);
        }
        return min;
    }

    public int move(int x, int y, int before){
        int temp = grid[x][y];
        min = Math.min(temp,min);
        grid[x][y] = before;
        return temp;
    }

    public static void main(String[] args) {
        Solution a = new Solution();
        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        int[] ans = a.solution(6,6,queries);
        for(int i=0;i< ans.length;i++){
            System.out.println(ans[i]);
        }
    }
}
