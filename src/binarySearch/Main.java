package binarySearch;

public class Main {
    public static void main(String[] args) {
        //오름차순 혹은 내림 차순으로 정렬된 데이터에서만 사용 가능
        int[] list = {12,21,30,41,56,68,79,89};
        int target = 79;
        int start = 0; int end = list.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;

            if(list[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

            System.out.println("start index = " + start);
            System.out.println("mid index = " + mid);
            System.out.println("end index = " + end);
        }
        System.out.println(list[start]);
    }
}
