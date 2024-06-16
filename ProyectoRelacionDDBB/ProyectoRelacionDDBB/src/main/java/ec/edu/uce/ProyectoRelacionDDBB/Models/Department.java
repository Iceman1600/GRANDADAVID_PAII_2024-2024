package ec.edu.uce.ProyectoRelacionDDBB.Models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


    @Entity
    public class Department {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        @Column(nullable = false)
        private String name;

        // One-to-many relationship with Employee
        @OneToMany(mappedBy = "department")
        private Set<Employee> employees = new HashSet<>();

        public Department( String name) {

            this.name = name;
        }
        public Department(){}
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

        public Set<Employee> getEmployees() {
            return employees;
        }

        public void setEmployees(Set<Employee> employees) {
            this.employees = employees;
        }

        @Override
        public String toString() {
            return "Department{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

