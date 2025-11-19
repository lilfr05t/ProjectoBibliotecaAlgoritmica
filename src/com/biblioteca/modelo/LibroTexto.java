/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.modelo;

public class LibroTexto extends Libro {

    private String facultad; // Encapsulado
    private int edicion; // Encapsulado

    public LibroTexto(String ISBN, String titulo, String autor, String facultad, int edicion) {
        super(ISBN, titulo, autor);
        this.facultad = facultad;
        this.edicion = edicion;
    }

    // Getters y Setters
    public String getFacultad() { return facultad; }
    public void setFacultad(String facultad) { this.facultad = facultad; }
    public int getEdicion() { return edicion; }
    public void setEdicion(int edicion) { this.edicion = edicion; }

    // Implementación Polimórfica
    @Override
    public String mostrarDetalles() {
        return String.format("Tipo: Texto | ISBN: %s | Título: %s | Autor: %s | Facultad: %s | Edición: %d",
                             getISBN(), getTitulo(), getAutor(), facultad, edicion);
    }
}