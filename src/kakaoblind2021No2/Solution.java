package kakaoblind2021No2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    static Map<String, Integer> map;
    static int m;
    public String[] solution(String[] orders, int[] course) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        for(int i=0;i< course.length;i++){
            map= new HashMap<>();
            m = 0;
            for(int j=0;j<orders.length;j++){
                find(0, "", course[i], 0, orders[j]);
            }
            for(String word : map.keySet()){
                if(map.get(word) == m && m > 1)
                    pq.offer(word);
            }
        }
        String answer[] = new String[pq.size()];
        int a = 0;
        while(!pq.isEmpty()){
            answer[a++] = pq.poll();
        }
        return answer;
    }

    static void find(int cnt, String str, int targetNum, int idx, String word){
        if(cnt == targetNum){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String temp = "";
            for(int i=0;i<chars.length;i++)
                temp += chars[i];
            map.put(temp,map.getOrDefault(temp,0) + 1);
            m = Math.max(m, map.get(temp));
            return;

        }
        for(int i=idx;i<word.length();i++){
            find(cnt+1,str+word.charAt(i),targetNum,i+1,word);
        }
    }

    public static void main(String[] args) {

    }
}
