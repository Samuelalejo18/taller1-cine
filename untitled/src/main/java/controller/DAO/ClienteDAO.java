package controller.DAO;

import model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static utils.Conexion.getConexion;

public class ClienteDAO implements IGenericDAO<Cliente> {

    @Override
    public List<Cliente> listarTodos() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente ORDER BY idCliente";
        try (Connection con = getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setUsername(rs.getString("username"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setEmail(rs.getString("email"));
                cliente.setNombre(rs.getString("nombreCliente"));
                cliente.setTelefono(rs.getString("telefonoCliente"));
                cliente.setDocumentoIdentidad(rs.getInt("documentoIdentidadCliente"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar clientes: " + e.getMessage());
        }
        return clientes;
    }

    @Override
    public boolean buscarPorId(Cliente cliente) {
        String sql = "SELECT * FROM cliente WHERE idCliente = ?";
        try (Connection con = getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, cliente.getIdCliente());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cliente.setUsername(rs.getString("username"));
                    cliente.setEmail(rs.getString("email"));
                    cliente.setNombre(rs.getString("nombreCliente"));
                    cliente.setTelefono(rs.getString("telefonoCliente"));
                    cliente.setDocumentoIdentidad(rs.getInt("documentoIdentidadCliente"));
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar cliente por ID: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean agregar(Cliente cliente) {
        String sql = "INSERT INTO cliente(username, email, nombreCliente, telefonoCliente, documentoIdentidadCliente) VALUES(?, ?, ?, ?, ?)";
        try (Connection con = getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cliente.getUsername());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getNombre());
            ps.setString(4, cliente.getTelefono());
            ps.setInt(5, cliente.getDocumentoIdentidad());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al agregar cliente: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean modificar(Cliente cliente) {
        String sql = "UPDATE cliente SET username = ?, email = ?, nombreCliente = ?, telefonoCliente = ?, documentoIdentidadCliente = ? WHERE idCliente = ?";
        try (Connection con = getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cliente.getUsername());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getNombre());
            ps.setString(4, cliente.getTelefono());
            ps.setInt(5, cliente.getDocumentoIdentidad());
            ps.setInt(6, cliente.getIdCliente());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al modificar cliente: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean eliminar(Cliente cliente) {
        String sql = "DELETE FROM cliente WHERE idCliente = ?";
        try (Connection con = getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, cliente.getIdCliente());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
        }
        return false;
    }
}
