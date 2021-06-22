package kakaotest;

class Solution1 {
    public int solution(String s) {
        int answer = 0;
        StringBuffer sb = new StringBuffer();

        char[] arr = new char[s.length()];
        for(int i=0;i<s.length();i++){
            arr[i] = s.charAt(i);
        }

        for(int i=0;i<s.length();i++){
            if(arr[i] >= 'a' && arr[i] <= 'z') {
                sb.append(arr[i]);
                arr[i] = '!';
                System.out.println(sb);
                String sb1 = sb.toString();

                if(sb1.equals("zero")){
                    arr[i] = '0';
                    sb.setLength(0);
                }
                else if(sb1.equals("one")){
                    arr[i] = '1';
                    sb.setLength(0);
                }
                else if(sb1.equals("two")){
                    arr[i] = '2';
                    sb.setLength(0);
                }
                else if(sb1.equals("three")){
                    arr[i] = '3';
                    sb.setLength(0);
                }
                else if(sb1.equals("four")){
                    arr[i] = '4';
                    sb.setLength(0);
                }
                else if(sb1.equals("five")){
                    arr[i] = '5';
                    sb.setLength(0);
                }
                else if(sb1.equals("six")){
                    arr[i] = '6';
                    sb.setLength(0);
                }
                else if(sb1.equals("seven")){
                    arr[i] = '7';
                    sb.setLength(0);
                }
                else if(sb1.equals("eight")){
                    arr[i] = '8';
                    sb.setLength(0);
                }
                else if(sb1.equals("nine")){
                    arr[i] = '9';
                    sb.setLength(0);
                }
                else{

                }

            }
        }

        for(int i=0;i<arr.length;i++) {
            if(arr[i] == '!'){
                continue;
            }else{
                sb.append(arr[i]);
            }
        }

        String temp = sb.toString();
        try{
            answer = Integer.parseInt(temp);
        } catch (NumberFormatException e) {

        } catch (Exception e) {

        }


        return answer;
    }
}

public class kakaoTest_1 {
    public static void main(String[] args) {
        Solution1 a = new Solution1();
        int ans = a.solution("one4seveneight");
        System.out.println(ans);
    }
}

