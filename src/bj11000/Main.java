package bj11000;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 1;
        int N = sc.nextInt();
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr,(a,b)->a[0]-b[0]);

        Queue<int[]> queue = new PriorityQueue<>((a,b)->a[1]-b[1]);
        for(int i=0;i<N;i++) {
            if(queue.isEmpty()) {
                queue.offer(arr[i]);
            } else {
                if(queue.peek()[1] <= arr[i][0]) {
                    queue.poll();
                }
                queue.offer(arr[i]);
            }
        }

        System.out.println(queue.size());
    }
}
