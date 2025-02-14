package controller.DAO;

import model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static utils.Conexion.getConexion;

public class ClienteDAO implements IGenericDAO<Cliente> {

    @Override
    public List<Cliente> listarTodos() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente ORDER BY idCliente";
        try (Connection con = getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setUsername(rs.getString("username"));
                cliente.setNombre(rs.getString("nombreCliente"));
                cliente.setEmail(rs.getString("email"));
                cliente.setNombre(rs.getString("nombreCliente"));
                cliente.setTelefono(rs.getString("telefonoCliente"));
                cliente.setDocumentoIdentidad(rs.getInt("documentoIdentidadCliente"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error");
        } finally {
            try {
                getConexion().close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return clientes;
    }

    @Override
    public boolean buscarPorId(Cliente cliente) throws SQLException {
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
            throw new SQLException("Error ak buscar el empleado por id");
        } catch (Exception e) {
            throw new RuntimeException("Error");
        }
        return false;
    }

    @Override
    public boolean agregar(Cliente cliente) throws SQLException {
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
            if (e.getSQLState().equals("23000")) { // Código de error para violación de restricción UNIQUE
                String errorMessage = e.getMessage();

                if (errorMessage.contains("cliente.email_UNIQUE")) {
                    throw new SQLException("El correo electrónico ya está registrado.");
                } else if (errorMessage.contains("cliente.username_UNIQUE")) {
                    throw new SQLException("El nombre de usuario ya está registrado.");
                } else if (errorMessage.contains("cliente.telefonoCliente_UNIQUE")) {
                    throw new SQLException("El número de teléfono ya está registrado.");
                } else if (errorMessage.contains("cliente.documentoIdentidadCliente_UNIQUE")) {
                    throw new SQLException("El documento de identidad ya está registrado.");
                }
            }
            throw new SQLException("Error al registrar el cliente.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean modificar(Cliente cliente) throws SQLException {
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
            if (e.getSQLState().equals("23000")) { // Código de error para violación de restricción UNIQUE
                String errorMessage = e.getMessage();

                if (errorMessage.contains("cliente.email_UNIQUE")) {
                    throw new SQLException("El correo electrónico ya está registrado.");
                } else if (errorMessage.contains("cliente.username_UNIQUE")) {
                    throw new SQLException("El nombre de usuario ya está registrado.");
                } else if (errorMessage.contains("cliente.telefonoCliente_UNIQUE")) {
                    throw new SQLException("El número de teléfono ya está registrado.");
                } else if (errorMessage.contains("cliente.documentoIdentidadCliente_UNIQUE")) {
                    throw new SQLException("El documento de identidad ya está registrado.");
                }
            }
            throw new SQLException("Error al modificar el cliente.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean eliminar(Cliente cliente) throws SQLException {
        String sql = "DELETE FROM cliente WHERE idCliente = ?";
        try (Connection con = getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, cliente.getIdCliente());
            ps.execute();
            return true;
        } catch (SQLException e) {
            throw new SQLException("El id no existe");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
