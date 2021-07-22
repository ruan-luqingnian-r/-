package com.ruan.test02;

/**
 * @PackgeName: com.ruan.test02
 * @ClassName: Student
 * @Author: ruan
 * Date: 2021/7/3 10:32
 * project name: Data-structure-and-algorithm
 * @Description: 作为子类
 */
//Student作为子类
@MyAnnotation(value="hello")
public class Student extends Person implements MyInterface{
    //属性：
    private int sno;//学号
    double height;//身高
    protected double weight;//体重
    public double score;//成绩
    //方法：
    @MyAnnotation(value="himthod")
    public String showInfo(){
        return "我是一名三好学生";
    }
    public String showInfo(int a,int b){
        return "重载方法====我是一名三好学生";
    }
    private void work(){
        System.out.println("我以后会找工作--》成为码农  程序员 程序猿  程序媛");
    }
    void happy(){
        System.out.println("做人最重要的就是开心每一天");
    }
    protected int getSno(){
        return sno;
    }
    //构造器
    public Student(){
        System.out.println("空参构造器");
    }
    private Student(int sno){
        this.sno = sno;
    }
    Student(int sno,double weight){
        this.sno = sno;
        this.weight = weight;
    }
    protected Student(int sno,double height,double weight){
        this.sno = sno;
    }
    @Override
    @MyAnnotation(value="hellomyMethod")
    public void myMethod() {
        System.out.println("我重写了myMethod方法。。");
    }
    @Override
    public String toString() {
        return "Student{" +
                "sno=" + sno +
                ", height=" + height +
                ", weight=" + weight +
                ", score=" + score +
                '}';
    }
}
