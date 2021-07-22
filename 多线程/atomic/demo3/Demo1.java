package 多线程.atomic.demo3;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @Author: ruan
 * Date: 2021/7/4 12:48
 * @Description:
 */
public class Demo1 {
    public static void main(String[] args) {
        Student student = new Student("ruan", 18L);
        AtomicLongFieldUpdater<Student> longFieldUpdater = AtomicLongFieldUpdater.newUpdater(Student.class, "age");
        longFieldUpdater.compareAndSet(student,18L,20L);
        System.out.println("age = " + student.getAge());
        AtomicReferenceFieldUpdater<Student, String> objectObjectAtomicReferenceFieldUpdater = AtomicReferenceFieldUpdater.newUpdater(Student.class,String.class,"name");
        objectObjectAtomicReferenceFieldUpdater.compareAndSet(student,"ruan","ruanxiangge");
        System.out.println("name = " + student.getName());

    }
}
class Student{
    volatile String name;
    volatile long age;

    public Student(String name, long age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }
}
