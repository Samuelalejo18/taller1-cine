package controller;

import controller.DAO.ClienteDAO;
import model.Cliente;
import view.cliente.JPanelCliente;
import view.cliente.ViewActualizarCliente;
import view.cliente.ViewNuevoCliente;
import view.roundClasses.RoundButton;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;

public class ControllerCliente implements ActionListener {
    private JPanelCliente jPanelCliente;
    private JTable tableCliente;
    private JButton btnNuevoCliente;
    private JButton btnModificarCliente;
    private JButton btnEliminarCliente;
    private JButton btnIdCliente;
    private JButton btnTodosClientes;
    private Cliente clienteSeleccionado;

    private ClienteDAO clienteDAO;

    // Crear cliente
    private RoundButton btnCrearCliente;
    private RoundButton btnVolverCrearCliente;
    private ViewNuevoCliente viewNuevoCliente;

    // Modificar cliente
    private ViewActualizarCliente viewActualizarCliente;
    private RoundButton btnUpdateCliente;
    private RoundButton btnVolverModificarCliente;

    public ControllerCliente() {
        jPanelCliente = new JPanelCliente();
        clienteDAO = new ClienteDAO();
        tableCliente = jPanelCliente.getTableCliente();
        btnNuevoCliente = jPanelCliente.getBtnNuevoCliente();
        btnEliminarCliente = jPanelCliente.getBtnEliminarCliente();
        btnIdCliente = jPanelCliente.getBtnIdCliente();
        btnModificarCliente = jPanelCliente.getBtnModificarCliente();
        btnTodosClientes = jPanelCliente.getBtnTodosClientes();
        btnTodosClientes.addActionListener(this);
        btnNuevoCliente.addActionListener(this);
        btnEliminarCliente.addActionListener(this);
        btnIdCliente.addActionListener(this);
        btnModificarCliente.addActionListener(this);
        actualizarTablaCliente();

        // Crear cliente
        viewNuevoCliente = new ViewNuevoCliente();
        btnCrearCliente = viewNuevoCliente.getBtnCrearCliente();
        btnVolverCrearCliente = viewNuevoCliente.getBtnVolver();
        btnCrearCliente.addActionListener(this);
        btnVolverCrearCliente.addActionListener(this);

        // Modificar cliente
        seleccionarClienteTable();
        viewActualizarCliente = new ViewActualizarCliente();
        btnUpdateCliente = viewActualizarCliente.getBtnModificarCliente();
        btnVolverModificarCliente = viewActualizarCliente.getBtnVolverModificar();
        btnUpdateCliente.addActionListener(this);
        btnVolverModificarCliente.addActionListener(this);

        viewActualizarCliente.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                viewActualizarCliente.limpiarCampos(); // Borra la información
                clienteSeleccionado = null; // Resetea la selección
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNuevoCliente) {
            viewNuevoCliente.limpiarCampos();
            viewNuevoCliente.setVisible(true);
            viewNuevoCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        if (e.getSource() == btnVolverCrearCliente) {
            viewNuevoCliente.setVisible(false);
            viewNuevoCliente.dispose();
            viewNuevoCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            jPanelCliente.getTableCliente().removeAll();
            actualizarTablaCliente();
        }
        if (e.getSource() == btnCrearCliente) {
            crearCliente(crearClienteView());
        }

        if (e.getSource() == btnModificarCliente) {
            if (clienteSeleccionado != null) {
                viewActualizarCliente.setVisible(true);
                viewActualizarCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                viewActualizarCliente.llenarCampos(
                        clienteSeleccionado.getIdCliente(),
                        clienteSeleccionado.getUsername(),
                        clienteSeleccionado.getEmail(),
                        clienteSeleccionado.getNombre(),
                        clienteSeleccionado.getTelefono(),
                        clienteSeleccionado.getDocumentoIdentidad()
                );
            } else {
                viewActualizarCliente.limpiarCampos();
                viewActualizarCliente.setVisible(true);
                viewActualizarCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        }

        if (e.getSource() == btnUpdateCliente) {
            modificarCliente(modificarClienteView());
            clienteSeleccionado = null;
            viewActualizarCliente.limpiarCampos();
        }

        if (e.getSource() == btnVolverModificarCliente) {
            viewActualizarCliente.setVisible(false);
            viewActualizarCliente.dispose();
            viewActualizarCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            jPanelCliente.getTableCliente().removeAll();
            actualizarTablaCliente();
        }

        if (e.getSource() == btnEliminarCliente) {
            if (clienteSeleccionado != null) {
                int confirmacion = JOptionPane.showConfirmDialog(jPanelCliente, "¿Está seguro de que desea eliminar el cliente seleccionado?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    eliminarCliente(clienteSeleccionado);
                }
            } else {
                JOptionPane.showMessageDialog(jPanelCliente, "Seleccione un cliente para eliminar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }

        if (e.getSource() == btnIdCliente) {
            int idCliente = jPanelCliente.pedirId();
            Cliente cliente = new Cliente(idCliente);
            buscarPorId(cliente);
            if (idCliente == 0 || cliente == null) {
                jPanelCliente.getTableCliente().removeAll();
                actualizarTablaCliente();
            }
        }

        if (e.getSource() == btnTodosClientes) {
            jPanelCliente.getTableCliente().removeAll();
            actualizarTablaCliente();
        }
    }

    public void actualizarTablaCliente() {
        List<Cliente> clientes = null;
        try {
            clientes = clienteDAO.listarTodos();
            DefaultTableModel modelo = jPanelCliente.getModel();
            modelo.setRowCount(0); // Limpiar datos previos

            for (Cliente cliente : clientes) {
                modelo.addRow(new Object[]{
                        cliente.getIdCliente(),
                        cliente.getUsername(),
                        cliente.getEmail(),
                        cliente.getNombre(),
                        cliente.getTelefono(),
                        cliente.getDocumentoIdentidad()
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(jPanelCliente, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public Cliente seleccionarClienteTable() {
        clienteSeleccionado = null; // Objeto Cliente seleccionado

        tableCliente.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) { // Evitar eventos duplicados
                int selectedRow = tableCliente.getSelectedRow(); // Obtener la fila seleccionada
                if (selectedRow != -1) { // Si hay una fila seleccionada
                    // Obtener los valores de la fila seleccionada
                    int id = (int) tableCliente.getValueAt(selectedRow, 0);
                    String username = (String) tableCliente.getValueAt(selectedRow, 1);
                    String email = (String) tableCliente.getValueAt(selectedRow, 2);
                    String nombre = (String) tableCliente.getValueAt(selectedRow, 3);
                    String telefono = (String) tableCliente.getValueAt(selectedRow, 4);
                    int documentoIdentidad = (int) tableCliente.getValueAt(selectedRow, 5);

                    // Crear el objeto Cliente con los valores obtenidos
                    clienteSeleccionado = new Cliente(username, email, nombre, telefono, documentoIdentidad, id);
                }
            }
        });

        return clienteSeleccionado; // Retornar el cliente seleccionado
    }

    public Cliente crearClienteView() {
        // Obtener los valores usando los métodos pedir...
        String username = viewNuevoCliente.pedirUsername();
        String email = viewNuevoCliente.pedirEmail();
        String nombre = viewNuevoCliente.pedirNombreCliente();
        String telefono = viewNuevoCliente.pedirTelefono();
        int documentoIdentidad = viewNuevoCliente.pedirDocumentoIdentidad();

        // Verificar que todos los valores sean válidos (no null)
        if (username == null || email == null || nombre == null || telefono == null || documentoIdentidad == 0) {
            JOptionPane.showMessageDialog(viewNuevoCliente, "Error: Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return null; // Si algún campo es inválido, retornar null
        }

        return new Cliente(username, email, nombre, telefono, documentoIdentidad);
    }

    public void crearCliente(Cliente cliente) {
        try {
            boolean agregado = clienteDAO.agregar(cliente);
            if (agregado && cliente != null) {
                JOptionPane.showMessageDialog(jPanelCliente, "Cliente agregado exitosamente");
                viewNuevoCliente.setVisible(false);
                viewNuevoCliente.dispose();
                viewNuevoCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                clienteSeleccionado = null;
                viewNuevoCliente.limpiarCampos();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(viewNuevoCliente, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            jPanelCliente.getTableCliente().removeAll();
            actualizarTablaCliente();
        }
    }

    public Cliente modificarClienteView() {
        // Obtener los valores usando los métodos pedir...
        int id = viewActualizarCliente.pedirId();
        String username = viewActualizarCliente.pedirUsername();
        String email = viewActualizarCliente.pedirEmail();
        String nombre = viewActualizarCliente.pedirNombreCliente();
        String telefono = viewActualizarCliente.pedirTelefono();
        int documentoIdentidad = viewActualizarCliente.pedirDocumentoIdentidad();

        // Verificar que todos los valores sean válidos (no null)
        if (id == 0 || username == null || email == null || nombre == null || telefono == null || documentoIdentidad == 0) {
            JOptionPane.showMessageDialog(viewActualizarCliente, "Error: Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return null; // Si algún campo es inválido, retornar null
        }

        // Crear y retornar el objeto Cliente
        return new Cliente( username, email, nombre, telefono, documentoIdentidad,id);
    }

    public void modificarCliente(Cliente cliente) {
        try {
            boolean modificado = clienteDAO.modificar(cliente);
            if (modificado && cliente != null) {
                JOptionPane.showMessageDialog(jPanelCliente, "Cliente modificado exitosamente");
                viewActualizarCliente.setVisible(false);
                viewActualizarCliente.dispose();
                viewActualizarCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                viewActualizarCliente.limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(jPanelCliente, "No se realizaron cambios en el cliente", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(viewActualizarCliente, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            jPanelCliente.getTableCliente().removeAll();
            actualizarTablaCliente();
        }
    }

    public void eliminarCliente(Cliente cliente) {
        boolean eliminado = false;
        try {
            eliminado = clienteDAO.eliminar(cliente);
            if (eliminado) {
                JOptionPane.showMessageDialog(jPanelCliente, "Cliente eliminado exitosamente");
            } else {
                JOptionPane.showMessageDialog(jPanelCliente, "No se eliminó el cliente.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(viewActualizarCliente, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            jPanelCliente.getTableCliente().removeAll();
            actualizarTablaCliente();
        }
    }

    public void buscarPorId(Cliente cliente) {
        boolean buscado = false;
        try {
            buscado = clienteDAO.buscarPorId(cliente);
            DefaultTableModel modelo = (DefaultTableModel) jPanelCliente.getTableCliente().getModel();
            modelo.setRowCount(0); // Borra todas las filas de la tabla

            if (buscado && cliente != null) {
                JOptionPane.showMessageDialog(jPanelCliente, "Cliente encontrado");
                modelo.addRow(new Object[]{
                        cliente.getIdCliente(),
                        cliente.getUsername(),
                        cliente.getEmail(),
                        cliente.getNombre(),
                        cliente.getTelefono(),
                        cliente.getDocumentoIdentidad()
                });
            } else {
                JOptionPane.showMessageDialog(jPanelCliente, "No se encontró el cliente.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(jPanelCliente, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public JPanelCliente getjPanelCliente() {
        return jPanelCliente;
    }
}