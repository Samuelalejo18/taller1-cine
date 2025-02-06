package controller;

import model.Cine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import static utils.Conexion.getConexion;

public class CineDAO implements IGenericDAO<Cine> {
    @Override
    public List<Cine> listarTodos() {
        List<Cine> cines = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sqlSelect = "SELECT * FROM neocine.cine ORDER BY idCine";
        try {
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
            System.out.println("Error al listar cines: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return cines;
    }

    @Override
    public boolean buscarPorId(Cine cine) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        // ? parametros posicionales
        String sql = "SELECT * FROM cine WHERE idcliente = ?";
        try {
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
    public boolean agregar(Cine cine) {
        PreparedStatement ps;
        Connection con = getConexion();
        // ? parametros posicionales
        String sqlCreate = "INSERT INTO Cine(nombre, direccion, resennas, telefono) " + " VALUES(?, ?, ?,?)";
        try {
            ps = con.prepareStatement(sqlCreate);
            ps.setString(1, cine.getNombre());
            ps.setString(2, cine.getDireccion());
            ps.setString(3, cine.getResennas());
            ps.setString(4, cine.getTelefono());

            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al agregar el cliente" + e.getMessage());
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
    public boolean modificar(Cine cine) {
        PreparedStatement ps;
        Connection con = getConexion();
        // ? parametros posicionales
        String sqlUpdate = "UPDATE  cine SET nombre = ?, direccion = ?, resennas =?, telefono = ?" + " WHERE idCine = ?";
        ;
        try {

            ps = con.prepareStatement(sqlUpdate);
            ps.setString(1, cine.getNombre());
            ps.setString(2, cine.getDireccion());
            ps.setString(3, cine.getResennas());
            ps.setString(4, cine.getTelefono());
            ps.setInt(5, cine.getIdCine());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al modificar el cliente" + e.getMessage());
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
    public boolean eliminar(Cine cine) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sqlDelete = " DELETE FROM cine WHERE idCine = ?";
        try {
            ps = con.prepareStatement(sqlDelete);
            ps.setInt(1, cine.getIdCine());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar el cliente" + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexion" + e.getMessage());
            }
        }
        return false;

    }



    public static void main(String[] args) {


        CineDAO dao = new CineDAO();
        System.out.println("*** Listar cines ***");
        List<Cine> cines = dao.listarTodos();
        cines.forEach(System.out::println);

/*
        //Listar clientes
        System.out.println("*** Listar Clientes ***");
        var clientes = clienteDao.listarClientes();
        clientes.forEach(System.out::println);
*/
        /*
        // Buscar por id
        Cliente cliente1 = new Cliente(2);
        System.out.println("Cliente antes de la busqueda: " + cliente1);
        boolean encontrado = clienteDao.buscarClientePorId(cliente1);
        if (encontrado)
            System.out.println("Cliente encontrado: " + cliente1);
        else
            System.out.println("No se encontro cliente: " + cliente1.getId());
*/
        //Agregar cliente - Crear- INSERT TO
      /*  Cliente nuevoCliente = new Cliente("Danna", "Vega", 60023);
        boolean agregado = clienteDao.agregarCliente(nuevoCliente);
        if (agregado)
            System.out.println("Cliente agregado: " + nuevoCliente);
        else
            System.out.println("No se agregi cliente: " + nuevoCliente);

        //Listar clientes
        System.out.println("*** Listar Clientes ***");
        var clientes = clienteDao.listarClientes();
        clientes.forEach(System.out::println);

        */
        /*Modificar cliente
         UPDATE
         * */
/*
        Cliente modificarCliente = new Cliente(1, "Carlos Daniel", "Ortiz", 355);
        var modificado = clienteDao.modificarCliente(modificarCliente);
        if (modificado)
            System.out.println("Cliente modificado" + modificarCliente);
        else
            System.out.println("No se modifico el cliente" + modificarCliente);


        /*Eliminar Cliente
        DELETE
         */

        /*
        Cliente clienteEliminado = new Cliente(7);
        boolean eliminado = clienteDao.eliminarCliente(clienteEliminado);
        if (eliminado)
            System.out.println("Cliente eliminado" + clienteEliminado);
        else
            System.out.println("No se elimino el cliente" + clienteEliminado);


        //Listar clientes
        System.out.println("*** Listar Clientes ***");
        var clientes = clienteDao.listarClientes();
        clientes.forEach(System.out::println);
*/

    }


}
