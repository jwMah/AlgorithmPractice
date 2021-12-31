package bj14502;

import java.util.*;

public class Main {
    static int[][] grid;
    static int[][] temp;
    static int max,N,M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        grid = new int[N][M];
        max = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                grid[i][j] = sc.nextInt();
            }
        }
        setWall(0,grid);
        System.out.println(max);



    }

    private static void print() {
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void setWall(int count,int[][] map) {
        if(count==3) {
            virus(map);
            getCleanArea();
            //print();
            //System.out.println(max);
            return;
        }
        int[][] temp = new int[N][M];
        for (int i = 0; i < map.length; i++) {
            temp[i] = map[i].clone();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(temp[i][j] == 0) {
                    temp[i][j] = 1;
                    setWall(count+1,temp);
                    temp[i][j] = 0;
                }
            }
        }
    }

    private static void getCleanArea() {
        int area = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(temp[i][j] == 0)
                    area++;
            }
        }
        max = Math.max(area,max);
    }

    static int[][] dirs = {{0,-1},{0,1},{1,0},{-1,0}};
    public static void virus(int[][] map) {
        temp = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            temp[i] = map[i].clone();
        }
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                if(temp[i][j] == 2) { //virus
                    dfs(i-1,j);
                    dfs(i+1,j);
                    dfs(i,j-1);
                    dfs(i,j+1);
                }
            }
        }
    }
    public static void dfs(int i, int j) {
        if(i < 0 || j < 0 || i >= N || j >= M || temp[i][j] != 0)
            return;
        temp[i][j] = 3;
        dfs(i-1,j);
        dfs(i+1,j);
        dfs(i,j-1);
        dfs(i,j+1);
    }
}
