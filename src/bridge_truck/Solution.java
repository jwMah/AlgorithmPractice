package bridge_truck;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int cur_weight = 0;
        int truck_index = 0;
        int finished = 0;
        Queue<int[]> queue = new LinkedList<>(); //트럭 무게와 입장 시간을 배열로 저장
        while(true) {
            if(finished == truck_weights.length) {
                break;
            }
            time++;
            if(!queue.isEmpty()) {
                if(bridge_length + queue.peek()[1] == time) {
                    cur_weight -= queue.peek()[0];
                    queue.poll();
                    finished++;
                }
            }

            if(truck_index == truck_weights.length)
                continue;
            if(bridge_length > queue.size() && cur_weight + truck_weights[truck_index] <= weight) {
                queue.offer(new int[]{truck_weights[truck_index],time});
                cur_weight += truck_weights[truck_index];
                truck_index++;
            }



        }
        return time;
    }

    public static void main(String[] args) {
        Solution a = new Solution();
        System.out.println(a.solution(100,100,new int[]{10}));
    }
}
