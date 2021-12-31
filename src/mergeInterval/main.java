package mergeInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class main {
    public static void main(String[] args) {
        int[][] intervals = {{2,6},{8,10},{1,3},{15,18}};

        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        List<List<Integer>> list = new ArrayList<>();
        //list.index
        for (int i = 0; i < intervals.length; i++) {
            if(list.isEmpty()){
                List<Integer> list1 = new ArrayList<>();
                list1.add(intervals[i][0]);
                list1.add(intervals[i][1]);
                list.add(list1);
            }
            List<Integer> list2 = list.get(list.size() -1);
            int finish_time = list2.get(1);
            if(intervals[i][0] <= finish_time) {
                list2.remove(1);
                list2.add(intervals[i][0]);
            } else {
                List<Integer> list3 = new ArrayList<>();
                list3.add(intervals[i][0]);
                list3.add((intervals[i][1]));
                list.add(list3);
            }
        }

        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
