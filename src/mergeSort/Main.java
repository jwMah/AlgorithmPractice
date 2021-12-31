package mergeSort;

public class Main {

    public static int[] sorted = new int[8];
    public static int[] list;

    public static void main(String[] args) {
        int n = 8;
        list = new int[]{21, 10, 12, 20, 25, 13, 15, 22};
        merge_sort(0,n-1);
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void merge_sort(int left, int right) {
        int mid;
        if(left < right) {
            mid = (right + left) / 2;
            merge_sort(left, mid);
            merge_sort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    private static void merge(int left, int mid, int right) {
        int a = left;
        int b = mid + 1;
        int c = left;
        while(a <= mid && b <= right) {
            if(list[a] <= list[b]) {
                sorted[c++] = list[a++];
            } else {
                sorted[c++] = list[b++];
            }
        }

        if(a <= mid) {
            for (int i = a; i <= mid; i++) {
                sorted[c++] = list[i];
            }
        }
        if(b <= right) {
            for (int i = b; i <= right; i++) {
                sorted[c++] = list[i];
            }
        }
        for (int i = left; i <= right; i++) {
            list[i] = sorted[i];
            System.out.println(list[i]);
        }
        System.out.println();
    }
}
