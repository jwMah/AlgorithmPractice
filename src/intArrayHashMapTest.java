import java.util.HashMap;

public class intArrayHashMapTest {
    public static void main(String[] args) {
        int[] a = {1,2};
        HashMap<int[],Integer> map = new HashMap<>();
        map.put(a,1);
        if(map.containsKey(new int[]{1,2}))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
