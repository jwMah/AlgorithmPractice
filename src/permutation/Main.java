package permutation;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main a = new Main();
        int[] nums = {1,2,3};
        System.out.println(a.permute(nums));
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(nums,list,list2);
        return list;
    }
    public void dfs(int[] nums,List<List<Integer>> list ,List<Integer> list2) {

        if(list2.size() == nums.length) {
            List<Integer> l = new ArrayList<>(list2);
            list.add(l);
        }

        for (int i = 0; i < nums.length; i++) {

            if(list2.size() == nums.length){
                continue;
            }

            list2.add(nums[i]);
            dfs(nums,list,list2);
            list2.remove(list2.size()-1);
        }
    }
}
