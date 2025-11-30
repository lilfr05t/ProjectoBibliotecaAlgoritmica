/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.biblioteca.modelo;
import java.io.Serializable;
/**
 * Define el comportamiento básico de cualquier elemento de la biblioteca
 * que pueda ser prestado a un usuario.
 * <p>
 * Extiende {@link Serializable} para permitir que los objetos que la implementen
 * puedan ser persistidos en archivos binarios.
 * </p>
 * * @author JeremyL
 * @version 1.0
 */
public interface Prestable extends Serializable {
    /**
     * Verifica si el recurso se encuentra disponible para préstamo.
     * @return true si está disponible, false si está prestado.
     */
    boolean isDisponible();
    /**
     * Cambia el estado de disponibilidad del recurso.
     * @param disponible true para liberarlo, false para marcarlo como prestado.
     */
    void setDisponible(boolean disponible);
    /**
     * Obtiene el título del recurso.
     * @return El título del recurso.
     */
    String getTitulo();
    /**
     * Obtiene el identificador único (ISBN) del recurso.
     * @return El ISBN como cadena de texto.
     */
    String getISBN();
}
