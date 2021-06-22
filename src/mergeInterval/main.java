package mergeInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class main {
    public static void main(String[] args) {
        int[][] intervals = {{2,6},{8,10},{1,3},{15,18}};

        Arrays.sort(intervals, Comparator.comparing(o -> o[0]));
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0;i<intervals.length;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            while(++i < intervals.length){
                int next_start=intervals[i][0];
                int next_end=intervals[i][1];
                if(next_start > end){
                    i--;
                    break;
                }
                end = Math.max(next_end,end);
            }
            list.add(Arrays.asList(start,end));
        }

        int[][] answer = new int[(list.size())][];
        for(int i=0;i<list.size();i++){
            answer[i] = new int[]{list.get(i).get(0),list.get(i).get(1)};
        }
        for(int i=0;i< answer.length;i++){
            System.out.println(answer[i][0] + " " + answer[i][1]);
        }
    }
}
