package kakao3;

import java.time.LocalDateTime;
import java.util.*;

public class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer;
        int free_time = fees[0];
        int free_fee = fees[1];
        int unit_time = fees[2];
        int unit_fee = fees[3];
        ArrayList<String> car = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> time_map = new HashMap<>();
        Map<Integer, Integer> fee_map = new HashMap<>();

        for(int i=0;i<records.length;i++) {
            String[] info = records[i].split(" ");
            String[] temp_time = info[0].split(":");
            int car_num = Integer.parseInt(info[1]);
            int hour = Integer.parseInt(temp_time[0]);
            int minute = Integer.parseInt(temp_time[1]);
            int time = hour * 60 + minute;
            if(info[2].equals("IN")) {
                map.put(car_num,time);
                car.add(info[1]);
            } else { //출차 기록
                int entered_time = map.get(car_num);
                int exit_time = time;
                int total_time = exit_time - entered_time;
                time_map.put(car_num,time_map.getOrDefault(car_num,0) + total_time);
                map.remove(car_num);
            }
        }

        //23시59분 출차
        for (Integer integer : map.keySet()) {
            int exit_time = 23 * 60 + 59;
            int entered_time = map.get(integer);
            int total_time = exit_time - entered_time;
            time_map.put(integer,time_map.getOrDefault(integer,0) + total_time);
        }

        //요금 계산
        for (Integer integer : time_map.keySet()) {
            if(time_map.get(integer) <= free_time) { //기본시간 이하의 이용 시간
                fee_map.put(integer,free_fee);
            } else {
                int total_time = time_map.get(integer);
                int rest_time = total_time - free_time;
                double unit = (double) rest_time / unit_time;
                int unit1 = (int) Math.ceil(unit);
                int total_fee = free_fee + unit1 * unit_fee;
                fee_map.put(integer,total_fee);
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Integer integer : fee_map.keySet()) {
            arrayList.add(integer);
        }

        arrayList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        answer = new int[arrayList.size()];
        int index = 0;
        for (Integer integer : arrayList) {
            answer[index++] = fee_map.get(integer);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        Solution s = new Solution();
        int[] ans = s.solution(fees,records);
        for (int i : ans) {
            System.out.println(i);
        }
    }
}
