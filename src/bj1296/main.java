package bj1296;
import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        int result = -1;
        String candidate = "";
        int old_l = 0;
        int old_o = 0;
        int old_v = 0;
        int old_e = 0;
        for(int i=0;i<name.length();i++){
            if(name.charAt(i) == 'l')
                old_l++;
            if(name.charAt(i) == 'o')
                old_o++;
            if(name.charAt(i) == 'v')
                old_v++;
            if(name.charAt(i) == 'e')
                old_e++;
        }
        int num = Integer.parseInt(sc.nextLine());
        for(int i=0; i<num; i++){
            int new_l = old_l;
            int new_o = old_o;
            int new_v = old_v;
            int new_e = old_e;
            String partner = sc.nextLine();
            for(int j=0;j<partner.length();j++){
                if(partner.charAt(j) == 'l')
                    new_l++;
                if(partner.charAt(j) == 'o')
                    new_o++;
                if(partner.charAt(j) == 'v')
                    new_v++;
                if(partner.charAt(j) == 'e')
                    new_e++;
            }

            int temp = ((new_l+new_o) * (new_l+new_v) * (new_l+new_e) *
                    (new_o+new_v) * (new_o+new_e) * (new_v+new_e)) % 100;

            if(temp > result){
                result = temp;
                candidate = partner;
            }
            else if(temp == result){
                String[] sort = new String[2];
                sort[0] = partner;
                sort[1] = candidate;
                Arrays.sort(sort);
                candidate = sort[0];
            }
        }
        System.out.println(candidate);
    }
}

