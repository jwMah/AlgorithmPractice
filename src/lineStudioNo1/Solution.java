package lineStudioNo1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Solution {
    public String solution(String source) {
        String answer = "";
        StringBuilder sb = new StringBuilder(source);

        while(true) {
            if(source.equals("")) {
                return answer;
            }
            HashSet<Character> set = new HashSet<>();
            HashSet<Integer> index = new HashSet<>();
            ArrayList<Character> list = new ArrayList<>();
            //source의 문자열 한단어 씩 비교
            for(int i=0;i<source.length();i++) {
                char temp = source.charAt(i);
                if(!set.contains(temp)) {
                    list.add(temp);
                    set.add(temp);
                    source = source.substring(0,i) + source.substring(i+1);
                    i--;
                }
            }

            //System.out.println(source);
            //리스트 정렬 후 dest에 붙히기
            Collections.sort(list);
            for (Character character : list) {
                answer = answer + character;
            }
            System.out.println(answer);
        }

    }

    public static void main(String[] args) {
        Solution a = new Solution();
        System.out.println(a.solution("cucumber"));
    }
}
