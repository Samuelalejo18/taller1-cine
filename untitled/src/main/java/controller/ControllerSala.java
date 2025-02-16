package controller;

import controller.DAO.CineDAO;
import controller.DAO.SalaDAO;
import model.Cine;
import model.Sala;
import view.roundClasses.RoundButton;
import view.sala.JPanelSala;
import view.sala.ViewActualizarSala;
import view.sala.ViewNuevaSala;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;

public class ControllerSala implements ActionListener {
    private JPanelSala jPanelSala;
    private JTable tableSala;
    private JButton btnNuevaSala;
    private JButton btnModificarSala;
    private JButton btnEliminarSala;
    private JButton btnIdSala;
    private JButton btnTodasSalas;
    private Sala salaSeleccionada;

    private SalaDAO salaDAO;
    private CineDAO cineDAO;
    // Crear sala
    private RoundButton btnCrearSala;
    private RoundButton btnVolverCrearSala;
    private ViewNuevaSala viewNuevaSala;

    // Modificar sala
    private ViewActualizarSala viewActualizarSala;
    private RoundButton btnUpdateSala;
    private RoundButton btnVolverModificarSala;

    public ControllerSala() {
        jPanelSala = new JPanelSala();
        salaDAO = new SalaDAO();
        tableSala = jPanelSala.getTableSala();
        btnNuevaSala = jPanelSala.getBtnNuevaSala();
        btnEliminarSala = jPanelSala.getBtnEliminarSala();
        btnIdSala = jPanelSala.getBtnIdSala();
        btnModificarSala = jPanelSala.getBtnModificarSala();
        btnTodasSalas = jPanelSala.getBtnTodasSalas();
        btnTodasSalas.addActionListener(this);
        btnNuevaSala.addActionListener(this);
        btnEliminarSala.addActionListener(this);
        btnIdSala.addActionListener(this);
        btnModificarSala.addActionListener(this);
        actualizarTablaSala();

        // Crear sala
        viewNuevaSala = new ViewNuevaSala();
        btnCrearSala = viewNuevaSala.getBtnCrearSala();
        btnVolverCrearSala = viewNuevaSala.getBtnVolverCrearSala();
        btnCrearSala.addActionListener(this);
        btnVolverCrearSala.addActionListener(this);

        // Modificar sala
        seleccionarSalaTable();
        viewActualizarSala = new ViewActualizarSala();
        btnUpdateSala = viewActualizarSala.getBtnModificarSala();
        btnVolverModificarSala = viewActualizarSala.getBtnVolverModificarSala();
        btnUpdateSala.addActionListener(this);
        btnVolverModificarSala.addActionListener(this);

        viewActualizarSala.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                viewActualizarSala.limpiarCampos(); // Borra la información
                salaSeleccionada = null; // Resetea la selección
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNuevaSala) {
            viewNuevaSala.limpiarCampos();
            viewNuevaSala.setVisible(true);
            viewNuevaSala.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        if (e.getSource() == btnVolverCrearSala) {
            viewNuevaSala.setVisible(false);
            viewNuevaSala.dispose();
            viewNuevaSala.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            jPanelSala.getTableSala().removeAll();
            actualizarTablaSala();
        }
        if (e.getSource() == btnCrearSala) {
            crearSala(crearSalaView());
        }

        if (e.getSource() == btnModificarSala) {
            if (salaSeleccionada != null) {
                viewActualizarSala.setVisible(true);
                viewActualizarSala.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                viewActualizarSala.llenarCampos(salaSeleccionada.getIdSala(), salaSeleccionada.getNumero(), salaSeleccionada.getNombre(), salaSeleccionada.getCantidadSilla(), salaSeleccionada.getFilas(), salaSeleccionada.getColumnas(), salaSeleccionada.getCine().getIdCine());
            } else {
                viewActualizarSala.limpiarCampos();
                viewActualizarSala.setVisible(true);
                viewActualizarSala.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        }

        if (e.getSource() == btnUpdateSala) {
            modificarSala(modificarSalaView());
            salaSeleccionada = null;
            viewActualizarSala.limpiarCampos();
        }

        if (e.getSource() == btnVolverModificarSala) {
            viewActualizarSala.setVisible(false);
            viewActualizarSala.dispose();
            viewActualizarSala.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            jPanelSala.getTableSala().removeAll();
            actualizarTablaSala();
        }

        if (e.getSource() == btnEliminarSala) {
            if (salaSeleccionada != null) {
                int confirmacion = JOptionPane.showConfirmDialog(jPanelSala, "¿Está seguro de que desea eliminar la sala seleccionada?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    eliminarSala(salaSeleccionada);
                }
            } else {
                JOptionPane.showMessageDialog(jPanelSala, "Seleccione una sala para eliminar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }

        if (e.getSource() == btnIdSala) {
            int idSala = jPanelSala.pedirId();
            Sala sala = new Sala(idSala);
            buscarPorId(sala);
            if (idSala == 0 || sala == null) {
                jPanelSala.getTableSala().removeAll();
                actualizarTablaSala();
            }
        }

        if (e.getSource() == btnTodasSalas) {
            jPanelSala.getTableSala().removeAll();
            actualizarTablaSala();
        }
    }

    public void actualizarTablaSala() {
        List<Sala> salas = null;
        try {
            salas = salaDAO.listarTodos();
            DefaultTableModel modelo = jPanelSala.getModel();
            modelo.setRowCount(0); // Limpiar datos previos

            for (Sala sala : salas) {
                modelo.addRow(new Object[]{sala.getIdSala(), sala.getNumero(), sala.getNombre(), sala.getCantidadSilla(), sala.getFilas(), sala.getColumnas(), sala.getCine().getIdCine()});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(jPanelSala, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public Sala seleccionarSalaTable() {
        salaSeleccionada = null; // Objeto Sala seleccionado

        tableSala.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) { // Evitar eventos duplicados
                int selectedRow = tableSala.getSelectedRow(); // Obtener la fila seleccionada
                if (selectedRow != -1) { // Si hay una fila seleccionada
                    // Obtener los valores de la fila seleccionada
                    int id = (int) tableSala.getValueAt(selectedRow, 0);
                    int numero = (int) tableSala.getValueAt(selectedRow, 1);
                    String nombre = (String) tableSala.getValueAt(selectedRow, 2);
                    int cantidadSillas = (int) tableSala.getValueAt(selectedRow, 3);
                    int filas = (int) tableSala.getValueAt(selectedRow, 4);
                    int columnas = (int) tableSala.getValueAt(selectedRow, 5);
                    int idCine = (int) tableSala.getValueAt(selectedRow, 6);
                    Cine cine = new Cine(idCine);
                    // Crear el objeto Sala con los valores obtenidos
                    salaSeleccionada = new Sala(id, numero, nombre, cantidadSillas, filas, columnas, cine);
                }
            }
        });

        return salaSeleccionada; // Retornar la sala seleccionada
    }

    public Sala crearSalaView() {
        // Obtener los valores usando los métodos pedir...
        cineDAO = new CineDAO();
        int numero = viewNuevaSala.pedirNumeroSala();
        String nombre = viewNuevaSala.pedirNombreSala();
        int cantidadSillas = viewNuevaSala.pedirCantidadSillas();
        int filas = viewNuevaSala.pedirFilas();
        int columnas = viewNuevaSala.pedirColumnas();
        int idCine = viewNuevaSala.pedirIdCine();
        Cine cine = new Cine(idCine);
        try {
            boolean encontrarCine = cineDAO.buscarPorId(cine);
            if (encontrarCine) {
                // Verificar que todos los valores sean válidos (no null o -1)
                if (numero <= 0 || nombre == null || cantidadSillas <= 0 || filas <= 0 || columnas <= 0 || idCine <= 0) {
                    JOptionPane.showMessageDialog(viewNuevaSala, "Error: Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    return null; // Si algún campo es inválido, retornar null
                }
                return new Sala(numero, nombre, cantidadSillas, filas, columnas, cine);
            } else {
                JOptionPane.showMessageDialog(jPanelSala, "El id del cine no existe, no es posible agregar la sala a este cine");
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void crearSala(Sala sala) {
        try {
            boolean agregado = salaDAO.agregar(sala);
            if (agregado && sala != null) {
                JOptionPane.showMessageDialog(jPanelSala, "Sala agregada exitosamente");
                viewNuevaSala.setVisible(false);
                viewNuevaSala.dispose();
                viewNuevaSala.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                salaSeleccionada = null;
                viewNuevaSala.limpiarCampos();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(viewNuevaSala, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            jPanelSala.getTableSala().removeAll();
            actualizarTablaSala();
        }
    }

    public Sala modificarSalaView() {
        // Obtener los valores usando los métodos pedir...
        int id = viewActualizarSala.pedirIdCine();
        int numero = viewActualizarSala.pedirNumeroSala();
        String nombre = viewActualizarSala.pedirNombreSala();
        int cantidadSillas = viewActualizarSala.pedirCantidadSillas();
        int filas = viewActualizarSala.pedirFilas();
        int columnas = viewActualizarSala.pedirColumnas();
        int idCine = viewActualizarSala.pedirIdCine();

        cineDAO = new CineDAO();
        Cine cine = new Cine(idCine);
        try {
            boolean encontrado = cineDAO.buscarPorId(cine);
            if (encontrado) {

                // Verificar que todos los valores sean válidos (no null o -1)
                if (id == 0 || numero == -1 || nombre == null || cantidadSillas == -1 || filas == -1 || columnas == -1 || idCine == -1) {
                    JOptionPane.showMessageDialog(viewActualizarSala, "Error: Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    return null; // Si algún campo es inválido, retornar null
                }

                // Crear y retornar el objeto Sala
                return new Sala(id, numero, nombre, cantidadSillas, filas, columnas);
            } else {
                JOptionPane.showMessageDialog(jPanelSala, "El id del cine no existe, no es posible agregar la sala a este cine");
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public void modificarSala(Sala sala) {
        try {
            boolean modificado = salaDAO.modificar(sala);
            if (modificado && sala != null) {
                JOptionPane.showMessageDialog(jPanelSala, "Sala modificada exitosamente");
                viewActualizarSala.setVisible(false);
                viewActualizarSala.dispose();
                viewActualizarSala.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                viewActualizarSala.limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(jPanelSala, "No se realizaron cambios en la sala", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(viewActualizarSala, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            jPanelSala.getTableSala().removeAll();
            actualizarTablaSala();
        }
    }

    public void eliminarSala(Sala sala) {
        boolean eliminado = false;
        try {
            eliminado = salaDAO.eliminar(sala);
            if (eliminado) {
                JOptionPane.showMessageDialog(jPanelSala, "Sala eliminada exitosamente");
            } else {
                JOptionPane.showMessageDialog(jPanelSala, "No se eliminó la sala.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(viewActualizarSala, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            jPanelSala.getTableSala().removeAll();
            actualizarTablaSala();
        }
    }

    public void buscarPorId(Sala sala) {
        boolean buscado = false;
        try {
            buscado = salaDAO.buscarPorId(sala);
            DefaultTableModel modelo = (DefaultTableModel) jPanelSala.getTableSala().getModel();
            modelo.setRowCount(0); // Borra todas las filas de la tabla

            if (buscado && sala != null) {
                JOptionPane.showMessageDialog(jPanelSala, "Sala encontrada");
                modelo.addRow(new Object[]{sala.getIdSala(), sala.getNumero(), sala.getNombre(), sala.getCantidadSilla(), sala.getFilas(), sala.getColumnas(), sala.getCine().getIdCine()});
            } else {
                JOptionPane.showMessageDialog(jPanelSala, "No se encontró la sala.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(jPanelSala, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public JPanelSala getjPanelSala() {
        return jPanelSala;
    }
}