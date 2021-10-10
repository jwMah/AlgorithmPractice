package generateParenthesis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<String> list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        Main a = new Main();
        a.generate(4);
        System.out.println(list);
        
    }
    public void generate(int n) {
        list = new ArrayList<>();
        dfs("",n,n);

    }
    public void dfs(String result,int left, int right) {
        if(left < 0 || right < 0 || left > right) {
            return;
        }
        if(left == 0 && right == 0) {
            list.add(result);
            return;
        }
        dfs(result+"(",left - 1,right);
        dfs(result+")",left,right-1);
    }
}
