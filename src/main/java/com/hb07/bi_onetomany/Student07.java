package com.hb07.bi_onetomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student07 {

    @Id
    private int id;

    @Column(name = "student_name",nullable = false)
    private String name;

    private int grade;

    @OneToMany(mappedBy = "student",orphanRemoval = true,cascade = CascadeType.REMOVE)
    private List<Book07> booklist = new ArrayList<>();

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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public List<Book07> getBooklist() {
        return booklist;
    }

    public void setBooklist(List<Book07> booklist) {
        this.booklist = booklist;
    }

    @Override
    public String toString() {
        return "Student07{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", booklist=" + booklist +
                '}';
    }
}
