package kakaoblind2021No3;

import java.util.ArrayList;

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        ArrayList<String[]> arrayList = new ArrayList<>();
        ArrayList<String[]> arrayList1 = new ArrayList<>();

        for(int i=0;i<info.length;i++){
            String[] a = info[i].split(" ");
            arrayList.add(a);
        }
        for(int i=0;i< query.length;i++){ //요구 조건 한개씩 보자
            query[i] = query[i].replace(" and","");
            String[] b = query[i].split(" ");
            arrayList1.add(b);
        }
        int i=0;
        for(String[] temp1 : arrayList1){
            for (String[] temp : arrayList) {
                if(!(temp[0].equals(temp1[0])) && !(temp1[0].equals("-")))
                    continue;
                if(!(temp[1].equals(temp1[1])) && !(temp1[1].equals("-")))
                    continue;
                if(!(temp[2].equals(temp1[2])) && !(temp1[2].equals("-")))
                    continue;
                if(!(temp[3].equals(temp1[3])) && !(temp1[3].equals("-")))
                    continue;
                if(Integer.parseInt(temp[4]) < Integer.parseInt(temp1[4]))
                    continue;
                answer[i] += 1;
            }
            i++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};


        int[] answer = new int[query.length];
        answer = s.solution(info, query);
        for (int i : answer) {
            System.out.println(i);
        }
    }
}