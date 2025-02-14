package utils;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection getConexion() throws Exception {
        Connection conexion = null;
        String nombreBaseDatos = "neocine";
        String url = "jdbc:mysql://localhost:3306/" + nombreBaseDatos;
        String usuario = "root";
        String password = "123456789";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion= DriverManager.getConnection(url, usuario, password);

        } catch (Exception e) {
            throw  new Exception("Error en conectar a la base de datos");
        }
        return conexion;
    }


}
