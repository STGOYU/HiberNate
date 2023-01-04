package com.hb13.get_load;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/*
   get() ---> gerçek nesneyi döndürür ,
               nesne yoksa null döner
               nesnenin olduğundan emin değilseniz get() kullanın
               dönen nesneye hemen kullanacaksam get() kullanılmalı
   load() --> proxy nesne döndürür, gerçek nesnenin gölgesi ,
               nesne yoksa exception fırlatır
               dönen nesne üzerinde delete yapılacaksa kullanılabilir
 */

public class RunnerFetch13 {

    public static void main(String[] args) {


        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student13.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


//       Student13 student1 = session.get(Student13.class,1L);
//        System.out.println("Student id : "+student1.getId());
//        System.out.println("Student get name : "+student1.getName());
        /*
        Student id : 1
        Student get name : Mustafa KESER //get den dolayi ikinciside geldi
         */
        //aynisini load icin yazalim hib bir sey yazmadi. bu method proxyden calisiyor db de kullanilmayacak data icin kullanilir
//        Student13 student2 = session.load(Student13.class,2L);
//        System.out.println("student2.getName() = " + student2.getName());
//        System.out.println();

        //DB de olmayan id yi cagirisak?
//        System.out.println("get() basladi : ");
//       Student13 student3 = session.get(Student13.class,5L);
////        System.out.println("student3.getName() = " + student3.getId()); //NullPointerException
//
//        if(student3!=null){
//            System.out.println("student3.getId() = " + student3.getId());
//            System.out.println("student3.getName() = " + student3.getName());
//        }
        System.out.println("****************************************************");
        //Load methodu basladi //oldugundan emin degilsek get yapilmali
//       Student13 student4 = session.load(Student13.class,10L);
//       if(student4 !=null){
//           System.out.println("student4.getId() = " + student4.getId());//ObjectNotFoundException
//           System.out.println("student4.getName() = " + student4.getName());//ObjectNotFoundException
//       }

        //Load () methodu kullanimi :
       Student13 student5 = session.get(Student13.class,1L);
       session.delete(student5);

       Student13 student6 = session.load(Student13.class,2L);
       session.delete(student6);

       //load methodu ile obje referansi alinir ve sonra delete cagrilir.
        //get methodu cagrilmayarak db ye hit engellenmis olur.





        tx.commit();
        session.close();
        sf.close();







    }
}
