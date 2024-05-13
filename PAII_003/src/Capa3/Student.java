/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Capa3;

/**
 *
 * @ David Granda
 */
public class Student {
    int id ;
    String name;
    String lname;
    int age;

    public Student(int id, String name, String lname, int age) {
        this.id = id;
        this.name = name;
        this.lname = lname;
        this.age = age;
    }

  public  Student() {
  }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
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
    

}
