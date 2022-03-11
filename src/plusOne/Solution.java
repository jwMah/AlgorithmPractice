package plusOne;

public class Solution {
    public static void main(String[] args) {
        int[] a = {9,9,9};
        int[] b = solve(a);
        for (int i : b) {
            System.out.print(i);
        }
    }
    static int[] solve(int[] k) {
        String temp = "";
        for (int i = 0; i < k.length; i++) {
            temp += Integer.toString(k[i]);
        }
        int temp2 = Integer.parseInt(temp) + 1;
        temp = Integer.toString(temp2);

        int[] ans = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            ans[i] = temp.charAt(i) - 48;
        }
        return ans;
    }
}
