package crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import objetos.*;


public class ModulosCursosCRUD {
    
    public static boolean crear(ModuloCurso modulocurso) throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getINSERTAR_MODULOCURSO());

        st.setString(1, modulocurso.getCodigoModulo());
        st.setString(2, modulocurso.getCodigoCurso());

        if (st.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }

    }

    public static ModuloCurso leerUno(String pk) throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getSELECCIONAR_MODULOCURSO());
        st.setString(1, pk);
        ResultSet rs = st.executeQuery();

        ModuloCurso modulocurso = new ModuloCurso();

        if (rs.next()) {
            modulocurso.setIdModuloCurso(rs.getInt(1));
            modulocurso.setCodigoModulo(rs.getString(2));
            modulocurso.setCodigoCurso(rs.getString(3));
        }

        return modulocurso;

    }
    
    public static ArrayList<ModuloCurso> leerTodos() throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getSELECCIONAR_MODULOSCURSOS());
        ResultSet rs = st.executeQuery();
        ArrayList<ModuloCurso> listaModulosCursos = new ArrayList();

        while (rs.next()) {
            ModuloCurso modulocurso = new ModuloCurso();
            modulocurso.setIdModuloCurso(rs.getInt(1));
            modulocurso.setCodigoModulo(rs.getString(2));
            modulocurso.setCodigoCurso(rs.getString(3));
            listaModulosCursos.add(modulocurso);
        }

        return listaModulosCursos;

    }
    
    public static boolean actualizar(ModuloCurso modulocurso, String pk) throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getACTUALIZAR_MODULOCURSO());
        st.setInt(1, modulocurso.getIdModuloCurso());
        st.setString(2, modulocurso.getCodigoModulo());
        st.setString(3, modulocurso.getCodigoCurso());
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
                .prepareStatement(sql.Sentencias.getBORRAR_MODULOCURSO());
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
                .prepareStatement(sql.Sentencias.getBUSCAR_PK_REPETIDA_MODULOCURSO());
        st.setString(1, pk);
        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            return true;
        } else {
            return false;
        }

    }
    
}