package view.cliente;

import view.roundClasses.RoundedTextField;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class JPanelCliente extends JPanel {

    private static final long serialVersionUID = 1L;
    private DefaultTableModel model;
    private JTable tableCliente;
    private JScrollPane scrollPaneCliente;
    private JButton btnNuevoCliente;
    private JButton btnModificarCliente;
    private RoundedTextField txtIdCliente;
    private JButton btnEliminarCliente;
    private JLabel lblModificar;
    private JLabel lblEliminar;
    private JLabel lblBuscarClientePor;
    private JButton btnIdCliente;
    private JButton btnTodosClientes;
    private JLabel lblListarTodosLos;

    public JPanelCliente() {

        setLayout(null); // Usamos `null` para posiciones exactas
        setBackground(Color.WHITE);

        // *** Etiqueta de título ***
        JLabel lblTitulo = new JLabel("¡Bienvenido al listado de Clientes!");
        lblTitulo.setFont(new Font("Raleway ExtraBold", Font.BOLD, 20));
        lblTitulo.setBounds(20, 10, 400, 30);
        add(lblTitulo);

        // *** Inicializar modelo de la tabla ***
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"IDCliente", "Username", "Email", "Nombre", "Teléfono", "Documento de Identidad"});

        tableCliente = new JTable(model);
        tableCliente.setFont(new Font("Arial", Font.PLAIN, 14)); // Fuente general de la tabla
        tableCliente.setRowHeight(25); // Altura de cada fila
        tableCliente.setGridColor(Color.LIGHT_GRAY); // Color de las líneas de la tabla

        // Obtener el modelo de columnas de la tabla
        TableColumnModel columnModel = tableCliente.getColumnModel();

        // Ajustar el ancho de columnas específicas
        columnModel.getColumn(0).setPreferredWidth(30);  // IDCliente más estrecha
        columnModel.getColumn(1).setPreferredWidth(150); // Username más amplio
        columnModel.getColumn(2).setPreferredWidth(200); // Email más amplio
        columnModel.getColumn(3).setPreferredWidth(150); // Nombre más amplio
        columnModel.getColumn(4).setPreferredWidth(100); // Teléfono
        columnModel.getColumn(5).setPreferredWidth(120); // Documento de Identidad

        // *** Estilizar encabezado ***
        JTableHeader header = tableCliente.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 16));
        header.setBackground(new Color(254, 10, 38)); // Rojo intenso
        header.setForeground(Color.WHITE);
        header.setOpaque(true);

        // Aumentar la altura del encabezado
        header.setPreferredSize(new Dimension(header.getWidth(), 40)); // Ajusta el 40 según lo necesites

        // Ajustar espaciado interno (opcional, mejora la apariencia)
        UIManager.put("TableHeader.cellBorder", BorderFactory.createEmptyBorder(10, 5, 10, 5));

        tableCliente.setTableHeader(header);

        // *** Alternar colores de filas ***
        tableCliente.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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

        scrollPaneCliente = new JScrollPane(tableCliente);
        scrollPaneCliente.setBounds(20, 89, 900, 400);
        add(scrollPaneCliente);

        
        scrollPaneCliente.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
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

        scrollPaneCliente.getVerticalScrollBar().setPreferredSize(new Dimension(8, 0)); // Más delgada
        scrollPaneCliente.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 8));
        // *** Panel de botones ***
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(null);
        panelBotones.setBounds(20, 500, 900, 100);
        add(panelBotones);

        // Botones
        btnNuevoCliente = new JButton("");
        btnNuevoCliente.setIgnoreRepaint(true);
        btnNuevoCliente.setSelected(true);
        btnNuevoCliente.setOpaque(false);
        btnNuevoCliente.setFocusCycleRoot(true);
        btnNuevoCliente.setDefaultCapable(false);
        btnNuevoCliente.setContentAreaFilled(false);
        btnNuevoCliente.setBorderPainted(false);
        btnNuevoCliente.setFocusPainted(false);
        btnNuevoCliente.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\nuevoCliente.png"));
        btnNuevoCliente.setBounds(73, 13, 84, 64);
        panelBotones.add(btnNuevoCliente);

        btnModificarCliente = new JButton("");
        btnModificarCliente.setFocusable(false);
        btnModificarCliente.setDefaultCapable(false);
        btnModificarCliente.setBorderPainted(false);
        btnModificarCliente.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\modificar.png"));
        btnModificarCliente.setOpaque(false);
        btnModificarCliente.setRolloverEnabled(false);
        btnModificarCliente.setContentAreaFilled(false);
        btnModificarCliente.setBounds(250, 13, 84, 64);
        panelBotones.add(btnModificarCliente);

        btnEliminarCliente = new JButton("");
        btnEliminarCliente.setOpaque(false);
        btnEliminarCliente.setFocusPainted(false);
        btnEliminarCliente.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\eliminar.png"));
        btnEliminarCliente.setContentAreaFilled(false);
        btnEliminarCliente.setBorderPainted(false);
        btnEliminarCliente.setBounds(427, 13, 84, 64);
        panelBotones.add(btnEliminarCliente);

        JLabel lblNuevoCliente = new JLabel("Nuevo Cliente");
        lblNuevoCliente.setFont(new Font("Raleway Light", Font.BOLD, 12));
        lblNuevoCliente.setBounds(74, 70, 92, 30);
        panelBotones.add(lblNuevoCliente);

        lblModificar = new JLabel("Modificar");
        lblModificar.setHorizontalAlignment(SwingConstants.CENTER);
        lblModificar.setFont(new Font("Raleway Light", Font.BOLD, 12));
        lblModificar.setBounds(250, 70, 84, 30);
        panelBotones.add(lblModificar);

        lblEliminar = new JLabel("Eliminar");
        lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
        lblEliminar.setFont(new Font("Raleway Light", Font.BOLD, 12));
        lblEliminar.setBounds(427, 70, 84, 30);
        panelBotones.add(lblEliminar);

        txtIdCliente = new RoundedTextField(20, 20);
        txtIdCliente.setHorizontalAlignment(SwingConstants.CENTER);
        txtIdCliente.setFont(new Font("Roboto Slab ExtraBold", Font.PLAIN, 14));
        txtIdCliente.setBounds(602, 39, 151, 38);
        panelBotones.add(txtIdCliente);

        lblBuscarClientePor = new JLabel("Buscar Cliente por ID");
        lblBuscarClientePor.setHorizontalAlignment(SwingConstants.CENTER);
        lblBuscarClientePor.setFont(new Font("Raleway Light", Font.BOLD, 14));
        lblBuscarClientePor.setBounds(596, 9, 164, 30);
        panelBotones.add(lblBuscarClientePor);

        btnIdCliente = new JButton("");
        btnIdCliente.setOpaque(false);
        btnIdCliente.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\LUPA.png"));
        btnIdCliente.setFocusPainted(false);
        btnIdCliente.setContentAreaFilled(false);
        btnIdCliente.setBorderPainted(false);
        btnIdCliente.setBounds(791, 45, 32, 32);
        panelBotones.add(btnIdCliente);

        JLabel lblRealiceBusquedaY = new JLabel("Realice búsqueda y administre la información que sea necesaria");
        lblRealiceBusquedaY.setFont(new Font("Raleway Light", Font.BOLD, 14));
        lblRealiceBusquedaY.setBounds(20, 51, 497, 30);
        add(lblRealiceBusquedaY);

        btnTodosClientes = new JButton("");
        btnTodosClientes.setOpaque(false);
        btnTodosClientes.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\todos.png"));
        btnTodosClientes.setFocusPainted(false);
        btnTodosClientes.setContentAreaFilled(false);
        btnTodosClientes.setBorderPainted(false);
        btnTodosClientes.setBounds(646, 13, 84, 64);
        add(btnTodosClientes);

        lblListarTodosLos = new JLabel("Listar todos los Clientes");
        lblListarTodosLos.setHorizontalAlignment(SwingConstants.CENTER);
        lblListarTodosLos.setFont(new Font("Raleway Light", Font.BOLD, 12));
        lblListarTodosLos.setBounds(732, 32, 169, 30);
        add(lblListarTodosLos);
    }

    // Getters y setters
    public JButton getBtnEliminarCliente() {
        return btnEliminarCliente;
    }

    public JButton getBtnModificarCliente() {
        return btnModificarCliente;
    }

    public JButton getBtnNuevoCliente() {
        return btnNuevoCliente;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    public JScrollPane getScrollPaneCliente() {
        return scrollPaneCliente;
    }

    public JTable getTableCliente() {
        return tableCliente;
    }

    public void setTableCliente(JTable tableCliente) {
        this.tableCliente = tableCliente;
    }

    public JButton getBtnIdCliente() {
        return btnIdCliente;
    }

    public RoundedTextField getTxtIdCliente() {
        return txtIdCliente;
    }

    public void setTxtIdCliente(RoundedTextField txtIdCliente) {
        this.txtIdCliente = txtIdCliente;
    }

    public JButton getBtnTodosClientes() {
        return btnTodosClientes;
    }

    public int pedirId() {
        String idTxt = txtIdCliente.getText().trim(); // Elimina espacios en blanco
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