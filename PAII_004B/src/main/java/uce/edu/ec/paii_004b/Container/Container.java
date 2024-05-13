package uce.edu.ec.paii_004b.Container;


import jakarta.persistence.Entity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import uce.edu.ec.paii_004b.Models.Courses;
import uce.edu.ec.paii_004b.Models.Professor;
import uce.edu.ec.paii_004b.Models.Schedule;
import uce.edu.ec.paii_004b.Models.Student;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @ David Granda
 */
public class Container {
    
/*public String Create(int id,String name,String lname, int age){

    	Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        
        configuration.addAnnotatedClass(Student.class);
        
        // Create Session Factory and auto-close with try-with-resources.
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
 
            Session session = sessionFactory.openSession();
 
            Student st = new Student(id,name,lname,age);  
           
 
            session.beginTransaction();
            session.persist(st); 
            session.getTransaction().commit();
              return "Usuario Creado";
       }catch(Exception e){
       e.printStackTrace();
       }
       
       return"Error al crear usuario";
        }

    SessionFactory sf = new Configuration().configure("Hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
       Session s =  sf.openSession();
       try{
           Student st = new Student(id,name,lname,age);
           s.beginTransaction();
           s.save(st);
           s.getTransaction().commit();
           s.close();
       return "Usuario Creado";
       }catch(Exception e){
       e.printStackTrace();
       }
       
       return"Error al crear usuario";
        
    }*/

public String Create(Object obj, String type) {

    Configuration configuration = new Configuration();
    configuration.configure("hibernate.cfg.xml");
    
    // Agregar la clase correspondiente según el tipo especificado
    if (type.equals("Student")) {
        configuration.addAnnotatedClass(Student.class);
    } else if (type.equals("Courses")) {
        configuration.addAnnotatedClass(Courses.class);
         } else if (type.equals("Professor")) {
        configuration.addAnnotatedClass(Professor.class);
        } else if (type.equals("Schedule")) {
        configuration.addAnnotatedClass(Schedule.class);
       
    } else {
        return "Tipo de objeto no válido";
    }
    
    // Crear Session Factory y cerrar automáticamente con try-with-resources.
    try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {

        Session session = sessionFactory.openSession();
        
        // Guardar el objeto en función de su tipo
        session.beginTransaction();
        session.persist(obj);
        session.getTransaction().commit();
        
        return " Succesfully Register";

    } catch(Exception e) {
        e.printStackTrace();
    }

    return "Error al Registrar";
}

public Object read(Class<?> classType, int id) {
    Configuration configuration = new Configuration();
    configuration.configure("hibernate.cfg.xml");
    
    configuration.addAnnotatedClass(classType);
    
    try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
        Session session = sessionFactory.openSession();
        
        Object obj = session.get(classType, id);
        
        if (obj != null) {
            return obj;
        } else {
            return "Objeto no encontrado";
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    return "Error al leer objeto";
}

public String update(Class<?> classType, int id, Object obj) {
    Configuration configuration = new Configuration();
    configuration.configure("hibernate.cfg.xml");
    
    configuration.addAnnotatedClass(classType);
    
    try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
        Session session = sessionFactory.openSession();
        
        Object existingObj = session.get(classType, id);
        
        if (existingObj != null) {
            session.beginTransaction();
            session.merge(obj);
            session.getTransaction().commit();
            return "Objeto actualizado exitosamente";
        } else {
            return "Objeto no encontrado";
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    return "Error al actualizar objeto";
}


public String delete(Class<?> classType, int id) {
    Configuration configuration = new Configuration();
    configuration.configure("hibernate.cfg.xml");
    
    configuration.addAnnotatedClass(classType);
    
    try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
        Session session = sessionFactory.openSession();
        
        Object obj = session.get(classType, id);
        
        if (obj != null) {
            session.beginTransaction();
            session.delete(obj);
            session.getTransaction().commit();
            return "Objeto eliminado exitosamente";
        } else {
            return "Objeto no encontrado";
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    return "Error al eliminar objeto";
}
}


    
