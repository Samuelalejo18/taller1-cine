package view.pelicula;

import view.roundClasses.RoundedTextField;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class JPanelPelicula extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private DefaultTableModel model;
    private JTable tablePelicula;
    private JScrollPane scrollPanePelicula;
    private JButton btnNuevaPelicula;
    private JButton btnModificarPelicula;
    private RoundedTextField txtIdPelicula;
    private JButton btnEliminarPelicula;
    private JLabel lblModificar;
    private JLabel lblEliminar;
    private JLabel lblBuscarPeliculaPor;
    private JButton btnIdPelicula;
    private JButton btnTodasPeliculas;
    private JLabel lblListarTodosLos;

    public JPanelPelicula() {

        setLayout(null); // Usamos `null` para posiciones exactas
        setBackground(Color.WHITE);

// *** Etiqueta de título ***
        JLabel lblTitulo = new JLabel("¡Bienvenido al listado de Peliculas!");
        lblTitulo.setFont(new Font("Raleway ExtraBold", Font.BOLD, 20));
        lblTitulo.setBounds(20, 10, 400, 30);
        add(lblTitulo);




        // *** Inicializar modelo de la tabla ***
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"IDPelicula", "Titulo", "Duracion", "paisOrigen", "año","idioma","sinopsis","tipo","genero"});

        tablePelicula = new JTable(model);
        tablePelicula.setFont(new Font("Arial", Font.PLAIN, 14)); // Fuente general de la tabla
        tablePelicula.setRowHeight(25); // Altura de cada fila
        tablePelicula.setGridColor(Color.LIGHT_GRAY); // Color de las líneas de la tabla

        // Obtener el modelo de columnas de la tabla
        TableColumnModel columnModel = tablePelicula.getColumnModel();

// Ajustar el ancho de columnas específicas
        columnModel.getColumn(0).setPreferredWidth(30);  // IDPelicula más estrecha
        columnModel.getColumn(2).setPreferredWidth(25);  // Duración más estrecha

// Opcional: Puedes ajustar otras columnas según necesidad
        columnModel.getColumn(1).setPreferredWidth(200); // Título más amplio
        columnModel.getColumn(3).setPreferredWidth(60); // País de origen
// Opcional: Puedes ajustar otras columnas según necesidad
        columnModel.getColumn(4).setPreferredWidth(30); // Título más amplio
        columnModel.getColumn(7).setPreferredWidth(40);
        columnModel.getColumn(5).setPreferredWidth(40);
        columnModel.getColumn(8).setPreferredWidth(40);

// *** Estilizar encabezado ***
        JTableHeader header = tablePelicula.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 16));
        header.setBackground(new Color(254, 10, 38)); // Rojo intenso
        header.setForeground(Color.WHITE);
        header.setOpaque(true);

// Aumentar la altura del encabezado
        header.setPreferredSize(new Dimension(header.getWidth(), 40)); // Ajusta el 40 según lo necesites

