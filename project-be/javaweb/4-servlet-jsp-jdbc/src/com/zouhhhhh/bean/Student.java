package com.zouhhhhh.bean;

import java.time.LocalDate;
import java.util.Date;

public class Student {

    int id;
    String name;
    String score;
    Date birthday;

    public Student() {
    }

    public Student(String name, String score, Date birthday) {
        this.name = name;
        this.score = score;
        this.birthday = birthday;
    }

    public Student(Integer id, String name, String score, Date birthday) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.birthday = birthday;
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

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score='" + score + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
