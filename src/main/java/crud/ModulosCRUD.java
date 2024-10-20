package crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import objetos.*;


public class ModulosCRUD {
    
    public static boolean crear(Modulo modulo) throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getINSERTAR_MODULO());

        st.setString(1, modulo.getCodigo());
        st.setString(2, modulo.getDescripcion());
        st.setInt(3, modulo.getHorasReales());
        st.setInt(4, modulo.getHorasPonderadas());
        st.setInt(5, modulo.getIdEspecialidad());

        if (st.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }

    }

    public static Modulo leerUno(String pk) throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getSELECCIONAR_MODULO());
        st.setString(1, pk);
        ResultSet rs = st.executeQuery();

        Modulo modulo = new Modulo();

        if (rs.next()) {
            modulo.setCodigo(rs.getString(1));
            modulo.setDescripcion(rs.getString(2));
            modulo.setHorasReales(rs.getInt(3));
            modulo.setHorasPonderadas(rs.getInt(4));
            modulo.setIdEspecialidad(rs.getInt(5));
        }

        return modulo;

    }
    
        public static ArrayList<Modulo> leerTodos() throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getSELECCIONAR_MODULOS());
        ResultSet rs = st.executeQuery();
        ArrayList<Modulo> listaModulos = new ArrayList();

        while (rs.next()) {
            Modulo modulo = new Modulo();
            modulo.setCodigo(rs.getString(1));
            modulo.setDescripcion(rs.getString(2));
            modulo.setHorasReales(rs.getInt(3));
            modulo.setHorasPonderadas(rs.getInt(4));
            modulo.setIdEspecialidad(rs.getInt(5));
            listaModulos.add(modulo);
        }

        return listaModulos;

    }
        
        public static boolean actualizar(Modulo modulo, String pk) throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getACTUALIZAR_MODULO());
        st.setString(1, modulo.getCodigo());
        st.setString(2, modulo.getDescripcion());
        st.setInt(3, modulo.getHorasReales());
        st.setInt(4, modulo.getHorasPonderadas());
        st.setInt(5, modulo.getIdEspecialidad());
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
                .prepareStatement(sql.Sentencias.getBORRAR_MODULO());
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
                .prepareStatement(sql.Sentencias.getBUSCAR_PK_REPETIDA_MODULO());
        st.setString(1, pk);
        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            return true;
        } else {
            return false;
        }

    }
    
}