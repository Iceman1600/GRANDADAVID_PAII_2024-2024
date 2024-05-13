/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package uce.edu.ec.paii_004b.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @ David Granda
 */
 @Entity
 @Table(name = "Professor")
public class Professor {
      @Id
    @Column(name = "Id")
      int id ;
      
      @Column(name = "Name")
    String name;
      
      @Column(name = "LName")
    String lname;
      
      @Column(name = "Age")
    int age;


    public Professor(int id, String name, String lname, int age) {
        this.id = id;
        this.name = name;
        this.lname = lname;
        this.age = age;
    }
      
   public Professor() {
   }

    
    public int getId() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public String toString() {
        return "Professor{" + "id=" + id + ", name=" + name + ", lname=" + lname + ", age=" + age + '}';
    }
    

}
