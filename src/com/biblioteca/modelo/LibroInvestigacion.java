/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.modelo;
/**
 * Subclase concreta de {@link Libro} orientada a obras de investigación científica.
 * Añade atributos específicos como el tema de investigación y el identificador DOI.
 * @see Libro
 */
public class LibroInvestigacion extends Libro {

    private String tema; // Encapsulado
    private String doi; // Encapsulado
    /**
     * Constructor para crear un Libro de Investigación.
     * @param ISBN Identificador único (ISBN).
     * @param titulo Título de la investigación.
     * @param autor Autor principal.
     * @param tema Área o tema principal de la investigación.
     * @param doi Identificador de Objeto Digital (DOI) único para publicaciones científicas.
     */
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
    /**
     * Implementación polimórfica que devuelve los detalles formateados para un libro de investigación.
     * @return Cadena de texto con ISBN, título, autor, tema y DOI.
     */
    @Override
    public String mostrarDetalles() {
        return String.format("Tipo: Inv. | ISBN: %s | Título: %s | Autor: %s | Tema: %s | DOI: %s",
                             getISBN(), getTitulo(), getAutor(), tema, doi);
    }
}
