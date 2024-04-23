/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inv_dependencia;

/**
 *
 * @author USUARIO
 */
public class Generador {
    
    protected Implementar imp;
    
    public Generador (Implementar i){
    this.imp = i;
    }
    
   public void generar(){
   imp.implementar();
   }
}
