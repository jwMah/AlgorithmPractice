package uniqueEmailAddress;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        String[] emails = {
        "test.email+james@coding.com",
                "test.e.mail+toto.jane@coding.com",
                "testemail+tom@cod.ing.com"};
        Solution a = new Solution();
        System.out.println(a.solution(emails));
    }

    public int solution(String[] arr) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            String[] temp = arr[i].split("@");
            temp[0] = temp[0].replace(".","");
            if(temp[0].contains("+")) {
                int idx = temp[0].indexOf("+");
                temp[0] = temp[0].substring(0,idx);
            }
            String ans = temp[0].concat(temp[1]);
            System.out.println(ans);
            set.add(ans);
        }
        return set.size();
    }
}
