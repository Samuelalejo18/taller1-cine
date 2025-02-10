package controller.DAO;

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
                director.setCantidadPeliculasRealizadas(rs.getInt("cantidadDePeliculasRealizadas"));
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
                director.setCantidadPeliculasRealizadas(rs.getInt("cantidadDePeliculasRealizadas"));
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
        String sqlCreate = "INSERT INTO director(nombre, nacionalidad, cantidadDePeliculasRealizadas) VALUES(?, ?, ?)";
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
        String sqlUpdate = "UPDATE director SET nombre = ?, nacionalidad = ?, cantidadDePeliculasRealizadas = ? WHERE idDirector = ?";
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

/*
    public static void main(String[] args) {


        DirectorDAO dao = new DirectorDAO();
/*
        System.out.println("*** Listar cines ***");
        List<Director> directores = dao.listarTodos();
        directores.forEach(System.out::println);
*/
/*

    // Buscar actor por ID
    Director director = new Director(11);
    System.out.println("Actor antes de la búsqueda: " +  director);
    boolean encontrado = dao.buscarPorId( director);
    if (encontrado)
        System.out.println("Director encontrado: " + director);
    else
        System.out.println("No se encontró el actor: " +  director);



    // Agregar un actor - INSERT
        Director nuevoDirector = new Director("Francis Ford Coppola", "Estadounidense", 14);

        boolean agregado = dao.agregar( nuevoDirector);
    if (agregado)
        System.out.println("Director agregado: " +  nuevoDirector);
    else
        System.out.println("No se agregó el director");

*/
/*
    // Modificar un actor - UPDATE
        Director nuevoDirector1 = new Director("Francis Ford Coppola", "Estadounidense", 15,11);

    boolean modificado = dao.modificar(nuevoDirector1 );
    if (modificado)
        System.out.println("Director modificado: " + nuevoDirector1 );
    else
        System.out.println("No se modificó el actor");
*/

/*
        // Eliminar un actor - DELETE
        Director directorEliminado = new Director(11);

        boolean eliminado = dao.eliminar(directorEliminado);
        if (eliminado)
            System.out.println("Actor eliminado: " + directorEliminado);
        else
            System.out.println("No se eliminó el actor");

    }

*/
}

