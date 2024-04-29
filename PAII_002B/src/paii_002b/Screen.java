/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package paii_002b;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @ David Granda
 */
public class Screen extends JFrame {
    public Canvas canvas;
    public static final int Width = 800, Height =600;

    public Screen(){
    setTitle("SPACE WARS");
    setSize(Width,Height);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setLocationRelativeTo(null);
    setVisible(true);
            
            canvas = new Canvas();
            canvas.setPreferredSize(new Dimension(Width,Height));
            canvas.setMaximumSize(new Dimension(Width,Height));
            canvas.setMinimumSize(new Dimension(Width,Height));
            canvas.setFocusable(true);
            add(canvas);
            
    }
}
