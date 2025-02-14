package controller.DAO;

import model.Cine;
import model.Sala;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static utils.Conexion.getConexion;

public class SalaDAO implements IGenericDAO<Sala> {

    @Override
    public List<Sala> listarTodos() {
        List<Sala> salas = new ArrayList<>();
        PreparedStatement ps;
        CineDAO cineDAO = null;
        ResultSet rs;
        Connection con = null;
        try {
            con = getConexion();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String sqlSelect = "SELECT * FROM sala s inner join cine c on c.idCine= s.idCine ORDER BY idSala";
        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();
            while (rs.next()) {
                Sala sala = new Sala();
                sala.setIdSala(rs.getInt("idSala"));
                sala.setNumero(rs.getInt("numeroSala"));
                sala.setNombre(rs.getString("nombreSala"));
                sala.setCantidadSilla(rs.getInt("cantidad_sillas"));
                sala.setFilas(rs.getInt("filas"));
                sala.setColumnas(rs.getInt("columnas"));
                int idCine = rs.getInt("idCine");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String resennas = rs.getString("resennas");
                String telefono = rs.getString("telefono");
                sala.setCine(new Cine(idCine, nombre, direccion, resennas, telefono));

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
        Connection con = null;
        try {
            con = getConexion();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String sql = "SELECT * FROM sala s inner join cine c on c.idCine= s.idCine WHERE idSala = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, sala.getIdSala());
            rs = ps.executeQuery();
            if (rs.next()) {

                sala.setNumero(rs.getInt("numeroSala"));
                sala.setNombre(rs.getString("nombreSala"));
                sala.setCantidadSilla(rs.getInt("cantidad_sillas"));
                sala.setFilas(rs.getInt("filas"));
                sala.setColumnas(rs.getInt("columnas"));
                int idCine = rs.getInt("idCine");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String resennas = rs.getString("resennas");
                String telefono = rs.getString("telefono");
                sala.setCine(new Cine(idCine, nombre, direccion, resennas, telefono));

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
        Connection con = null;
        try {
            con = getConexion();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String sqlCreate = "INSERT INTO sala (numeroSala, nombreSala, cantidad_sillas, filas, columnas, idCine) VALUES (?, ?, ?, ?, ?, ?)";
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
        Connection con = null;
        try {
            con = getConexion();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String sqlUpdate = "UPDATE sala SET numeroSala = ?, nombreSala = ?,cantidad_sillas = ?, filas = ?, columnas = ?, idCine = ? WHERE idSala = ?";
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
        Connection con = null;
        try {
            con = getConexion();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
/*
    public static void main(String[] args) {
        SalaDAO salaDAO = new SalaDAO();
/*
        // Listar todas las salas
        System.out.println("*** Listar salas ***");
        List<Sala> salas = salaDAO.listarTodos();
        salas.forEach(System.out::println);
*/
/*
        // Buscar sala por ID
        Sala sala = new Sala(19);


        System.out.println("Sala antes de la búsqueda: " + sala);
        boolean encontrada = salaDAO.buscarPorId(sala);
        if (encontrada)
            System.out.println("Sala encontrada: " + sala);
        else
            System.out.println("No se encontró la sala: " + sala);
*/
/*
        // Agregar una nueva sala
        Sala nuevaSala = new Sala();
        nuevaSala.setNumero(4);
        nuevaSala.setNombre("Sala VIP");
        nuevaSala.setCantidadSilla(100);
        nuevaSala.setFilas(10);
        nuevaSala.setColumnas(10);
        nuevaSala.setCine(new Cine(1));

        boolean agregada = salaDAO.agregar(nuevaSala);
        if (agregada)
            System.out.println("Sala agregada: " + nuevaSala);
        else
            System.out.println("No se agregó la sala");


 */
        /*
        // Modificar una sala existente
        Sala salaModificar = new Sala();
        salaModificar.setIdSala(2); // ID de la sala a modificar
        salaModificar.setNumero(8);
        salaModificar.setNombre("Sala 3D");
        salaModificar.setCantidadSilla(150);
        salaModificar.setFilas(15);
        salaModificar.setColumnas(10);
        salaModificar.setCine(new Cine(1, "Cinepolis", "Calle 123", "Buena atención", "123456789"));

        boolean modificada = salaDAO.modificar(salaModificar);
        if (modificada)
            System.out.println("Sala modificada: " + salaModificar);
        else
            System.out.println("No se modificó la sala");
*/
  /*
        // Eliminar una sala
        Sala salaEliminar = new Sala();
        salaEliminar.setIdSala(37); // ID de la sala a eliminar

        boolean eliminada = salaDAO.eliminar(salaEliminar);
        if (eliminada)
            System.out.println("Sala eliminada: " + salaEliminar);
        else
            System.out.println("No se eliminó la sala");


    }
*/

}

