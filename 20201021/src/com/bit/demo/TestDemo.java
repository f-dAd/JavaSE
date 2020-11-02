package com.bit.demo;

import java.util.Arrays;

/**
 * @program: 20201021
 * @description
 * @author: YouName
 * @create: 2020-10-27 18:46
 **/

class Student implements Comparable<Student>{
    public String name;
    public int age;
    public int score;

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        if (this.age > o.age){
            return 1;
        }else if (this.age == o.age){
            return 0;
        }else {
            return -1;
        }

    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
class Animal{
    protected String name;

    public Animal(String name) {
        this.name = name;
        System.out.println("Animal(String)");
    }
}
interface IFlying{
    void fly();
}
interface IRunning{
    void run();
}
interface ISwimming{
    void swim();
}

class Cat extends Animal implements IRunning{
    public Cat(String name) {
        super(name);
    }
    public void run(){
        System.out.println(this.name+"正在跑");
    }
}
class Fish extends Animal implements ISwimming{
    public Fish(String name) {
        super(name);
    }
    public void swim(){
        System.out.println(this.name+"正在游泳");
    }
}
class Frog extends Animal implements IRunning, ISwimming{
    public Frog(String name) {
        super(name);
    }
    public void run(){
        System.out.println(this.name+"正在跑");
    }
    public void swim(){
        System.out.println(this.name+"正在游泳");
    }

}
public class TestDemo {
    public static void main(String[] args) {
        Student student1 = new Student("bit",18, 79);
        Student student2 = new Student("bit",20, 99);
        Student student3 = new Student("bit",18, 89);
        Student students[] = new Student[3];
        students[0] = student1;
        students[1] = student2;
        students[2] = student3;
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }



}
