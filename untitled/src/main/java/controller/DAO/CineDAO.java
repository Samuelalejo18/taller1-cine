package controller.DAO;

import model.Cine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static utils.Conexion.getConexion;

public class CineDAO implements IGenericDAO<Cine> {
    @Override
    public List<Cine> listarTodos() throws SQLException {
        List<Cine> cines = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = null;

        String sqlSelect = "SELECT * FROM neocine.cine ORDER BY idCine";
        try {
            con = getConexion();
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cine cine = new Cine();
                cine.setIdCine(rs.getInt("idCine"));
                cine.setNombre(rs.getString("nombre"));
                cine.setDireccion(rs.getString("direccion"));
                cine.setResennas(rs.getString("resennas"));
                cine.setTelefono(rs.getString("telefono"));
                cines.add(cine);
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
        return cines;
    }

    @Override
    public boolean buscarPorId(Cine cine) throws SQLException {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = null;

        // ? parametros posicionales
        String sql = "SELECT * FROM cine WHERE idCine= ?";
        try {
            con = getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cine.getIdCine());
            rs = ps.executeQuery();
            if (rs.next()) {
                cine.setNombre(rs.getString("nombre"));
                cine.setDireccion(rs.getString("direccion"));
                cine.setResennas(rs.getString("resennas"));
                cine.setTelefono(rs.getString("telefono"));
                return true;
            }
        } catch (Exception e) {
            throw new SQLException("Error al buscar el empleado por id");
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
    public boolean agregar(Cine cine) throws SQLException {
        String sql = "INSERT INTO Cine(nombre, direccion, resennas, telefono) VALUES(?, ?, ?, ?)";

        try (Connection con = getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cine.getNombre());
            ps.setString(2, cine.getDireccion());
            ps.setString(3, cine.getResennas());
            ps.setString(4, cine.getTelefono());
            ps.execute();
            return true;

        } catch (SQLException e) {
            if (e.getSQLState().equals("23000")) { // Código de error para violación de restricción UNIQUE
                String errorMessage = e.getMessage();

                if (errorMessage.contains("cine.nombre_UNIQUE")) {

                    throw new SQLException("El nombre del cine ya está registrado.");
                } else if (errorMessage.contains("cine.telefono_UNIQUE")) {
                    throw new SQLException("El número de teléfono ya está registrado.");
                }
                return false;
            }
            throw new SQLException("Error al registrar el cine.");
        } catch (Exception e) {

            throw new RuntimeException("Error inesperado al registrar el cine.", e);
        }
    }


    @Override
    public boolean modificar(Cine cine) throws SQLException {
        PreparedStatement ps;
        Connection con = null;

        String sqlUpdate = "UPDATE cine SET nombre = ?, direccion = ?, resennas = ?, telefono = ? WHERE idCine = ?";

        try {
            con = getConexion();
            ps = con.prepareStatement(sqlUpdate);
            ps.setString(1, cine.getNombre());
            ps.setString(2, cine.getDireccion());
            ps.setString(3, cine.getResennas());
            ps.setString(4, cine.getTelefono());
            ps.setInt(5, cine.getIdCine());

            int filasAfectadas = ps.executeUpdate(); // Retorna el número de filas modificadas

            if (filasAfectadas == 0) {
                throw new SQLException("No se encontró un cine con el ID especificado.");
            }

            return true;
        } catch (SQLException e) {
            String sqlState = e.getSQLState();

            if (sqlState != null && sqlState.equals("23000")) { // Verifica que sqlState no sea null
                String errorMessage = e.getMessage();
                if (errorMessage.contains("cine.nombre_UNIQUE")) {
                    throw new SQLException("El nombre del cine ya está registrado.");
                } else if (errorMessage.contains("cine.telefono_UNIQUE")) {
                    throw new SQLException("El número de teléfono ya está registrado.");
                }
            } else if (sqlState == null) {
                throw new SQLException("Error desconocido en la base de datos: " + e.getMessage());
            }

            throw new SQLException("Error al registrar el cine.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
        @Override
    public boolean eliminar(Cine cine) throws SQLException {
        PreparedStatement ps;
        Connection con = null;
        try {
            con = getConexion();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String sqlDelete = " DELETE FROM cine WHERE idCine = ?";
        try {
            ps = con.prepareStatement(sqlDelete);
            ps.setInt(1, cine.getIdCine());
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
ViewAutenticacion view= new ViewAutenticacion(); 

        CineDAO dao = new CineDAO();

        System.out.println("*** Listar cines ***");
        List<Cine> cines = dao.listarTodos();
        cines.forEach(System.out::println);

        /*

        // Buscar por id
        Cine cine1= new Cine(1);
        System.out.println("cine antes de la busqueda: "+  cine1);
        boolean encontrado = dao.buscarPorId(cine1);
        if (encontrado)
            System.out.println("Cliente encontrado: " + cine1);
        else
            System.out.println("No se encontro cliente: " + cine1);

        //Agregar cliente - Crear- INSERT TO
        Cine cine2 = new Cine( "neo cine", "Av. Principal #123, Ciudad", "Excelente servicio y calidad de imagen", "555-1234");

        boolean agregado = dao.agregar(cine2);
        if (agregado)
            System.out.println("Cliente agregado: " + cine2);
        else
            System.out.println("No se agregi cliente: " + cine2);

        //Listar clientes


        Modificar cliente
         UPDATE




        Cine modificarCine = new Cine(1, "neo cine max", "Av. Principal #123, Ciudad", "Excelente servicio y calidad de imagen", "5554-1234");
        boolean modificado = dao.modificar(modificarCine);
        if (modificado)
            System.out.println("Cliente modificado" + modificarCine);
        else
            System.out.println("No se modifico el cliente" + modificarCine);




        Eliminar Cliente
        DELETE
         *

       Cine cine= new Cine(8);
        boolean eliminado = dao.eliminar(cine);
        if (eliminado)
            System.out.println("Cliente eliminado" + cine);
        else
            System.out.println("No se elimino el cliente" + eliminado);


*/
/*
    }
*/

}
