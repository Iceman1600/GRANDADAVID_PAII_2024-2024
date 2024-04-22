/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pall_001;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/**
 *
 * @author USUARIO
 */

public abstract class Funciones {
    private static final int BYTEFLOAT = 4;
    public static FloatBuffer setFloatBuffer (float [] array){

    FloatBuffer fb;
        ByteBuffer buffer = ByteBuffer.allocateDirect(array.length*BYTEFLOAT);
        buffer.order(ByteOrder.nativeOrder());
        fb = buffer.asFloatBuffer();
        fb.put(array);
        fb.position(0);
    return fb;

        };
    public static ByteBuffer setByteBuffer(byte [] vertices){

        ByteBuffer buffer = ByteBuffer.allocateDirect(vertices.length);
        buffer.order(ByteOrder.nativeOrder());
        buffer.put(vertices);
        buffer.position(0);

        return buffer;
    };


}

