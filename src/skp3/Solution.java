package skp3;

public class Solution {
    public int solution(String[] color, int[] prices) {
        int answer = 0;
        int[][] arr = new int[5][2];
        for (int i = 0; i < color.length; i++) {
            int index = 0;
            for (int j = 0; j < 2; j++) {
                char temp = color[i].charAt(j);
                index = index(temp);
                arr[index][j]++;
            }
            while(arr[index][0] > 0 && arr[index][1] > 0) {
                answer += prices[0];
                arr[index][0]--;
                arr[index][1]--;
            }
        }

        int temp1 = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i][0] > 0) {
                temp1 += prices[1] * arr[i][0];
            }
        }

        int temp2 = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 2; j++) {
                if(arr[i][j] > 0) {
                    temp2 += prices[0] * arr[i][j];
                }
            }
        }

        int ans = Math.min(temp1,temp2);

        answer += ans;

        return answer;
    }
    public int index(char temp) {
        switch (temp) {
            case 'B':
                return 0;
            case 'G':
                return 4;
            case 'W':
                return 1;
            case 'R':
                return 2;
            default:
                return 3;
        }
    }
}
