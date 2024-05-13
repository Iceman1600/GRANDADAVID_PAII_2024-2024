/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package uce.edu.ec.paii_004b.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @ David Granda
 */
@Entity
 @Table(name = "Schedule")
public class Schedule {
  @Id
    @Column(name = "Id")
   int id_courses;
   @Column(name = "Id")
   int id_student;
    @Column(name = "Id")
   int id_prof;
     @Column(name = "Id")
    LocalTime hour_b;
      @Column(name = "Id")// Cambiado a LocalTime para representar la hora
   LocalTime hour_f;
       @Column(name = "Id")// Cambiado a LocalTime para representar la hora
   LocalDate day;    // Cambiado a LocalDate para representar la fecha

    public Schedule(int id_courses, int id_student, int id_prof, LocalTime hour_b, LocalTime hour_f, LocalDate day) {
  
        this.id_courses = id_courses;
        this.id_student = id_student;
        this.id_prof = id_prof;
        this.hour_b = hour_b;
        this.hour_f = hour_f;
        this.day = day;
    }

    public int getId_courses() {
        return id_courses;
    }

    public void setId_courses(int id_courses) {
        this.id_courses = id_courses;
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public int getId_prof() {
        return id_prof;
    }

    public void setId_prof(int id_prof) {
        this.id_prof = id_prof;
    }

    public LocalTime getHour_b() {
        return hour_b;
    }

    public void setHour_b(LocalTime hour_b) {
        this.hour_b = hour_b;
    }

    public LocalTime getHour_f() {
        return hour_f;
    }

    public void setHour_f(LocalTime hour_f) {
        this.hour_f = hour_f;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "Schedule{" + "id_courses=" + id_courses + ", id_student=" + id_student + ", id_prof=" + id_prof + ", hour_b=" + hour_b + ", hour_f=" + hour_f + ", day=" + day + '}';
    }
   
   
   
    

}
