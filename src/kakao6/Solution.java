package kakao6;

public class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        for(int i=0;i< skill.length;i++) {
            if(skill[i][0] == 1) { //공격
                for(int j=skill[i][2];j<=skill[i][4];j++) {
                    for(int k=skill[i][1];k<=skill[i][3];k++) {
                        board[k][j] -= skill[i][5];
                    }
                }
            } else {
                for(int j=skill[i][2];j<=skill[i][4];j++) {
                    for(int k=skill[i][1];k<=skill[i][3];k++) {
                        board[k][j] += skill[i][5];
                    }
                }
            }
        }

        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j] >= 1) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
        int[][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
        Solution s = new Solution();
        System.out.println(s.solution(board,skill));
    }
}
