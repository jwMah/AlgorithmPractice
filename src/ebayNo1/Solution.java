package ebayNo1;

import java.util.*;
class Solution {
    static int num = 0;
    static Map<String,ArrayList<String>> map = new HashMap<>();
    public int solution(String[][] schedule) {
        int answer = -1;

        int count = 0;
        dfs(0,schedule);
        return answer;
    }

    private static void dfs(int idx,String[][] schedule) {
        if(idx == schedule.length) {
            num++;
            return;
        }
            for(int j=0;j<4;j++) {
                String[] temp = schedule[idx][j].split(" ");

                if(temp.length == 2) { //3시간 수업
                    if(map.containsKey(temp[0])) {
                        boolean abc = true;
                        String time = temp[1].replaceAll(":","");
                        int n = Integer.parseInt(time);
                        String time2 = Integer.toString(n + 300);
                        ArrayList<String> list = map.get(temp[0]);
                        for (String s : list) {
                            String check[] = s.split(" ");
                            if(Integer.parseInt(check[1]) > n || Integer.parseInt(check[0]) < n + 300 ) {
                                abc = false;
                                break;
                            }
                        }

                        if(abc) {

                        }

                    } else { //해당 요일에 신청한 수업이 없어서 들어도 된다.
                        String time = temp[1].replaceAll(":","");
                        int n = Integer.parseInt(time);
                        String time2 = Integer.toString(n + 300);
                        time = time + " " + time2;
                        ArrayList<String> list = new ArrayList<>();
                        list.add(time);
                        map.put(temp[0],list);
                        dfs(idx + 1, schedule);
                        map.remove(temp[0]);
                    }
                } else { //2시간 수업

                }
            }
    }

    public static void main(String[] args) {
        Solution a = new Solution();
        //a.solution()
    }
}
