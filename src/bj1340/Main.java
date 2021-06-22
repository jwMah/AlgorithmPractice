package bj1340;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String month = sc.nextLine();
        int day = sc.nextInt();
        int year = sc.nextInt();
        int hour = sc.nextInt();
        int minute = sc.nextInt();
        int[] mon = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int month_index = 0;
        int total_min = 0; //1년의 총 분
        int ans_min = 0; //입력으로 받은 총 분

        //젇답 = 1년의 총 분 / 입력으로 받은 총 분
        Main a = new Main();

        //윤년 처리
        mon[1] += a.isLeap(year);


        for(int i=0;i<mon.length;i++){
            total_min += mon[i] * 24 * 60;
        }


        switch(month){
            case "January":
                month_index = 0;
                break;
            case "February":
                month_index = 1;
                break;
            case "March":
                month_index = 2;
                break;
            case "April":
                month_index = 3;
                break;
            case "May":
                month_index = 4;
                break;
            case "June":
                month_index = 5;
                break;
            case "July":
                month_index = 6;
                break;
            case "August":
                month_index = 7;
                break;
            case "September":
                month_index = 8;
                break;
            case "October":
                month_index = 9;
                break;
            case "November":
                month_index = 10;
                break;
            case "December":
                month_index = 11;
                break;
        }

        //전 달까지 분 계산
        for(int i=0;i<month_index;i++){
            ans_min += mon[i] * 24 * 60;
        }

        ans_min += (day -1) * 24 * 60;
        ans_min += hour * 60;
        ans_min += minute;
        System.out.println("ans_min = " + ans_min);
        System.out.println("total_min = " + total_min);

        double ans = (double) ((double) ans_min / (double) total_min) * 100;
        System.out.println(ans);
    }
    public int isLeap(int year){
        if(year % 4 != 0) return 0;
        if(year % 100 != 0) return 1;
        if(year % 400 == 0) return 1;
        return 0;
    }
}
