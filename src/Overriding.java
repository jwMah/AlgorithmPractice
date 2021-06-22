
class Woman{
    public String name;
    public int age;

    public void hello(){
        System.out.println("hello");
    }

    public void getInfo(){
        System.out.println("이름은 "+name+" 나이는 "+age);
    }
}

class Job extends Woman{
    public String job;

    public void getInfo(){
        super.getInfo();
        System.out.println("직업은 "+job);
    }
}

public class Overriding {
    public static void main(String[] args) {
        Job job = new Job();
        job.job = "programmer";
        //job.name = "Jason";
        //job.age = 37;
        job.getInfo();
        job.hello();
    }
}
