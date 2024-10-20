package crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import objetos.*;


public class CiclosCRUD {

    public static boolean crear(Ciclo ciclo) throws SQLException {
        try {
            PreparedStatement st = logica.LogicaConexion.getConexion()
                    .prepareStatement(sql.Sentencias.getINSERTAR_CICLO());

            st.setString(1, ciclo.getNombre());
            st.setInt(2, ciclo.getIdFamiliaProfesional());
            st.setString(3, ciclo.getTipo());

            if (st.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }

    public static Ciclo leerUno(String pk) throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getSELECCIONAR_CICLO());
        st.setString(1, pk);
        ResultSet rs = st.executeQuery();

        Ciclo ciclo = new Ciclo();

        if (rs.next()) {
            ciclo.setIdCiclo(rs.getInt(1));
            ciclo.setNombre(rs.getString(2));
            ciclo.setIdFamiliaProfesional(rs.getInt(3));
            ciclo.setTipo(rs.getString(4));
        }

        return ciclo;

    }

    public static ArrayList<Ciclo> leerTodos() throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getSELECCIONAR_CICLOS());
        ResultSet rs = st.executeQuery();
        ArrayList<Ciclo> listaCiclos = new ArrayList();

        while (rs.next()) {
            Ciclo ciclo = new Ciclo();
            ciclo.setIdCiclo(rs.getInt(1));
            ciclo.setNombre(rs.getString(2));
            ciclo.setIdFamiliaProfesional(rs.getInt(3));
            ciclo.setTipo(rs.getString(4));
            listaCiclos.add(ciclo);
        }

        return listaCiclos;

    }

    public static boolean actualizar(Ciclo ciclo, String pk) throws SQLException {
        System.out.println(ciclo.toString());
        System.out.println(pk);
        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getACTUALIZAR_CICLO());
        st.setString(1, ciclo.getNombre());
        st.setInt(2, ciclo.getIdFamiliaProfesional());
        st.setString(3, ciclo.getTipo());
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
                .prepareStatement(sql.Sentencias.getBORRAR_CICLO());
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
                .prepareStatement(sql.Sentencias.getBUSCAR_PK_REPETIDA_CICLO());
        st.setString(1, pk);
        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            return true;
        } else {
            return false;
        }

    }

}
