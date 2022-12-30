package Practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerProFetch {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).addAnnotatedClass(Address.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Employee employee = session.get(Employee.class,1003);
        Address address = session.get(Address.class,102);

        System.out.println(employee);
        System.out.println();
        System.out.println(address);
        System.out.println();
        System.out.println(address.getEmployee());


        tx.commit();

        session.close();
        sf.close();

    }
}
