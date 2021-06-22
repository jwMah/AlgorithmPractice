package Main;

public class maxHeap {
    int capacity;
    int size;
    int[] arr;

    public maxHeap(int maximumSize){
        capacity = maximumSize;
        arr = new int[maximumSize+1];
        size = 0;
        arr[0] = Integer.MAX_VALUE;
    }

    public boolean isFull(){
        return size == capacity;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void insert(int value){
        arr[size] = value;
        int temp = size;
        while(temp != 0){
            if(arr[temp] > arr[temp/2]){
                
            }
        }
    }
}
