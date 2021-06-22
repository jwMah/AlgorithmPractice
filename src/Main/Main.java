package Main;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        while(true){
            String n = sc.next();
            if(n.equals("0"))
                break;
            char[] arr = n.toCharArray();
            int index = arr.length/2;
            boolean bool = true;
            for(int i=0;i<arr.length;i++){
                if(i == arr.length-1-i)
                    break;
                if(arr[i] != arr[arr.length-1-i] ){
                    sb.append("no\n");
                    bool = false;
                    break;
                }
            }
            if(bool)
                sb.append("yes\n");
        }
        System.out.println(sb);
    }
}
