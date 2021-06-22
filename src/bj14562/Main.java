package bj14562;
import java.util.Scanner;

public class Main {

    private static double min;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] num = new int[n][2];
        for(int i=0; i<n; i++){
            num[i][0] = sc.nextInt();
            num[i][1] = sc.nextInt();
        }
        Main a = new Main();
        for(int i=0;i<n;i++){
            min = 1e9;
            int count = 0;
            a.dfs(num[i][0],num[i][1], count);
            System.out.println((int)min);
        }
    }

    void dfs(int a, int b,int count){
        if(count > min)
            return;
        if(a > b)
            return;
        if(a == b){
            min = count;
            return;
        }

        dfs(a*2,b+3,count+1);
        dfs(a+1,b,count+1);

    }
}
