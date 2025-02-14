package controller.DAO;

import model.Pelicula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static utils.Conexion.getConexion;

public class PeliculaDAO implements IGenericDAO<Pelicula> {
    @Override
    public List<Pelicula> listarTodos() throws SQLException {
        List<Pelicula> peliculas = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = null;
        try {
            con = getConexion();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String sqlSelect = "SELECT * FROM neocine.Pelicula ORDER BY idPelicula";
        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();
            while (rs.next()) {
                Pelicula pelicula = new Pelicula();

                pelicula.setIdPelicula(rs.getInt("idPelicula"));
                pelicula.setDuracion(rs.getInt("duracion"));
                pelicula.setPaisOrigen(rs.getString("paisOrigen"));
                pelicula.setAnno(rs.getInt("anno"));
                pelicula.setTitulo(rs.getString("titulo"));
                pelicula.setIdioma(rs.getString("idioma"));
                pelicula.setSinopsis(rs.getString("sinopsis"));
                pelicula.setGenero(rs.getString("genero"));
                pelicula.setTipo(rs.getString("tipo"));
                peliculas.add(pelicula);
            }
        } catch (Exception e) {
            throw new SQLException(e);
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                throw new SQLException(e);
            }
        }
        return peliculas;
    }

    @Override
    public boolean buscarPorId(Pelicula pelicula) throws SQLException {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = null;
        try {
            con = getConexion();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // ? parametros posicionales
        String sql = "SELECT * FROM pelicula WHERE idPelicula = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pelicula.getIdPelicula());
            rs = ps.executeQuery();
            if (rs.next()) {
                pelicula.setDuracion(rs.getInt("duracion"));
                pelicula.setPaisOrigen(rs.getString("paisOrigen"));
                pelicula.setAnno(rs.getInt("anno"));
                pelicula.setTitulo(rs.getString("titulo"));
                pelicula.setIdioma(rs.getString("idioma"));
                pelicula.setSinopsis(rs.getString("sinopsis"));
                pelicula.setGenero(rs.getString("genero"));
                pelicula.setTipo(rs.getString("tipo"));
                return true;
            }
        }catch (Exception e) {
            throw new SQLException("Error al buscar la pelicula por id");
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                throw new SQLException("Error al cerrar la conexion");
            }
        }
        return false;
    }

    @Override
    public boolean agregar(Pelicula entidad) throws SQLException {
        PreparedStatement ps;
        Connection con = null;
        try {
            con = getConexion();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // ? parametros posicionales
        String sqlCreateMovie = "INSERT INTO pelicula  (titulo, duracion, paisOrigen, anno, idioma, sinopsis, tipo, genero) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sqlCreateMovie);
         ps.setString(1, entidad.getTitulo());
         ps.setDouble(2, entidad.getDuracion());
         ps.setString(3, entidad.getPaisOrigen());
         ps.setInt(4, entidad.getAnno());
         ps.setString(5, entidad.getIdioma());
         ps.setString(6, entidad.getSinopsis());
         ps.setString(7, entidad.getTipo());
         ps.setString(8, entidad.getGenero());

            ps.execute();
            return true;
        } catch (Exception e) {
            throw new SQLException("Error al agregar la pelicula");
        } finally {

            try {
                con.close();
            } catch (SQLException e) {
                throw new SQLException("Error al cerrar la conexion");
            }
        }

    }

    @Override
    public boolean modificar(Pelicula entidad) throws SQLException {
        PreparedStatement ps;
        Connection con = null;
        try {
            con = getConexion();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // ? parametros posicionales
        String sqlUpdateMovie = "UPDATE pelicula "
                + "SET titulo = ?, duracion = ?, paisOrigen = ?, anno = ?, idioma = ?, sinopsis = ?, tipo = ?, genero = ? "
                + "WHERE idPelicula = ?";
        try {

            ps = con.prepareStatement(sqlUpdateMovie);
            ps.setString(1, entidad.getTitulo());
            ps.setDouble(2, entidad.getDuracion());
            ps.setString(3, entidad.getPaisOrigen());
            ps.setInt(4, entidad.getAnno());
            ps.setString(5, entidad.getIdioma());
            ps.setString(6, entidad.getSinopsis());
            ps.setString(7, entidad.getTipo());
            ps.setString(8, entidad.getGenero());
            ps.setInt(9, entidad.getIdPelicula());
            ps.execute();

            int filasAfectadas = ps.executeUpdate(); // Retorna el número de filas modificadas

            if (filasAfectadas == 0) {
                throw new SQLException("No se encontró la pelicula con el ID especificado.");
            }


            return true;
        } catch (Exception e) {

            throw new SQLException("Error al modificar la pelicula");
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new SQLException("Error al cerrar la conexion");
            }

        }
    }

    @Override
    public boolean eliminar(Pelicula pelicula) throws SQLException {
        PreparedStatement ps;
        Connection con = null;
        try {
            con = getConexion();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String sqlDelete = " DELETE FROM pelicula WHERE idPelicula = ?";
        try {
            ps = con.prepareStatement(sqlDelete);
            ps.setInt(1, pelicula.getIdPelicula());
            ps.execute();
            return true;
        } catch (Exception e) {
            throw new SQLException("Error al eliminar el cine.");
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new SQLException("Error al cerrar la conexion");
            }
        }
    }

    /*
    public static void main(String[] args) {
        PeliculaDAO dao = new PeliculaDAO();

        System.out.println("*** Listar Películas ***");
        List<Pelicula> peliculas = dao.listarTodos();
        peliculas.forEach(System.out::println);
/*
        // Buscar película por ID
        Pelicula pelicula1 = new Pelicula();
        pelicula1.setIdPelicula(1);
        System.out.println("\nPelícula antes de la búsqueda: " + pelicula1);
        boolean encontrada = dao.buscarPorId(pelicula1);
        if (encontrada)
            System.out.println("Película encontrada: " + pelicula1);
        else
            System.out.println("No se encontró la película con ID 1.");
*/

/*
        // Agregar una película - INSERT
        Pelicula pelicula2 =new Pelicula(120, "EE.UU.", 2024, "Dune: Parte Dos",
                "Inglés", "El épico viaje de Paul Atreides continúa.",
                "Ciencia Ficción", "Acción");

        boolean agregada = dao.agregar(pelicula2);
        if (agregada)
            System.out.println("\nPelícula agregada: " + pelicula2);
        else
            System.out.println("\nNo se agregó la película.");
*/

/*
        // Modificar una película - UPDATE
        Pelicula modificarPelicula =new Pelicula(180, "estados unidos", 2024, "Dune: Parte tres",
                "Inglés", "El épico viaje de Paul Atreides continúa.",
                "Ciencia Ficción", "Acción");
        modificarPelicula.setIdPelicula(10); // ID de la película a modificar
        boolean modificada = dao.modificar(modificarPelicula);
        if (modificada)
            System.out.println("\nPelícula modificada: " + modificarPelicula);
        else
            System.out.println("\nNo se modificó la película.");

        // Eliminar una película - DELETE
        Pelicula peliculaEliminar = new Pelicula();
        peliculaEliminar.setIdPelicula(10); // ID de la película a eliminar
        boolean eliminada = dao.eliminar(peliculaEliminar);
        if (eliminada)
            System.out.println("\nPelícula eliminada con ID: " + peliculaEliminar.getIdPelicula());
        else
            System.out.println("\nNo se eliminó la película.");


    }
*/


}
