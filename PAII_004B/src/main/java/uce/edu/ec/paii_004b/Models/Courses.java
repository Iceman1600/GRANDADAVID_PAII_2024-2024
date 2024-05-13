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
/**
 *
 * @ David Granda
 */
 @Entity
 @Table(name = "Courses")
public class Courses {
       @Id
    @Column(name = "Id")
    int id;
    @Column(name = "Name")   
    String name;
    @Column(name = "Description")
    String Description;
    @Column(name = "Level")
    int level;

    public Courses(int id, String name, String Description, int level) {
        this.id = id;
        this.name = name;
        this.Description = Description;
        this.level = level;
    }

    public Courses() {
    }

    public  int getId() {
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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Courses{" + "id=" + id + ", name=" + name + ", Description=" + Description + ", level=" + level + '}';
    }
    
    

}
