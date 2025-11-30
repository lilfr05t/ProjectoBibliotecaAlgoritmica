/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.modelo;
/**
 * Subclase concreta de {@link Libro} que representa un libro de texto educativo.
 * Se especializa añadiendo información sobre la facultad a la que pertenece y su número de edición.
 * <p>
 * Esta clase es un ejemplo de herencia y especialización en el modelo de objetos.
 * </p>
 * @see Libro
 */
public class LibroTexto extends Libro {

    private String facultad; // Encapsulado
    private int edicion; // Encapsulado
    /**
     * Crea una nueva instancia de un Libro de Texto.
     * @param ISBN Identificador único del libro.
     * @param titulo Título de la obra.
     * @param autor Autor del libro.
     * @param facultad Facultad o departamento académico asociado al libro.
     * @param edicion Número de edición del libro.
     */
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
    /**
     * Implementación específica para mostrar los detalles de un libro de texto.
     * Incluye la facultad y la edición en la cadena resultante.
     * @return Cadena formateada con los datos del libro de texto.
     */
    @Override
    public String mostrarDetalles() {
        return String.format("Tipo: Texto | ISBN: %s | Título: %s | Autor: %s | Facultad: %s | Edición: %d",
                             getISBN(), getTitulo(), getAutor(), facultad, edicion);
    }
}