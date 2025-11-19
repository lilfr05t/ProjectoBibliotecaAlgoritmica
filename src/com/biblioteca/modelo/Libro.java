/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.modelo;

import java.io.Serializable;

public abstract class Libro implements Prestable {

    private String ISBN; // Encapsulado
    private String titulo;
    private String autor;
    private boolean disponible = true;
    
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
    
    // Método Abstracto para Polimorfismo
    public abstract String mostrarDetalles(); 
}
