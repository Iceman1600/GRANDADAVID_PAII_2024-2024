/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paii_002b;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author USUARIO
 */
public class Adapter {
      //  protected Implementar imp;
 
 /*  public void drawHuman(Drawable d,Graphics g){
  d.draw(g, 300,525,400,525,350,470);
 
   }*/
   
    
        public void drawHuman(Drawable d, Graphics g, Human human) {
        int[] coordinates = human.getCoordinates();
        d.draw(g, coordinates[0], coordinates[1], coordinates[2], coordinates[3], coordinates[4], coordinates[5]);
    }
        
         public void drawInfinitely(Drawable d, Graphics g, Human human) {
        int[] coordinates = human.getCoordinates();
         Bullet newBullet = new Bullet(coordinates[4], 500, 10, 10);
         drawBullet(newBullet, g, newBullet);
         
        
     //   d.draw3(g, coordinates[4], 500,10,10);
    }
        
   
    public void drawAlien(Drawable d,Graphics g, Alien a){
int[] coordinates = a.getCoordinates();
d.draw2(g, coordinates[0], coordinates[1], coordinates[2], coordinates[3], coordinates[4], coordinates[5], coordinates[6], coordinates[7], coordinates[8], coordinates[9]);
//d.draw2(g,30, 165, 30, 80, 130, 80, 130, 165,80,120);
  
   }
      
       public void drawBullet(Drawable d,Graphics g,Bullet b){

int[] coordinates = b.getCoordinates();
 d.draw3(g, coordinates[0], coordinates[1], coordinates[2], coordinates[3]);
 /*int[] parameters = b.getParameters();
 d.draw3(g, parameters[0], parameters[1], parameters[2], parameters[3]);*/
 
   }
       
          public void drawLine(Drawable d,Graphics g){
          d.draw3(g, 0, 440, 800, 440);
          }
       
         public void moveLeft(Movable m,Graphics g, Object o){
              if (o instanceof Human) {
        Human h = (Human) o;
        int[] coordinates = h.getCoordinates();
        m.moveLeft(coordinates, 10);
    } else if (o instanceof Bullet) {
        Bullet b = (Bullet) o;
        int[] coordinates = b.getCoordinates();
        m.moveLeft(coordinates,5);}}
   
           public void moveRight(Movable m,Graphics g, Object o){
             if (o instanceof Human) {
        Human h = (Human) o;
        int[] coordinates = h.getCoordinates();
        m.moveRight(coordinates, 10, 780);
    } else if (o instanceof Bullet) {
        Bullet b = (Bullet) o;
        int[] coordinates = b.getCoordinates();
      m.moveRight(coordinates, 5, 780);}}
   
   
            public void moveDown(Movable m,Graphics g, Object o){
                     if (o instanceof Alien) {
       Alien a= (Alien) o;
              int[] coordinates = a.getCoordinates();
    m.moveDown(coordinates,10,3);
    }else if (o instanceof Bullet) {
        Bullet b = (Bullet) o;
        int[] coordinates = b.getCoordinates();
        m.moveDown(coordinates, 5, 3);}}
   
  
            public void moveUp(Movable m,Graphics g,Object o){
                if (o instanceof Human) {
       Human h = (Human) o;
              int[] coordinates = h.getCoordinates();
    m.moveUp(coordinates,10,3);
    }else if (o instanceof Bullet) {
        Bullet b = (Bullet) o;
        int[] coordinates = b.getCoordinates();
        m.moveUp(coordinates, 10, 6);}}
   
        public void Shoot(Movable m,Graphics g, Bullet b ){
        int[] coordinates = b.getCoordinates();
        m.moveDown(coordinates, 10, 8);}
  
}
