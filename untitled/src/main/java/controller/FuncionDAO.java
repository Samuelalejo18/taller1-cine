package controller;

import model.Funcion;
import model.Pelicula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static utils.Conexion.getConexion;

public class FuncionDAO implements IGenericDAO<Funcion> {
    @Override
    public List<Funcion> listarTodos() {
        List<Funcion> funciones = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sqlSelect = "SELECT * FROM neocine.funcion ORDER BY idFuncion";
        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();
            while (rs.next()) {
                Funcion funcion = new Funcion();
                funcion.setIdFuncion(rs.getInt("idFuncion"));
                funcion.setDia(rs.getDate("dia").toLocalDate());
                funcion.setHora(rs.getTime("hora").toLocalTime());
                funciones.add(funcion);
            }
        } catch (Exception e) {
            System.out.println("Error al listar funciones: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return funciones;
    }

    @Override
    public boolean buscarPorId(Funcion funcion) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        // ? parametros posicionales
        String sql = "SELECT * FROM funcion WHERE idFuncion= ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, funcion.getIdFuncion());
            rs = ps.executeQuery();
            if (rs.next()) {
                funcion.setDia(rs.getDate("dia").toLocalDate());
                funcion.setHora(rs.getTime("hora").toLocalTime());
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error al recuperar funcion por id: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean agregar(Funcion funcion) {
        PreparedStatement ps;
        Connection con = getConexion();
        // ? parametros posicionales
        String sqlCreateFuncion = "INSERT INTO funcion  (dia,hora) "
                + "VALUES (?, ?)";
        try {
            ps = con.prepareStatement(sqlCreateFuncion);
            // Set 'dia' (LocalDate) in PreparedStatement
            ps.setDate(1, java.sql.Date.valueOf(funcion.getDia())); // Convert LocalDate to java.sql.Date

            // Set 'hora' (LocalTime) in PreparedStatement
            ps.setTime(2, java.sql.Time.valueOf(funcion.getHora()));
            ;

            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al agregar la funcion" + e.getMessage());
        } finally {

            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrrar la conexion" + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean modificar(Funcion funcion) {
        PreparedStatement ps;
        Connection con = getConexion();
        // ? parametros posicionales
        String sqlUpdate = "UPDATE  funcion SET dia= ?, hora =?" + " WHERE idFuncion = ?";
        try {

            ps = con.prepareStatement(sqlUpdate);
            ps.setDate(1, java.sql.Date.valueOf(funcion.getDia())); // Convert LocalDate to java.sql.Date

            // Set 'hora' (LocalTime) in PreparedStatement
            ps.setTime(2, java.sql.Time.valueOf(funcion.getHora()));
            ;
            ps.setInt(3, funcion.getIdFuncion());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al modificar la funcion" + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexion" + e.getMessage());
            }

        }
        return false;
    }

    @Override
    public boolean eliminar(Funcion funcion) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sqlDelete = " DELETE FROM funcion WHERE idFuncion = ?";
        try {
            ps = con.prepareStatement(sqlDelete);
            ps.setInt(1, funcion.getIdFuncion());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar el funcion" + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexion" + e.getMessage());
            }
        }
        return false;
    }
}
