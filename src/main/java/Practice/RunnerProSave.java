package Practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerProSave {

    public static void main(String[] args) {

        Address address1 = new Address();
        address1.setId(101);
        address1.setAddressLine1("School Street");
        address1.setZipcode("92320");
        address1.setCity("Stuttgart");
        address1.setEmployee(address1.getEmployee());

        Address address2 = new Address();
        address2.setId(102);
        address2.setAddressLine1("Martin Street");
        address2.setZipcode("72320");
        address2.setCity("Stuttgart");
        address2.setEmployee(address2.getEmployee());



        Employee employee1 = new Employee();
        employee1.setId(1001);
        employee1.setName("Ali Can");
        employee1.setSalary(80);
        employee1.setAddress(address1);


        Employee employee2 = new Employee();
        employee2.setId(1002);
        employee2.setName("Veli Can");
        employee2.setSalary(90);
        employee2.setAddress(address1);


        Employee employee3 = new Employee();
        employee3.setId(1003);
        employee3.setName("Mehmet");
        employee3.setSalary(70);
        employee3.setAddress(address2);


        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).addAnnotatedClass(Address.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        session.save(address1);
        session.save(address2);
        session.save(employee1);
        session.save(employee2);
        session.save(employee3);


        tx.commit();

        session.close();
        sf.close();

    }
}
