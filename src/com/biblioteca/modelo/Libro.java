/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.modelo;

import java.io.Serializable;
/**
 * Clase abstracta que representa un libro genérico en la biblioteca.
 * Implementa la interfaz {@link Prestable} y sirve como base para tipos específicos
 * de libros (Texto, Investigación).
 * * @see LibroTexto
 * @see LibroInvestigacion
 */
public abstract class Libro implements Prestable {

    private String ISBN; // Encapsulado
    private String titulo;
    private String autor;
    private boolean disponible = true;
    /**
     * Constructor principal para inicializar un libro.
     * @param ISBN Identificador único del libro.
     * @param titulo Título de la obra.
     * @param autor Autor principal de la obra.
     */
    public Libro(String ISBN, String titulo, String autor) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
    }

    // Métodos de la Interface Prestable / Getters y Setters
    @Override
    public boolean isDisponible() { return disponible; }
    @Override
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
    @Override
    public String getTitulo() { return titulo; }
    @Override
    public String getISBN() { return ISBN; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    
    /**
     * Método abstracto que obliga a las subclases a definir cómo muestran su información.
     * Esto es un ejemplo de polimorfismo en el sistema.
     * * @return Una cadena con los detalles formateados del libro.
     * @return 
     */
    public abstract String mostrarDetalles(); 
}
