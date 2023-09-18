package com.nighterdream.Pojo;

public class Employee {
    private Integer id;
    private String name;
    private String age;
    private String position;

    public Employee() {
    }

    public Employee(String name, String age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    public Employee(Integer id, String name, String age, String position) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.position = position;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
            return "职员{" +
                    "员工id=" + id +
                    ", 员工姓名='" + name + '\'' +
                    ", 员工年龄='" + age + '\'' +
                    ", 员工职位='" + position + '\'' +
                    '}';
    }
}
