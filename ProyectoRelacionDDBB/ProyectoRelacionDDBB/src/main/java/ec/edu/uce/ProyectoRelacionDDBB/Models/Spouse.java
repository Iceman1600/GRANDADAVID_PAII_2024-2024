package ec.edu.uce.ProyectoRelacionDDBB.Models;

import jakarta.persistence.*;

@Entity
public class Spouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;

    // One-to-one relationship with Employee
    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Spouse( String name,Employee employee) {

        this.name = name;
    }
    public Spouse(){}

    public long getId() {
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Spouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employee=" + employee +
                '}';
    }
}

