package bj2579;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] max = new int[N+1];
        int[] val = new int[N+1];
        for(int i=1;i<N+1;i++) {
            val[i] = sc.nextInt();
        }
        max[0] = 0;
        max[1] = val[1];

        if(N >= 2) {
            max[2] = val[1] + val[2];
            if(N >= 3) {
                max[3] = Math.max(val[1] + val[3], val[2] + val[3]);
                if(N >= 4) {
                    for(int i=4;i<N+1;i++) {
                        max[i] = Math.max(max[i-2] + val[i], max[i-3] + val[i-1] + val[i]);
                    }
                }
            }
        }
        System.out.println(max[N]);
    }
}
