package line1;

public class Solution {
    public int solution(int[] student, int k) {
        int answer = 0;
        int count;
        for(int i=0;i< student.length -1;i++) {
            count = 0;
            if(student[i] == 1)
                count++;
            if(count == k) {
                answer++;
            }
            for(int j=i+1;j<student.length; j++) {
                if(student[j] == 1)
                    count++;
                if(count == k) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
