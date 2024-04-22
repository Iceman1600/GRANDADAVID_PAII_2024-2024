/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pall_001;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author USUARIO
 */
public class Metodos {
  /*  int a,b,c,d,e,f;
    int [] puntosx = {a,b,c};
    int [] puntosy = {d,e,f};*/
      public static void Circulo(Graphics g, int x, int y, int x1, int y1){
          g.drawOval(x,y,x1,y1);
          g.setColor(Color.blue);
          g.fillOval(x,y,x1,y1);}
      
      
          
          public static void Cuadrado(Graphics g, int x, int y, int x1, int y1){
          g.drawRect(x,y,x1,y1);
          g.setColor(Color.black);
          g.fillRect(x,y,x1,y1);}
      
          
      /*   public static void Triangulo(Graphics g){
             int[] xPoints = {80,10,150};
             int[] yPoints = {80,10,10};    
          g.drawPolygon(xPoints,yPoints,3);
         g.setColor(Color.red);
          g.fillPolygon(xPoints,yPoints,3);
         }
        /*/ 
          public static void Triangulo(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3) { 
int[] xPoints = {x1, x2, x3};
int[] yPoints = {y1, y2, y3};    
int nPoints = 3;
         
        g.setColor(Color.GREEN);
        g.drawPolygon(xPoints, yPoints, nPoints);
        g.fillPolygon(xPoints, yPoints, nPoints);
          
    }
          
          
}


      
      