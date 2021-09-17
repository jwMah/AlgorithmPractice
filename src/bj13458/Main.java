package bj13458;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long count = 0; //int로 표현할 수 있는 범위를 넘어갈 수 있어서 long으로 선언
        int N = sc .nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        int B = sc.nextInt();
        int C = sc.nextInt();

        for (int i=0;i<N;i++) {
            if(arr[i] <= B) {
                count++;
                continue;
            } else {
                arr[i] -= B;
                count++;

                if(arr[i] % C == 0)
                    count += arr[i]/C;
                else if(arr[i] % C != 0)
                    count += arr[i]/C + 1;
            }

        }
        System.out.println(count);
    }
}
