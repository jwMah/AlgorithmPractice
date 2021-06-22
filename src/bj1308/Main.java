package bj1308;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start_year = sc.nextInt();
        int start_month = sc.nextInt();
        int start_day = sc.nextInt();
        int end_year = sc.nextInt();
        int end_month = sc.nextInt();
        int end_day = sc.nextInt();
        if(end_year - start_year > 1000){ //1000년 초과
            System.out.println("gg");
        }
        else if(end_year - start_year == 1000 && end_month - start_month >= 0 && end_day - start_day >= 0){ //년도 차이 1000이고 날짜도 고려
            System.out.println("gg");
        }
        else{ //1000년 이하
            Main a = new Main();
            int day1 = a.days(start_year,start_month,start_day);
            int day2 = a.days(end_year,end_month,end_day);
            int ans = day2 - day1;
            System.out.println("D-"+ans);
        }
    }

    public int isLeap(int year){
        if(year % 4 != 0) return 0;
        if(year % 100 != 0) return 1;
        if(year % 400 == 0) return 1;
        return 0;
    }

    public int days(int year, int month, int day){
        int result=0;
        int mon[] = {31,28,31,30,31,30,31,31,30,31,30,31};
        for(int i=1;i<year;i++){ // 작년까지의 모든 일 수 계산
            result += 365 + isLeap(i);
        }
        for(int i=1;i<month;i++){ //해당 년도에 모든 달들의 일 수 계산
            if(i == 2){ //2월
                result += isLeap(year);
            }
            result += mon[i-1];
        }
        //해당 월의 일 수 계산
        result += day;
        return result;
    }
}
