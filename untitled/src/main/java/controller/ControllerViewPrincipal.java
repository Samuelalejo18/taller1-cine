package controller;

import controller.DAO.CineDAO;
import model.Cine;
import view.JPanelCine;
import view.ViewPrincipal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static view.ViewPrincipal.*;

public class ControllerViewPrincipal implements ActionListener {


    private ViewPrincipal viewPrincipal;
    private JPanelCine panelCine;
    private CineDAO cineDAO;
    public ControllerViewPrincipal() {
        viewPrincipal = new ViewPrincipal();
        panelCine = new JPanelCine(); // Se instancia el panel de cines
     viewPrincipal.getMainPanel().add(panelCine,"Cine");

     crearTablaCine();
//viewPrincipal.getBtnCine().addActionListener(e -> viewPrincipal.getCardLayout().show(viewPrincipal.getMainPanel(), "Cine"));

        mostrarViewPrincipal(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


    public void crearTablaCine() {
        cineDAO = new CineDAO();
        List<Cine> cines = cineDAO.listarTodos();
        DefaultTableModel modelosDeCines = panelCine.getModel(); // Obtener modelo desde JPanelCine
        modelosDeCines.setRowCount(0); // Limpiar datos previos

        for (Cine cine : cines) {
            modelosDeCines.addRow(new Object[]{cine.getIdCine(), cine.getNombre(), cine.getDireccion(), cine.getResennas(), cine.getTelefono()});
        }
    }
    public void mostrarViewPrincipal(boolean visible) {
        viewPrincipal.setVisible(visible);
        viewPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
