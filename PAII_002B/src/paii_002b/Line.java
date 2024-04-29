/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package paii_002b;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @ David Granda
 */
public class Line implements Drawable{

    @Override
    public void draw(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void draw2(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int x5, int y5) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void draw3(Graphics g, int x1, int y1, int x2, int y2) {
          g.drawLine(x1,y1,x2,y2);
          g.setColor(Color.white);
    }

    @Override
    public void drawi(Graphics g, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
