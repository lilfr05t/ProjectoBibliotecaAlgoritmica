
package proyectobibliotecaalgoritmicaii;
import com.biblioteca.gestor.Biblioteca;
import com.biblioteca.vista.FrmMenuPrincipal;
import javax.swing.JOptionPane;
import com.biblioteca.excepciones.PersistenciaException; // Importa tu excepción
/**
 * Clase principal que contiene el punto de entrada (main) de la aplicación.
 * <p>
 * Su responsabilidad es orquestar el inicio del sistema, asegurando que los datos
 * previos se carguen correctamente antes de mostrar la interfaz gráfica al usuario.
 * </p>
 * @author JeremyL, EnzoL
 * @version 1.0
 */
public class ProyectoBibliotecaAlgoritmicaII {
    /**
     * Método principal que inicia la ejecución del programa.
     * <p>
     * El flujo de inicialización es el siguiente:
     * <ol>
     * <li>Intenta cargar los datos persistidos (libros y estudiantes) invocando a {@link Biblioteca#cargarTodo()}.</li>
     * <li>Si la carga falla (ej. archivos no existen o corruptos), captura la {@link PersistenciaException},
     * notifica al usuario mediante un diálogo, e inicia el sistema con datos vacíos.</li>
     * <li>Finalmente, lanza la ventana principal {@link FrmMenuPrincipal} dentro del hilo de eventos de Swing (EDT).</li>
     * </ol>
     * @param args Argumentos de la línea de comandos (no utilizados en esta versión).
     */
    public static void main(String[] args) {
        
        // 1. CARGA DE DATOS PERSISTENTES (INIT)
        try {
            // Llama al Singleton y carga todos los gestores (libros, estudiantes, préstamos)
            Biblioteca.getInstance().cargarTodo();
            System.out.println("Datos de persistencia cargados exitosamente.");
            
        } catch (PersistenciaException e) {
            // Manejo de error si los archivos .ser no existen o están corruptos
            JOptionPane.showMessageDialog(null, 
                "Error al cargar los datos guardados: " + e.getMessage() + 
                "\nLa aplicación iniciará con datos vacíos.", 
                "Advertencia de Inicialización", JOptionPane.WARNING_MESSAGE);
        }
        
        // 2. EJECUCIÓN DE LA INTERFAZ GRÁFICA (EDT)
        try {
        // Opción clara (reemplazar por la linea de abajo): new com.formdev.flatlaf.FlatIntelliJLaf().setup(); 
            javax.swing.UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatDarkLaf());
        } catch(Exception ex) {
            System.err.println("No se pudo cargar el tema oscuro. Se usará el por defecto.");
        }   
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Muestra la ventana principal
                new FrmMenuPrincipal().setVisible(true);
            }
        });
        
    
    }
    
}
