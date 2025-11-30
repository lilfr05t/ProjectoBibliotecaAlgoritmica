
package com.biblioteca.gestor;

import com.biblioteca.modelo.*;
import com.biblioteca.excepciones.*;
import java.util.function.Predicate;
/**
 * Clase principal que actúa como Fachada (Facade) del sistema y utiliza el patrón Singleton.
 * Centraliza la lógica de negocio y coordina los gestores de Libros y Estudiantes.
 * <p>
 * Esta clase es el único punto de acceso para realizar transacciones complejas
 * como préstamos y devoluciones.
 * </p>
 */
public class Biblioteca { // Clase Singleton y Fachada

    private static Biblioteca INSTANCIA = null;
    /** Gestor encargado de la persistencia y manejo de libros. */
    public Gestor<Libro> gestorLibros = new Gestor<>("libros.ser");
    /** Gestor encargado de la persistencia y manejo de estudiantes. */
    public Gestor<Estudiante> gestorEstudiantes = new Gestor<>("estudiantes.ser");

    // -------------------------------------------------------------------
    // PATRÓN SINGLETON
    // -------------------------------------------------------------------
    /** Constructor privado para evitar instanciación directa (Patrón Singleton). */
    private Biblioteca() {} 
    /**
     * Obtiene la instancia única de la clase Biblioteca.
     * Si no existe, la crea; si ya existe, devuelve la misma.
     * @return La instancia única de Biblioteca.
     */
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
    
    // LÓGICA DE NEGOCIO (Transacciones)
    
    /**
     * Realiza la transacción de préstamo de un libro a un estudiante.
     * Valida la existencia de ambos, la disponibilidad del libro y el límite de préstamos del estudiante.
     * * @param codigoEstudiante Identificador del estudiante.
     * @param ISBN Identificador del libro.
     * @throws RecursoNoEncontradoException Si el estudiante o el libro no existen, o el libro no está disponible.
     * @throws LimitePrestamosExcedidoException Si el estudiante ya tiene el máximo de libros permitidos.
     * @throws PersistenciaException Si ocurre un error al guardar los cambios.
     */
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
    /**
     * Realiza la transacción de devolución de un libro.
     * Actualiza el estado del libro a disponible y lo remueve de la lista del estudiante.
     * * @param codigoEstudiante Identificador del estudiante.
     * @param ISBN Identificador del libro a devolver.
     * @throws RecursoNoEncontradoException Si el estudiante no existe o no tiene ese libro prestado.
     * @throws PersistenciaException Si ocurre un error al guardar los cambios.
     */
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
    
    
    // MÉTODO POLIMÓRFICO
    /**
     * Genera un reporte de todos los libros utilizando polimorfismo para mostrar sus detalles.
     * @return Un String con el listado completo de libros y su estado.
     */
    public String generarReporteDetalladoLibros() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- REPORTE DE INVENTARIO ---\n");
        for (Libro libro : gestorLibros.listarTodo()) {
            sb.append(libro.mostrarDetalles()).append(" | Estado: ").append(libro.isDisponible() ? "Disponible" : "Prestado").append("\n"); // POLIMORFISMO
        }
        return sb.toString();
    }
}
