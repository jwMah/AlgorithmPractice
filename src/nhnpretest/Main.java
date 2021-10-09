package nhnpretest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static int[][] grid;
    static int count;
    static int area;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        grid = new int[N][N];
        count = 0;
        area = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(grid[i][j] == 1) {
                    count++;
                    dfs(i,j);
                    arrayList.add(area);
                    area = 0;
                }
            }
        }
        arrayList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(count);
        for (Integer integer : arrayList) {
            System.out.print(integer + " ");
        }
    }

    static void dfs(int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        area++;
        dfs(i+1,j);
        dfs(i,j+1);
        dfs(i-1,j);
        dfs(i,j-1);
    }
}
