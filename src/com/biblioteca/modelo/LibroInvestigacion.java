/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.modelo;

public class LibroInvestigacion extends Libro {

    private String tema; // Encapsulado
    private String doi; // Encapsulado

    public LibroInvestigacion(String ISBN, String titulo, String autor, String tema, String doi) {
        super(ISBN, titulo, autor);
        this.tema = tema;
        this.doi = doi;
    }

    // Getters y Setters
    public String getTema() { return tema; }
    public void setTema(String tema) { this.tema = tema; }
    public String getDoi() { return doi; }
    public void setDoi(String doi) { this.doi = doi; }

    // Implementación Polimórfica
    @Override
    public String mostrarDetalles() {
        return String.format("Tipo: Inv. | ISBN: %s | Título: %s | Autor: %s | Tema: %s | DOI: %s",
                             getISBN(), getTitulo(), getAutor(), tema, doi);
    }
}
