package licenseKeyFormatting;

public class Solution {
    public static void main(String[] args) {
        String a = "8-5g-3-j";
        String b = "8F3Z-2e-9-w";
        int k = 2;
        System.out.println(solve(b,k));
    }
    static String solve(String s, int k) {
        s = s.toUpperCase();
        int idx = s.indexOf('-');
        String ans = s.substring(0,idx+1);
        s = s.substring(idx+1);
        s = s.replace("-","");
        StringBuilder sb = new StringBuilder(s);
        int len = sb.length();
        for (int i = k; i < len; i=i+k) {
            sb.insert(i,"-");
            //System.out.println(sb);
        }
        return ans + sb.toString();
    }
}
