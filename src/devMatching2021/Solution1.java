package devMatching2021;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public int[] solution1(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        Map<String, String> parentMap = new HashMap<>();
        Map<String, Integer> indexMap = new HashMap<>();

        for(int i=0;i< enroll.length;i++){
            parentMap.put(enroll[i],referral[i]);
            indexMap.put(enroll[i],i);
        }

        for(int i=0;i< seller.length;i++){
            String now = seller[i];
            int price = amount[i] * 100;

            while(!now.equals("-")){
                int tax = price / 10; //상납금 ㅠ
                int mine = price - tax; // 세후
                answer[indexMap.get(now)] += mine;
                price = tax;
                now = parentMap.get(now);

                if(price < 1)
                    break;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
    }
}
