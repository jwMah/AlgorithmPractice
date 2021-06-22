package removeInvalidParenthesis;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String s = "(a)())()";
        Main a = new Main();
        System.out.println(a.removeInvalidParenthesis(s));
    }
    public List<String> removeInvalidParenthesis(String s) {
        List<String> res = new ArrayList<>();
        if(s == null){
            return res;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(s);
        visited.add(s);
        boolean found = false;
        while(!queue.isEmpty()){
            String temp = queue.poll();
            if(isValid(temp)){
                res.add(temp);
                found = true;
            }
            if(found) continue;
            for(int j=0;j<temp.length();j++){
                if(temp.charAt(j) != '(' && temp.charAt(j) != ')')
                    continue;
                String str = temp.substring(0,j)+temp.substring(j+1);
                if(!visited.contains(str)){
                    queue.offer(str);
                    visited.add(str);
                }

            }

        }


        return res;
    }
    public boolean isValid(String s) {
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(')
                count++;
            if(s.charAt(i) == ')'){
                count--;
                if(count<0)
                    return false;
            }
        }
        return count==0;
    }
}
