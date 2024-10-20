package logica;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import gui.Asignacion;
import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import objetos.EleccionModulo;


public class LogicaAsignaciones {

    private static ArrayList<EleccionModulo> listaElecciones = new ArrayList();
    private static ArrayList<EleccionModulo> listaModulos = new ArrayList();

    //rellena los JLabel de la interfaz con datos
    public static void rellenarDatosProfesor(Asignacion asign) throws SQLException {
        String[] datos = getDatosSiguienteProfesor();

        asign.getCampoProfesor().setText(datos[0] + " " + datos[1]);
        asign.getCampoEspecialidad().setText(datos[2]);
        asign.getCampoHorasContratadas().setText(datos[3]);
        asign.getCampoOrden().setText(datos[4]);
        asign.setTitle("Asignación de módulos al profesor " + datos[0] + " " + datos[1]);
    }

    public static void rellenarDatosModulosDisponibles(Asignacion asign) throws SQLException {
        
//actualizacion
        cargarModulos(asign);
        recalcularTablas(asign);

    }

    public static ArrayList<EleccionModulo> getListaElecciones() {
        return listaElecciones;
    }

    public static ArrayList<EleccionModulo> getListaModulos() {
        return listaModulos;
    }

    public static void annadirModulosSeleccionados(Asignacion asig) {
        //añade los modulos seleccionados a la lista de modulos seleccionados
        int[] listaSeleccionados;
        int tabla = asig.getjTabbedPane1().getSelectedIndex();

        switch (tabla) {
            case 0:
                listaSeleccionados = asig.getTablaManana().getSelectedRows();
                break;
            case 1:
                listaSeleccionados = asig.getTablaTarde().getSelectedRows();
                break;
            case 2:
                listaSeleccionados = asig.getTablaNoche().getSelectedRows();
                break;
            default:
                throw new AssertionError();
        }

        DefaultTableModel[] listaDTMs = new DefaultTableModel[]{
            (DefaultTableModel) asig.getTablaManana().getModel(),
            (DefaultTableModel) asig.getTablaTarde().getModel(),
            (DefaultTableModel) asig.getTablaNoche().getModel()
        };

        for (int in : listaSeleccionados) {
            System.out.println(String.valueOf(in));
            System.out.println(listaDTMs[tabla].getValueAt(in, 0));
            ArrayList<EleccionModulo> listaTempo = (ArrayList) listaModulos.clone();
            for (EleccionModulo mod : listaTempo) {
                if (mod.getIdmodulo_curso() == Integer.parseInt(listaDTMs[tabla].getValueAt(in, 0).toString())) {
                    listaElecciones.add(mod);
                    listaModulos.remove(mod);
                }
            }
        }

        recalcularTablas(asig);

    }

    public static void eliminarModulosSeleccionados(Asignacion asig) {

        int[] listaSeleccionados = asig.getTablaElegidos().getSelectedRows();
        DefaultTableModel dtm = (DefaultTableModel) asig.getTablaElegidos().getModel();

        for (int in : listaSeleccionados) {
            ArrayList<EleccionModulo> listaTempo = (ArrayList) listaElecciones.clone();
            for (EleccionModulo mod : listaTempo) {
                if (mod.getIdmodulo_curso() == Integer.parseInt(dtm.getValueAt(in, 0).toString())) {
                    listaModulos.add(mod);
                    listaElecciones.remove(mod);
                }
            }
        }

        recalcularTablas(asig);
    }

