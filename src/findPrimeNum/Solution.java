package findPrimeNum;

import java.util.*;
class Solution {
    static int answer = 0;
    static ArrayList<Integer> list = new ArrayList<>();
    static boolean[] check = new boolean[7];
    public int solution(String numbers) {
        String temp = "";
        permutation(numbers, temp);
//         for(int i=1;i<=numbers.length();i++) {

//             generate(numbers, temp,i);
//         }
        prime_check();
        return answer;
    }

    static void permutation(String num, String temp) {
        if(!temp.equals("")) {
            if(!list.contains(Integer.parseInt(temp)))
                list.add(Integer.parseInt(temp));
            //return;
        }
        for(int i=0;i<num.length();i++) {
            permutation(num.substring(0,i) + num.substring(i+1,num.length()),temp + num.charAt(i));
        }
    }

    static void generate(String num, String temp, int n) {
        if(n == temp.length()) {
            if(!list.contains(Integer.parseInt(temp)))
                list.add(Integer.parseInt(temp));
            return;
        }
        for(int i=0;i<num.length();i++) {
            if(check[i]) {
                continue;
            }
            temp += num.charAt(i);
            check[i] = true;
            generate(num,temp,n);
            check[i] = false;
            temp = temp.substring(0,temp.length() - 1);
        }
    }

    static void prime_check() {
        if(list.size() == 0)
            return;
        int j;
        for(int i=0;i<list.size();i++) {
            int num = list.get(i);
            //System.out.println(num);
            if(num == 0 || num == 1)
                continue;
            for(j=2;j<num;j++) {
                if(num % j == 0) {
                    break;
                }
            }
            if(j == num)
                answer++;
        }
    }
}