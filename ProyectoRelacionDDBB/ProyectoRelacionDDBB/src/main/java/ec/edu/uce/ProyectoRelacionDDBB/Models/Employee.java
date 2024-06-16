package ec.edu.uce.ProyectoRelacionDDBB.Models;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String position;

    // One-to-one relationship with Spouse
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private Spouse spouse;

    // Many-to-many relationship with Project
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "employee_project",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id"))
    private Set<Project> projects = new HashSet<Project>();

    // Many-to-one relationship with Department
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee( String name, String position, Spouse spouse,Department department) {

        this.name = name;
        this.position = position;
        this.spouse = spouse;
        this.department = department;
    }

    public Employee(){}

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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Spouse getSpouse() {
        return spouse;
    }

    public void setSpouse(Spouse spouse) {
        this.spouse = spouse;
    }
    public Set<Project> getProject() {
        return projects;
    }



    public void setProject(Set<Project> projects) {
        this.projects = projects;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", spouse=" + spouse + '\'' +
                ", department=" + department +
                '}';
    }
}
