package controller;

import controller.DAO.CineDAO;
import model.Cine;
import view.Cine.JPanelCine;
import view.Cine.ViewActualizarCine;
import view.Cine.ViewNuevoCine;
import view.roundClasses.RoundButton;
import view.roundClasses.RoundedTextField;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class ControllerCine implements ActionListener {


    private JPanelCine panelCine;
    private CineDAO cineDAO;
    private JButton btnNuevoCine;
    private JButton btnModificarCine;
    private RoundedTextField txtIdCine;
    private JButton btnEliminarCine;

    private JTable tableCine;

    private Cine cineSeleccionado;

    //Nuevo cine
    private ViewNuevoCine viewNuevoCine;
    private RoundButton btnVolverNuevoCine;
    private RoundButton btnCrearCine;


    //Modificar Cine
    private ViewActualizarCine viewActualizarCine;
    private RoundButton btnUpdateCine;
    private RoundButton btnVolverModificar;


    ///buscar por id
    private JButton btnIdCine;

    public ControllerCine() {
        panelCine = new JPanelCine();
        cineDAO = new CineDAO();
        btnNuevoCine = panelCine.getBtnNuevoCine();
        btnModificarCine = panelCine.getBtnModificarCine();
        btnEliminarCine = panelCine.getBtnEliminarCine();
        btnIdCine = panelCine.getBtnIdCine();
        btnNuevoCine.addActionListener(this);
        btnModificarCine.addActionListener(this);
        btnEliminarCine.addActionListener(this);
        btnIdCine.addActionListener(this);
        tableCine = panelCine.getTableCine();


        viewNuevoCine = new ViewNuevoCine();
        btnVolverNuevoCine = viewNuevoCine.getBtnVolver();
        btnVolverNuevoCine.addActionListener(this);
        btnCrearCine = viewNuevoCine.getBtnCrearCine();
        btnCrearCine.addActionListener(this);

        viewActualizarCine = new ViewActualizarCine();
        seleccionarCineTable();
        btnUpdateCine = viewActualizarCine.getBtnModificarCine();
        btnVolverModificar = viewActualizarCine.getBtnVolverModificar();
        btnVolverModificar.addActionListener(this);
        btnUpdateCine.addActionListener(this);

        actualizarTablaCine();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNuevoCine) {
            viewNuevoCine.limpiarCampos();
            viewNuevoCine.setVisible(true);
            viewNuevoCine.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        }
        if (e.getSource() == btnVolverNuevoCine) {
            viewNuevoCine.setVisible(false);
            viewNuevoCine.dispose();
            viewNuevoCine.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            panelCine.getTableCine().removeAll();
            actualizarTablaCine();
        }
        if (e.getSource() == btnCrearCine) {
            crearCine();
        }

        if (e.getSource() == btnModificarCine) {
            if (cineSeleccionado != null) {
                viewActualizarCine.setVisible(true);
                viewActualizarCine.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                viewActualizarCine.llenarCampos(cineSeleccionado.getIdCine(), cineSeleccionado.getNombre(), cineSeleccionado.getDireccion(), cineSeleccionado.getResennas(), cineSeleccionado.getTelefono());

            } else {

                viewActualizarCine.limpiarCampos();
                viewActualizarCine.setVisible(true);
                viewActualizarCine.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }


        }

        if (e.getSource() == btnVolverModificar) {
            viewActualizarCine.setVisible(false);
            viewActualizarCine.dispose();
            viewActualizarCine.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            panelCine.getTableCine().removeAll();
            actualizarTablaCine();
        }

        if (e.getSource() == btnUpdateCine) {
            int id = viewActualizarCine.pedirId();
            String nombre = viewActualizarCine.pedirNombreCine();
            String direccion = viewActualizarCine.pedirDireccion();
            String resennas = viewActualizarCine.pedirResennas();
            String telefono = viewActualizarCine.pedirTelefono();

            // Verificar si algún campo está vacío
            if (id == 0 || nombre == null || direccion == null || resennas == null || telefono == null) {
                JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {

                Cine cine = new Cine(id, nombre, direccion, resennas, telefono);
                modificarCine(cine);
                viewActualizarCine.limpiarCampos();

            }
            viewActualizarCine.limpiarCampos();


        }

        if (e.getSource() == btnEliminarCine) {
            if (cineSeleccionado != null) {
                int confirmacion = JOptionPane.showConfirmDialog(
                        panelCine,
                        "¿Está seguro de que desea eliminar el cine seleccionado?",
                        "Confirmar eliminación",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE
                );

                if (confirmacion == JOptionPane.YES_OPTION) {
                    eliminarCine(cineSeleccionado);
                }
            } else {
                JOptionPane.showMessageDialog(panelCine, "Seleccione un cine para eliminar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }

        if(e.getSource()== btnIdCine){
            int idCine= panelCine.pedirId();
            Cine cine= new Cine(idCine);
            if(idCine!=0 || cine!=null){
             //   buscarPorId(cine);

            }

        }

    }
    public Cine seleccionarCineTable() {

        tableCine.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) { // Evitar eventos duplicados
                int selectedRow = tableCine.getSelectedRow();
                if (selectedRow != -1) { // Si hay una fila seleccionada
                    int id = (int) tableCine.getValueAt(selectedRow, 0);
                    String nombre = (String) tableCine.getValueAt(selectedRow, 1);
                    String direccion = (String) tableCine.getValueAt(selectedRow, 2);
                    String resennas = (String) tableCine.getValueAt(selectedRow, 3);
                    String telefono = (String) tableCine.getValueAt(selectedRow, 4);

                    cineSeleccionado = new Cine(id, nombre, direccion, resennas, telefono);

                }
            }
        });
        return cineSeleccionado;
    }


    public JPanelCine getPanelCine() {
        return panelCine;
    }

    public void actualizarTablaCine() {
        List<Cine> cines = null;
        try {
            cines = cineDAO.listarTodos();
            DefaultTableModel modelo = panelCine.getModel();
            modelo.setRowCount(0); // Limpiar datos previos

            for (Cine cine : cines) {
                modelo.addRow(new Object[]{cine.getIdCine(), cine.getNombre(), cine.getDireccion(), cine.getResennas(), cine.getTelefono()});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(panelCine, e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void crearCine() {
        Cine cine = new Cine(viewNuevoCine.pedirNombreCine(), viewNuevoCine.pedirDireccion(), viewNuevoCine.pedirResennas(), viewNuevoCine.pedirTelefono());
        try {
            boolean agregado = cineDAO.agregar(cine);
            if (agregado) {
                JOptionPane.showMessageDialog(panelCine, "Cine agregado exitosamente");
                viewNuevoCine.setVisible(false);
                viewNuevoCine.dispose();
                viewNuevoCine.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                cineSeleccionado = null;
                viewActualizarCine.limpiarCampos();

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(viewNuevoCine, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            panelCine.getTableCine().removeAll();

            actualizarTablaCine();
        }

    }

    public void modificarCine(Cine cine) {

        try {
            boolean modificado = cineDAO.modificar(cine);
            if (modificado) {
                JOptionPane.showMessageDialog(panelCine, "Cine  modificado exitosamente");
                viewActualizarCine.setVisible(false);
                viewActualizarCine.dispose();
                viewActualizarCine.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                viewActualizarCine.limpiarCampos();
            }else {
                JOptionPane.showMessageDialog(panelCine, "No se realizaron cambios en el cine.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(viewNuevoCine, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            panelCine.getTableCine().removeAll();
            viewActualizarCine.limpiarCampos();
            actualizarTablaCine();
        }

    }

    public void eliminarCine(Cine cine) {
        boolean eliminado = false;
        try {
            eliminado = cineDAO.eliminar(cine);
            if (eliminado) {
                JOptionPane.showMessageDialog(panelCine, "Cine  eliminado exitosamente");
            }else{
                JOptionPane.showMessageDialog(panelCine, "No se  elimino  el cine.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(viewNuevoCine, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            panelCine.getTableCine().removeAll();
            actualizarTablaCine();
        }

    }

/*
    public void buscarPorId(Cine cine) {
        boolean buscado= false;
        try {
             buscado = cineDAO.buscarPorId(cine);
            if(buscado) {
                JOptionPane.showMessageDialog(panelCine, "Cine encontrado");
            }else{
                JOptionPane.showMessageDialog(panelCine, "No se  encontro el cine .", "Aviso", JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(viewNuevoCine, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            panelCine.getTableCine().removeAll();
            actualizarTablaCine();
        }

    }
*/

}