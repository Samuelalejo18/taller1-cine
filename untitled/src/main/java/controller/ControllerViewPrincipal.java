package controller;

import view.ViewPrincipal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerViewPrincipal implements ActionListener {


    private ViewPrincipal viewPrincipal;
    private ControllerCine controllerCine;
    private ControllerPelicula controllerPelicula;
    private ControllerCliente controllerCliente;
    private ControllerSala controllerSala;

    public ControllerViewPrincipal() {
        viewPrincipal = new ViewPrincipal();
        controllerCine = new ControllerCine();
        controllerPelicula = new ControllerPelicula();
        // Agregar el panel de cine a la vista principal
        viewPrincipal.getMainPanel().add(controllerCine.getPanelCine(), "Cine");
        viewPrincipal.getMainPanel().add(controllerPelicula.getjPanelPelicula(), "Pelicula");
        controllerCliente = new ControllerCliente();
        viewPrincipal.getMainPanel().add(controllerCliente.getjPanelCliente(), "Cliente");

        ControllerSala sala = new ControllerSala();
        viewPrincipal.getMainPanel().add(sala.getjPanelSala(), "Sala");
        mostrarViewPrincipal(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


    public void mostrarViewPrincipal(boolean visible) {
        viewPrincipal.setVisible(visible);
        viewPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
