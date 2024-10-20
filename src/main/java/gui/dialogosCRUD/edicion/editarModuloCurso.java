package gui.dialogosCRUD.edicion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import objetos.ModuloCurso;


public class editarModuloCurso extends javax.swing.JDialog {
    
    ModuloCurso modcur;

    /**
     * Creates new form crearTurno
     */
    public editarModuloCurso(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
    }
    
    public editarModuloCurso(java.awt.Frame parent, boolean modal, ModuloCurso modcur) throws SQLException {
        super(parent, modal);
        initComponents();
        
        this.modcur = modcur;

        PreparedStatement st = logica.LogicaConexion.getConexion().prepareStatement(sql.Sentencias.getSELECCIONAR_CURSOS());
        ResultSet rs = st.executeQuery();
        ArrayList<String> listaCursos = new ArrayList();

        while (rs.next()) {
            listaCursos.add(rs.getString(1));
        }

        comboCursos.setModel(new DefaultComboBoxModel(listaCursos.toArray()));

        st = logica.LogicaConexion.getConexion().prepareStatement(sql.Sentencias.getSELECCIONAR_MODULOS());
        rs = st.executeQuery();
        ArrayList<String> listaModus = new ArrayList();

        while (rs.next()) {
            listaModus.add(rs.getString(1));
        }

        comboModulos.setModel(new DefaultComboBoxModel(listaModus.toArray()));
        
        
        for (int i = 0; i < listaCursos.size(); i++) {
            if (listaCursos.get(i).equals(modcur.getCodigoCurso())) {
                comboCursos.setSelectedIndex(i);
            } 
        }
        
        for (int i = 0; i < listaModus.size(); i++) {
            if (listaModus.get(i).equals(modcur.getCodigoModulo())) {
                comboModulos.setSelectedIndex(i);
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
        botonCrear = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        comboModulos = new javax.swing.JComboBox<>();
        comboCursos = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edición de módulos-cursos");
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Módulo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 10, 20);
        getContentPane().add(jLabel1, gridBagConstraints);

        botonCrear.setText("Editar módulo-curso");
        botonCrear.setPreferredSize(new java.awt.Dimension(150, 30));
        botonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 20, 20);
        getContentPane().add(botonCrear, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Curso:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        getContentPane().add(jLabel2, gridBagConstraints);

        comboModulos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "leer ciclos" }));
        comboModulos.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        getContentPane().add(comboModulos, gridBagConstraints);

        comboCursos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "leer ciclos" }));
        comboCursos.setPreferredSize(new java.awt.Dimension(150, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        getContentPane().add(comboCursos, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearActionPerformed
        try {
            ModuloCurso modcur = new objetos.ModuloCurso(this.modcur.getIdModuloCurso(), comboModulos.getSelectedItem().toString(), comboCursos.getSelectedItem().toString());
            System.out.println("MMMMMM: " + modcur.toString());
            crud.ModulosCursosCRUD.actualizar(modcur, String.valueOf(modcur.getIdModuloCurso()));
            dispose();
            logica.LogicaTablas.actualizarTablasBaseDeDatos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
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
            java.util.logging.Logger.getLogger(editarModuloCurso.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editarModuloCurso.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editarModuloCurso.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editarModuloCurso.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                    editarModuloCurso dialog = new editarModuloCurso(new javax.swing.JFrame(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);

} catch (SQLException ex) {
                    Logger.getLogger(editarModuloCurso.class  

.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCrear;
    private javax.swing.JComboBox<String> comboCursos;
    private javax.swing.JComboBox<String> comboModulos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
