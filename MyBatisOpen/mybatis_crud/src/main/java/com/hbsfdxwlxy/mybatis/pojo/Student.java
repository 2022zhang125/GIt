package com.hbsfdxwlxy.mybatis.pojo;

import java.util.Objects;

public class Student {
    private String name;
    private String xh;
    private Character sex;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student that = (Student) o;
        return sex == that.sex && Objects.equals(name, that.name) && Objects.equals(xh, that.xh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, xh, sex);
    }

    @Override
    public String toString() {
        return "StudentTest{" +
                "name='" + name + '\'' +
                ", xh='" + xh + '\'' +
                ", sex=" + sex +
                '}';
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Student(String name, String xh, char sex) {
        this.name = name;
        this.xh = xh;
        this.sex = sex;
    }
}
