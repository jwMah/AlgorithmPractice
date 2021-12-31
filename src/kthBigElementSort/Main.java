package kthBigElementSort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int[] nums  = {2,3,1,5,6,4};
        int k = 2;
        solve(nums,k);
        solve_pq(nums,k);
    }

    private static void solve_pq(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(num);
            if(queue.size() > 2)
                queue.poll();
        }
        System.out.println(queue.poll());
    }

    private static void solve(int[] nums, int k) {
        Arrays.sort(nums);
        System.out.println(nums[nums.length-k]);
    }

}
