package com.hb08.manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student08 {

    @Id
    private int id;

    private String name;

    @ManyToMany
    @JoinTable(name = "student08_book08",
            joinColumns = { @JoinColumn(name = "std_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")}
    )
    private List<Student08> students = new ArrayList<>();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Student08> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "Student08{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
