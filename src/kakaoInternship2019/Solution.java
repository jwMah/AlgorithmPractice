package kakaoInternship2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int[] solution(String s) {
        s = s.substring(2,s.length()-2).replace("},{","-");
        String[] arr = s.split("-");

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        ArrayList<Integer> temp = new ArrayList<>();


        for (String s1 : arr) {
            String[] val = s1.split(",");
            for (String s2 : val) {
                int num = Integer.parseInt(s2);
                if(!temp.contains(num)){
                    temp.add(num);
                }
            }
        }

        int[] answer = new int[temp.size()];
        int i=0;
        for (Integer integer : temp) {
            answer[i] = (int) integer;
            i++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        int[] answer = s.solution(s1);
        for (int i=0;i< answer.length;i++) {
            System.out.println(answer[i]);
        }
    }
}
