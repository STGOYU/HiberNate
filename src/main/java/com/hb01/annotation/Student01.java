package com.hb01.annotation;

import javax.persistence.*;

//@Entity annotation i koydugumuz sinifi db de bir tabloya karsilik getirir.
@Entity
@Table(name="t_student01") //db de tablo ismim t_student01 olarak degisti
public class Student01 {  //DB student01 isminde tablo olusturur.
    // claasin  entity ilacagini soyldeik classdan obje urettigimizde fieldlarin bazilari unique olmali
    //bu classdan bir primary-key olusmasini saglar
    @Id
//    @Column(name="std_id")
    private int id;

    //@Column zorunlu degil ancak customize edebilmek icin gerekli.
        //nullable true olursa bu fieldi olustururken es gecebilir, asagida istedigimiz bilgileri setledik.
    @Column(name="student_name", length = 100, nullable = false, unique = false)  //sql ce heder in ismini verdik
    private String name;

//    @Transient //db deki tabloda grade adinda bir colum olusmasini engeller
    private int grade;

//    @Lob  //--> large object ile buyuk boyutlu datalar tutulabilir
//    private byte[] image ;


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

    @Override
    public String toString() {
        return "student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
