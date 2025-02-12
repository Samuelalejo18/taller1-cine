package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class JPanelCine extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private DefaultTableModel model;
    private JTable tableCine;
    private JScrollPane scrollPaneCine;
    private JButton btnNuevoCine;
    private  JButton btnModificarCine;

   private JButton btnEliminarCine;

    private JButton btnSalirCine;

    public JPanelCine() {

        setLayout(null); // Usamos `null` para posiciones exactas
        setBackground(Color.WHITE);

        // *** Etiqueta de título ***
        JLabel lblTitulo = new JLabel("¡Bienvenido al listado de Cines!");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setBounds(20, 10, 400, 30);
        add(lblTitulo);

        // *** Inicializar modelo de la tabla ***
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"IDCine", "Nombre", "Dirección", "Reseñas", "Teléfono"});

        tableCine = new JTable(model);
        scrollPaneCine = new JScrollPane(tableCine);
        scrollPaneCine.setBounds(20, 50, 900, 400);
        add(scrollPaneCine);

        // *** Panel de botones ***
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(null);
        panelBotones.setBounds(20, 470, 900, 100);
        add(panelBotones);

        // Botones
        btnNuevoCine = new JButton("Nuevo Cine");
        btnNuevoCine.setBounds(50, 20, 150, 50);
        panelBotones.add(btnNuevoCine);

        btnModificarCine = new JButton("Modificar");
        btnModificarCine.setBounds(250, 20, 150, 50);
        panelBotones.add(btnModificarCine);

      btnEliminarCine = new JButton("Eliminar");
        btnEliminarCine.setBounds(450, 20, 150, 50);
        panelBotones.add(btnEliminarCine);

        btnSalirCine = new JButton("Salir");
        btnSalirCine.setBounds(650, 20, 150, 50);
        panelBotones.add(btnSalirCine);
    }

    public JButton getBtnEliminarCine() {
        return btnEliminarCine;
    }

    public void setBtnEliminarCine(JButton btnEliminarCine) {
        this.btnEliminarCine = btnEliminarCine;
    }

    public JButton getBtnModificarCine() {
        return btnModificarCine;
    }

    public void setBtnModificarCine(JButton btnModificarCine) {
        this.btnModificarCine = btnModificarCine;
    }

    public JButton getBtnNuevoCine() {
        return btnNuevoCine;
    }

    public void setBtnNuevoCine(JButton btnNuevoCine) {
        this.btnNuevoCine = btnNuevoCine;
    }

    public JButton getBtnSalirCine() {
        return btnSalirCine;
    }

    public void setBtnSalirCine(JButton btnSalirCine) {
        this.btnSalirCine = btnSalirCine;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    public JScrollPane getScrollPaneCine() {
        return scrollPaneCine;
    }

    public void setScrollPaneCine(JScrollPane scrollPaneCine) {
        this.scrollPaneCine = scrollPaneCine;
    }

    public JTable getTableCine() {
        return tableCine;
    }

    public void setTableCine(JTable tableCine) {
        this.tableCine = tableCine;
    }
}
