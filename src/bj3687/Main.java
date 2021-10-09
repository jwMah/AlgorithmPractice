package bj3687;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[]{0, 0, 1, 7, 4, 2, 0, 8};
        long[] min = new long[101];
        Arrays.fill(min,Long.MAX_VALUE);
        String[] max = new String[101];
        min[2] = 1;
        min[3] = 7;
        min[4] = 4;
        min[5] = 2;
        min[6] = 6;
        min[7] = 8;
        min[8] = 10;
        max[2] = "1";
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer,String> map = new HashMap<>();

        String[] add = {"1","7","4","2","0","8"};

        for(int j=9;j<101;j++) {
            for (int k = 2; k < 8; k++) {
                String line = min[j-k] + add[k-2];
                //System.out.println(line);
                min[j] = Math.min(Long.parseLong(line),min[j]);
            }
        }

        for (int j = 3; j < 101; j++) {
            String line = "";
            int length = j/2;
            if(length % 2 == 0) {
                line += "1";
            } else {
                line += "7";
            }
            for (int k = 0; k <length -1 ; k++) {
                line += "1";
            }
            max[j] = line;
        }

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int M = sc.nextInt();
            System.out.println(min[M] + " " + max[M]);
        }

    }
}
