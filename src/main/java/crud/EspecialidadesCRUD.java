package crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import objetos.*;


public class EspecialidadesCRUD {
    //fg
    public static boolean crear(Especialidad especialidad) throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getINSERTAR_ESPECIALIDAD());

        st.setString(1, especialidad.getDescripcion());

        if (st.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }

    }

    public static Especialidad leerUno(String pk) throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getSELECCIONAR_ESPECIALIDAD());
        st.setString(1, pk);
        ResultSet rs = st.executeQuery();

        Especialidad especialidad = new Especialidad();

        if (rs.next()) {
            especialidad.setIdEspecialidad(rs.getInt(1));
            especialidad.setDescripcion(rs.getString(2));
        }

        return especialidad;

    }
    
    public static ArrayList<Especialidad> leerTodos() throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getSELECCIONAR_ESPECIALIDADES());
        ResultSet rs = st.executeQuery();
        ArrayList<Especialidad> listaEspecialidades = new ArrayList();

        while (rs.next()) {
            Especialidad espe = new Especialidad();
            espe.setIdEspecialidad(rs.getInt(1));
            espe.setDescripcion(rs.getString(2));
            listaEspecialidades.add(espe);
        }

        return listaEspecialidades;

    }
    
    public static boolean actualizar(Especialidad especialidad, String pk) throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getACTUALIZAR_ESPECIALIDAD());
        st.setString(1, especialidad.getDescripcion());
        st.setString(2, pk);
        try {
            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.printStackTrace();
            
        }
        return false;

    }

    public static boolean eliminar(String pk) throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getBORRAR_ESPECIALIDAD());
        st.setString(1, pk);

        try {
            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.printStackTrace();
            return false;
            
        }

    }

    public static boolean comprobarExistencia(String pk) throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getBUSCAR_PK_REPETIDA_ESPECIALIDAD());
        st.setString(1, pk);
        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            return true;
        } else {
            return false;
        }

    }
    
}