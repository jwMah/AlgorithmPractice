import java.util.Arrays;

public class Course<T> {
    private String name;
    private T[] students;

    public Course(String name, int capacity) {
        this.name = name;
        students = (T[]) (new Object[capacity]);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T[] getStudents() {
        return students;
    }

    public void setStudents(T[] students) {
        this.students = students;
    }

    public void add(T t) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = t;
                break;
            }
        }
    }

    public static void main(String[] args) {

    }

    public static void registerCourse(Course<?> course) {
        System.out.println(course.getName() + " 수강생: " + Arrays.toString(course.getStudents()));
    }
}