// Ajustar espaciado interno (opcional, mejora la apariencia)
        UIManager.put("TableHeader.cellBorder", BorderFactory.createEmptyBorder(10, 5, 10, 5));

        tablePelicula.setTableHeader(header);
        // *** Alternar colores de filas ***
        tablePelicula.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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
        scrollPanePelicula = new JScrollPane(tablePelicula);
        scrollPanePelicula.setBounds(20, 89, 900, 400);
        add(scrollPanePelicula);

        // *** Panel de botones ***
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(null);
        panelBotones.setBounds(20, 500, 900, 100);
        add(panelBotones);

        // Botones
        btnNuevaPelicula = new JButton("");
        btnNuevaPelicula.setIgnoreRepaint(true);
        btnNuevaPelicula.setSelected(true);
        btnNuevaPelicula.setOpaque(false);
        btnNuevaPelicula.setFocusCycleRoot(true);
        btnNuevaPelicula.setDefaultCapable(false);
        btnNuevaPelicula.setContentAreaFilled(false);
        btnNuevaPelicula.setBorderPainted(false);
        btnNuevaPelicula.setFocusPainted(false);
        btnNuevaPelicula.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\claqueta roja.png"));
        btnNuevaPelicula.setBounds(73, 13, 84, 64);
        panelBotones.add(btnNuevaPelicula);

        btnModificarPelicula = new JButton("");
        btnModificarPelicula.setFocusable(false);
        btnModificarPelicula.setDefaultCapable(false);
        btnModificarPelicula.setBorderPainted(false);
        btnModificarPelicula.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\modificar.png"));
        btnModificarPelicula.setOpaque(false);
        btnModificarPelicula.setRolloverEnabled(false);
        btnModificarPelicula.setContentAreaFilled(false);
        btnModificarPelicula.setBounds(250, 13, 84, 64);
        panelBotones.add(btnModificarPelicula);

        btnEliminarPelicula = new JButton("");
        btnEliminarPelicula.setOpaque(false);
        btnEliminarPelicula.setFocusPainted(false);
        btnEliminarPelicula.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\eliminar.png"));
        btnEliminarPelicula.setContentAreaFilled(false);
        btnEliminarPelicula.setBorderPainted(false);
        btnEliminarPelicula.setBounds(427, 13, 84, 64);
        panelBotones.add(btnEliminarPelicula);

        JLabel lblNuevoPelicula = new JLabel("Nuevo Pelicula");
        lblNuevoPelicula.setFont(new Font("Raleway Light", Font.BOLD, 12));
        lblNuevoPelicula.setBounds(74, 70, 92, 30);
        panelBotones.add(lblNuevoPelicula);

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

        txtIdPelicula = new RoundedTextField(20, 20);
        txtIdPelicula.setHorizontalAlignment(SwingConstants.CENTER);
        txtIdPelicula.setFont(new Font("Roboto Slab ExtraBold", Font.PLAIN, 14));
        txtIdPelicula.setBounds(602, 39, 151, 38);
        panelBotones.add(txtIdPelicula);

        lblBuscarPeliculaPor = new JLabel("Buscar Pelicula por ID");
        lblBuscarPeliculaPor.setHorizontalAlignment(SwingConstants.CENTER);
        lblBuscarPeliculaPor.setFont(new Font("Raleway Light", Font.BOLD, 14));
        lblBuscarPeliculaPor.setBounds(596, 9, 164, 30);
        panelBotones.add(lblBuscarPeliculaPor);

        btnIdPelicula = new JButton("");
        btnIdPelicula.setOpaque(false);
        btnIdPelicula.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\LUPA.png"));
        btnIdPelicula.setFocusPainted(false);
        btnIdPelicula.setContentAreaFilled(false);
        btnIdPelicula.setBorderPainted(false);
        btnIdPelicula.setBounds(791, 45, 32, 32);
        panelBotones.add(btnIdPelicula);

        JLabel lblRealiceBusquedaY = new JLabel("Realice  busqueda y administre la informacion que sea necesaria");
        lblRealiceBusquedaY.setFont(new Font("Raleway Light", Font.BOLD, 14));
        lblRealiceBusquedaY.setBounds(20, 51, 497, 30);
        add(lblRealiceBusquedaY);
        
        btnTodasPeliculas = new JButton("");
        btnTodasPeliculas.setOpaque(false);
        btnTodasPeliculas.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\todos.png"));
        btnTodasPeliculas.setFocusPainted(false);
        btnTodasPeliculas.setContentAreaFilled(false);
        btnTodasPeliculas.setBorderPainted(false);
        btnTodasPeliculas.setBounds(646, 13, 84, 64);
        add(btnTodasPeliculas);
        
        lblListarTodosLos = new JLabel("Listar todos los Peliculas");
        lblListarTodosLos.setHorizontalAlignment(SwingConstants.CENTER);
        lblListarTodosLos.setFont(new Font("Raleway Light", Font.BOLD, 12));
        lblListarTodosLos.setBounds(732, 32, 169, 30);
        add(lblListarTodosLos);
    }

    public JButton getBtnEliminarPelicula() {
        return btnEliminarPelicula;
    }



    public JButton getBtnModificarPelicula() {
        return btnModificarPelicula;
    }


    public JButton getBtnNuevaPelicula() {
        return btnNuevaPelicula;
    }


    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    public JScrollPane getScrollPanePelicula() {
        return scrollPanePelicula;
    }



    public JTable getTablePelicula() {
        return tablePelicula;
    }

    public void setTablePelicula(JTable tablePelicula) {
        this.tablePelicula = tablePelicula;
    }

    public JButton getBtnIdPelicula() {
        return btnIdPelicula;
    }


    public RoundedTextField getTxtIdPelicula() {
        return txtIdPelicula;
    }

    public void setTxtIdPelicula(RoundedTextField txtIdPelicula) {
        this.txtIdPelicula = txtIdPelicula;
    }

    
    
    public JButton getBtnTodos() {
		return btnTodasPeliculas;
	}

	public int pedirId() {
        String idTxt = txtIdPelicula.getText().trim(); // Elimina espacios en blanco
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
