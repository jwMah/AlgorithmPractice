import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Dog {
    String name;
    Dog(String name) {this.name = name;}
    void setName(String n) {
        name = n;
    }
    public boolean equals(Dog dog) {
        if(dog.name.equals(this.name)) {
            return true;
        }
        return false;
    }
}

public class StreamTest implements A{
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        Collections.sort(list, (b,c) -> b - c);
        for (Integer integer : list) {
            System.out.println(integer);
        }

    }

    @Override
    public void print_num() {

    }

    @Override
    public void hello(int k) {

    }
}
