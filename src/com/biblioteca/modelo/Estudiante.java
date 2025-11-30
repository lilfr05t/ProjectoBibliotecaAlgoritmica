
package com.biblioteca.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * Representa a un estudiante registrado en el sistema de biblioteca.
 * Contiene información personal y el historial de préstamos activos.
 */
public class Estudiante implements Serializable {
    
    // 1. DEFINICIÓN DE LA CONSTANTE (MEJORA DE POO)
    private static final int MAX_LIBROS_PERMITIDOS = 3; 
    
    private String codigo; 
    private String nombre;
    private String carrera;
    /** Lista de libros que el estudiante tiene actualmente en su posesión. */
    private final List<Libro> librosPrestados; 
    /**
     * Crea un nuevo estudiante.
     * @param codigo Identificador único del estudiante.
     * @param nombre Nombre completo.
     * @param carrera Carrera que cursa.
     */
    public Estudiante(String codigo, String nombre, String carrera) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.carrera = carrera;
        this.librosPrestados = new ArrayList<>(); // Inicialización aquí
    }

    // Getters y Setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }
    
    /**
     * Obtiene una copia de la lista de libros prestados para proteger la encapsulación.
     * @return Una nueva lista conteniendo los libros prestados.
     */
    public List<Libro> getLibrosPrestados() { return new ArrayList<>(librosPrestados); } 

    // 2. MÉTODO REQUERIDO: getMaxLibros()
    /**
     * Devuelve el número máximo de libros que un estudiante puede tener prestados.
     * Este método resuelve el error en FrmGestionEstudiantes.
     */
    public int getMaxLibros() {
        return MAX_LIBROS_PERMITIDOS;
    }
    /**
     * Verifica si el estudiante puede solicitar un nuevo préstamo basándose en
     * el límite definido en {@link #MAX_LIBROS_PERMITIDOS}.
     * * @return true si tiene menos libros del límite, false en caso contrario.
     */
    public boolean puedePrestar() { 
        return librosPrestados.size() < MAX_LIBROS_PERMITIDOS; // Usando la constante
    }
    /**
     * Agrega un libro a la lista de préstamos del estudiante.
     * @param libro El objeto Libro a prestar.
     */
    public void agregarPrestamo(Libro libro) { this.librosPrestados.add(libro); }
    /**
     * Elimina un libro de la lista de préstamos (Devolución).
     * @param libro El libro a devolver.
     * @return true si el libro fue encontrado y removido, false si no lo tenía.
     */
    public boolean quitarPrestamo(Libro libro) { 
        // Usamos removeIf para quitarlo si el ISBN coincide.
        return this.librosPrestados.removeIf(l -> l.getISBN().equals(libro.getISBN())); 
    }
}
