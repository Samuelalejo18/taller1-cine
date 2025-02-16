package view.sala;

import view.roundClasses.RoundButton;
import view.roundClasses.RoundedPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class ViewActualizarSala extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private RoundedPanel jpnModificarSala;
    private RoundedPanel jpnFormulario;
    private JLabel lblTituloSala;
    private JTextField txtNumeroSala;
    private JLabel lblNumero;
    private JLabel lblNombre;

    private JTextField txtNombreSala;
    private JLabel lblCantidadSillas;
    private JTextField txtCantidadSillas;
    private JLabel lblFilas;
    private JTextField txtFilas;
    private JLabel lblColumnas;
    private JTextField txtColumnas;
    private JLabel lblIdCine;
    private JTextField txtIdCine;
    private RoundButton btnModificarSala;
    private RoundButton btnVolverModificarSala;
    private JLabel lblNewLabel;
    private JTextField txtIdSala;
    private JLabel lblNewLabel_1;

    /**
     * Launch the application.
     */


    /**
     * Create the frame.
     */
    public ViewActualizarSala() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(177, 7, 24));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        this.setSize(1000, 800);
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        this.setResizable(false);

        lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(788, 24, 37, 47);
        contentPane.add(lblNewLabel);
        lblNewLabel.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\volver.png")); // Actualiza la ruta de la imagen

        jpnModificarSala = new RoundedPanel(50);
        jpnModificarSala.setBackground(new Color(0, 0, 0));
        jpnModificarSala.setBounds(45, 78, 890, 609);
        contentPane.add(jpnModificarSala);
        jpnModificarSala.setLayout(null);

        jpnFormulario = new RoundedPanel(50);
        jpnFormulario.setBounds(53, 34, 402, 534);
        jpnFormulario.setBackground(new Color(255, 255, 255));
        jpnModificarSala.add(jpnFormulario);
        jpnFormulario.setLayout(null);

        lblTituloSala = new JLabel("Modificar Sala");
        lblTituloSala.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 40));
        lblTituloSala.setHorizontalAlignment(SwingConstants.CENTER);
        lblTituloSala.setBounds(2, -2, 402, 63);
        jpnFormulario.add(lblTituloSala);

        // Crear un panel contenedor para los campos de texto y etiquetas
        JPanel panelContenedor = new JPanel();
        panelContenedor.setBackground(new Color(255, 255, 255));
        panelContenedor.setLayout(null);
        panelContenedor.setPreferredSize(new Dimension(380, 500));

        // Agregar los componentes al panel contenedor
        lblNumero = new JLabel("Número de Sala");
        lblNumero.setHorizontalAlignment(SwingConstants.LEFT);
        lblNumero.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblNumero.setBounds(52, 10 + 70, 297, 14);
        panelContenedor.add(lblNumero);

        txtNumeroSala = new JTextField();
        txtNumeroSala.setColumns(10);
        txtNumeroSala.setBounds(52, 30 + 70, 297, 34);
        panelContenedor.add(txtNumeroSala);

        lblNombre = new JLabel("Nombre de la Sala");
        lblNombre.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
        lblNombre.setBounds(52, 80 + 70, 297, 14);
        panelContenedor.add(lblNombre);

        txtNombreSala = new JTextField();
        txtNombreSala.setColumns(10);
        txtNombreSala.setBounds(52, 100 + 70, 297, 34);
        panelContenedor.add(txtNombreSala);

        lblCantidadSillas = new JLabel("Cantidad de Sillas");
        lblCantidadSillas.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblCantidadSillas.setHorizontalAlignment(SwingConstants.LEFT);
        lblCantidadSillas.setBounds(52, 150 + 70, 297, 14);
        panelContenedor.add(lblCantidadSillas);

        txtCantidadSillas = new JTextField();
        txtCantidadSillas.setBounds(52, 170 + 70, 297, 34);
        panelContenedor.add(txtCantidadSillas);

        lblFilas = new JLabel("Filas");
        lblFilas.setHorizontalAlignment(SwingConstants.LEFT);
        lblFilas.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblFilas.setBounds(52, 220 + 70, 297, 14);
        panelContenedor.add(lblFilas);

        txtFilas = new JTextField();
        txtFilas.setColumns(10);
        txtFilas.setBounds(52, 240 + 70, 297, 34);
        panelContenedor.add(txtFilas);

        lblColumnas = new JLabel("Columnas");
        lblColumnas.setHorizontalAlignment(SwingConstants.LEFT);
        lblColumnas.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblColumnas.setBounds(52, 290 + 70, 297, 14);
        panelContenedor.add(lblColumnas);

        txtColumnas = new JTextField();
        txtColumnas.setColumns(10);
        txtColumnas.setBounds(52, 310 + 70, 297, 34);
        panelContenedor.add(txtColumnas);

        lblIdCine = new JLabel("ID Cine");
        lblIdCine.setHorizontalAlignment(SwingConstants.LEFT);
        lblIdCine.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblIdCine.setBounds(52, 360 + 70, 297, 14);
        panelContenedor.add(lblIdCine);

        txtIdCine = new JTextField();
        txtIdCine.setColumns(10);
        txtIdCine.setBounds(52, 380 + 70, 297, 34);
        panelContenedor.add(txtIdCine);

        // Agregar el panel contenedor al JScrollPane
        JScrollPane scrollPane = new JScrollPane(panelContenedor);

        JLabel lblIDSala = new JLabel("ID SALA");
        lblIDSala.setHorizontalAlignment(SwingConstants.LEFT);
        lblIDSala.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblIDSala.setBounds(52, 11, 297, 14);
        panelContenedor.add(lblIDSala);

        txtIdSala = new JTextField();
        txtIdSala.setColumns(10);
        txtIdSala.setBounds(52, 100 - 70, 297, 34);
        panelContenedor.add(txtIdSala);
        scrollPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(255, 255, 255)));

        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
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


        // Reducir el tamaño de la barra de desplazamiento
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(8, 0));
        scrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 8));

        scrollPane.setFocusable(false);
        scrollPane.setBounds(2, 59, 401, 381);
        jpnFormulario.add(scrollPane);

        btnModificarSala = new RoundButton("Modificar Sala");
        btnModificarSala.setBounds(110, 465, 165, 43);
        jpnFormulario.add(btnModificarSala);
        btnModificarSala.setForeground(Color.WHITE);
        btnModificarSala.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 15));
        btnModificarSala.setBorderPainted(false);
        btnModificarSala.setBackground(new Color(177, 7, 24));

        lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\asiento-de-cine.png"));
        lblNewLabel_1.setBounds(551, 193, 268, 240);
        jpnModificarSala.add(lblNewLabel_1);

        btnVolverModificarSala = new RoundButton("Volver");
        btnVolverModificarSala.setBounds(773, 23, 159, 48);
        contentPane.add(btnVolverModificarSala);
        btnVolverModificarSala.setText("   Volver");
        btnVolverModificarSala.setBorderPainted(false);
        btnVolverModificarSala.setBackground(new Color(255, 255, 255));
        btnVolverModificarSala.setForeground(new Color(16, 6, 38));
        btnVolverModificarSala.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 21));
    }

    // Getters y Setters
    public RoundButton getBtnModificarSala() {
        return btnModificarSala;
    }

    public RoundButton getBtnVolverModificarSala() {
        return btnVolverModificarSala;
    }

    public void llenarCampos(int idSala, int numero, String nombre, int cantidadSillas, int filas, int columnas, int idCine) {
        txtIdSala.setText(String.valueOf(idSala));
        txtNumeroSala.setText(String.valueOf(numero));
        txtNombreSala.setText(nombre);
        txtCantidadSillas.setText(String.valueOf(cantidadSillas));
        txtFilas.setText(String.valueOf(filas));
        txtColumnas.setText(String.valueOf(columnas));
        txtIdCine.setText(String.valueOf(idCine));
    }

    public void limpiarCampos() {
        txtNumeroSala.setText("");
        txtNombreSala.setText("");
        txtCantidadSillas.setText("");
        txtFilas.setText("");
        txtColumnas.setText("");
        txtIdCine.setText("");
    }

    // Métodos de validación
    public int pedirNumeroSala() {
        String numeroStr = txtNumeroSala.getText().trim();
        int numero = 0;

        try {
            if (numeroStr.isEmpty()) {
                throw new Exception("El campo de número de sala no puede estar vacío.");
            }

            if (!numeroStr.matches("\\d+")) {
                throw new Exception("El número de sala debe ser un número entero.");
            }

            numero = Integer.parseInt(numeroStr);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }

        return numero;
    }

    public String pedirNombreSala() {
        String nombre = txtNombreSala.getText().trim();

        try {
            if (nombre.isEmpty()) {
                throw new Exception("El campo de nombre de sala no puede estar vacío.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        return nombre;
    }

    public int pedirCantidadSillas() {
        String cantidadStr = txtCantidadSillas.getText().trim();
        int cantidad = 0;

        try {
            if (cantidadStr.isEmpty()) {
                throw new Exception("El campo de cantidad de sillas no puede estar vacío.");
            }

            if (!cantidadStr.matches("\\d+")) {
                throw new Exception("La cantidad de sillas debe ser un número entero.");
            }

            cantidad = Integer.parseInt(cantidadStr);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }

        return cantidad;
    }

    public int pedirFilas() {
        String filasStr = txtFilas.getText().trim();
        int filas = 0;

        try {
            if (filasStr.isEmpty()) {
                throw new Exception("El campo de filas no puede estar vacío.");
            }

            if (!filasStr.matches("\\d+")) {
                throw new Exception("El número de filas debe ser un número entero.");
            }

            filas = Integer.parseInt(filasStr);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }

        return filas;
    }

    public int pedirColumnas() {
        String columnasStr = txtColumnas.getText().trim();
        int columnas = 0;

        try {
            if (columnasStr.isEmpty()) {
                throw new Exception("El campo de columnas no puede estar vacío.");
            }

            if (!columnasStr.matches("\\d+")) {
                throw new Exception("El número de columnas debe ser un número entero.");
            }

            columnas = Integer.parseInt(columnasStr);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }

        return columnas;
    }

    public int pedirIdSala() {
        String idCineStr = txtIdSala.getText().trim();
        int idCine = 0;

        try {
            if (idCineStr.isEmpty()) {
                throw new Exception("El campo de ID Cine no puede estar vacío.");
            }

            if (!idCineStr.matches("\\d+")) {
                throw new Exception("El ID Cine debe ser un número entero.");
            }

            idCine = Integer.parseInt(idCineStr);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }

        return idCine;
    }


    public int pedirIdCine() {
        String idCineStr = txtIdCine.getText().trim();
        int idCine = 0;

        try {
            if (idCineStr.isEmpty()) {
                throw new Exception("El campo de ID Cine no puede estar vacío.");
            }

            if (!idCineStr.matches("\\d+")) {
                throw new Exception("El ID Cine debe ser un número entero.");
            }

            idCine = Integer.parseInt(idCineStr);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }

        return idCine;
    }
}