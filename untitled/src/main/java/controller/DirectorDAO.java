package controller;

import model.Cine;
import model.Director;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static utils.Conexion.getConexion;

public class DirectorDAO implements IGenericDAO<Director> {



    @Override
    public List<Director> listarTodos() {
        List<Director> directores = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sqlSelect = "SELECT * FROM director ORDER BY idDirector";
        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();
            while (rs.next()) {
                Director director = new Director();
                director.setIdDirector(rs.getInt("idDirector"));
                director.setNombre(rs.getString("nombre"));
                director.setNacionalidad(rs.getString("nacionalidad"));
                director.setCantidadPeliculasRealizadas(rs.getInt("cantidadPeliculasRealizadas"));
                directores.add(director);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar directores: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return directores;
    }

    @Override
    public boolean buscarPorId(Director director) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * FROM director WHERE idDirector = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, director.getIdDirector());
            rs = ps.executeQuery();
            if (rs.next()) {
                director.setNombre(rs.getString("nombre"));
                director.setNacionalidad(rs.getString("nacionalidad"));
                director.setCantidadPeliculasRealizadas(rs.getInt("cantidadPeliculasRealizadas"));
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error al recuperar director por id: " + e.getMessage());
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
    public boolean agregar(Director director) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sqlCreate = "INSERT INTO director(nombre, nacionalidad, cantidadPeliculasRealizadas) VALUES(?, ?, ?)";
        try {
            ps = con.prepareStatement(sqlCreate);
            ps.setString(1, director.getNombre());
            ps.setString(2, director.getNacionalidad());
            ps.setInt(3, director.getCantidadPeliculasRealizadas());

            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al agregar el director: " + e.getMessage());
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
    public boolean modificar(Director director) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sqlUpdate = "UPDATE director SET nombre = ?, nacionalidad = ?, cantidadPeliculasRealizadas = ? WHERE idDirector = ?";
        try {
            ps = con.prepareStatement(sqlUpdate);
            ps.setString(1, director.getNombre());
            ps.setString(2, director.getNacionalidad());
            ps.setInt(3, director.getCantidadPeliculasRealizadas());
            ps.setInt(4, director.getIdDirector());

            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al modificar el director: " + e.getMessage());
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
    public boolean eliminar(Director director) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sqlDelete = "DELETE FROM director WHERE idDirector = ?";
        try {
            ps = con.prepareStatement(sqlDelete);
            ps.setInt(1, director.getIdDirector());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el director: " + e.getMessage());
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

