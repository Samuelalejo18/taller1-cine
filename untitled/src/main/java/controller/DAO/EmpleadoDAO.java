package controller.DAO;

import model.Empleado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static utils.Conexion.getConexion;

public class EmpleadoDAO implements IGenericDAO<Empleado> {

    @Override
    public List<Empleado> listarTodos() {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT * FROM empleado ORDER BY idEmpleado";
        try (Connection con = getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setIdEmpleado(rs.getInt("idempleado"));
                empleado.setUsername(rs.getString("username"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setEmail(rs.getString("email"));
                empleado.setNombre(rs.getString("nombreEmpleado"));
                empleado.setTelefono(rs.getString("telefonoEmpleado"));
                empleado.setDocumentoIdentidad(rs.getInt("documentoIdentidadEmpleado"));
                empleados.add(empleado);

                empleados.add(empleado);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar empleados: " + e.getMessage());
        }
        return empleados;
    }

    @Override
    public boolean buscarPorId(Empleado empleado) {
        String sql = "SELECT * FROM empleado WHERE idEmpleado = ?";
        try (Connection con = getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, empleado.getIdEmpleado());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    empleado.setUsername(rs.getString("username"));
                    empleado.setEmail(rs.getString("email"));
                    empleado.setNombre(rs.getString("nombreEmpleado"));
                    empleado.setTelefono(rs.getString("telefonoEmpleado"));
                    empleado.setDocumentoIdentidad(rs.getInt("documentoIdentidadEmpleado"));
                    empleado.setPassword(rs.getString("password"));
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar empleado por ID: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean agregar(Empleado empleado) {
        String sql = "INSERT INTO empleado(username, email, nombreEmpleado, telefonoEmpleado, documentoIdentidadEmpleado, password) VALUES(?, ?, ?, ?, ?, ?)";
        try (Connection con = getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, empleado.getUsername());
            ps.setString(2, empleado.getEmail());
            ps.setString(3, empleado.getNombre());
            ps.setString(4, empleado.getTelefono());
            ps.setInt(5, empleado.getDocumentoIdentidad());
            ps.setString(6, empleado.getPassword());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al agregar empleado: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean modificar(Empleado empleado) {
        String sql = "UPDATE empleado SET username = ?, email = ?, nombreEmpleado = ?, telefonoEmpleado = ?, documentoIdentidadEmpleado = ?, password = ? WHERE idEmpleado = ?";
        try (Connection con = getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, empleado.getUsername());
            ps.setString(2, empleado.getEmail());
            ps.setString(3, empleado.getNombre());
            ps.setString(4, empleado.getTelefono());
            ps.setInt(5, empleado.getDocumentoIdentidad());
            ps.setString(6, empleado.getPassword());
            ps.setInt(7, empleado.getIdEmpleado());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al modificar empleado: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean eliminar(Empleado empleado) {
        String sql = "DELETE FROM empleado WHERE idEmpleado = ?";
        try (Connection con = getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, empleado.getIdEmpleado());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar empleado: " + e.getMessage());
        }
        return false;
    }
}
