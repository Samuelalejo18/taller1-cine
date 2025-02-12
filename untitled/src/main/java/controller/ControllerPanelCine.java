package controller;

import controller.DAO.CineDAO;
import model.Cine;
import view.JPanelCine;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ControllerPanelCine /*implements ActionListener*/ {
    /*private DefaultTableModel modelosDeCines;
    private JTable tableCine;
    private JScrollPane scrollPane;
    private JButton btnNuevoCine;
    private JButton btnModificar;
    private CineDAO cineDAO;
    private JButton btnEliminar;

    private JButton btnSalir;
    private JPanelCine jPanelCine;

    public ControllerPanelCine() {
        jPanelCine = new JPanelCine();
        tableCine = jPanelCine.getTableCine();
        crearTablaCine();

    }

    public void crearTablaCine() {
        cineDAO = new CineDAO();
        List<Cine> cines= cineDAO.listarTodos();
        DefaultTableModel modelosDeCines = new DefaultTableModel();
        modelosDeCines.setColumnIdentifiers(new Object[]{"IDCine", "Nombre","dirreccion", "reseñas","telefono"});
        for (Cine cine: cines) {
            modelosDeCines.addRow(new Object[]{cine.getIdCine(),cine.getNombre(),cine.getDireccion(),cine.getResennas(),cine.getTelefono()});
        }
        tableCine.setModel(modelosDeCines);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JPanelCine panelCine = new JPanelCine();
    }

    */

}
