package com.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch01 {

    public static void main(String[] args) {


        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
       Transaction tx = session.beginTransaction();

       /*
       //DB den bilgi almak icin 3 yol vardir
       1) get()   ---> sql ile javaca konusma yapiyoruz 3 select calisti database i yordu --performansa bagli
       2) SQL  --> 1 select calisti hepsini basti en son yapilacak
       3) HQL //hibernate query languege --> tek select calisti performans onemli ise bu kullanilir
        */

        // 1. yol get
//      Student01 student01 = session.get(Student01.class,1001);
//      Student01 student02 = session.get(Student01.class,1002);
//      Student01 student03 = session.get(Student01.class,1003);
//        System.out.println(student01);
//        System.out.println(student02);
//        System.out.println(student03);

//        // 2. yol SQL
//        String sqlQuery = "SELECT * FROM t_student01";
//       List<Object[]> resultList = session.createSQLQuery(sqlQuery).getResultList(); //gelenler object olacak  ic ice array geldi
//        for (Object[] object:resultList) {
//            System.out.println(Arrays.toString(object));
//        }

        // 3. yol HQL
        //Trick : tablo ismi ve heder ismi kullanilmaz. Hql sorgusunda fromdan sonra  java class ismi kullanilmali

//        String hqlQuery = "FROM Student01";
//       List<Student01> resultList2 =  session.createQuery(hqlQuery, Student01.class).getResultList(); // class ile mapledi
//        for (Student01 student01: resultList2) {
//            System.out.println(student01);
//        }

        // donecek kayit unique tek bir tane ise uniqueResult kullanilir id gibi

//        String sqlQuery2 = "SELECT * FROM t_student01 WHERE student_name='Tarik' ";
//        Object [] uniqueResult = (Object[]) session.createSQLQuery(sqlQuery2).uniqueResult(); // array aldik cunku fieldleri gelecek
//        System.out.println(Arrays.toString(uniqueResult));
//
//        // tek tek de field ler alinabilir.
//        System.out.println(uniqueResult[0] + ":" + uniqueResult[1] + ":"+ uniqueResult[2]);

        //unique REsultSet HQL ile
//        String hqlQuery2 = "FROM Student01 WHERE name='Tarik'";
//       Student01 uniqueResult2 = session.createQuery(hqlQuery2, Student01.class).uniqueResult();
//        System.out.println(uniqueResult2);  //sadece tarik i aldigi icin toString methodu yeterli

        //yukaridaki sorguyu HQL Alias kullanarak yapalim
//       String hqlQuery3 = "FROM Student01 std WHERE std.name='Mirac'";
//        Student01 uniqueResult3 = session.createQuery(hqlQuery3, Student01.class).uniqueResult();
//        System.out.println(uniqueResult3);
//
//
        //grade degeri 90 olan ogrenciyi getirelim
        String hqlQuery4 = "SELECT s.id,s.name FROM Student01 s WHERE s.grade=90";

        // createQuery metoduna tek parametre girdiğimiz için Student01 clası ile mappleme işlemi yapılmadı
        // bu yüzden Object olarak aldık

       List<Object []> resultlist3 = session.createQuery(hqlQuery4).getResultList();
        for (Object[] object: resultlist3) {
            System.out.println(Arrays.toString(object));
        }

        tx.commit();

       session.close();
       sf.close();
    }
}
