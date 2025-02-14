package controller.DAO;

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
        Connection con = null;
        try {
            con = getConexion();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String sqlSelect = "SELECT * FROM actor ORDER BY idActor";
        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();
            while (rs.next()) {
                Actor actor = new Actor();
                actor.setIdActor(rs.getInt("idActor"));
                actor.setNombre(rs.getString("nombre"));
                actor.setNacionalidad(rs.getString("nacionalidad"));
                actor.setCantidadPeliculasRealizadas(rs.getInt("cantidadDePeliculasRealizadas"));
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
        Connection con = null;
        try {
            con = getConexion();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String sql = "SELECT * FROM actor WHERE idActor = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, actor.getIdActor());
            rs = ps.executeQuery();
            if (rs.next()) {
                actor.setNombre(rs.getString("nombre"));
                actor.setNacionalidad(rs.getString("nacionalidad"));
                actor.setCantidadPeliculasRealizadas(rs.getInt("cantidadDePeliculasRealizadas"));
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
        Connection con = null;
        try {
            con = getConexion();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String sqlCreate = "INSERT INTO actor(nombre, nacionalidad, cantidadDePeliculasRealizadas) VALUES(?, ?, ?)";
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
        Connection con = null;
        try {
            con = getConexion();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String sqlUpdate = "UPDATE actor SET nombre = ?, nacionalidad = ?, cantidadDePeliculasRealizadas = ? WHERE idActor = ?";
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
        Connection con = null;
        try {
            con = getConexion();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
/*
    public static void main(String[] args) {


        ActorDAO dao = new ActorDAO();

        System.out.println("*** Listar cines ***");
        List<Actor> actores = dao.listarTodos();
        actores.forEach(System.out::println);
*/
/*

    // Buscar actor por ID
    Actor actor1 = new Actor();
    actor1.setIdActor(1);
    System.out.println("Actor antes de la búsqueda: " + actor1);
    boolean encontrado = dao.buscarPorId(actor1);
    if (encontrado)
        System.out.println("Actor encontrado: " + actor1);
    else
        System.out.println("No se encontró el actor: " + actor1);
*/

/*
    // Agregar un actor - INSERT
    Actor actor2 = new Actor("Tom Hanks", "Estadounidense", 70);
    boolean agregado = dao.agregar(actor2);
    if (agregado)
        System.out.println("Actor agregado: " + actor2);
    else
        System.out.println("No se agregó el actor");
*/

/*
    // Modificar un actor - UPDATE
    Actor modificarActor = new Actor("Tom Hanks", "Estadounidense", 75,12);
    boolean modificado = dao.modificar(modificarActor);
    if (modificado)
        System.out.println("Actor modificado: " + modificarActor);
    else
        System.out.println("No se modificó el actor");
*/

/*
    // Eliminar un actor - DELETE
    Actor actorEliminar = new Actor(12);

    boolean eliminado = dao.eliminar(actorEliminar);
    if (eliminado)
        System.out.println("Actor eliminado: " + actorEliminar);
    else
        System.out.println("No se eliminó el actor");

    }
*/
}


