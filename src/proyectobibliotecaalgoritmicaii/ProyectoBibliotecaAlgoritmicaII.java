
package proyectobibliotecaalgoritmicaii;
import com.biblioteca.gestor.Biblioteca;
import com.biblioteca.vista.FrmMenuPrincipal;
import javax.swing.JOptionPane;
import com.biblioteca.excepciones.PersistenciaException; // Importa tu excepción

public class ProyectoBibliotecaAlgoritmicaII {
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
        // Esto asegura que la GUI se lance correctamente en el hilo de eventos de Swing.
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Muestra la ventana principal
                new FrmMenuPrincipal().setVisible(true);
            }
        });
    }
    
}
