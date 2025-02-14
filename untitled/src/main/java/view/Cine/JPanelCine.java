package view.Cine;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import view.roundClasses.*;

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
    private JButton btnModificarCine;
    private RoundedTextField txtIdCine;
    private JButton btnEliminarCine;
    private JLabel lblModificar;
    private JLabel lblEliminar;
    private JLabel lblBuscarCinePor;
    private JButton btnIdCine;
    private JButton btnTodos;
    private JLabel lblListarTodosLos;

    public JPanelCine() {

        setLayout(null); // Usamos `null` para posiciones exactas
        setBackground(Color.WHITE);

// *** Etiqueta de título ***
        JLabel lblTitulo = new JLabel("¡Bienvenido al listado de Cines!");
        lblTitulo.setFont(new Font("Raleway ExtraBold", Font.BOLD, 20));
        lblTitulo.setBounds(20, 10, 400, 30);
        add(lblTitulo);

        // *** Inicializar modelo de la tabla ***
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"IDCine", "Nombre", "Dirección", "Reseñas", "Teléfono"});

        tableCine = new JTable(model);
        tableCine.setFont(new Font("Arial", Font.PLAIN, 14)); // Fuente general de la tabla
        tableCine.setRowHeight(25); // Altura de cada fila
        tableCine.setGridColor(Color.LIGHT_GRAY); // Color de las líneas de la tabla

        TableColumnModel columnModel =  tableCine.getColumnModel();

// Ajustar el ancho de columnas específicas
        columnModel.getColumn(0).setPreferredWidth(30);
        columnModel.getColumn(4).setPreferredWidth(40);

// *** Estilizar encabezado ***
        JTableHeader header = tableCine.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 16));
        header.setBackground(new Color(254, 10, 38)); // Rojo intenso
        header.setForeground(Color.WHITE);
        header.setOpaque(true);

// Aumentar la altura del encabezado
        header.setPreferredSize(new Dimension(header.getWidth(), 40)); // Ajusta el 40 según lo necesites

// Ajustar espaciado interno (opcional, mejora la apariencia)
        UIManager.put("TableHeader.cellBorder", BorderFactory.createEmptyBorder(10, 5, 10, 5));

        tableCine.setTableHeader(header);
        // *** Alternar colores de filas ***
        tableCine.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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
        scrollPaneCine = new JScrollPane(tableCine);
        scrollPaneCine.setBounds(20, 89, 900, 400);
        add(scrollPaneCine);

        // *** Panel de botones ***
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(null);
        panelBotones.setBounds(20, 500, 900, 100);
        add(panelBotones);

        // Botones
        btnNuevoCine = new JButton("");
        btnNuevoCine.setIgnoreRepaint(true);
        btnNuevoCine.setSelected(true);
        btnNuevoCine.setOpaque(false);
        btnNuevoCine.setFocusCycleRoot(true);
        btnNuevoCine.setDefaultCapable(false);
        btnNuevoCine.setContentAreaFilled(false);
        btnNuevoCine.setBorderPainted(false);
        btnNuevoCine.setFocusPainted(false);
        btnNuevoCine.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\nuevoCine.png"));
        btnNuevoCine.setBounds(73, 13, 84, 64);
        panelBotones.add(btnNuevoCine);

        btnModificarCine = new JButton("");
        btnModificarCine.setFocusable(false);
        btnModificarCine.setDefaultCapable(false);
        btnModificarCine.setBorderPainted(false);
        btnModificarCine.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\modificar.png"));
        btnModificarCine.setOpaque(false);
        btnModificarCine.setRolloverEnabled(false);
        btnModificarCine.setContentAreaFilled(false);
        btnModificarCine.setBounds(250, 13, 84, 64);
        panelBotones.add(btnModificarCine);

        btnEliminarCine = new JButton("");
        btnEliminarCine.setOpaque(false);
        btnEliminarCine.setFocusPainted(false);
        btnEliminarCine.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\eliminar.png"));
        btnEliminarCine.setContentAreaFilled(false);
        btnEliminarCine.setBorderPainted(false);
        btnEliminarCine.setBounds(427, 13, 84, 64);
        panelBotones.add(btnEliminarCine);

        JLabel lblNuevoCine = new JLabel("Nuevo Cine");
        lblNuevoCine.setFont(new Font("Raleway Light", Font.BOLD, 12));
        lblNuevoCine.setBounds(83, 70, 74, 30);
        panelBotones.add(lblNuevoCine);

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

        txtIdCine = new RoundedTextField(20, 20);
        txtIdCine.setHorizontalAlignment(SwingConstants.CENTER);
        txtIdCine.setFont(new Font("Roboto Slab ExtraBold", Font.PLAIN, 14));
        txtIdCine.setBounds(602, 39, 151, 38);
        panelBotones.add(txtIdCine);

        lblBuscarCinePor = new JLabel("Buscar cine por ID");
        lblBuscarCinePor.setHorizontalAlignment(SwingConstants.CENTER);
        lblBuscarCinePor.setFont(new Font("Raleway Light", Font.BOLD, 14));
        lblBuscarCinePor.setBounds(602, 8, 151, 30);
        panelBotones.add(lblBuscarCinePor);

        btnIdCine = new JButton("");
        btnIdCine.setOpaque(false);
        btnIdCine.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\LUPA.png"));
        btnIdCine.setFocusPainted(false);
        btnIdCine.setContentAreaFilled(false);
        btnIdCine.setBorderPainted(false);
        btnIdCine.setBounds(791, 45, 32, 32);
        panelBotones.add(btnIdCine);

        JLabel lblRealiceBusquedaY = new JLabel("Realice  busqueda y administre la informacion que sea necesaria");
        lblRealiceBusquedaY.setFont(new Font("Raleway Light", Font.BOLD, 14));
        lblRealiceBusquedaY.setBounds(20, 51, 497, 30);
        add(lblRealiceBusquedaY);
        
        btnTodos = new JButton("");
        btnTodos.setOpaque(false);
        btnTodos.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\todos.png"));
        btnTodos.setFocusPainted(false);
        btnTodos.setContentAreaFilled(false);
        btnTodos.setBorderPainted(false);
        btnTodos.setBounds(646, 13, 84, 64);
        add(btnTodos);
        
        lblListarTodosLos = new JLabel("Listar todos los cines");
        lblListarTodosLos.setHorizontalAlignment(SwingConstants.CENTER);
        lblListarTodosLos.setFont(new Font("Raleway Light", Font.BOLD, 12));
        lblListarTodosLos.setBounds(732, 32, 169, 30);
        add(lblListarTodosLos);
    }

    public JButton getBtnEliminarCine() {
        return btnEliminarCine;
    }



    public JButton getBtnModificarCine() {
        return btnModificarCine;
    }


    public JButton getBtnNuevoCine() {
        return btnNuevoCine;
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



    public JTable getTableCine() {
        return tableCine;
    }

    public void setTableCine(JTable tableCine) {
        this.tableCine = tableCine;
    }

    public JButton getBtnIdCine() {
        return btnIdCine;
    }


    public RoundedTextField getTxtIdCine() {
        return txtIdCine;
    }

    public void setTxtIdCine(RoundedTextField txtIdCine) {
        this.txtIdCine = txtIdCine;
    }

    
    
    public JButton getBtnTodos() {
		return btnTodos;
	}

	public int pedirId() {
        String idTxt = txtIdCine.getText().trim(); // Elimina espacios en blanco
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