    private static void recalcularTablas(Asignacion asign) {
        DefaultTableModel dtmManana = (DefaultTableModel) asign.getTablaManana().getModel();
        DefaultTableModel dtmTarde = (DefaultTableModel) asign.getTablaTarde().getModel();
        DefaultTableModel dtmNoche = (DefaultTableModel) asign.getTablaNoche().getModel();
        DefaultTableModel dtmElegidos = (DefaultTableModel) asign.getTablaElegidos().getModel();
        dtmElegidos.setRowCount(0);
        dtmManana.setRowCount(0);
        dtmTarde.setRowCount(0);
        dtmNoche.setRowCount(0);

        for (EleccionModulo e : listaModulos) {
            switch (e.getTurno()) {
                case 1:
                    System.out.println("\n" + e.getCodigoCurso());
                    System.out.println("turno: " + e.getTurno());
                    System.out.println("case 1");
                    dtmManana.addRow(e.toArrayStrings());
                    break;
                case 2:
                    System.out.println("\n" + e.getCodigoCurso());
                    System.out.println("turno: " + e.getTurno());
                    System.out.println("case 2");
                    dtmTarde.addRow(e.toArrayStrings());
                    break;
                case 3:
                    System.out.println("\n" + e.getCodigoCurso());
                    System.out.println("turno: " + e.getTurno());
                    System.out.println("case 3");
                    dtmNoche.addRow(e.toArrayStrings());
                    break;
                default:
                    System.out.println("turno: " + e.getTurno());
                    break;
            }
        }

        for (EleccionModulo e : listaElecciones) {
            dtmElegidos.addRow(e.toArrayStringsConTurno());
        }
    }

    public static void siguienteProfe(Asignacion asig) throws SQLException {
        listaModulos.clear();
        listaElecciones.clear();
        logica.LogicaAsignaciones.rellenarDatosProfesor(asig);
            logica.LogicaAsignaciones.rellenarDatosModulosDisponibles(asig);
        
    }
    
    public static void recalcularHoras(Asignacion asig) {
        if (!listaElecciones.isEmpty()) {
            asig.getBotonGuardarAsignaciones().setEnabled(true);
        } else {
            asig.getBotonGuardarAsignaciones().setEnabled(false);
        }
        
        asig.getLabelModulosSeleccionados().setText(String.valueOf(listaElecciones.size()));
        int ht = 0;
        
        for (EleccionModulo ele : listaElecciones) {
            ht += ele.getHorasreales();
        }
        
        asig.getLabelHorasTotales().setText(String.valueOf(ht));
        int hp = 0;
        for (EleccionModulo ele : listaElecciones) {
            hp += ele.getHorasponderadas();
        }
        asig.getLabelHorasPonderadas().setText(String.valueOf(hp));
        
        if (ht > Integer.parseInt(asig.getCampoHorasContratadas().getText())) {
            asig.getLabelHorasTotales().setForeground(Color.red);
            System.out.println("rojo");
        } else {
            asig.getLabelHorasTotales().setForeground(Color.green);
        }
    }

    public static boolean guardarAsignaciones(Asignacion asig) {

        try {
            PreparedStatement st = logica.LogicaConexion.getConexion()
                    .prepareStatement(sql.Sentencias.getINSERTAR_ASIGNACION());
            st.setInt(1, profesorActual);

            for (EleccionModulo elecciones : listaElecciones) {

                st.setInt(2, elecciones.getIdmodulo_curso());
                ResultSet rs = st.executeQuery();

            }
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(LogicaAsignaciones.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    private static void cargarModulos(Asignacion asign) throws SQLException {
        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getVER_ASIGNACIONES_DISPONIBLES_POR_PROFESOR());
        st.setString(1, asign.getCampoEspecialidad().getText());
        ResultSet rs = st.executeQuery();
        listaModulos.clear();
        listaElecciones.clear();
        while (rs.next()) {

            EleccionModulo e = new EleccionModulo();
            e.setIdmodulo_curso(rs.getInt(1));
            e.setCodigomodulo(rs.getString(2));
            e.setCodigoCurso(rs.getString(3));
            e.setDescripcionModulo(rs.getString(4));
            e.setHorasreales(rs.getInt(5));
            e.setHorasponderadas(rs.getInt(6));
            e.setTurno(rs.getInt(7));
            e.setDescripcionCiclo(rs.getString(8));
            e.setTipoGrado(rs.getString(9));
            e.setNivel(rs.getInt(10));

            listaModulos.add(e);

        }
    }

    private static int profesorActual;

    public static String[] getDatosSiguienteProfesor() throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getORDENAR_PROFESORES());
        ResultSet rs = st.executeQuery();

        rs.next();

        profesorActual = rs.getInt(6);

        return new String[]{rs.getString(1), rs.getString(2), rs.getString(3), String.valueOf(rs.getInt(4)), String.valueOf(rs.getString(5))};

    }

    public static void fijarDatosAlExplorarAsignaciones(String pk) {

    }

}
