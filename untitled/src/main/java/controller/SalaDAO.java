package controller;

import model.Cine;
import model.Sala;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static utils.Conexion.getConexion;

public class SalaDAO implements  IGenericDAO<Sala>{

    @Override
    public List<Sala> listarTodos() {
        List<Sala> salas = new ArrayList<>();
        PreparedStatement ps;
        CineDAO cineDAO = null;
        ResultSet rs;
        Connection con = getConexion();
        String sqlSelect = "SELECT * FROM sala ORDER BY idSala";
        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();
            while (rs.next()) {
                Sala sala = new Sala();
                sala.setIdSala(rs.getInt("idSala"));
                sala.setNumero(rs.getInt("numero"));
                sala.setNombre(rs.getString("nombre"));
                sala.setCantidadSilla(rs.getInt("cantidadSilla"));
                sala.setFilas(rs.getInt("filas"));
                sala.setColumnas(rs.getInt("columnas"));

                // Si quieres establecer el cine de la sala, puedes obtenerlo y asignarlo aquí
                // Por ejemplo, si tienes un objeto CineDAO, puedes hacer:

                salas.add(sala);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar salas: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return salas;
    }

    @Override
    public boolean buscarPorId(Sala sala) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * FROM sala WHERE idSala = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, sala.getIdSala());
            rs = ps.executeQuery();
            if (rs.next()) {
                sala.setNumero(rs.getInt("numero"));
                sala.setNombre(rs.getString("nombre"));
                sala.setCantidadSilla(rs.getInt("cantidadSilla"));
                sala.setFilas(rs.getInt("filas"));
                sala.setColumnas(rs.getInt("columnas"));
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error al recuperar sala por id: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean agregar(Sala sala) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sqlCreate = "INSERT INTO sala (numero, nombre, cantidadSilla, filas, columnas, idCine) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sqlCreate);
            ps.setInt(1, sala.getNumero());
            ps.setString(2, sala.getNombre());
            ps.setInt(3, sala.getCantidadSilla());
            ps.setInt(4, sala.getFilas());
            ps.setInt(5, sala.getColumnas());
            ps.setInt(6, sala.getCine().getIdCine()); // Relación con el cine

            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al agregar la sala: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean modificar(Sala sala) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sqlUpdate = "UPDATE sala SET numero = ?, nombre = ?, cantidadSilla = ?, filas = ?, columnas = ?, idCine = ? WHERE idSala = ?";
        try {
            ps = con.prepareStatement(sqlUpdate);
            ps.setInt(1, sala.getNumero());
            ps.setString(2, sala.getNombre());
            ps.setInt(3, sala.getCantidadSilla());
            ps.setInt(4, sala.getFilas());
            ps.setInt(5, sala.getColumnas());
            ps.setInt(6, sala.getCine().getIdCine()); // Relación con el cine
            ps.setInt(7, sala.getIdSala());

            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al modificar la sala: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean eliminar(Sala sala) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sqlDelete = "DELETE FROM sala WHERE idSala = ?";
        try {
            ps = con.prepareStatement(sqlDelete);
            ps.setInt(1, sala.getIdSala());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar la sala: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return false;
    }
}

