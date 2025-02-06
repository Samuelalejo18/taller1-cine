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
    public boolean agregar(Object entidad) {
        return false;
    }

    @Override
    public boolean modificar(Object entidad) {
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        return false;
    }

    public static void main(String[] args) {
        CineDAO dao = new CineDAO();
        System.out.println("*** Listar cines ***");
        List<Cine> cines = dao.listarTodos();
        cines.forEach(System.out::println);
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
    public boolean modificarCine(Cine cine) {
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
    public boolean eliminarCine(Cine cine) {
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
}
