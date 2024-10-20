package crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import objetos.*;


public class CursosCRUD {
    
    public static boolean crear(Curso curso) throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getINSERTAR_CURSO());

        st.setString(1, curso.getCodigo());
        st.setInt(2, curso.getIdTurno());
        st.setInt(3, curso.getIdCiclo());
        st.setInt(4, curso.getNivel());

        if (st.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }

    }

    public static Curso leerUno(String pk) throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getSELECCIONAR_CURSO());
        st.setString(1, pk);
        ResultSet rs = st.executeQuery();

        Curso curso = new Curso();

        if (rs.next()) {
            curso.setCodigo(rs.getString(1));
            curso.setIdTurno(rs.getInt(2));
            curso.setIdCiclo(rs.getInt(3));
            curso.setNivel(rs.getInt(4));
        }

        return curso;

    }
    
        public static ArrayList<Curso> leerTodos() throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getSELECCIONAR_CURSOS());
        ResultSet rs = st.executeQuery();
        ArrayList<Curso> listaCursos = new ArrayList();

        while (rs.next()) {
            Curso curso = new Curso();
            curso.setCodigo(rs.getString(1));
            curso.setIdTurno(rs.getInt(2));
            curso.setIdCiclo(rs.getInt(3));
            curso.setNivel(rs.getInt(4));
            listaCursos.add(curso);
        }

        return listaCursos;

    }
        
        public static boolean actualizar(Curso curso, String pk) throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getACTUALIZAR_CURSO());
        st.setString(1, curso.getCodigo());
        st.setInt(2, curso.getIdTurno());
        st.setInt(3, curso.getIdCiclo());
        st.setInt(4, curso.getNivel());
        st.setString(5, pk);
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
                .prepareStatement(sql.Sentencias.getBORRAR_CURSO());
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
                .prepareStatement(sql.Sentencias.getBUSCAR_PK_REPETIDA_CURSO());
        st.setString(1, pk);
        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            return true;
        } else {
            return false;
        }

    }
    
}