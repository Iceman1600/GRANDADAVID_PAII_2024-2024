/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inv_dependencia;

import java.util.Scanner;

/**
 *
 * @ David Granda
 * Inversion de Dependencias
 */
public class Inv_Dependencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Seleccione una forma geométrica:");
            System.out.println("1. Triángulo");
            System.out.println("2. Cuadrado");
            System.out.println("3. Círculo");
            System.out.println("4. Salir");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Generador g = new Generador(new Triangulo());
                    g.generar();
                    break;
                case 2:
                    Generador g1 = new Generador(new Cuadrado());
                    g1.generar();
                    break;
                case 3:
                    Generador g2 = new Generador(new Circulo());
                    g2.generar();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }
    
}
