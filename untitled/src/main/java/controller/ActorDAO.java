package controller;

import model.Actor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static utils.Conexion.getConexion;

public class ActorDAO implements IGenericDAO<Actor> {

    @Override
    public List<Actor> listarTodos() {
        List<Actor> actores = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sqlSelect = "SELECT * FROM actor ORDER BY idActor";
        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();
            while (rs.next()) {
                Actor actor = new Actor();
                actor.setIdActor(rs.getInt("idActor"));
                actor.setNombre(rs.getString("nombre"));
                actor.setNacionalidad(rs.getString("nacionalidad"));
                actor.setCantidadPeliculasRealizadas(rs.getInt("cantidadPeliculasRealizadas"));
                actores.add(actor);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar actores: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return actores;
    }

    @Override
    public boolean buscarPorId(Actor actor) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * FROM actor WHERE idActor = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, actor.getIdActor());
            rs = ps.executeQuery();
            if (rs.next()) {
                actor.setNombre(rs.getString("nombre"));
                actor.setNacionalidad(rs.getString("nacionalidad"));
                actor.setCantidadPeliculasRealizadas(rs.getInt("cantidadPeliculasRealizadas"));
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error al recuperar actor por id: " + e.getMessage());
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
    public boolean agregar(Actor actor) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sqlCreate = "INSERT INTO actor(nombre, nacionalidad, cantidadPeliculasRealizadas) VALUES(?, ?, ?)";
        try {
            ps = con.prepareStatement(sqlCreate);
            ps.setString(1, actor.getNombre());
            ps.setString(2, actor.getNacionalidad());
            ps.setInt(3, actor.getCantidadPeliculasRealizadas());

            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al agregar el actor: " + e.getMessage());
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
    public boolean modificar(Actor actor) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sqlUpdate = "UPDATE actor SET nombre = ?, nacionalidad = ?, cantidadPeliculasRealizadas = ? WHERE idActor = ?";
        try {
            ps = con.prepareStatement(sqlUpdate);
            ps.setString(1, actor.getNombre());
            ps.setString(2, actor.getNacionalidad());
            ps.setInt(3, actor.getCantidadPeliculasRealizadas());
            ps.setInt(4, actor.getIdActor());

            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al modificar el actor: " + e.getMessage());
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
    public boolean eliminar(Actor actor) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sqlDelete = "DELETE FROM actor WHERE idActor = ?";
        try {
            ps = con.prepareStatement(sqlDelete);
            ps.setInt(1, actor.getIdActor());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el actor: " + e.getMessage());
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