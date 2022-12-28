package Practice;

import com.hb01.annotation.Student01;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerPro {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Employee employee1 = new Employee();
        employee1.setId(1001);
        employee1.setName("Ali Can");
        employee1.setSalary(80);


        Employee employee2 = new Employee();
        employee2.setId(1002);
        employee2.setName("Veli Can");
        employee2.setSalary(90);

        Employee employee3 = new Employee();
        employee3.setId(1003);
        employee3.setName("Mehmet");
        employee3.setSalary(70);

        String query = "FROM Employee";
        System.out.println(query);
        //HQL örnek- Bütün çalışanları getirme sorgusu
//        Query query = session.createQuery("from Employee");

    }
}
