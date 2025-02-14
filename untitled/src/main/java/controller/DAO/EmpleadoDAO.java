package controller.DAO;

import model.Empleado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static utils.Conexion.getConexion;

public class EmpleadoDAO implements IGenericDAO<Empleado> {

    @Override
    public List<Empleado> listarTodos() throws SQLException {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT * FROM empleado ORDER BY idEmpleado";
        try (Connection con = getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setIdEmpleado(rs.getInt("idempleado"));
                empleado.setUsername(rs.getString("username"));
                empleado.setNombre(rs.getString("nombreEmpleado"));
                empleado.setEmail(rs.getString("email"));
                empleado.setPassword(rs.getString("password"));
                empleado.setNombre(rs.getString("nombreEmpleado"));
                empleado.setTelefono(rs.getString("telefonoEmpleado"));
                empleado.setDocumentoIdentidad(rs.getInt("documentoIdentidadEmpleado"));
                empleados.add(empleado);

                empleados.add(empleado);
            }
        } catch (SQLException e) {
            throw  new SQLException("Error a listar la los empleados");
        } catch (Exception e) {
            throw new RuntimeException("Error");
        }finally {

        }

        return empleados;
    }

    @Override
    public boolean buscarPorId(Empleado empleado)  throws SQLException  {
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
        }  catch (SQLException e) {
            throw  new SQLException("Error ak buscar el empleado por id");
        } catch (Exception e) {
            throw new RuntimeException("Error");
        }
        return false;
    }

    @Override
    public boolean agregar(Empleado empleado)    throws SQLException {
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
            if (e.getSQLState().equals("23000")) { // Código de error para violación de restricción UNIQUE
                String errorMessage = e.getMessage();

                if (errorMessage.contains("empleado.email_UNIQUE")) {
                    throw new SQLException("El correo electrónico ya está registrado.");
                } else if (errorMessage.contains("empleado.username_UNIQUE")) {
                    throw new SQLException("El nombre de usuario ya está registrado.");
                } else if (errorMessage.contains("empleado.telefonoEmpleado_UNIQUE")) {
                    throw new SQLException("El número de teléfono ya está registrado.");
                } else if (errorMessage.contains("empleado.documentoIdentidadEmpleado_UNIQUE")) {
                    throw new SQLException("El documento de identidad ya está registrado.");
                }
            }
            throw new SQLException("Error al registrar el empleado.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean modificar(Empleado empleado) throws Exception {
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
            if (e.getSQLState().equals("23000")) { // Código de error para violación de restricción UNIQUE
                String errorMessage = e.getMessage();

                if (errorMessage.contains("empleado.email_UNIQUE")) {
                    throw new SQLException("El correo electrónico ya está registrado.");
                } else if (errorMessage.contains("empleado.username_UNIQUE")) {
                    throw new SQLException("El nombre de usuario ya está registrado.");
                } else if (errorMessage.contains("empleado.telefonoEmpleado_UNIQUE")) {
                    throw new SQLException("El número de teléfono ya está registrado.");
                } else if (errorMessage.contains("empleado.documentoIdentidadEmpleado_UNIQUE")) {
                    throw new SQLException("El documento de identidad ya está registrado.");
                }
            }
            throw new SQLException("Error al registrar el empleado.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean eliminar(Empleado empleado)  throws SQLException {
        String sql = "DELETE FROM empleado WHERE idEmpleado = ?";
        try (Connection con = getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, empleado.getIdEmpleado());
            ps.execute();
            return true;
        } catch (SQLException e) {
            throw  new SQLException("El id no existe");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
/*
    public static void main(String[] args) {
        EmpleadoDAO empleadoDAO= new EmpleadoDAO();
        System.out.println("*** Listar cines ***");
        List<Empleado> cines = empleadoDAO.listarTodos();
        cines.forEach(System.out::println);
    }
*/
}

