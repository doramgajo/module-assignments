package crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import objetos.*;


public class TurnosCRUD {
    
    public static boolean crear(Turno turno) throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getINSERTAR_TURNO());

        st.setString(1, turno.getDescripcion());

        if (st.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }

    }

    public static Turno leerUno(String pk) throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getSELECCIONAR_TURNO());
        st.setString(1, pk);
        ResultSet rs = st.executeQuery();

        Turno turno = new Turno();

        if (rs.next()) {
            turno.setIdTurno(rs.getInt(1));
            turno.setDescripcion(rs.getString(2));
        }

        return turno;

    }
    
    public static ArrayList<Turno> leerTodos() throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getSELECCIONAR_TURNOS());
        ResultSet rs = st.executeQuery();
        ArrayList<Turno> listaTurnos = new ArrayList();

        while (rs.next()) {
            Turno turno = new Turno();
            turno.setIdTurno(rs.getInt(1));
            turno.setDescripcion(rs.getString(2));
            listaTurnos.add(turno);
        }

        return listaTurnos;

    }
    
    public static boolean actualizar(Turno turno, String pk) throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getACTUALIZAR_TURNO());
        st.setInt(1, turno.getIdTurno());
        st.setString(2, turno.getDescripcion());
        st.setString(3, pk);
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
                .prepareStatement(sql.Sentencias.getBORRAR_TURNO());
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
                .prepareStatement(sql.Sentencias.getBUSCAR_PK_REPETIDA_TURNO());
        st.setString(1, pk);
        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            return true;
        } else {
            return false;
        }

    }
    
}