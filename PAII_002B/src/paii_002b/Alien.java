package paii_002b;


import java.awt.Color;
import java.awt.Graphics;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @ David Granda
 */
public class Alien implements Drawable,Movable {
    
     private int[] coordinates;
     
     public Alien(){}

    public Alien(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int x5, int y5) {
        this.coordinates = new int[]{x1, y1, x2, y2, x3, y3,  x4, y4, x5, y5};
    }

   // public Human(){}
    public int[] getCoordinates() {
        return coordinates;
    }

     @Override
       public void draw2(Graphics g, int x1,int y1, int x2, int y2, int x3, int y3,int x4, int y4, int x5, int y5) { 
int[] xPoints = {x1, x2, x3,x4,x5};
int [] yPoints = {y1, y2, y3,y4,y5};    
int nPoints = 5;
         
        g.setColor(Color.GREEN);
        g.drawPolygon(xPoints, yPoints, nPoints);
        g.fillPolygon(xPoints, yPoints, nPoints);
          
    }

    @Override
    public void draw(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
       @Override
 public void moveDown(int[] coordenadas, int pixels, int speed) {
    // Actualizar las coordenadas verticales
    for (int i = 1; i < coordenadas.length; i += 2) {
        coordenadas[i] += pixels * speed; // Multiplicar la cantidad de píxeles por la velocidad
    }
}

    @Override
    public void moveLeft(int[] coordinates,int x) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void moveRight(int[] coordinates,int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

    @Override
    public void moveUp(int[] coordenadas, int pixels, int speed) {
          for (int i = 1; i < coordenadas.length; i += 2) {
        coordenadas[i] += pixels * speed; // Multiplicar la cantidad de píxeles por la velocidad
    }
}

    @Override
    public void draw3(Graphics g, int x1, int y1,int x2, int y2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 
    @Override
    public void drawi(Graphics g, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
}
