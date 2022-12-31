package com.hb05.manytoone;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Student05 {

    @Id
    private int id; //normalde burada wrapper class yazilir Long gibi default degeri null oldugu icin yazilir bos kalirsa nullexception atar

    @Column(name = "student_name",nullable = false)
    private String name;

    private int grade;

    private LocalDateTime createon; //creqte tarihi

    @ManyToOne() //oldugun class once yazilir yani many one
    @JoinColumn(name = "university_id")
    private University university;


    @PrePersist // create tarihini persist(kalici) edildigi zaman calisir
    public void prePersist(){
        createon=LocalDateTime.now();
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public LocalDateTime getCreateon() {
        return createon;
    }

//    public void setCreateon(LocalDateTime createon) {
//        this.createon = createon;
//    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "Student05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", createon=" + createon +
                ", university=" + university +
                '}';
    }
}
