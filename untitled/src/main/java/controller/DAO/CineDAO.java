package controller.DAO;

import model.Cine;
import view.ViewAutenticacion;

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
        String sql = "SELECT * FROM cine WHERE idCine= ?";
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
