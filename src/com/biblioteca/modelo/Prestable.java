/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.biblioteca.modelo;
import java.io.Serializable;

public interface Prestable extends Serializable {
    boolean isDisponible();
    void setDisponible(boolean disponible);
    String getTitulo();
    String getISBN();
}
