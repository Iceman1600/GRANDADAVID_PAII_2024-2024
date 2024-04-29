/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paii_002b;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author USUARIO
 */
public class Human implements Drawable,Movable{
     private int[] coordinates;

    public Human(int x1, int y1, int x2, int y2, int x3, int y3) {
        this.coordinates = new int[]{x1, y1, x2, y2, x3, y3};
    }
    public Human(){}

   
    public int[] getCoordinates() {
        return coordinates;
    }


 @Override
    public void draw(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3) {
       int[] xPoints = {x1, x2, x3};
int[] yPoints = {y1, y2, y3};    
int nPoints = 3;
         
        g.setColor(Color.white);
        g.drawPolygon(xPoints, yPoints, nPoints);
        g.fillPolygon(xPoints, yPoints, nPoints);
          
    }

    @Override
    public void draw2(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int x5, int y5) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


   
 @Override
    public void moveLeft(int[] coordinates,int pixels) {
        for (int i = 0; i < coordinates.length; i += 2) {
            coordinates[i] -= pixels;
    if (coordinates[i] < 0) {
                    coordinates[i] = 0; // Establecer la coordenada x en el límite izquierdo
        }
    }}

 @Override
    public void moveRight(int[] coordinates,int pixels, int frameWidth) {
        for (int i = 0; i < coordinates.length; i += 2) {
            coordinates[i] += pixels;
            if (coordinates[i] > frameWidth) {
                 coordinates[i] = frameWidth; // Establecer la coordenada x en el límite derecho
        }}}
    
    
    @Override
    public void moveDown(int[] coordenadas, int pixels, int speed) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 
    @Override
    public void moveUp(int[] coordinates, int pixels, int speed) {
          for (int i = 1; i < coordinates.length; i += 2) {
        coordinates[i] -= pixels * speed; // Multiplicar la cantidad de píxeles por la velocidad
    }}
    
    @Override
    public void draw3(Graphics g, int x1, int y1, int x2, int y2) {
        g.drawOval(x1,y1,x2,y2);
          g.setColor(Color.white);
          g.fillOval(x1,y1,x2,y2);}
    
  
    @Override
    public void drawi(Graphics g, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
}
