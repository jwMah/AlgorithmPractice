package line2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Solution {
    public String solution(String[] research, int n, int k) {
        HashMap<Character,Integer>[] maps = new HashMap[research.length];
        int c=0;
        HashMap<Character, Integer> map;
        for (String s : research) {
            map = new HashMap<>();
            for(int i=0;i<s.length();i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0) + 1);
            }
            maps[c++] = map;
        }

        boolean day = true;
        ArrayList<Character> ans = new ArrayList<>();
        HashMap<Character, Integer> last = new HashMap<>();
        HashMap<Character, Integer> temp;
        for (int i=0; i < research.length - n + 1; i++) {
            temp = new HashMap<>();
            for(int j= i; j < i + n; j++) {
                for (Character ch : maps[j].keySet()) {
                    if(maps[j].get(ch) >= k) {
                        temp.put(ch, temp.getOrDefault(ch, 0) + maps[j].get(ch));
                    }
                }
            }

            for (Character character : temp.keySet()) {
                if(temp.get(character) >= 2 * n * k) {
                    last.put(character, last.getOrDefault(character,0)+1);
                }
            }
        }

        int max = 0;
        for (Character ch : last.keySet()) {
            if(last.get(ch) >= max) {
                max = last.get(ch);
            }
        }
        for (Character character : last.keySet()) {
            if(last.get(character) == max) {
                ans.add(character);
            }
        }

        if(ans.isEmpty())
            return "None";
        else {
            ans.sort(new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    return o1 - o2;
                }
            });
            return String.valueOf(ans.get(0));
        }
    }

    public static void main(String[] args) {
        String[] arr = {"yxxy","xxyyy","yz"};
        int n = 2;
        int k = 1;
        Solution s = new Solution();
        String ans = s.solution(arr,n,k);
        System.out.println(ans);
    }
}
