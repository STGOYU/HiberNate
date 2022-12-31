package com.hb05.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnerFetch05 {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student05.class).addAnnotatedClass(University.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        //get methodu
       Student05 student = session.get(Student05.class,1001);
        System.out.println(student);
        System.out.println(student.getUniversity());

        //HQL ile student05 in hepsi
        String hqlQuery1 = "FROM Student05";  //Student05.class parantezde list getirecegi icin mapleme yapiyoruz
        List<Student05> resultList1= session.createQuery(hqlQuery1, Student05.class).getResultList();
        resultList1.forEach(s-> System.out.println(s));

        //HQL ile 1 id li universiteye giden butun ogrencileri bulalim
        String hqlQuery2 = "FROM Student05 s where s.university.id=1";
        List<Student05> resultList2= session.createQuery(hqlQuery2, Student05.class).getResultList();
        resultList2.forEach(s-> System.out.println(s));


        tx.commit();

        session.close();
        sf.close();
    }
}
