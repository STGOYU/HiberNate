package com.hb10.idgeneration;

import javax.persistence.*;

@Entity
public class Student10 {

    /*
    Oracle DB - PostgreSQL ---> Sequence ---> hangi id ile baslayacagini vs. ayarlar kontrol dev'de
    MySQL - MicrosoftSQL  --> IDENTITY -----> birden baslayip siralar kendi yapisina goredir en basittidir

    GenerationType.AUTO  ---> Hibernate otomatik olarak strateji belirler
    GenerationType.TABLE ---> En yavasi ...cok kullanilmiyor,id uretmek icin ekstra tablo yapar

     */
    @Id
    @GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence",  //generator ismi ayni olmali
                        sequenceName = "student_seq", //db de olusacak sequence ismi
                        initialValue = 1000,  //id ler 1000 ile baslasin
                        allocationSize = 10)  //cache leme mekanizmasinda 10 id beklesin
    private int id;

    @Column(name = "student_name",nullable = false)
    private String name;

    private int grade;

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

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

    @Override
    public String toString() {
        return "Student10{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
