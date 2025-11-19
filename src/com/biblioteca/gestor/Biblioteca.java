
package com.biblioteca.gestor;

import com.biblioteca.modelo.*;
import com.biblioteca.excepciones.*;
import java.util.function.Predicate;

public class Biblioteca { // Clase Singleton y Fachada

    private static Biblioteca INSTANCIA = null;
    
    public Gestor<Libro> gestorLibros = new Gestor<>("libros.ser");
    public Gestor<Estudiante> gestorEstudiantes = new Gestor<>("estudiantes.ser");

    // -------------------------------------------------------------------
    // PATRÓN SINGLETON
    // -------------------------------------------------------------------
    private Biblioteca() {} // Constructor PRIVADO

    public static Biblioteca getInstance() {
        if (INSTANCIA == null) {
            INSTANCIA = new Biblioteca();
        }
        return INSTANCIA;
    }
    
    public void guardarTodo() throws PersistenciaException {
        gestorLibros.guardar();
        gestorEstudiantes.guardar();
    }
    public void cargarTodo() throws PersistenciaException {
        gestorLibros.cargar();
        gestorEstudiantes.cargar();
    }
    // -------------------------------------------------------------------
    // LÓGICA DE NEGOCIO (Transacciones)
    // -------------------------------------------------------------------

    public void realizarPrestamo(String codigoEstudiante, String ISBN) 
            throws RecursoNoEncontradoException, LimitePrestamosExcedidoException, PersistenciaException {
        
        // 1. Buscar Estudiante y Libro (Uso de Genéricos)
        Predicate<Estudiante> pEstudiante = e -> e.getCodigo().equals(codigoEstudiante);
        Estudiante estudiante = gestorEstudiantes.buscarPorIdentificador(pEstudiante);
        
        Predicate<Libro> pLibro = l -> l.getISBN().equals(ISBN);
        Libro libro = gestorLibros.buscarPorIdentificador(pLibro);
        
        if (estudiante == null) throw new RecursoNoEncontradoException("Estudiante", codigoEstudiante);
        if (libro == null || !libro.isDisponible()) throw new RecursoNoEncontradoException("Libro o no disponible", ISBN);
        
        // 2. Aplicar Restricción (Excepción Definida por el Usuario)
        if (!estudiante.puedePrestar()) throw new LimitePrestamosExcedidoException(codigoEstudiante);
        
        // 3. Realizar Transacción y Persistir
        libro.setDisponible(false);
        estudiante.agregarPrestamo(libro);
        guardarTodo();
    }

    public void realizarDevolucion(String codigoEstudiante, String ISBN) 
            throws RecursoNoEncontradoException, PersistenciaException {
        
        Predicate<Estudiante> pEstudiante = e -> e.getCodigo().equals(codigoEstudiante);
        Estudiante estudiante = gestorEstudiantes.buscarPorIdentificador(pEstudiante);
        
        Predicate<Libro> pLibro = l -> l.getISBN().equals(ISBN);
        Libro libro = gestorLibros.buscarPorIdentificador(pLibro);
        
        if (estudiante == null) throw new RecursoNoEncontradoException("Estudiante", codigoEstudiante);
        if (libro == null) throw new RecursoNoEncontradoException("Libro", ISBN);
        
        // 3. Procesar Devolución (Uso de Relación de Asociación)
        if (estudiante.quitarPrestamo(libro)) {
            libro.setDisponible(true);
        } else {
             throw new RecursoNoEncontradoException("Préstamo activo", "El estudiante no tiene el libro " + ISBN);
        }
        
        guardarTodo();
    }
    
    // -------------------------------------------------------------------
    // MÉTODO POLIMÓRFICO
    // -------------------------------------------------------------------
    public String generarReporteDetalladoLibros() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- REPORTE DE INVENTARIO ---\n");
        for (Libro libro : gestorLibros.listarTodo()) {
            sb.append(libro.mostrarDetalles()).append(" | Estado: ").append(libro.isDisponible() ? "Disponible" : "Prestado").append("\n"); // POLIMORFISMO
        }
        return sb.toString();
    }
}
