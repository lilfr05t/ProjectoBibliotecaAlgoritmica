
package com.biblioteca.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Estudiante implements Serializable {
    
    // 1. DEFINICIÓN DE LA CONSTANTE (MEJORA DE POO)
    private static final int MAX_LIBROS_PERMITIDOS = 3; 
    
    private String codigo; 
    private String nombre;
    private String carrera;
    // Se recomienda inicializar Listas en la declaración o el constructor, no en la firma.
    private final List<Libro> librosPrestados; 

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
    
    // Dejamos el getter defensivo, pero ahora con 'final' en la declaración superior.
    public List<Libro> getLibrosPrestados() { return new ArrayList<>(librosPrestados); } 

    // 2. MÉTODO REQUERIDO: getMaxLibros()
    /**
     * Devuelve el número máximo de libros que un estudiante puede tener prestados.
     * Este método resuelve el error en FrmGestionEstudiantes.
     */
    public int getMaxLibros() {
        return MAX_LIBROS_PERMITIDOS;
    }
    
    // 3. Lógica de negocio (ahora usa la constante)
    public boolean puedePrestar() { 
        return librosPrestados.size() < MAX_LIBROS_PERMITIDOS; // Usando la constante
    }
    
    public void agregarPrestamo(Libro libro) { this.librosPrestados.add(libro); }
    
    public boolean quitarPrestamo(Libro libro) { 
        // Usamos removeIf para quitarlo si el ISBN coincide.
        return this.librosPrestados.removeIf(l -> l.getISBN().equals(libro.getISBN())); 
    }
}
