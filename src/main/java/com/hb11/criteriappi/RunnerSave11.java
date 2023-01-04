package com.hb11.criteriappi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Random;

public class RunnerSave11 {

    public static void main(String[] args) {

        /*
    CRUD (Create, Read, Update, Delete)
        C --> session.save
        R --> session.get, HQL, SQL
        U --> session.update, updateQuery
        D --> session.delete, HQL, SQL
 */


        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student11.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Random random =new Random();

//        for (int i = 1; i < 21 ; i++) {
//            Student11 student = new Student11();
//            student.setName("Student Name : "+ i );
//            student.setMathGrade(random.nextInt(100)); //birden 100 e kadar uretir
//            session.save(student);
//        }

//       Student11 student = session.get(Student11.class,1L);
//        student.setName("Guncellenmis "+student.getName());
//
//        session.update(student);


        //DEgisken tanimlama :
        int sMathGrade = 80;
        int lMathGrade = 75;

        //75 in altindakileri 80 e setleme yapalim

//       String hqlQuery = "UPDATE Student11 s SET s.mathGrade=:sMath WHERE s.mathGrade<:lMath";
//       Query query = session.createQuery(hqlQuery);
//
//       query.setParameter("sMath",sMathGrade);
//       query.setParameter("lMath",lMathGrade);
//
//       int numOfRecords = query.executeUpdate();
//        System.out.println("Degistirilen kayit sayisi : "+numOfRecords);

        // !!! CriteriaAPI ***********************************************

        CriteriaBuilder cb =  session.getCriteriaBuilder();
        CriteriaQuery<Student11> criteriaQuery = cb.createQuery(Student11.class);
        Root<Student11> root = criteriaQuery.from(Student11.class);

        /*
        Bir session nesnesi ile getCriteriaBuilder() yöntemini çağırarak bir CriteriaBuilder örneği oluşturun.
        CriteriaBuilder createQuery() yöntemini çağırarak bir CriteriaQuery örneği oluşturun.
        Session createQuery() yöntemini çağırarak bir sorgu örneği oluşturun
        Bize sonuçları veren sorgu nesnesinin getResultList() yöntemini çağırın
         */

        // 1.Örnek
//        criteriaQuery.select(root);
//        Query<Student11> query1 =session.createQuery(criteriaQuery);
//        List<Student11> resultList = query1.getResultList();
//        resultList.forEach(s->System.out.println(s));

//        // 2.Örnek
//        criteriaQuery.select(root).
//                where(cb.equal(root.get("name"),"Student Name 6"));
//        Query<Student11> query2 = session.createQuery(criteriaQuery);
//        List<Student11> resulList2 = query2.getResultList();
//        resulList2.forEach(System.out::println);

        //3. ornek mathGrade degeri 80 den buyuk olan datalari getirelim
//        criteriaQuery.select(root).where(cb.greaterThan(root.get("mathGrade"),80));
//       Query<Student11> query3 = session.createQuery(criteriaQuery);
//       List<Student11> resultList3 = query3.getResultList();
//       resultList3.forEach(System.out::println);

        // !!! 4.örnek --> MathGrade puanı 95 den küçük olan
//        criteriaQuery.select(root).where(cb.lessThan(root.get("mathGrade"),95));
//        Query<Student11> query4 = session.createQuery(criteriaQuery);
//        List<Student11> resultList4 = query4.getResultList();
//        resultList4.forEach(System.out::println);


        // !!! 5.örnek : id si 1 veya mathGrade i 75 den büyük olan recordu bulalım

        Long id = 1L ;

        Predicate predicateForId = cb.equal(root.get("id"), id);
        Predicate predicateForMathGrade = cb.greaterThan(root.get("mathGrade"), 75);

        Predicate predicateQuery = cb.or(predicateForId , predicateForMathGrade );

        criteriaQuery.where(predicateQuery);
        Query<Student11> query5 = session.createQuery(criteriaQuery);
        List<Student11> resultList6 = query5.getResultList();
        resultList6.forEach(System.out::println);





        tx.commit();
        session.close();
        sf.close();
    }
}
