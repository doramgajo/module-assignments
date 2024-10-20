package logica;

import gui.MenuAsignaciones;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import objetos.Asignacion;


public class LogicaEstadisticas {
    
    //actualiza las estadisticas
    public static void actualizarEstadisticas(MenuAsignaciones menu) throws SQLException {
        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getCALCULAR_PORCENTAJE_PROFESORES_ASIGNADOS());
        ResultSet rs = st.executeQuery();

        rs.next();
        menu.getjLabel5().setText(String.format("%.1f", rs.getFloat(3)) + "%");
        menu.getjProgressBar2().setValue(rs.getInt(3));
        
        st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getCALCULAR_PORCENTAJE_MODULOS_ASIGNADOS());
        rs = st.executeQuery();
        rs.next();
        menu.getjLabel3().setText(String.format("%.1f", rs.getFloat(1)) + "%");
        menu.getjProgressBar1().setValue(rs.getInt(1));

        st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getCALCULAR_HORAS_TOTALES());
        rs = st.executeQuery();
        rs.next();
        menu.getjLabel2().setText(rs.getInt(1) + " horas");
        
        st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getCONTAR_G_MEDIOS());
        rs = st.executeQuery();
        rs.next();
        menu.getjLabel19().setText(String.valueOf(rs.getInt(1)));
        
        st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getCONTAR_G_SUPERIORES());
        rs = st.executeQuery();
        rs.next();
        menu.getjLabel23().setText(String.valueOf(rs.getInt(1)));
        
        st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getCONTAR_C_ESPECIALIZACION());
        rs = st.executeQuery();
        rs.next();
        menu.getjLabel21().setText(String.valueOf(rs.getInt(1)));
        
        st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getCONTAR_PROFESORES());
        rs = st.executeQuery();
        rs.next();
        menu.getjLabel11().setText(String.valueOf(rs.getInt(1)));
        
        st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getCONTAR_CICLOS());
        rs = st.executeQuery();
        rs.next();
        menu.getjLabel15().setText(String.valueOf(rs.getInt(1)));
        
        st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getCONTAR_CURSOS());
        rs = st.executeQuery();
        rs.next();
        menu.getjLabel13().setText(String.valueOf(rs.getInt(1)));
        
        st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getCONTAR_MODULOS());
        rs = st.executeQuery();
        rs.next();
        menu.getjLabel17().setText(String.valueOf(rs.getInt(1)));
        
        st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getCALCULAR_MEDIA_HORAS());
        rs = st.executeQuery();
        rs.next();
        menu.getjLabel4().setText(String.valueOf(String.format("%.1f", rs.getFloat(1))) + " horas");
    }
    
}