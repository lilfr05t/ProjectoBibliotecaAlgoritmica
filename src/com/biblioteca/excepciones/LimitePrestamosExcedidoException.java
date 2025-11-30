/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.excepciones;
/**
 * Excepción de regla de negocio que se lanza cuando un estudiante intenta solicitar
 * un préstamo pero ya ha alcanzado el número máximo de libros permitidos.
 * <p>
 * Ayuda a mantener la integridad de las reglas de préstamo de la biblioteca.
 * </p>
 * @see com.biblioteca.modelo.Estudiante#getMaxLibros()
 * @author TuNombre
 * @version 1.0
 */
public class LimitePrestamosExcedidoException extends Exception {
    /**
     * Crea una nueva instancia de la excepción con un mensaje predefinido.
     * @param codigoEstudiante El código del estudiante que infringió la regla.
     */
    public LimitePrestamosExcedidoException(String codigoEstudiante) {
        super("El estudiante con código " + codigoEstudiante + " ha excedido el límite de préstamos.");
    }
}
