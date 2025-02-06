package controller;

import model.Pelicula;
import model.Pelicula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static utils.Conexion.getConexion;

public class PeliculaDAO implements  IGenericDAO<Pelicula>{
    @Override
    public List<Pelicula> listarTodos() {
        List<Pelicula> Peliculas = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
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
                Peliculas.add(pelicula);
            }
        } catch (Exception e) {
            System.out.println("Error al listar Peliculas: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return Peliculas;
    }

    @Override
    public boolean buscarPorId(Pelicula pelicula) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
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
        } catch (Exception e) {
            System.out.println("Error al recuperar cine por id: " + e.getMessage());
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
    public boolean agregar(Pelicula entidad) {
        PreparedStatement ps;
        Connection con = getConexion();
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
            System.out.println("Error al agregar la pelicula" + e.getMessage());
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
    public boolean modificar(Pelicula entidad) {
        PreparedStatement ps;
        Connection con = getConexion();
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
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al modificar  la pelicula" + e.getMessage());
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
    public boolean eliminar(Pelicula pelicula) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sqlDelete = " DELETE FROM pelicula WHERE idPelicula = ?";
        try {
            ps = con.prepareStatement(sqlDelete);
            ps.setInt(1, pelicula.getIdPelicula());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar la pelicula" + e.getMessage());
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
