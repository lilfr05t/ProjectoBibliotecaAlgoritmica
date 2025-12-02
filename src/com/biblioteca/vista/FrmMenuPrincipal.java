
package com.biblioteca.vista;
import com.biblioteca.gestor.Biblioteca;
import javax.swing.JOptionPane;
import com.biblioteca.excepciones.PersistenciaException;
/**
 * Ventana principal de la aplicación que sirve como menú de navegación.
 * Permite al usuario acceder a los diferentes módulos del sistema:
 * gestión de libros, gestión de estudiantes y operaciones de préstamo/devolución.
 * <p>
 * También gestiona el cierre seguro de la aplicación, asegurando que los datos
 * se guarden antes de salir.
 * </p>
 * @author JeremyL
 * @version 1.0
 */
public class FrmMenuPrincipal extends javax.swing.JFrame {
    
    private final Biblioteca biblioteca = Biblioteca.getInstance();
    /**
     * Constructor que inicializa los componentes gráficos y centra la ventana.
     */
    public FrmMenuPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnGestionLibros = new javax.swing.JButton();
        btnGestionEstudiantes = new javax.swing.JButton();
        btnPrestamos = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú Principal");

        jLabel1.setText("Sistema de Gestión de Biblioteca");

        btnGestionLibros.setText("Gestión de Libros");
        btnGestionLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionLibrosActionPerformed(evt);
            }
        });

        btnGestionEstudiantes.setText("Gestión de Estudiantes");
        btnGestionEstudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionEstudiantesActionPerformed(evt);
            }
        });

        btnPrestamos.setText("Préstamos y Devoluciones");
        btnPrestamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrestamosActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(47, 47, 47))
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGestionEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnGestionLibros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPrestamos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(122, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGestionLibros)
                .addGap(18, 18, 18)
                .addComponent(btnPrestamos)
                .addGap(18, 18, 18)
                .addComponent(btnGestionEstudiantes)
                .addGap(48, 48, 48)
                .addComponent(btnSalir)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGestionLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionLibrosActionPerformed
        // Abre el formulario de gestión de libros
        new FrmGestionLibros().setVisible(true);
        this.dispose(); // Cierra esta ventana
    }//GEN-LAST:event_btnGestionLibrosActionPerformed

    private void btnGestionEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionEstudiantesActionPerformed
        // Abre el formulario de gestión de estudiantes
        new FrmGestionEstudiantes().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnGestionEstudiantesActionPerformed

    private void btnPrestamosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrestamosActionPerformed
        // Abre el formulario de préstamos
        new FrmPrestamosDevolucion().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnPrestamosActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // Llama al Singleton para guardar todos los datos antes de salir
        try {
            // Llama al método de persistencia de la Fachada (Biblioteca)
            biblioteca.guardarTodo(); 
            JOptionPane.showMessageDialog(this, "Datos guardados. Saliendo del sistema.", "Cierre Exitoso", JOptionPane.INFORMATION_MESSAGE);
        } catch (PersistenciaException e) {
            // Manejo de la Excepción Personalizada
            JOptionPane.showMessageDialog(this, "Error al guardar los datos: " + e.getMessage(), "Error Crítico", JOptionPane.ERROR_MESSAGE);
        } finally {
            System.exit(0); // Cierra la aplicación Java de forma segura
        }
    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGestionEstudiantes;
    private javax.swing.JButton btnGestionLibros;
    private javax.swing.JButton btnPrestamos;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
