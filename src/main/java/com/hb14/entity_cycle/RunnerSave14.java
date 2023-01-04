package com.hb14.entity_cycle;

import com.hb13.get_load.Student13;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave14 {
    /*
Hinernate in Objeler ile nasıl çalıştığı ile ilgili ek bilgi :
   Entity State :
      *) Transient : Objenin newlenmiş hali, DB ile ilişkisi yok.

      *) Persisted or Managed : DB de row a karşılık geldiği durum,
                        save(),get() vs. yapıldığı zamana denk geliyor.

      *) Detached : Session kapandıktan sonra elimizdeki objenin state durumu.

      *) Removed : obje remove yapıldığı zmanki durum.
*/

    public static void main(String[] args) {


        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student13.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Student14 student1 = new Student14();  //Transient
        student1.setName("Recep Bey");
        student1.setMathGrade(99);

        Student14 student2 = new Student14(); //Transient
        student2.setName("Emir Bey");
        student2.setMathGrade(90);

        Student14 student3 = new Student14(); //Transient
        student3.setName("Tarik Bey");
        student3.setMathGrade(85);



        session.save(student1); //Persisted or Managed
        session.save(student2);
        session.save(student3);


        student1.setName("Updated"); //yeniden save methodu ile gondermeye gerek yok //Persisted or Managed

        session.evict(student1); // Detacted state e gecti //kayit olmaz commit calismadi

        session.update(student1); // detacted olmus student i persisted state e alir
        session.merge(student1); // detacted olmus student i persisted state e alir

        /*
        Hibernate sessionu ile ilişkilendirmek için, bu yöntemlerden herhangi biri kullanılabilir.
        - load(), merge(), refresh(), update() or save().
         */






        tx.commit();
        session.close();
        sf.close();
    }
}
