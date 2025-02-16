package view.sala;

import view.roundClasses.RoundedTextField;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class JPanelSala extends JPanel {

    private static final long serialVersionUID = 1L;
    private DefaultTableModel model;
    private JTable tableSala;
    private JScrollPane scrollPaneSala;
    private JButton btnNuevaSala;
    private JButton btnModificarSala;
    private RoundedTextField txtIdSala;
    private JButton btnEliminarSala;
    private JLabel lblModificar;
    private JLabel lblEliminar;
    private JLabel lblBuscarSalaPor;
    private JButton btnIdSala;
    private JButton btnTodasSalas;
    private JLabel lblListarTodosLos;

    public JPanelSala() {

        setLayout(null); // Usamos `null` para posiciones exactas
        setBackground(Color.WHITE);

        // *** Etiqueta de título ***
        JLabel lblTitulo = new JLabel("¡Bienvenido al listado de Salas!");
        lblTitulo.setFont(new Font("Raleway ExtraBold", Font.BOLD, 20));
        lblTitulo.setBounds(20, 10, 400, 30);
        add(lblTitulo);

        // *** Inicializar modelo de la tabla ***
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"ID Sala", "Número", "Nombre", "Cantidad de Sillas", "Filas", "Columnas", "ID Cine"});

        tableSala = new JTable(model);
        tableSala.setFont(new Font("Arial", Font.PLAIN, 14)); // Fuente general de la tabla
        tableSala.setRowHeight(25); // Altura de cada fila
        tableSala.setGridColor(Color.LIGHT_GRAY); // Color de las líneas de la tabla

        // Obtener el modelo de columnas de la tabla
        TableColumnModel columnModel = tableSala.getColumnModel();

        // Ajustar el ancho de columnas específicas
        columnModel.getColumn(0).setPreferredWidth(30);  // ID Sala más estrecha
        columnModel.getColumn(1).setPreferredWidth(50);  // Número más estrecha
        columnModel.getColumn(2).setPreferredWidth(150); // Nombre más amplio
        columnModel.getColumn(3).setPreferredWidth(100); // Cantidad de Sillas
        columnModel.getColumn(4).setPreferredWidth(50);  // Filas
        columnModel.getColumn(5).setPreferredWidth(70);  // Columnas
        columnModel.getColumn(6).setPreferredWidth(50);  // ID Cine

        // *** Estilizar encabezado ***
        JTableHeader header = tableSala.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 16));
        header.setBackground(new Color(254, 10, 38)); // Rojo intenso
        header.setForeground(Color.WHITE);
        header.setOpaque(true);

        // Aumentar la altura del encabezado
        header.setPreferredSize(new Dimension(header.getWidth(), 40)); // Ajusta el 40 según lo necesites

        // Ajustar espaciado interno (opcional, mejora la apariencia)
        UIManager.put("TableHeader.cellBorder", BorderFactory.createEmptyBorder(10, 5, 10, 5));

        tableSala.setTableHeader(header);

        // *** Alternar colores de filas ***
        tableSala.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (!isSelected) {
                    c.setBackground(row % 2 == 0 ? new Color(240, 240, 240) : Color.WHITE); // Alternar gris claro y blanco
                } else {
                    c.setBackground(new Color(255, 79, 79)); // Color al seleccionar una fila
                }
                return c;
            }
        });

        scrollPaneSala = new JScrollPane(tableSala);
        scrollPaneSala.setBounds(20, 89, 900, 400);
        
        
        scrollPaneSala.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(200, 0, 0); // Color de la barra (Rojo oscuro)
                this.trackColor = new Color(240, 240, 240); // Color del fondo de la barra
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                return new JButton() {
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(0, 0); // Oculta los botones de desplazamiento
                    }
                };
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return new JButton() {
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(0, 0); // Oculta los botones de desplazamiento
                    }
                };
            }
        });

        scrollPaneSala.getVerticalScrollBar().setPreferredSize(new Dimension(8, 0)); // Más delgada
        scrollPaneSala.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 8));



        add(scrollPaneSala);

        // *** Panel de botones ***
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(null);
        panelBotones.setBounds(20, 500, 900, 100);
        add(panelBotones);

        // Botones
        btnNuevaSala = new JButton("");
        btnNuevaSala.setContentAreaFilled(false);
        btnNuevaSala.setFocusTraversalKeysEnabled(false);
        btnNuevaSala.setOpaque(false);
        btnNuevaSala.setFocusable(false);
        btnNuevaSala.setFocusPainted(false);
        btnNuevaSala.setBorderPainted(false);
        btnNuevaSala.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\sala.png"));
        btnNuevaSala.setBounds(73, 13, 84, 64);
        panelBotones.add(btnNuevaSala);

        btnModificarSala = new JButton("");
        btnModificarSala.setFocusPainted(false);
        btnModificarSala.setContentAreaFilled(false);
        btnModificarSala.setDefaultCapable(false);
        btnModificarSala.setBorderPainted(false);
        btnModificarSala.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\modificar.png"));
        btnModificarSala.setBounds(250, 13, 84, 64);
        panelBotones.add(btnModificarSala);

        btnEliminarSala = new JButton("");
        btnEliminarSala.setBorderPainted(false);
        btnEliminarSala.setFocusTraversalKeysEnabled(false);
        btnEliminarSala.setFocusPainted(false);
        btnEliminarSala.setContentAreaFilled(false);
        btnEliminarSala.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\eliminar.png"));
        btnEliminarSala.setBounds(427, 13, 84, 64);
        panelBotones.add(btnEliminarSala);

        JLabel lblNuevaSala = new JLabel("Nueva Sala");
        lblNuevaSala.setHorizontalAlignment(SwingConstants.CENTER);
        lblNuevaSala.setFont(new Font("Raleway Light", Font.BOLD, 12));
        lblNuevaSala.setBounds(65, 70, 92, 30);
        panelBotones.add(lblNuevaSala);

        lblModificar = new JLabel("Modificar");
        lblModificar.setHorizontalAlignment(SwingConstants.CENTER);
        lblModificar.setHorizontalTextPosition(SwingConstants.CENTER);
        lblModificar.setFont(new Font("Raleway Light", Font.BOLD, 12));
        lblModificar.setBounds(250, 70, 84, 30);
        panelBotones.add(lblModificar);

        lblEliminar = new JLabel("Eliminar");
        lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
        lblEliminar.setFont(new Font("Raleway Light", Font.BOLD, 12));
        lblEliminar.setBounds(427, 70, 84, 30);
        panelBotones.add(lblEliminar);

        txtIdSala = new RoundedTextField(20, 20);
        txtIdSala.setBounds(602, 39, 151, 38);
        panelBotones.add(txtIdSala);

        lblBuscarSalaPor = new JLabel("Buscar Sala por ID");
        lblBuscarSalaPor.setHorizontalAlignment(SwingConstants.CENTER);
        lblBuscarSalaPor.setFont(new Font("Raleway Light", Font.BOLD, 14));
        lblBuscarSalaPor.setBounds(596, 9, 164, 30);
        panelBotones.add(lblBuscarSalaPor);

        btnIdSala = new JButton("");
        btnIdSala.setRequestFocusEnabled(false);
        btnIdSala.setFocusTraversalKeysEnabled(false);
        btnIdSala.setContentAreaFilled(false);
        btnIdSala.setOpaque(false);
        btnIdSala.setFocusable(false);
        btnIdSala.setBorderPainted(false);
        btnIdSala.setFocusPainted(false);
        btnIdSala.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\LUPA.png"));
        btnIdSala.setBounds(791, 45, 32, 32);
        panelBotones.add(btnIdSala);

        btnTodasSalas = new JButton("");
        btnTodasSalas.setFocusTraversalKeysEnabled(false);
        btnTodasSalas.setFocusable(false);
        btnTodasSalas.setFocusPainted(false);
        btnTodasSalas.setOpaque(false);
        btnTodasSalas.setContentAreaFilled(false);
        btnTodasSalas.setBorderPainted(false);
        btnTodasSalas.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\todos.png"));
        btnTodasSalas.setBounds(646, 13, 84, 64);
        add(btnTodasSalas);

        lblListarTodosLos = new JLabel("Listar todas las Salas");
        lblListarTodosLos.setFont(new Font("Raleway Light", Font.BOLD, 12));
        lblListarTodosLos.setBounds(732, 32, 169, 30);
        add(lblListarTodosLos);
    }

    // Getters y Setters
    public JButton getBtnEliminarSala() {
        return btnEliminarSala;
    }

    public JButton getBtnModificarSala() {
        return btnModificarSala;
    }

    public JButton getBtnNuevaSala() {
        return btnNuevaSala;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    public JScrollPane getScrollPaneSala() {
        return scrollPaneSala;
    }

    public JTable getTableSala() {
        return tableSala;
    }

    public void setTableSala(JTable tableSala) {
        this.tableSala = tableSala;
    }

    public JButton getBtnIdSala() {
        return btnIdSala;
    }

    public RoundedTextField getTxtIdSala() {
        return txtIdSala;
    }

    public void setTxtIdSala(RoundedTextField txtIdSala) {
        this.txtIdSala = txtIdSala;
    }

    public JButton getBtnTodasSalas() {
        return btnTodasSalas;
    }

    public int pedirId() {
        String idTxt = txtIdSala.getText().trim(); // Elimina espacios en blanco
        int id = 0;

        // Expresión regular para validar solo números
        String regex = "\\d+";

        try {
            if (idTxt.isEmpty()) {
                throw new NumberFormatException("El campo de id no puede estar vacío.");
            }

            if (!idTxt.matches(regex)) {
                throw new NumberFormatException("El id solo debe contener números.");
            }

            id = Integer.parseInt(idTxt);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return id;
    }
}