package bj1312;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        double a =sc.nextDouble();
//        double b = sc.nextDouble();
//        int n = sc.nextInt();
//        int temp = (int) (a/b);
//        double result = a / b;
//        result = result - (double) temp;
//        for(int i=0;i<n;i++){
//            result *= 10;
//        }
//        int ans = (int) result;
//        for(;;){
//            if(n == 1)
//                break;
//            ans = ans % (int) Math.pow(10,n-1);
//            n--;
//        }
//        System.out.println(ans);

//        double a =sc.nextDouble();
//        double b = sc.nextDouble();
//        int n = sc.nextInt();
//
//        String str = Double.toString(a/b);
//        int answer = str.charAt(n+1) - '0';
//        System.out.println(answer);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int result = a%b;

        for (int i = 0; i < c-1; i++) {
            result *= 10;
            result %= b;
        }
        result *= 10;
        System.out.println(result/b);
    }
}
