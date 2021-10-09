package kakao1;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

public class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, ArrayList<String>> name_map = new HashMap<>();
        Map<String,Integer> count_map = new HashMap<>();

        for(int i=0;i<report.length;i++) {
            String[] temp = report[i].split(" ");
            ArrayList<String> temp_list = new ArrayList<>();
            if(!name_map.containsKey(temp[0])) { //temp[0]은 신고내역 자체가 없다.
                temp_list.add(temp[1]);
                name_map.put(temp[0],temp_list);
                count_map.put(temp[1],count_map.getOrDefault(temp[1],0) + 1);
            } else { //temp[0]이 신고한 적은 있다
                temp_list = name_map.get(temp[0]);
                if(!name_map.get(temp[0]).contains(temp[1])) { //temp[0]이 temp[1]을 신고한 적이 없다.
                    temp_list.add(temp[1]);
                    count_map.put(temp[1],count_map.getOrDefault(temp[1],0) + 1);
                }
            }
        }

        ArrayList<String> bad_boys = new ArrayList<>();
        for (String s : count_map.keySet()) {
            if(count_map.get(s) >= k) {
                bad_boys.add(s);
            }
        }

        for (String s : name_map.keySet()) {
            ArrayList<String> mail = name_map.get(s);
            for (String bad_boy : bad_boys) {
                if(mail.contains(bad_boy)) {
                    for(int i=0;i< id_list.length;i++) {
                        if(s.equals(id_list[i])) {
                            answer[i]++;
                        }
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] id_list = {"con","ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;
        Solution s = new Solution();
        int[] ans = s.solution(id_list,report,k);
        for (int i : ans) {
            System.out.println(i);
        }
    }
}
