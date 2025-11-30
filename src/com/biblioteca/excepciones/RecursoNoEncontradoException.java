
package com.biblioteca.excepciones;
/**
 * Excepción personalizada que se lanza cuando se intenta acceder a un elemento
 * (Libro o Estudiante) que no existe en el sistema o no está disponible.
 * <p>
 * Se utiliza para validar la existencia de recursos antes de realizar operaciones
 * críticas como préstamos o devoluciones.
 * </p>
 * @author TuNombre
 * @version 1.0
 */
public class RecursoNoEncontradoException extends Exception {
    /**
     * Constructor detallado para cuando se conoce el tipo de recurso y su ID.
     * @param tipoRecurso El nombre del recurso buscado (ej. "Libro", "Estudiante").
     * @param identificador El código o ISBN que no se encontró.
     */
    public RecursoNoEncontradoException(String tipoRecurso, String identificador) {
        super(tipoRecurso + " con identificador " + identificador + " no encontrado.");
    }
    
    /**
     * Constructor genérico para mensajes personalizados.
     * Útil cuando el error no depende solo de un ID, sino de un estado (ej. "Libro no disponible").
     * @param mensaje Descripción detallada del error.
     */
    // Este permite que la clase se instancie con un solo String (el mensaje de error)
    public RecursoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
