package line3;

import java.util.ArrayList;

public class Solution {
    public int[] solution(int[][] jobs) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean check[] = new boolean[jobs.length];
        int time = jobs[0][0] + jobs[0][1];
        int type = jobs[0][2];
        check[0] = true;
        ans.add(type);
        for(int i=1;i< jobs.length;i++) {
            if(jobs[i][0] >= time) {
                if(type == jobs[i][2]) {
                    time = jobs[i][0] + jobs[i][1];
                    check[i] = true;
                } else {

                }
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {

    }
}
