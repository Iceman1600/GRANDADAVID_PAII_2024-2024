/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package paii_002b;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author USUARIO
 */
public class ScreenII extends javax.swing.JFrame {

    /**
     * Creates new form ScreenII
     */
      public Canvas canvas;
    public static final int Width = 800, Height =600;
     private  Adapter ad = new Adapter()  ;
    Human h = new Human(300,525,400,525,350,470);
    Alien a = new Alien(30, 165, 30, 80, 130, 80, 130, 165,80,120);
    Alien a2 = new Alien(320, 165, 320, 80, 420, 80, 420, 165,370,120);
    Alien a3 = new Alien(620, 165, 620, 80, 720, 80, 720, 165,670,120);
    Alien a4 = new Alien(175, 260, 175, 175, 275, 175, 275, 260,225,215);
    Alien a5 = new Alien (470, 260, 470, 175, 570, 175, 570, 260,520,215);
    Bullet b = new Bullet(350,500,10,10);
    Bullet b2 = new Bullet(80,120,10,10);
    Bullet b3 = new Bullet(370,120,10,10);
    Bullet b4 = new Bullet(670,120,10,10);
    Bullet b5 = new Bullet(225,215,10,10);
    Bullet b6 = new Bullet(520,215,10,10);
    Bullet b7 = new Bullet();
    Line l = new Line();
    Usuario u ;
     private int frameWidth = 800;
      private Timer timer,timer2;
     private Timer bulletSelectionTimer; 
    
    public ScreenII(Usuario u){
    this.u = u;
    jLabel1.setText(u.getNname());
    setTitle("SPACE WARS");
    this.getContentPane().setBackground(Color.black);
    setSize(Width,Height);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setLocationRelativeTo(null);
    setVisible(true);
            
           /* canvas = new Canvas();
            canvas.setPreferredSize(new Dimension(Width,Height));
            canvas.setMaximumSize(new Dimension(Width,Height));
            canvas.setMinimumSize(new Dimension(Width,Height));
            canvas.setFocusable(true);
           add(canvas);*/
            
             // adaptador = new Adapter();
                  jPanel1 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Llamamos al método generar dentro de paintComponent
               
               ad.drawHuman(h, g,h);
               ad.drawAlien(a, g,a);
               ad.drawAlien(a2, g,a2);
               ad.drawAlien(a3, g,a3);
               ad.drawAlien(a4, g,a4);
               ad.drawAlien(a5, g,a5);
               ad.drawBullet(b, g, b);
               ad.drawBullet(b2, g, b2);
               ad.drawBullet(b3, g, b3);
               ad.drawBullet(b4, g, b4);
               ad.drawBullet(b5, g, b5);
               ad.drawBullet(b6, g, b6);
               ad.drawLine(l, g);
              
            }
                    
        };
     
         jPanel1.setBackground(Color.black);
     //    h = new Human(300, 400);

        // Agregar KeyListener al panel
        jPanel1.setFocusable(true);
 
        jPanel1.requestFocusInWindow(); // Asegurar que el panel tenga el foco para recibir eventos de teclado
         jPanel1.addKeyListener(new KeyAdapter() {
      // addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_LEFT) {
                    // Mover el objeto alien hacia la izquierda
                   ad.moveLeft(h, jPanel1.getGraphics(),h);
                    ad.moveLeft(b,jPanel1.getGraphics(), b);
                  //  jPanel1.repaint();
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    // Mover el objeto alien hacia la derecha
                      ad.moveRight(h, jPanel1.getGraphics(),h);
                      ad.moveRight(b, jPanel1.getGraphics(),b);
                    //  jPanel1.repaint();
                 }
                else if (keyCode == KeyEvent.VK_SPACE) {
                    // Mover la bala hacia arriba cuando se presione la barra espaciadora
                     timer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
                            ad.moveUp(b, jPanel1.getGraphics(),b); 
                jPanel1.repaint(); // Repintar el panel para mostrar el movimiento
                
                ad.drawInfinitely(h,jPanel1.getGraphics(), h);
                jPanel1.repaint(); // Repintar el panel para mostrar el movimiento
               
            }
        });
        timer.start();
              
        
    }
              
                // Redibujar el panel
                jPanel1.repaint();
            }
                  
            @Override
            public void keyReleased(KeyEvent e) {}
        });

          // Inicializar el temporizador para mover el alien hacia abajo
    
         timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ad.moveDown(a, jPanel1.getGraphics(),a); // Mover el alien hacia abajo
                 ad.moveDown(a2, jPanel1.getGraphics(),a2); 
                  ad.moveDown(a3, jPanel1.getGraphics(),a3); 
                   ad.moveDown(a4, jPanel1.getGraphics(),a4); 
                    ad.moveDown(a5, jPanel1.getGraphics(),a5);
                      ad.moveDown(b2, jPanel1.getGraphics(),b2); 
                       ad.moveDown(b3, jPanel1.getGraphics(),b3); 
                        ad.moveDown(b4, jPanel1.getGraphics(),b4); 
                         ad.moveDown(b5, jPanel1.getGraphics(),b5); 
                           ad.moveDown(b6, jPanel1.getGraphics(),b6); 
                             //ad.moveUp(b, jPanel1.getGraphics(),b); 
                jPanel1.repaint(); // Repintar el panel para mostrar el movimiento
            }
        });
        timer.start();
        
         bulletSelectionTimer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectRandomBullet(); // Método para seleccionar una bala aleatoria
            }
        });
        bulletSelectionTimer.start();
        
          add( jPanel1); // Añadimos el panel al JFrame
      // add(panel1,BorderLayout.NORTH);
      //  add(canvas,BorderLayout.NORTH);
        
        // Establecemos el JFrame como visible
        setVisible(true);
    }
    
   private void selectRandomBullet() {
        int randomIndex = (int) (Math.random() * 6); // Escoger una bala aleatoria
        Bullet bullet;
        switch (randomIndex) {
            case 0:
               ad.Shoot(b2, jPanel1.getGraphics(),b2); 
       
                break;
            case 1:
               ad.Shoot(b3, jPanel1.getGraphics(),b3); 
                break;
            case 2:
                 ad.Shoot(b4, jPanel1.getGraphics(),b4); 
                break;
            case 3:
                 ad.Shoot(b5, jPanel1.getGraphics(),b5); 
                break;
            case 4:
                 ad.Shoot(b6, jPanel1.getGraphics(),b6); 
                break;
           
        }     
}
     
        
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(314, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(270, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 //       adaptador.generar(new Human(), getGraphics());
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ScreenII.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScreenII.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScreenII.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScreenII.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScreenII().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
