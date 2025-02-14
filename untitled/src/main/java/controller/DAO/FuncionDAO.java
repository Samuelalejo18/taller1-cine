package controller.DAO;

import model.Funcion;
import model.Pelicula;
import model.Sala;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static utils.Conexion.getConexion;

public class FuncionDAO implements IGenericDAO<Funcion> {
    @Override
    public List<Funcion> listarTodos() {
        List<Funcion> funciones = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = null;
        try {
            con = getConexion();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String sqlSelect = "SELECT * FROM funcion f inner join pelicula p on p.idPelicula= f.idPelicula inner join sala s on s.idSala= f.idSala";
        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();
            while (rs.next()) {
                Funcion funcion = new Funcion();
                funcion.setIdFuncion(rs.getInt("idFuncion"));
                funcion.setDia(rs.getDate("dia").toLocalDate());
                funcion.setHora(rs.getTime("hora").toLocalTime());
                //Pelicula
                int idPelicula = rs.getInt("idPelicula");
                double duracion = rs.getInt("duracion");
                String paisOrigen = rs.getString("paisOrigen");
                int anno = rs.getInt("anno");
                String titulo = rs.getString("titulo");
                String idioma = rs.getString("idioma");
                String sinopsis = rs.getString("sinopsis");
                String genero = rs.getString("genero");
                String tipo = rs.getString("tipo");
                funcion.setPelicula(new Pelicula(idPelicula, duracion, paisOrigen, anno, titulo, idioma, sinopsis, tipo, genero));

                //Sala
                int idSala = rs.getInt("idSala");
                int numeroSala = rs.getInt("numeroSala");
                String nombreSala = rs.getString("nombreSala");
                int cantidadSilla = rs.getInt("cantidad_sillas");
                int filas = rs.getInt("filas");
                int columnas = rs.getInt("columnas");
                funcion.setSala(new Sala(idSala, numeroSala, nombreSala, cantidadSilla, filas, columnas));


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
        Connection con = null;
        try {
            con = getConexion();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // ? parametros posicionales
        String sql = "SELECT * FROM funcion f inner join pelicula p on p.idPelicula= f.idPelicula inner join sala s on s.idSala= f.idSala WHERE idFuncion= ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, funcion.getIdFuncion());
            rs = ps.executeQuery();
            if (rs.next()) {

                funcion.setDia(rs.getDate("dia").toLocalDate());
                funcion.setHora(rs.getTime("hora").toLocalTime());
                //Pelicula
                int idPelicula = rs.getInt("idPelicula");
                double duracion = rs.getInt("duracion");
                String paisOrigen = rs.getString("paisOrigen");
                int anno = rs.getInt("anno");
                String titulo = rs.getString("titulo");
                String idioma = rs.getString("idioma");
                String sinopsis = rs.getString("sinopsis");
                String genero = rs.getString("genero");
                String tipo = rs.getString("tipo");
                funcion.setPelicula(new Pelicula(idPelicula, duracion, paisOrigen, anno, titulo, idioma, sinopsis, tipo, genero));

                //Sala
                int idSala = rs.getInt("idSala");
                int numeroSala = rs.getInt("numeroSala");
                String nombreSala = rs.getString("nombreSala");
                int cantidadSilla = rs.getInt("cantidad_sillas");
                int filas = rs.getInt("filas");
                int columnas = rs.getInt("columnas");
                funcion.setSala(new Sala(idSala, numeroSala, nombreSala, cantidadSilla, filas, columnas));


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
        Connection con = null;
        try {
            con = getConexion();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // ? parametros posicionales
        String sqlCreateFuncion = "INSERT INTO funcion  (dia,hora, idSala,idPelicula) "
                + "VALUES (?, ?,?,?)";
        try {
            ps = con.prepareStatement(sqlCreateFuncion);
            // Set 'dia' (LocalDate) in PreparedStatement
            ps.setDate(1, java.sql.Date.valueOf(funcion.getDia())); // Convert LocalDate to java.sql.Date

            // Set 'hora' (LocalTime) in PreparedStatement
            ps.setTime(2, java.sql.Time.valueOf(funcion.getHora()));
            ps.setInt(4, funcion.getPelicula().getIdPelicula());
            ps.setInt(3, funcion.getSala().getIdSala());


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
        Connection con = null;
        try {
            con = getConexion();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // ? parametros posicionales
        String sqlUpdate = "UPDATE  funcion SET dia= ?, hora =? ,idSala=?, idPelicula=? " + " WHERE idFuncion = ?";
        try {

            ps = con.prepareStatement(sqlUpdate);
            ps.setDate(1, java.sql.Date.valueOf(funcion.getDia())); // Convert LocalDate to java.sql.Date

            // Set 'hora' (LocalTime) in PreparedStatement
            ps.setTime(2, java.sql.Time.valueOf(funcion.getHora()));
            ps.setInt(3, funcion.getSala().getIdSala());
            ps.setInt(4, funcion.getPelicula().getIdPelicula());

            ps.setInt(5, funcion.getIdFuncion());
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
        Connection con = null;
        try {
            con = getConexion();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
/*
    public static void main(String[] args) {
        FuncionDAO dao = new FuncionDAO();

        System.out.println("*** Listar cines ***");
        List<Funcion> funciones = dao.listarTodos();
        funciones.forEach(System.out::println);
        // Buscar actor por ID
        Funcion funcion = new Funcion(1);

        System.out.println("Actor antes de la búsqueda: " + funcion);
        boolean encontrado = dao.buscarPorId(funcion);
        if (encontrado)
            System.out.println("Actor encontrado: " + funcion);
        else
            System.out.println("No se encontró el actor: " + funcion);

/*
        // Agregar un actor - INSERT

        Funcion funcion2 = new Funcion();
        funcion2.setDia(LocalDate.of(2025, 2, 9));
        funcion2.setHora(LocalTime.of(20, 30));
        funcion2.setSala(new Sala(30));
        funcion2.setPelicula(new Pelicula(6));
        boolean agregado = dao.agregar(funcion);
        if (agregado)
            System.out.println("Actor agregado: " + funcion2);
        else
            System.out.println("No se agregó el actor");
*/
        // Modificar un actor - UPDATE
/*
        Funcion funcion3 = new Funcion(46);
        funcion3.setDia(LocalDate.of(2024, 6, 30));
        funcion3.setHora(LocalTime.of(15, 30));
        funcion3.setSala(new Sala(20));
        funcion3.setPelicula(new Pelicula(4));

        boolean modificado = dao.modificar(funcion3);
        if (modificado)
            System.out.println("Actor modificado: " +funcion3);
        else
            System.out.println("No se modificó el actor");

        */
        /*
        // Eliminar un actor - DELETE
        Funcion funcion4 = new Funcion(47);

        boolean eliminado = dao.eliminar(funcion4);
        if (eliminado)
            System.out.println("Actor eliminado: " + funcion4);
        else
            System.out.println("No se eliminó el actor");

    }
*/

}
