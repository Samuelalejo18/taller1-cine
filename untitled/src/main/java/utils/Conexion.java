package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public static Connection getConexion() {
        Connection conexion = null;
        String nombreBaseDatos = "neocine";
        String url = "jdbc:mysql://localhost:3306/" + nombreBaseDatos;
        String usuario = "root";
        String password = "123456789";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion= DriverManager.getConnection(url, usuario, password);
            System.out.printf("conexion exitosa");
        } catch (Exception e) {
            System.out.println("ERROR DE CONEXION A LA BASE DE DATOS: " + e.getMessage());
        }
        return conexion;
    }


}
