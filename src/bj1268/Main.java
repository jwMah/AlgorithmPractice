//package bj1268;
//
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        int[][] arr = new int[num][5];
//        for(int i=0;i<num;i++){
//            for(int j=0;j<5;j++){
//                arr[i][j] = sc.nextInt();
//            }
//        }
//        int n = 0;
//        int student = 1;
//        for(int i=0;i<num;i++){
//            HashSet<Integer> hs = new HashSet<>();
//            for(int j=0;j<5;j++){
//                for(int k=0;k<num;k++){
//                    if(i == k)
//                        continue;
//                    if(arr[i][j] == arr[k][j]){
//                        hs.add(k);
//                    }
//                }
//            }
//            if(n < hs.size()){
//                n = hs.size();
//                student = i + 1;
//            }
//        }
//
//        System.out.println(student);
//    }
//}