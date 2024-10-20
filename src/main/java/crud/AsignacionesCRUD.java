package crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import objetos.*;


public class AsignacionesCRUD {
    
    public static boolean crear(Asignacion asignacion) throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getINSERTAR_PROFESORMODULO());

        st.setInt(1, asignacion.getIdProfesorModulo());
        st.setInt(2, asignacion.getIdProfesor());
        st.setString(3, asignacion.getCodigoModulo());

        if (st.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }

    }

    public static Asignacion leerUno(String pk) throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getSELECCIONAR_PROFESORMODULO());
        st.setString(1, pk);
        ResultSet rs = st.executeQuery();

        Asignacion asignacion = new Asignacion();

        if (rs.next()) {
            asignacion.setIdProfesorModulo(rs.getInt(1));
            asignacion.setIdProfesor(rs.getInt(2));
            asignacion.setCodigoModulo(rs.getString(3));
        }

        return asignacion;

    }
    
    public static ArrayList<Asignacion> leerTodos() throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getSELECCIONAR_PROFESORESMODULOS());
        ResultSet rs = st.executeQuery();
        ArrayList<Asignacion> listaAsignaciones = new ArrayList();

        while (rs.next()) {
            Asignacion asign = new Asignacion();
            asign.setIdProfesorModulo(rs.getInt(1));
            asign.setIdProfesor(rs.getInt(2));
            asign.setCodigoModulo(rs.getString(3));
            listaAsignaciones.add(asign);
        }

        return listaAsignaciones;

    }
    
    public static boolean actualizar(Asignacion asignacion, String pk) throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getACTUALIZAR_PROFESORMODULO());
        st.setInt(1, asignacion.getIdProfesorModulo());
        st.setInt(2, asignacion.getIdProfesor());
        st.setString(3, asignacion.getCodigoModulo());
        st.setString(4, pk);
        try {
            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return false;

    }

    public static boolean eliminar(String pk) throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getBORRAR_PROFESORMODULO());
        st.setString(1, pk);

        try {
            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return false;

    }

    public static boolean comprobarExistencia(String pk) throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getBUSCAR_PK_REPETIDA_PROFESORMODULO());
        st.setString(1, pk);
        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            return true;
        } else {
            return false;
        }

    }
    
}