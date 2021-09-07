package kakaoInternship2020No1;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left_pos = 10;
        int right_pos = 12;
        for(int i=0;i< numbers.length;i++) {
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                //left hand button

                answer.concat("L");
            } else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                //right hand button
                answer.concat("R");

            } else {

            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution a = new Solution();
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String result = a.solution(numbers,"right");
        System.out.println(result);
    }
}