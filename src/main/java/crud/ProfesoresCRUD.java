package crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import objetos.*;


public class ProfesoresCRUD {
    
    public static boolean crear(Profesor profesor) throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getINSERTAR_PROFESOR());

        st.setString(1, profesor.getNombre());
        st.setString(2, profesor.getApellido());
        st.setInt(3, profesor.getNumeroOrden());
        st.setInt(4, profesor.getIdEspecialidad());
        st.setInt(5, profesor.getHorasContratadas());

        if (st.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }

    }

    public static Profesor leerUno(String pk) throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getSELECCIONAR_PROFESOR());
        st.setString(1, pk);
        ResultSet rs = st.executeQuery();

        Profesor profesor = new Profesor();

        if (rs.next()) {
            profesor.setIdProfesor(rs.getInt(1));
            profesor.setNombre(rs.getString(2));
            profesor.setApellido(rs.getString(3));
            profesor.setNumeroOrden(rs.getInt(4));
            profesor.setIdEspecialidad(rs.getInt(5));
            profesor.setHorasContratadas(rs.getInt(6));
        }

        return profesor;

    }
    
    public static ArrayList<Profesor> leerTodos() throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getSELECCIONAR_PROFESORES());
        ResultSet rs = st.executeQuery();
        ArrayList<Profesor> listaProfesores = new ArrayList();

        while (rs.next()) {
            Profesor profesor = new Profesor();
            profesor.setIdProfesor(rs.getInt(1));
            profesor.setNombre(rs.getString(2));
            profesor.setApellido(rs.getString(3));
            profesor.setNumeroOrden(rs.getInt(4));
            profesor.setIdEspecialidad(rs.getInt(5));
            profesor.setHorasContratadas(rs.getInt(6));
            listaProfesores.add(profesor);
        }

        return listaProfesores;

    }
    
    public static boolean actualizar(Profesor profesor, String pk) throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getACTUALIZAR_PROFESOR());
        st.setString(1, profesor.getNombre());
        st.setString(2, profesor.getApellido());
        st.setInt(3, profesor.getNumeroOrden());
        st.setInt(4, profesor.getIdEspecialidad());
        st.setInt(5, profesor.getHorasContratadas());
        st.setString(6, pk);
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
                .prepareStatement(sql.Sentencias.getBORRAR_PROFESOR());
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
                .prepareStatement(sql.Sentencias.getBUSCAR_PK_REPETIDA_PROFESOR());
        st.setString(1, pk);
        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            return true;
        } else {
            return false;
        }

    }
    
}