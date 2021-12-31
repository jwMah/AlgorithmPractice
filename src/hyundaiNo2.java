import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class hyundaiNo2 {
    public static void main(String[] args) {
        String[][] friends = new String[2][2];
        friends[0][0] = "hello";
        friends[0][1] = "val1";
        friends[1][0] = "hello";
        friends[1][1] = "val2";
        String user_id = "aa";
        //String aaa = new String(user_id);
        //System.out.println(aaa);

        ArrayList<Integer> list = new ArrayList<>();



        LinkedList<String> arr = new LinkedList<>();
        arr.add("hello1");
        arr.add("hello2");

        arr.remove(1);

        for (String s : arr) {
            System.out.println(s);
        }
//        ArrayList<ArrayList<String>> list1 = new ArrayList<>();
//        HashMap<String,ArrayList<String>> map = new HashMap<>();
//
//        for (int i = 0; i < friends.length; i++) {
//            ArrayList<String> temp;
//            if(map.containsKey(friends[i][0])) {
//                temp = map.get(friends[i][0]);
//                temp.add(friends[i][1]);
//            } else {
//                temp = new ArrayList<>();
//                temp.add(friends[i][1]);
//            }
//            map.put(friends[i][0],temp);
//        }
//        ArrayList<String> user_list = map.get(user_id);
//
//        for (ArrayList<String> value : map.values()) {
//            for (String s : value) {
//                System.out.println(s);
//            }
//        }
    }
}


