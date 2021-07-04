package 多线程.atomic.demo4;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author: ruan
 * Date: 2021/7/4 13:03
 * @Description:
 */
public class Demo1 {
    public static void main(String[] args) {
        AtomicReference<Student> studentAtomicReference = new AtomicReference<>();
        Student ruan = new Student(1L, "ruan");
        Student rxg = new Student(2L, "rxg");
        studentAtomicReference.set(ruan );
        boolean b = studentAtomicReference.compareAndSet(ruan, rxg);
        Student student = studentAtomicReference.get();
        System.out.println(student.getName());
    }
}
class Student{
    private long id;
    private String name;

    public Student(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
