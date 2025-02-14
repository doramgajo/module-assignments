package gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;


public class Asignacion extends javax.swing.JFrame {

    MenuAsignaciones parent;

    /**
     * Creates new form Asignacion
     */
    public Asignacion(MenuAsignaciones menu) throws SQLException {
        initComponents();
        this.parent = menu;
        //Estilo de botones
        this.setExtendedState(MAXIMIZED_BOTH);
        botonAnnadirSelecionados.putClientProperty("JButton.buttonType", "roundRect");
        botonEliminarSeleccionados.putClientProperty("JButton.buttonType", "roundRect");
        botonGuardarAsignaciones.putClientProperty("JButton.buttonType", "roundRect");
        getBotonGuardarAsignaciones().setEnabled(false);
        //Listener para si cerramos la ventana, actualiza estadisticas y hace visible la ventana anterior
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                try {
                    logica.LogicaEstadisticas.actualizarEstadisticas(parent);
                } catch (SQLException ex) {
                    Logger.getLogger(Asignacion.class.getName()).log(Level.SEVERE, null, ex);
                }
                parent.setVisible(true);
            }
        });
    }

    private Asignacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public JTable getTablaElegidos() {
        return tablaElegidos;
    }

    public JTable getTablaManana() {
        return tablaManana;
    }

    public JTable getTablaNoche() {
        return tablaNoche;
    }

    public JTable getTablaTarde() {
        return tablaTarde;
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

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoProfesor = new javax.swing.JLabel();
        campoHorasContratadas = new javax.swing.JLabel();
        campoEspecialidad = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        campoOrden = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaElegidos = new javax.swing.JTable();
        botonAnnadirSelecionados = new javax.swing.JButton();
        botonEliminarSeleccionados = new javax.swing.JButton();
        botonGuardarAsignaciones = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        labelModulosSeleccionados = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        labelHorasPonderadas = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        labelHorasTotales = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaManana = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaTarde = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaNoche = new javax.swing.JTable();

        setIconImage(new ImageIcon("src/main/resources/logo_programa.png").getImage());

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asig_explorar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(jButton1, gridBagConstraints);

        jPanel3.add(jPanel4, java.awt.BorderLayout.EAST);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Profesor:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Horas contratadas:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 29, 3);
        jPanel2.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Especialidad:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(3, 20, 3, 3);
        jPanel2.add(jLabel3, gridBagConstraints);

        campoProfesor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoProfesor.setText("Aaa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 13);
        jPanel2.add(campoProfesor, gridBagConstraints);

        campoHorasContratadas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoHorasContratadas.setText("23");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 29, 13);
        jPanel2.add(campoHorasContratadas, gridBagConstraints);

        campoEspecialidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoEspecialidad.setText("Aaaa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(campoEspecialidad, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Nº Orden:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(3, 20, 29, 3);
        jPanel2.add(jLabel9, gridBagConstraints);

        campoOrden.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoOrden.setText("12");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 29, 3);
        jPanel2.add(campoOrden, gridBagConstraints);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Asignación de módulos por profesor");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(jLabel11, gridBagConstraints);

        jPanel3.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel3, java.awt.BorderLayout.NORTH);

        jPanel7.setToolTipText("yfhjgfgjgj");
        jPanel7.setLayout(new java.awt.GridBagLayout());

        tablaElegidos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tablaElegidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Siglas", "Módulo", "Curso", "Ciclo", "Tipo de grado", "Nivel", "Horas reales", "Horas ponde.", "Turno"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaElegidos);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel7.add(jScrollPane1, gridBagConstraints);

        botonAnnadirSelecionados.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonAnnadirSelecionados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/crud_create.png"))); // NOI18N
        botonAnnadirSelecionados.setText("Añadir seleccionados");
        botonAnnadirSelecionados.setPreferredSize(new java.awt.Dimension(300, 40));
        botonAnnadirSelecionados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnnadirSelecionadosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.5;
        jPanel7.add(botonAnnadirSelecionados, gridBagConstraints);

        botonEliminarSeleccionados.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonEliminarSeleccionados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancelar.png"))); // NOI18N
        botonEliminarSeleccionados.setText("Eliminar seleccionados");
        botonEliminarSeleccionados.setPreferredSize(new java.awt.Dimension(300, 40));
        botonEliminarSeleccionados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarSeleccionadosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel7.add(botonEliminarSeleccionados, gridBagConstraints);

        botonGuardarAsignaciones.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonGuardarAsignaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/check.png"))); // NOI18N
        botonGuardarAsignaciones.setText("Guardar asignaciones");
        botonGuardarAsignaciones.setPreferredSize(new java.awt.Dimension(300, 40));
        botonGuardarAsignaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarAsignacionesActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.5;
        jPanel7.add(botonGuardarAsignaciones, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Módulos seleccionados:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel1.add(jLabel4, gridBagConstraints);

        labelModulosSeleccionados.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelModulosSeleccionados.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel1.add(labelModulosSeleccionados, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Horas ponderadas:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel1.add(jLabel7, gridBagConstraints);

        labelHorasPonderadas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelHorasPonderadas.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jPanel1.add(labelHorasPonderadas, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Horas totales:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel1.add(jLabel8, gridBagConstraints);

        labelHorasTotales.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelHorasTotales.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jPanel1.add(labelHorasTotales, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 1.4;
        jPanel7.add(jPanel1, gridBagConstraints);

        tablaManana.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tablaManana.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Siglas", "Módulo", "Curso", "Ciclo", "Tipo de grado", "Nivel", "Horas reales", "Horas ponde."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tablaManana);

        jTabbedPane1.addTab("Turno de mañana", jScrollPane4);

        tablaTarde.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tablaTarde.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Siglas", "Módulo", "Curso", "Ciclo", "Tipo de grado", "Nivel", "Horas reales", "Horas ponde."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tablaTarde);

        jTabbedPane1.addTab("Turno de tarde", jScrollPane5);

        tablaNoche.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tablaNoche.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Siglas", "Módulo", "Curso", "Ciclo", "Tipo de grado", "Nivel", "Horas reales", "Horas ponde."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tablaNoche);

        jTabbedPane1.addTab("Turno de noche", jScrollPane6);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 3.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        jPanel7.add(jTabbedPane1, gridBagConstraints);

        getContentPane().add(jPanel7, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonAnnadirSelecionadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnnadirSelecionadosActionPerformed

        logica.LogicaAsignaciones.annadirModulosSeleccionados(this);
        logica.LogicaAsignaciones.recalcularHoras(this);
    }//GEN-LAST:event_botonAnnadirSelecionadosActionPerformed

    private void botonEliminarSeleccionadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarSeleccionadosActionPerformed
        logica.LogicaAsignaciones.eliminarModulosSeleccionados(this);
        logica.LogicaAsignaciones.recalcularHoras(this);
    }//GEN-LAST:event_botonEliminarSeleccionadosActionPerformed

    private void botonGuardarAsignacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarAsignacionesActionPerformed
        
        if (Integer.parseInt(labelHorasTotales.getText()) > Integer.parseInt(campoHorasContratadas.getText())) {
            if (JOptionPane.showConfirmDialog(this, "Las horas totales de los módulos seleccionados exceden las horas de contratación del profesor. ¿Desea realizar las asignaciones?") == 0) {
                ejecutarAsignaciones();
            }
        } else {
            ejecutarAsignaciones();
        }
        
    }//GEN-LAST:event_botonGuardarAsignacionesActionPerformed

    private void ejecutarAsignaciones() {
        
        if (logica.LogicaAsignaciones.guardarAsignaciones(this)) {
             JOptionPane.showMessageDialog(null, "Asignaciones realizadas con éxito. Se continuará con el siguiente profesor.");
         } else {
             JOptionPane.showConfirmDialog(null, "Ocurrió un error.");
         }
         
        try {
            logica.LogicaAsignaciones.siguienteProfe(this);
        } catch (SQLException ex) {
            Logger.getLogger(Asignacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        logica.LogicaAsignaciones.recalcularHoras(this);
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            new gui.ExploracionAsignaciones().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(MenuAsignaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Asignacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Asignacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Asignacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Asignacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Asignacion().setVisible(true);
            }
        });
    }

    public JTabbedPane getjTabbedPane1() {
        return jTabbedPane1;
    }

    public JLabel getLabelHorasPonderadas() {
        return labelHorasPonderadas;
    }

    public JLabel getLabelHorasTotales() {
        return labelHorasTotales;
    }

    public JLabel getLabelModulosSeleccionados() {
        return labelModulosSeleccionados;
    }

    public JButton getBotonGuardarAsignaciones() {
        return botonGuardarAsignaciones;
    }
    
    

    public JLabel getCampoEspecialidad() {
        return campoEspecialidad;
    }

    public JLabel getCampoHorasContratadas() {
        return campoHorasContratadas;
    }

    public JLabel getCampoOrden() {
        return campoOrden;
    }

    public JLabel getCampoProfesor() {
        return campoProfesor;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAnnadirSelecionados;
    private javax.swing.JButton botonEliminarSeleccionados;
    private javax.swing.JButton botonGuardarAsignaciones;
    private javax.swing.JLabel campoEspecialidad;
    private javax.swing.JLabel campoHorasContratadas;
    private javax.swing.JLabel campoOrden;
    private javax.swing.JLabel campoProfesor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelHorasPonderadas;
    private javax.swing.JLabel labelHorasTotales;
    private javax.swing.JLabel labelModulosSeleccionados;
    private javax.swing.JTable tablaElegidos;
    private javax.swing.JTable tablaManana;
    private javax.swing.JTable tablaNoche;
    private javax.swing.JTable tablaTarde;
    // End of variables declaration//GEN-END:variables
}
