/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.excepciones;

public class LimitePrestamosExcedidoException extends Exception {
    public LimitePrestamosExcedidoException(String codigoEstudiante) {
        super("El estudiante con código " + codigoEstudiante + " ha excedido el límite de préstamos.");
    }
}
