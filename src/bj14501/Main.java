package bj14501;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] t = new int[17];
        int[] p = new int[17];
        int ans = 0;
        for(int i=1;i<=N;i++){
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        for(int i=N;i>=1;i--){
            if(i + t[i] > N + 1)
                p[i] = p[i+1];
            else {
                p[i] = Math.max(p[i+1], p[i] + p[i+t[i]]);
                ans = Math.max(ans,p[i]);
            }
        }

        System.out.println(ans);
    }
}
