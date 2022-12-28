package Practice;

import javax.persistence.*;

@Entity
@Table(name="Employee")
public class Employee {

    @Id
    private long id;

    @Column(name="emp_name")
    private String name;

    @Column(name="emp_salary")
    private double salary;
    @OneToOne
     @JoinColumn(name = "emp_id")
    private Address address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
