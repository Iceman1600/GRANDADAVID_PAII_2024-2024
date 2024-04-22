/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author USUARIO
 */
public class Triangulo extends JPanel{
    
    @Override
    public void paint(Graphics g){
     int[] xPoints = {80,10,150};
      int[] yPoints = {80,10,10};    
          g.drawPolygon(xPoints,yPoints,3);
           g.setColor(Color.red);
          g.fillPolygon(xPoints,yPoints,3);
    }
    
    public static void main (String[]args){
    JFrame ventana = new JFrame("Triangulo");
    Triangulo objeto = new Triangulo();
    ventana.add(objeto);
    ventana.setSize(700,700);
    ventana.setLocationRelativeTo(null);
    ventana.setVisible(true);
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
