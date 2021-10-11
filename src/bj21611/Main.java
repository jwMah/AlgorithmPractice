package bj21611;

import java.util.Scanner;

public class Main {
    static int K;
    static int[] arr;
    static int[] robot_pos;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        K = sc.nextInt();

        arr = new int[2 * N];
        robot_pos = new int[N];

        for(int i=0;i<2 * N;i++) {
            arr[i] = sc.nextInt();
        }

        int count = 0;
        while(true) {
            count++;
            belt_move();
            robot_move();
            if(arr[0] > 0) {
                robot_pos[0] = 1;
                arr[0]--;
            }
            if(!finish_check()) {
                break;
            }
        }

        System.out.println(count);

    }

    public static void robot_move() {
        for (int i = robot_pos.length - 1; i > 0; i--) {
            //System.out.println(robot_pos[i]);
            if(robot_pos[i-1] == 1 && arr[i] > 0  && robot_pos[i] == 0) {
                robot_pos[i-1] = 0;
                robot_pos[i] = 1;
                arr[i]--;
            }
        }
        if(robot_pos[arr.length/2-1] == 1) {
            robot_pos[arr.length/2-1] = 0;
        }
    }

    public static void belt_move() {
        int end;
        for (int i = robot_pos.length -1; i > 0; i--) {
            robot_pos[i] = robot_pos[i -1];
        }
        robot_pos[0] = 0;

        if(robot_pos[robot_pos.length-1] == 1) {
            robot_pos[robot_pos.length-1] = 0;
        }

        robot_pos[0] = 0;

        end = arr[arr.length - 1];
        for (int i = arr.length -1; i > 0; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = end;
    }

    public static boolean finish_check() {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                count++;
            }
        }
        if(count >= K)
            return false;
        return true;
    }
}
