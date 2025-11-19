package com.biblioteca.gestor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import com.biblioteca.excepciones.PersistenciaException;
import java.util.function.Predicate;

public class Gestor<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = 1L; 
    private List<T> listaObjetos;
    private final String nombreArchivo;

    public Gestor(String nombreArchivo) {
        this.listaObjetos = new ArrayList<>();
        this.nombreArchivo = nombreArchivo;
    }
    
    // Métodos CRUD básicos
    public void agregar(T objeto) throws PersistenciaException {
        this.listaObjetos.add(objeto);
        guardar(); 
    }
    
    public void eliminar(T objeto) throws PersistenciaException {
        // Asume que el objeto implementa correctamente hashCode/equals o usa predicado
        this.listaObjetos.remove(objeto);
        guardar();
    }
    
    public List<T> listarTodo() {
        return new ArrayList<>(listaObjetos);
    }

    public T buscarPorIdentificador(Predicate<T> predicado) {
        for (T objeto : listaObjetos) {
            if (predicado.test(objeto)) {
                return objeto;
            }
        }
        return null;
    }

    // MÉTODO DE PERSISTENCIA 1: GUARDAR (SERIALIZACIÓN)
    public void guardar() throws PersistenciaException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(nombreArchivo))) {
            oos.writeObject(this.listaObjetos); 
        } catch (IOException e) {
            throw new PersistenciaException("Fallo al guardar los datos en " + nombreArchivo, e);
        }
    }

    // MÉTODO DE PERSISTENCIA 2: CARGAR (DESERIALIZACIÓN)
        public void cargar() throws PersistenciaException {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(nombreArchivo))) {

            @SuppressWarnings("unchecked") 
            List<T> listaCargada = (List<T>) ois.readObject();
            this.listaObjetos = listaCargada;

        } catch (FileNotFoundException e) {
            // Opción segura: Si el archivo no existe (primera ejecución), simplemente 
            // dejamos la listaObjetos como un ArrayList vacío y salimos sin error.
            this.listaObjetos = new ArrayList<>(); 

        } catch (IOException | ClassNotFoundException e) {
            // Cualquier otro error crítico de lectura/clase, se envuelve y se lanza
            // para ser manejado en la clase Biblioteca.
            throw new PersistenciaException("Error al leer los datos de " + nombreArchivo, e);
        }
    }
}