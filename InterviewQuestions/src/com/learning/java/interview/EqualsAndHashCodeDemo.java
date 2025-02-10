package com.learning.java.interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class EqualsAndHashCodeDemo {

    public static void main(String[] args) {
        //String name = "ashok";
        // String secondName = "ashok"; //(address  of name)


        //String name = new String("ashok");
        //String secondName = new String("ashok");
        //String thirdName = "ashok";

        //check the reference (==)
        // System.out.println(name == secondName);

        //checks the data
        // System.out.println(name.equals(secondName));

        //creating two Students
        Student ashok = new Student(1, "ashok");
        Student afzal = new Student(1, "ashok");

        //checking equals
//        System.out.println(ashok.equals(afzal));
//        System.out.println(ashok == afzal);

        //checking hashcode
        System.out.println("ashok hashcode: " + ashok.hashCode());
        System.out.println("afzal hashcode: " + afzal.hashCode());

        //checking hashset
        Set<Student> friends = new HashSet<>(Arrays.asList(ashok, afzal));

        System.out.println(friends);

    }
}

class Student extends Object {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


