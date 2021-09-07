package kakao2021;

public class Solution {
    String temp;
    public int solution(String s) {

        String[] num = {"0","1","2","3","4","5","6","7","8","9"};
        String[] num2 = {"zero","one","two","three","four","five","six","seven","eight","nine","ten"};
        for(int i=0;i<10;i++){
            s = s.replace(num2[i],num[i]);
        }
        return Integer.parseInt(s);
    }
}
