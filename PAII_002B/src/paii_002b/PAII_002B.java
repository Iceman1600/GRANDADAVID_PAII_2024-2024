/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package paii_002b;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author USUARIO
 */
public class PAII_002B extends JFrame  {


    
    public PAII_002B() {
     
        setTitle("Ejemplo de Implementación");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Llamamos al método generar dentro de paintComponent
                Adapter adaptador = new Adapter();
             //   adaptador.dibujarTriangulo(new Triangulo(), g);
            //    adaptador.dibujarAliens(new Aliens(), g);
            }
        };
        
        add(panel); // Añadimos el panel al JFrame
        
        // Establecemos el JFrame como visible
        setVisible(true);
    }
    
 
        
      public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
       PAII_002B      frame = new PAII_002B();
            frame.setVisible(true);
        });
    }}
                
    

