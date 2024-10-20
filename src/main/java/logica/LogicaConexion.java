package logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class LogicaConexion {

    private static String ruta = "localhost:3306/asignaciondemodulos";
    private static String usuario = "root";
    private static String contrasena = "";
    private static Connection conexion;

    public static boolean conectar() throws SQLException {
        try {
            conexion = DriverManager.getConnection("jdbc:mariadb://"
                + ruta, usuario, contrasena);
        } catch (Exception e) {
            return false;
        }
        

        return !conexion.isClosed();

    }
    
    public static String aString() {
        return "jdbc:mariadb://" + ruta + "\n"  + usuario + "\n" + contrasena;
    }

    public static String getRuta() {
        return ruta;
    }

    public static void setRuta(String ruta) {
        LogicaConexion.ruta = ruta;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        LogicaConexion.usuario = usuario;
    }

    public static String getContrasena() {
        return contrasena;
    }

    public static void setContrasena(String contrasena) {
        LogicaConexion.contrasena = contrasena;
    }

    public static Connection getConexion() {
        return conexion;
    }

    public static void setConexion(Connection conexion) {
        LogicaConexion.conexion = conexion;
    }
    
    

}
