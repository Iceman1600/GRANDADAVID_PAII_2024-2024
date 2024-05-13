/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package paii_003;

import Resources.Connect;
import Capa2.Dao_Student;
import Capa2.Dao_Professor;
import Capa2.Dao_Schedule;
import Capa2.Dao_Courses;
import Capa3.Courses;
import Capa3.Professor;
import Capa3.Schedule;
import Capa3.Student;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

/**
 *
 * @ David Granda
 */
public class PAII_003 {

    private static Connection connection;

    private static Connection obtenerConexion() throws SQLException {
        return Connect.getConnection();
    }

    public static void main(String[] args) throws SQLException {
        connection = obtenerConexion();
        Dao_Student ds = new Dao_Student();
        Dao_Professor dp = new Dao_Professor();
        Dao_Courses dc = new Dao_Courses();
        Dao_Schedule dsc = new Dao_Schedule();
        int opcion;
        int id;
        int id2;
        int ids;
        int idp;
        int age;
        int level;
        String des;
        String name;
        String lname;
        String startInput;
        String endInput;
        String dateInput;
        LocalTime startHour;
        LocalTime endHour;
        Scanner leer4 = new Scanner(System.in);
        Scanner leer2 = new Scanner(System.in);
        Scanner leer3 = new Scanner(System.in);
        Scanner leer = new Scanner(System.in);

        do {
            System.out.println("Opcion 1: Admindtrator Student");
            System.out.println("Opcion 2:  Admindtrator Professor ");
            System.out.println("Opcion 3:  Admindtrator Courses  ");
            System.out.println("Opcion 4:  Admindtrator Schedule  ");
            System.out.println("Elegir Opción:  ");
            opcion = leer.nextInt();
            switch (opcion) {

                case 1:
                    do {

                        System.out.println("Opcion 1: Register Student");
                        System.out.println("Opcion 2: Update Student ");
                        System.out.println("Opcion 3: Search Student  ");
                        System.out.println("Opcion 4: Delete Student  ");
                        System.out.println("Elegir Opción:  ");
                        opcion = leer.nextInt();
                        switch (opcion) {

                            case 1:

                                System.out.println("Register ID");
                                id = leer3.nextInt();

                                System.out.println("Register Name");
                                name = leer4.nextLine();

                                System.out.println("Register Last Name");
                                lname = leer3.nextLine();

                                System.out.println("Register Age: ");
                                age = leer4.nextInt();

                                Student s = new Student(id, name, lname, age);
                                ds.create(connection, s);

                                System.out.println(ds.getAll(connection));

                                break;

                            case 2:
                                System.out.println("Enter ID ");
                                id = leer4.nextInt();
                                ds.read(connection, id);

                                System.out.println("Register ID");
                                id2 = leer3.nextInt();

                                System.out.println("Register Name");
                                name = leer4.nextLine();

                                System.out.println("Register Last Name");
                                lname = leer3.nextLine();

                                System.out.println("Register Age: ");
                                age = leer4.nextInt();

                                Student s2 = new Student(id2, name, lname, age);
                                ds.create(connection, s2);

                                System.out.println(ds.getAll(connection));

                                break;

                            case 3:

                                System.out.println("Enter ID ");
                                id = leer4.nextInt();
                                ds.read(connection, id);
                                System.out.println(ds.getAll(connection));
                                break;

                            case 4:
                                System.out.println("Enter ID ");
                                id = leer4.nextInt();
                                ds.delete(connection, id);

                            default:
                                System.out.println("Wrong option try again");
                                opcion = leer3.nextInt();
                        }

                    } while (opcion != 4);

                    break;

                case 2:
                    do {

                        System.out.println("Opcion 1: Register Professor");
                        System.out.println("Opcion 2: Update Professor ");
                        System.out.println("Opcion 3: Search Professor ");
                        System.out.println("Opcion 4: Delete Professor  ");
                        System.out.println("Elegir Opción:  ");
                        opcion = leer.nextInt();
                        switch (opcion) {

                            case 1:

                                System.out.println("Register ID");
                                id = leer3.nextInt();

                                System.out.println("Register Name");
                                name = leer4.nextLine();

                                System.out.println("Register Last Name");
                                lname = leer3.nextLine();

                                System.out.println("Register Age: ");
                                age = leer4.nextInt();

                                Professor p = new Professor(id, name, lname, age);
                                dp.create(connection, p);

                                System.out.println(dp.getAll(connection));

                                break;

                            case 2:
                                System.out.println("Enter ID ");
                                id = leer4.nextInt();
                                dp.read(connection, id);

                                System.out.println("Register ID");
                                id2 = leer3.nextInt();

                                System.out.println("Register Name");
                                name = leer4.nextLine();

                                System.out.println("Register Last Name");
                                lname = leer3.nextLine();

                                System.out.println("Register Age: ");
                                age = leer4.nextInt();

                                Professor p2 = new Professor(id2, name, lname, age);
                                dp.create(connection, p2);

                                System.out.println(ds.getAll(connection));

                                break;

                            case 3:

                                System.out.println("Enter ID ");
                                id = leer4.nextInt();
                                dp.read(connection, id);
                                System.out.println(ds.getAll(connection));
                                break;

                            case 4:
                                System.out.println("Enter ID ");
                                id = leer4.nextInt();
                                dp.delete(connection, id);

                            default:
                                System.out.println("Wrong option try again");
                                opcion = leer3.nextInt();
                        }
                    } while (opcion != 4);

                    break;
                case 3:
                    do {

                        System.out.println("Opcion 1: Register Course");
                        System.out.println("Opcion 2: Update Course ");
                        System.out.println("Opcion 3: Search Course ");
                        System.out.println("Opcion 4: Delete Course ");
                        System.out.println("Elegir Opción:  ");
                        opcion = leer.nextInt();
                        switch (opcion) {

                            case 1:

                                System.out.println("Register ID");
                                id = leer3.nextInt();

                                System.out.println("Register Name");
                                name = leer4.nextLine();

                                System.out.println("Register Description");
                                des = leer3.nextLine();

                                System.out.println("Register Level: ");
                                level = leer4.nextInt();

                                Courses c = new Courses(id, name, des, level);
                                dc.create(connection, c);

                                System.out.println(dc.getAll(connection));

                                break;

                            case 2:
                                System.out.println("Enter ID ");
                                id = leer4.nextInt();
                                dc.read(connection, id);

                                System.out.println("Register ID");
                                id2 = leer3.nextInt();

                                System.out.println("Register Name");
                                name = leer4.nextLine();

                                System.out.println("Register Description");
                                des = leer3.nextLine();

                                System.out.println("Register Level: ");
                                level = leer4.nextInt();

                                Courses c2 = new Courses(id2, name, des, level);
                                dc.create(connection, c2);

                                System.out.println(dc.getAll(connection));
                                break;

                            case 3:

                                System.out.println("Enter ID ");
                                id = leer4.nextInt();
                                dc.read(connection, id);
                                System.out.println(dc.getAll(connection));
                                break;

                            case 4:
                                System.out.println("Enter ID ");
                                id = leer4.nextInt();
                                dc.delete(connection, id);

                            default:
                                System.out.println("Wrong option try again");
                                opcion = leer3.nextInt();
                        }
                    } while (opcion != 4);
                    break;

                case 4:
                    do {

                        System.out.println("Opcion 1: Register Schedule");
                        System.out.println("Opcion 2: Update Schedule ");
                        System.out.println("Opcion 3: Search Schedule ");
                        System.out.println("Opcion 4: Delete Schedule ");
                        System.out.println("Elegir Opción:  ");
                        opcion = leer.nextInt();
                        switch (opcion) {

                            case 1:

                                System.out.println("Register ID_Course");
                                id = leer3.nextInt();

                                System.out.println("Register ID_Student");
                                ids = leer3.nextInt();

                                System.out.println("Register ID_Professor");
                                idp = leer3.nextInt();

                                System.out.println("Register start time (HH:mm:ss)");
                                startInput = leer3.next();
                                startHour = LocalTime.parse(startInput);

                                System.out.println("Register end time (HH:mm:ss)");
                                endInput = leer3.next();
                                endHour = LocalTime.parse(endInput);

                                System.out.println("Register date (yyyy-MM-dd)");
                                dateInput = leer3.next();
                                LocalDate date = LocalDate.parse(dateInput);

                                Schedule s = new Schedule(id, ids, idp, startHour, endHour, date);
                                dsc.create(connection, s);

                                System.out.println(dsc.getAll(connection));

                                break;

                            case 2:
                                System.out.println("Enter ID_Course ");
                                id = leer4.nextInt();
                                dsc.read(connection, id);

                                System.out.println("Register ID_Course");
                                id2 = leer3.nextInt();

                                System.out.println("Register ID_Student");
                                ids = leer3.nextInt();

                                System.out.println("Register ID_Professor");
                                idp = leer3.nextInt();

                                System.out.println("Register start time (HH:mm:ss)");
                                startInput = leer3.next();
                                startHour = LocalTime.parse(startInput);

                                System.out.println("Register end time (HH:mm:ss)");
                                endInput = leer3.next();
                                endHour = LocalTime.parse(endInput);

                                System.out.println("Register date (yyyy-MM-dd)");
                                dateInput = leer3.next();
                                date = LocalDate.parse(dateInput);

                                Schedule sc2 = new Schedule(id2, ids, idp, startHour, endHour, date);
                                dsc.create(connection, sc2);

                                System.out.println(dsc.getAll(connection));

                            case 3:

                                System.out.println("Enter ID_Course ");
                                id = leer4.nextInt();
                                dsc.read(connection, id);
                                System.out.println(dsc.getAll(connection));
                                break;

                            case 4:
                                System.out.println("Enter ID_Course ");
                                id = leer4.nextInt();
                                dsc.delete(connection, id);

                            default:
                                System.out.println("Wrong option try again");
                                opcion = leer3.nextInt();
                        }
                    } while (opcion != 4);

            }
        } while (opcion != 4);

    }
}
