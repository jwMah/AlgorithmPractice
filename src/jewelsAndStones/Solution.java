package jewelsAndStones;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        String jewel = "aA";
        String stones = "aAAbbbb";
        System.out.println(solution(jewel,stones));
    }
    static int solution(String jewel, String stone) {
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < jewel.length(); i++) {
            set.add(jewel.charAt(i));
        }
        for (int i = 0; i < stone.length(); i++) {
            if(set.contains(stone.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}
