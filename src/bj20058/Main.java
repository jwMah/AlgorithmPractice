package bj20058;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, Q, L, length, sum, size, max;
    static int[][] grid;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stz.nextToken());
        Q = Integer.parseInt(stz.nextToken());
        sum = 0;
        max = 0;
        size = 0;

        length = (int) Math.pow(2,N);
        grid = new int[length][length];

        for (int i = 0; i < length; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < length; j++) {
                grid[i][j] = Integer.parseInt(stz.nextToken());
            }
        }

        stz = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int l = Integer.parseInt(stz.nextToken());
            move(l);
            fire();
        }
        sum();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if(grid[i][j] != 0) {
                    dfs(i,j);
                    max = Math.max(size,max);
                    size = 0;
                }
            }
        }


        System.out.println(sum);
        System.out.println(max);

    }

    private static void grid_print() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    public static void move(int level) {

        int loop = length / (int) Math.pow(2,level);
        int next[][] = new int[length][length];
        int x = 0;
        for (int i = 0; i < loop; i++) {
            int y = 0;
            if(i != 0)
                x += (int) Math.pow(2,level);
            for (int j = 0; j < loop; j++) {
                if(j != 0)
                    y += (int) Math.pow(2,level);

                for (int a = 0; a < (int) Math.pow(2,level); a++) {
                    for (int b = 0; b < (int) Math.pow(2,level); b++) {
                        next[x+b][y-a+(int)Math.pow(2,level)-1] = grid[x+a][y+b];
                    }
                }
            }
        }
        grid = next;
    }



    static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void fire() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if(grid[i][j] == 0)
                    continue;

                int ice_count = 0;

                for(int[] dir : dirs) {
                    int ny = i + dir[0];
                    int nx = j + dir[1];
                    if(ny < 0 || ny >= length || nx < 0 || nx >= length) {
                        continue;
                    }
                    if(grid[ny][nx] != 0)
                        ice_count++;
                }

                if(ice_count < 3) {
                    grid[i][j]--;
                }

            }
        }
    }

    public static void sum() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                sum += grid[i][j];
            }
        }
    }

    public static void dfs(int i, int j) {
        if(i < 0 || i >= length || j < 0 || j >= length || grid[i][j] == 0){
            return;
        }

        size++;
        grid[i][j] = 0;

        dfs(i-1,j);
        dfs(i+1,j);
        dfs(i,j-1);
        dfs(i,j+1);
    }
}
