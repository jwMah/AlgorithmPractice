package bj11725;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer>[] list;
    static int[] tree;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        tree = new int[N+1];
        list = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=1;i<N+1;i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<N-1;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            list[u].add(v);
            list[v].add(u);
        }
        tree[1] = 1; //tree의 루트 (1번 인덱스) 은 1
        bfs(1);

        for(int i=2;i<N+1;i++){
            System.out.println(tree[i]);
        }
    }

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);
        while(!queue.isEmpty()) {
            int row = queue.poll();
            for(int item : list[row]) {
                if(!visited[item]){
                    queue.offer(item);
                    tree[item] = row;
                    visited[item] = true;
                }
            }

        }
    }
}
