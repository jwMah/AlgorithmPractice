//촌수계산
package bj2644;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] grid;
    static int[] checked;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int m = sc.nextInt();
        grid = new int[n+1][n+1];
        checked = new int[n+1];
        for(int i=0;i<m;i++){
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            grid[num1][num2] = 1;
            grid[num2][num1] = 1;
        }
        Main c = new Main();
        int ans = c.bfs(a,b);
        System.out.println(ans);
    }
    public int bfs(int a, int b){
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(a);
        checked[a] = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int k = 0;k<size;k++){
                int start = queue.poll();
                if(start == b){
                    return count;
                }
                for(int i=0;i<grid[0].length;i++){
                    if(checked[i] == 0 && grid[start][i] == 1){
                        checked[i] = 1;
                        queue.offer(i);
                    }
                }
            }
            count++;
        }

        return -1;
    }
}
