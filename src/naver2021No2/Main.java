package naver2021No2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public int[] solution(int n, int[][] commands) {
        int[] answer = {};
        Queue[] arr = new Queue[n];
        ArrayList<Integer> arrayList = new ArrayList<>();
        boolean front_empty = true;
        int front_val = 0;

        int p =0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new LinkedList<Integer>();
        }

        for (int i = 0; i < commands.length; i++) {
            if(commands[i][0] == -1) {
                arrayList.add(front_val);
                boolean empty = true;
                for (int j = p; j < p + n; j++) {
                    int index = j % n;
                    if(!arr[index].isEmpty()) {
                        p = index;
                        front_val =  (int) arr[p].poll();
                        empty = false;
                        break;
                    }
                }
                if(empty) {
                    front_val = 0;
                    front_empty = true;
                }
            } else {
                if(front_empty) {
                    front_val = commands[i][1];
                    p = commands[i][0];
                    front_empty = false;
                } else {
                    arr[commands[i][0]].offer(commands[i][1]);
                }
            }
        }
        int a = 0;
        answer = new int[arrayList.size()];
        for (Integer integer : arrayList) {
            answer[a++] = integer;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] commands = new int[][]{{0,1},{0,2},{0,5},{1,3},{3,4},{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1}};
        Main a = new Main();

        int[] answer = a.solution(4,commands);
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}
