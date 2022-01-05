package functionDevelopment;

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }
    public static void main(String[] args) {
        Solution a = new Solution();
        int[] ans = a.solution(new int[]{93, 30, 55}, new int[]{1,30,5});
        for (int an : ans) {
            System.out.println(an);
        }


    }
}
