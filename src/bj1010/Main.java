package bj1010;

import java.util.Scanner;

public class Main {

    static int[][] dp = new int[30][30];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Main b = new Main();
        int a = sc.nextInt();
        for(int i=0;i<a;i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            sb.append(b.combination(m,n)).append('\n');
        }
        System.out.println(sb);
    }
    public int combination(int n, int m){

        if(dp[n][m] > 0){ //이미 방문
            return dp[n][m];
        }

        if(n == m || m == 0){
            return dp[n][m] = 1;
        }
        return dp[n][m] = combination(n-1,m-1) + combination(n-1,m);
    }
}

