package meetingRoom;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int[][] intervals = {{5,10},{16,20},{0,30}};
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        for (int i = 0; i < intervals.length; i++) {
            if(pq.isEmpty())
                pq.offer(intervals[i]);
            else {
                if(pq.peek()[1] <= intervals[i][0]) {
                    pq.poll();
                }
                pq.offer(intervals[i]);
            }
        }
        System.out.println(pq.size());
    }
}
