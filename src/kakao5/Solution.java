package kakao5;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static int[][] grid;
    int max = 0;
    int wolf_count;
    int sheep_count;
    public int solution(int[] info, int[][] edges) {
//        int answer = 0;
        grid = new int[info.length][info.length];
        for(int i=0;i< edges.length;i++) {
            grid[edges[i][0]][edges[i][1]] = 1;
            grid[edges[i][1]][edges[i][0]] = 1;
        }
        Solution s = new Solution();

        sheep_count = 0;
        wolf_count = 0;
        s.bfs(0, info);
        return max;
    }
    public void bfs(int start, int[] info) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        sheep_count++;
        while(!queue.isEmpty()) {
            int index = queue.poll();
//            if(information[index] == 0) {
//                sheep_count++;
//            } else {
//                wolf_count++;
//            }
            max = Math.max(max,sheep_count);
            for(int i= 0;i< grid.length;i++) {
                if(grid[index][i] == 1) {
                    if(info[i] == 1) { //늑대
                        wolf_count++;
                        if(sheep_count <= wolf_count) {
                            wolf_count--;
                        } else {
                            grid[index][i] = 2;
                            queue.offer(i);
                        }
                    } else { //양
                        sheep_count++;
                        grid[index][i] = 2;
                        queue.offer(i);
                    }
                } else if(grid[index][i] == 2) {
                    queue.offer(i);
                }
                else {}
            }
        }
    }

    public static void main(String[] args) {
        int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
        int[][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
        Solution s = new Solution();
        System.out.println(s.solution(info,edges));
    }
}
