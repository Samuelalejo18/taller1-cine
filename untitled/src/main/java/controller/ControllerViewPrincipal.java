package controller;

import view.ViewPrincipal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerViewPrincipal implements ActionListener {


    private ViewPrincipal viewPrincipal;
    private ControllerCine controllerCine;

    public ControllerViewPrincipal() {
        viewPrincipal = new ViewPrincipal();
        controllerCine = new ControllerCine();
        // Agregar el panel de cine a la vista principal
        viewPrincipal.getMainPanel().add(controllerCine.getPanelCine(), "Cine");

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
