/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.excepciones;
/**
 * Excepción técnica que envuelve errores relacionados con la entrada/salida de datos
 * y la serialización de objetos.
 * <p>
 * Su objetivo es desacoplar la capa de negocio de los errores específicos del sistema
 * de archivos (como {@link java.io.IOException}), permitiendo un manejo de errores más limpio.
 * </p>
 * @author TuNombre
 * @version 1.0
 */
public class PersistenciaException extends Exception {
    /**
     * Constructor que permite encadenar excepciones.
     * @param mensaje Mensaje descriptivo del error de persistencia.
     * @param causa La excepción original (ej. IOException) que causó el fallo.
     */
    public PersistenciaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
