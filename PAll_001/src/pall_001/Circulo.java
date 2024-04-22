/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pall_001;

import java.nio.FloatBuffer;

/**
 *
 * @author USUARIO
 */
public class Circulo {
    

    private static final int compPorVertice = 2;
    private static final int compPorColor = 4;
    private FloatBuffer bufferVertices;
    private FloatBuffer bufferColores;
    private float radio = 1.0f;
    private int numSegmentos = 36;
    private float[] vertices;
    private float[] color;
    public Circulo(float[] color) {
        this.color=color;
        calcularVertices();


       /* float[] colores = new float[(numSegmentos + 2) * compPorColor];

        // Configurar el color dorado para todos los vértices
        for (int i = 0; i < colores.length; i += compPorColor) {
            colores[i] = 1.0f;   // Componente rojo
            colores[i + 1] = 0.84f;  // Componente verde
            colores[i + 2] = 0.0f;   // Componente azul
            colores[i + 3] = 1.0f;   // Componente alpha

        };*/

        bufferVertices = Funciones.setFloatBuffer(vertices);

     //   bufferColores =  funciones.setFloatBuffer(colores);
    }


    private void calcularVertices() {
        vertices = new float[(numSegmentos + 2) * 2]; // +2 para incluir el centro del círculo

        // Coordenadas del centro del círculo
        vertices[0] = 0.0f;
        vertices[1] = 0.0f;

        float angulo;
        int indice = 2;

        // Calcular las coordenadas de los vértices del círculo
        for (int i = 0; i <= numSegmentos; i++) {
            angulo = (float) (2* Math.PI * i / numSegmentos);
            vertices[indice++] = radio * (float) Math.cos(angulo);
            vertices[indice++] = radio * (float) Math.sin(angulo);
        }
    }

    public void dibujar(GLAutoDrawable drawable) {
        gl.glFrontFace(GL10.GL_CW);

        bufferVertices.position(0);
        gl.glVertexPointer(compPorVertice, GL10.GL_FLOAT, 0, bufferVertices);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glColor4f(color[0],color[1],color[2],color[3]);

       /* bufferColores.position(0);
        gl.glColorPointer(compPorColor, GL10.GL_FLOAT, 0, bufferColores);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);*/

        gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 0, numSegmentos + 2);

        gl.glFrontFace(GL10.GL_CCW);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
    }
}
    
}
