package hIndex;

import java.util.*;

public class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        Map<String,String> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] c = new int[3];
        String a = "abcd";
        a.replace(0,"b");
        StringBuilder sb = new StringBuilder(a);
        sb.setCharAt(0,'a');
        return answer;
    }

    public static void main(String[] args) {
        int citations[] = {3,0,6,1,5};
        Solution a = new Solution();
        System.out.println(a.solution(citations));
    }
}
