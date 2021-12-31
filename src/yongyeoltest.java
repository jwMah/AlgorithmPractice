import java.io.*;
import java.util.Collections;

class GenericArrayList<T> {

    private Object[] elementData = new Object[5];
    private int size;

    public void add(T value) {
        elementData[size++] = value;
    }

    public T get(int idx) {
        return (T) elementData[idx];
    }
}

class SimpleArrayListForInteger {
    private int size;
    private Object[] elementData = new Object[5];

    public void add(Object value) {
        elementData[size++] = value;
    }

    public Object get(int idx) {
        return elementData[idx];
    }
}


public class yongyeoltest {
    public static void main(String[] args) throws IOException {
        GenericArrayList<Integer> a = new GenericArrayList<>();
        SimpleArrayListForInteger b = new SimpleArrayListForInteger();
        a.add(1);
        a.add(2);
        Student<Integer> student = new Student<>();
        int num1 = student.getOneStudent(12);
        int num2 = student.getId(13);
        int num3 = student.toT1(14);
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);


    }

    public static <T extends String> void print(T param) {
        System.out.println(param.charAt(0));
    }
}

class Student<T>{

    public T getOneStudent(T id){ return id; }  // 1

    public <T> T getId(T id){return id;} // 2 제네릭 클래스의 T와 다름

    public <S> T toT1(S id){return (T) id; }  // 3

    //public static <S> T toT2(S id){return id;}  // 4 에러
}





