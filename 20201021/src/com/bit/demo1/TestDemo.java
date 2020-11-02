package com.bit.demo1;

/**
 * @program: 20201021
 * @description
 * @author: YouName
 * @create: 2020-10-28 21:18
 **/
class Money implements Cloneable{
    double money = 12.5;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class Person implements Cloneable{
    public int age;

    Money m = new Money();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person p = (Person)super.clone();
        p.m = (Money)this.m.clone();
        return p;
    }
}

public class TestDemo {
    public static void main(String[] args) throws CloneNotSupportedException{
        Person person1 = new Person();
        Person person2 = (Person) person1.clone();
        System.out.println(person1.m.money);
        System.out.println(person2.m.money);
        System.out.println("----------修改-------------");
        person2.m.money = 99.9;
        System.out.println(person1.m.money);
        System.out.println(person2.m.money);
    }

}
