//바이러스
package bj2606;

import java.util.*;

public class Main {
    static int[][] grid;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        grid = new int[n+1][n+1];
        int num = sc.nextInt();
        for(int i=0;i<num;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int num1, num2;
            if(a > b){
                num1 = b;
                num2 = a;
            }
            else{
                num1 = a;
                num2 = b;
            }
            grid[num1][num2] = 1;
        }
        Main a = new Main();
        int ans = a.bfs();
        System.out.println(ans);
    }
    public int bfs(){
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for(int r = 2;r<grid.length;r++){
            if(grid[1][r] == 1){
                queue.offer(r);
                set.add(r);
                count++;
            }
        }
        while(!queue.isEmpty()){
            int start = queue.poll();
            for(int i=start+1;i<grid.length;i++){
                if(grid[start][i] == 1){
                    if(!set.contains(i)){
                        queue.offer(i);
                        set.add(i);
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
