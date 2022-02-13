package skp4;

import java.util.ArrayList;

public class Solution {
    public int[] solution(String[] rsp3) {
        int[] answer = new int[3];
        for (int i = 0; i < rsp3.length; i++) {
            char first = rsp3[i].charAt(0);
            char second = rsp3[i].charAt(1);
            char third = rsp3[i].charAt(2);
            //점수 계산
            if((first == second && second == third) || (first != second && second != third && first != third))
                continue;
            int[] result = winOrLose(rsp3[i]);

            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < result.length; j++) {
                if(result[j] == 1)
                    list.add(j);
            }
            if(list.size() == 1) {
                answer[list.get(0)] += 2;
            }
            if(list.size() == 2) {
                if(answer[list.get(0)] == answer[list.get(1)]) {
                    answer[list.get(0)]++;
                    answer[list.get(1)]++;
                } else {
                    if(answer[list.get(0)] < answer[list.get(1)]) {
                        answer[list.get(0)] += 2;
                    } else {
                        answer[list.get(1)] += 2;
                    }

                }
            }
        }
        return answer;
    }

    private int[] winOrLose(String s) {
        switch (s) {
            case "PPS":
            case "RRP":
            case "SSR":
                return new int[]{0,0,1};
            case "PPR":
            case "RRS":
            case "SSP":
                return new int[]{1,1,0};
            case "PRP":
            case "RSR":
            case "SPS":
                return new int[]{1,0,1};
            case "PRR":
            case "RSS":
            case "SPP":
                return new int[]{1,0,0};
            case "PSP":
            case "RPR":
            case "SRS":
                return new int[]{0,1,0};
            case "PSS":
            case "RPP":
            case "SRR":
                return new int[]{0,1,1};

        }
        return new int[]{0,0,0};
    }
//    public int winOrLose(char a, char b) {
//        if(a == 'P') {
//            if(b == 'P') {
//                return 0;
//            } else if(b == 'R') {
//                return 1;
//            } else {
//                return -1;
//            }
//        } else if(a == 'R') {
//            if(b == 'P') {
//                return -1;
//            } else if(b == 'R') {
//                return 0;
//            } else {
//                return 1;
//            }
//        } else { //S
//            if(b == 'P') {
//                return 1;
//            } else if(b == 'R') {
//                return -1;
//            } else {
//                return 0;
//            }
//        }
//    }
}
