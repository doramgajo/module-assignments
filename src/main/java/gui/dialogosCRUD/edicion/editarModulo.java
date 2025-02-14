package gui.dialogosCRUD.edicion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import objetos.Modulo;


public class editarModulo extends javax.swing.JDialog {
    
    Modulo moduloviejo;

    /**
     * Creates new form crearTurno
     */
    public editarModulo(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
    }
    
    public editarModulo(java.awt.Frame parent, boolean modal, Modulo moduloviejo) throws SQLException {
        super(parent, modal);
        initComponents();
        
        this.moduloviejo = moduloviejo;
        
        spinnerHorasReales.setValue(moduloviejo.getHorasReales());
        spinnerHorasPonderadas.setValue(moduloviejo.getHorasPonderadas());
        campoCodigo.setText(moduloviejo.getCodigo());
        campoDescripcion.setText(moduloviejo.getDescripcion());
        
        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getESPECIALIDADES_CONCATENADAS());
        ResultSet rs = st.executeQuery();
        ArrayList<String> listaEspes = new ArrayList();

        while (rs.next()) {
            listaEspes.add(rs.getString(1));
        }
        System.out.println(moduloviejo.getIdEspecialidad());
        comboEspecialidad.setModel(new DefaultComboBoxModel(listaEspes.toArray()));
        for (int i = 0; i < listaEspes.size(); i++) {
            System.out.println(i + ": lista: " + listaEspes.get(i).substring(0, listaEspes.get(i).indexOf(".")));
            System.out.println(i + ": moduloviejo: " + moduloviejo.getIdEspecialidad());
            if (listaEspes.get(i).substring(0, listaEspes.get(i).indexOf(".")).equals(String.valueOf(moduloviejo.getIdEspecialidad()))) {
                comboEspecialidad.setSelectedIndex(i);
                System.out.println("coincide");
            } else {
                System.out.println("no coincide");
            }
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        campoCodigo = new javax.swing.JTextField();
        botonCrear = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboEspecialidad = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        campoDescripcion = new javax.swing.JTextField();
        spinnerHorasReales = new javax.swing.JSpinner();
        spinnerHorasPonderadas = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edición de módulos");
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Código:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 10, 20);
        getContentPane().add(jLabel1, gridBagConstraints);

        campoCodigo.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 10, 20);
        getContentPane().add(campoCodigo, gridBagConstraints);

        botonCrear.setText("Editar módulo");
        botonCrear.setPreferredSize(new java.awt.Dimension(150, 30));
        botonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 20, 20);
        getContentPane().add(botonCrear, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Descripción:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        getContentPane().add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Especialidad:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        getContentPane().add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Horas reales:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        getContentPane().add(jLabel4, gridBagConstraints);

        comboEspecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "leer ciclos" }));
        comboEspecialidad.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        getContentPane().add(comboEspecialidad, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Horas ponderadas:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        getContentPane().add(jLabel5, gridBagConstraints);

        campoDescripcion.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        getContentPane().add(campoDescripcion, gridBagConstraints);

        spinnerHorasReales.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        getContentPane().add(spinnerHorasReales, gridBagConstraints);

        spinnerHorasPonderadas.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        getContentPane().add(spinnerHorasPonderadas, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearActionPerformed
        if (campoCodigo.getText().isBlank() || campoDescripcion.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacíos.");
        } else {
            try {
                crud.ModulosCRUD.actualizar(new objetos.Modulo(campoCodigo.getText(), campoDescripcion.getText(), Integer.parseInt(spinnerHorasReales.getValue().toString()), Integer.parseInt(spinnerHorasPonderadas.getValue().toString()), Integer.parseInt(comboEspecialidad.getSelectedItem().toString().substring(0, comboEspecialidad.getSelectedItem().toString().indexOf(".")))), moduloviejo.getCodigo());
                dispose();
                logica.LogicaTablas.actualizarTablasBaseDeDatos();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_botonCrearActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(editarModulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editarModulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editarModulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editarModulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    editarModulo dialog = new editarModulo(new javax.swing.JFrame(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(editarModulo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCrear;
    private javax.swing.JTextField campoCodigo;
    private javax.swing.JTextField campoDescripcion;
    private javax.swing.JComboBox<String> comboEspecialidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSpinner spinnerHorasPonderadas;
    private javax.swing.JSpinner spinnerHorasReales;
    // End of variables declaration//GEN-END:variables
}
