
package com.biblioteca.excepciones;

public class RecursoNoEncontradoException extends Exception {
    // Constructor 1: Para cuando tienes el recurso y el identificador (usado en Biblioteca)
    public RecursoNoEncontradoException(String tipoRecurso, String identificador) {
        super(tipoRecurso + " con identificador " + identificador + " no encontrado.");
    }
    
    // Constructor 2: Para mensajes genéricos (¡NUEVO, y soluciona el error en FrmPrestamoDevolucion!)
    // Este permite que la clase se instancie con un solo String (el mensaje de error)
    public RecursoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
