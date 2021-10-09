package programmersWeeklyChallenge2;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String solution(int[][] scores) {
        String answer = "";

        for(int i=0;i< scores[0].length;i++) {
            int max = 0;
            int min = 100;
            double sum = 0;
            Map<Integer,Integer> map = new HashMap<>();
            for (int j = 0; j < scores.length; j++) {
                map.put(scores[j][i],map.getOrDefault(scores[j][i],0) + 1);
                max = Math.max(scores[j][i],max);
                min = Math.min(min,scores[j][i]);
                sum += scores[j][i];
            }

            int my_score = scores[i][i];
            int people_count = scores.length;
            if(my_score == max || my_score == min) {
                if(map.get(my_score) == 1) {
                    sum -= my_score;
                    people_count--;
                }
            }

            double avg = sum / people_count;

            if(avg >= 90) {
                answer = answer.concat("A");
            } else if(avg >= 80) {
                answer = answer.concat("B");
            } else if(avg >= 70) {
                answer = answer.concat("C");
            } else if(avg >= 50) {
                answer = answer.concat("D");
            } else {
                answer = answer.concat("F");
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution a = new Solution();
        int[][] scores = {{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}};
        System.out.println(a.solution(scores));

    }
}
