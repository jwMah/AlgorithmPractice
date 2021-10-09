package kakao2;


public class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        if(n == 0)
            return 0;
        StringBuilder sb = new StringBuilder();
        int current = n;
        while(current > 0){
            if(current % k < 10){
                sb.append(current % k);
            } else {
                sb.append((char)(current % k - 10 + 'A'));
            }
            current /= k;
        }
        String num = sb.reverse().toString();
        String[] prime = num.split("0+");
        for (String s : prime) {
            System.out.print(s + " ");
        }
        for(int i=0;i< prime.length;i++) {
            boolean isPrime = true;
            int number = Integer.parseInt(prime[i]);
            //int number = 100;
            if(number == 1)
                continue;
            for(int j=2;j<number;j++) {
                if(number % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime)
                answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 0;
        int k = 3;
        Solution s = new Solution();
        System.out.println(s.solution(n,k));
    }
}
