package crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import objetos.*;


public class FamiliasProfesionalesCRUD {
    
    public static boolean crear(FamiliaProfesional familiaprofesional) throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getINSERTAR_FAMILIA_PROFESIONAL());

        st.setString(1, familiaprofesional.getDescripcion());

        if (st.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }

    }

    public static FamiliaProfesional leerUno(String pk) throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getSELECCIONAR_FAMILIA_PROFESIONAL());
        st.setString(1, pk);
        ResultSet rs = st.executeQuery();

        FamiliaProfesional familiaprofesional = new FamiliaProfesional();

        if (rs.next()) {
            familiaprofesional.setIdFamiliaProfesional(rs.getInt(1));
            familiaprofesional.setDescripcion(rs.getString(2));
        }

        return familiaprofesional;

    }
    
    public static ArrayList<FamiliaProfesional> leerTodos() throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getSELECCIONAR_FAMILIAS_PROFESIONALES());
        ResultSet rs = st.executeQuery();
        ArrayList<FamiliaProfesional> listaFamilias = new ArrayList();

        while (rs.next()) {
            FamiliaProfesional familia = new FamiliaProfesional();
            familia.setIdFamiliaProfesional(rs.getInt(1));
            familia.setDescripcion(rs.getString(2));
            listaFamilias.add(familia);
        }

        return listaFamilias;

    }
    
    public static boolean actualizar(FamiliaProfesional familiaprofesional, String pk) throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getACTUALIZAR_FAMILIA_PROFESIONAL());
        st.setString(1, familiaprofesional.getDescripcion());
        st.setString(2, pk);
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
                .prepareStatement(sql.Sentencias.getBORRAR_FAMILIA_PROFESIONAL());
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
                .prepareStatement(sql.Sentencias.getBUSCAR_PK_REPETIDA_FAMILIA_PROFESIONAL());
        st.setString(1, pk);
        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            return true;
        } else {
            return false;
        }

    }
    
}