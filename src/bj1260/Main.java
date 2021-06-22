//dfs와 bfs
package bj1260;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] grid;
    static int[] check;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();
        grid = new int[n+1][n+1];
        check = new int[n+1];
        for(int i=0;i<m;i++){
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            grid[num1][num2] = 1;
            grid[num2][num1] = 1;
        }
        Main a = new Main();
        check[v] = 1;
        System.out.print(v+" ");
        a.dfs(v);
        System.out.println();
        check = new int[n+1];

        a.bfs(v);
    }
    public void bfs(int v){
        Queue<Integer> queue = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        queue.offer(v);
        check[v] = 1;
        while(!queue.isEmpty()){
            int start = queue.poll();
            sb.append(start).append(" ");
            for(int i=0;i<grid[0].length;i++){
                if(grid[start][i] == 1 && check[i] == 0){
                    check[i] = 1;
                    queue.offer(i);
                }
            }
        }
        System.out.println(sb);
    }
    public void dfs(int v){
        for(int i=0;i< grid[0].length;i++){
            if(grid[v][i] == 1 && check[i] == 0){
                System.out.print(i + " ");
                check[i] = 1;
                dfs(i);
            }
        }
    }
}
