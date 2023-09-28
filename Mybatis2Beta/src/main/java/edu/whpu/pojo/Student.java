package edu.whpu.pojo;

public class Student {
    private int id;
    private String name;
    private int age;
    private int class_id;

    public Student() {
    }

    public Student(int id, String name, int age, int class_id) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.class_id = class_id;
    }

    public Student(String name, int age, int class_id) {
        this.name = name;
        this.age = age;
        this.class_id = class_id;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(int id, String name, int class_id) {
        this.id = id;
        this.name = name;
        this.class_id = class_id;
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", class_id=" + class_id;
    }

}
