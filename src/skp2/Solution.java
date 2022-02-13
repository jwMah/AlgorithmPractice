package skp2;

import java.util.Stack;

public class Solution {
    public int[] solution(int[] deposit) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < deposit.length; i++) {
            if(deposit[i] > 0) { //입금
                stack.add(deposit[i]);
            } else { //출금
                int out = deposit[i];
                while(true) {
                    int temp = stack.pop();
                    if(temp > out) { //출금액보다 입금된 돈이 크다.
                        temp -= out;
                        stack.add(temp);
                        break;
                    } else if(temp == out) {
                        break;
                    } else { //출금액이 입금된 돈보다 크다.
                        out -= temp;
                    }
                }
            }
        }
        return answer;
    }
}
