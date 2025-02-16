package view.sala;

import view.roundClasses.RoundButton;
import view.roundClasses.RoundedPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class ViewNuevaSala extends JFrame {

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
    private RoundButton btnCrearSala;
    private RoundButton btnVolverCrearSala;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;

    /**
     * Launch the application.
     */


    /**
     * Create the frame.
     */
    public ViewNuevaSala() {
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
        jpnFormulario.setBounds(428, 32, 402, 534);
        jpnFormulario.setBackground(new Color(255, 255, 255));
        jpnModificarSala.add(jpnFormulario);
        jpnFormulario.setLayout(null);

        lblTituloSala = new JLabel("Crear Sala");
        lblTituloSala.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 40));
        lblTituloSala.setHorizontalAlignment(SwingConstants.CENTER);
        lblTituloSala.setBounds(2, -2, 402, 63);
        jpnFormulario.add(lblTituloSala);

        // Crear un panel contenedor para los campos de texto y etiquetas
        JPanel panelContenedor = new JPanel();
        panelContenedor.setBackground(new Color(255, 255, 255));
        panelContenedor.setLayout(null);
        panelContenedor.setPreferredSize(new Dimension(380, 430));

        lblNumero = new JLabel("Número de Sala");
        lblNumero.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblNumero.setHorizontalAlignment(SwingConstants.LEFT);
        lblNumero.setBounds(52, 10, 297, 14);
        panelContenedor.add(lblNumero);

        txtNumeroSala = new JTextField();
        txtNumeroSala.setColumns(10);
        txtNumeroSala.setBounds(52, 30, 297, 34);
        panelContenedor.add(txtNumeroSala);

        lblNombre = new JLabel("Nombre de la Sala");
        lblNombre.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
        lblNombre.setBounds(52, 80, 297, 14);
        panelContenedor.add(lblNombre);

        txtNombreSala = new JTextField();
        txtNombreSala.setColumns(10);
        txtNombreSala.setBounds(52, 100, 297, 34);
        panelContenedor.add(txtNombreSala);

        lblCantidadSillas = new JLabel("Cantidad de Sillas");
        lblCantidadSillas.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblCantidadSillas.setHorizontalAlignment(SwingConstants.LEFT);
        lblCantidadSillas.setBounds(52, 150, 297, 14);
        panelContenedor.add(lblCantidadSillas);

        txtCantidadSillas = new JTextField();
        txtCantidadSillas.setBounds(52, 170, 297, 34);
        panelContenedor.add(txtCantidadSillas);

        lblFilas = new JLabel("Filas");
        lblFilas.setHorizontalAlignment(SwingConstants.LEFT);
        lblFilas.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblFilas.setBounds(52, 220, 297, 14);
        panelContenedor.add(lblFilas);

        txtFilas = new JTextField();
        txtFilas.setColumns(10);
        txtFilas.setBounds(52, 240, 297, 34);
        panelContenedor.add(txtFilas);

        lblColumnas = new JLabel("Columnas");
        lblColumnas.setHorizontalAlignment(SwingConstants.LEFT);
        lblColumnas.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblColumnas.setBounds(52, 290, 297, 14);
        panelContenedor.add(lblColumnas);

        txtColumnas = new JTextField();
        txtColumnas.setColumns(10);
        txtColumnas.setBounds(52, 310, 297, 34);
        panelContenedor.add(txtColumnas);

        lblIdCine = new JLabel("ID Cine");
        lblIdCine.setHorizontalAlignment(SwingConstants.LEFT);
        lblIdCine.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblIdCine.setBounds(52, 360, 297, 14);
        panelContenedor.add(lblIdCine);

        txtIdCine = new JTextField();
        txtIdCine.setColumns(10);
        txtIdCine.setBounds(52, 380, 297, 34);
        panelContenedor.add(txtIdCine);

        // Agregar el panel contenedor al JScrollPane
        JScrollPane scrollPane = new JScrollPane(panelContenedor);
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

        btnCrearSala = new RoundButton("Crear Sala");
        btnCrearSala.setBounds(130, 465, 165, 43);
        jpnFormulario.add(btnCrearSala);
        btnCrearSala.setForeground(Color.WHITE);
        btnCrearSala.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 15));
        btnCrearSala.setBorderPainted(false);
        btnCrearSala.setBackground(new Color(177, 7, 24));

        lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setBounds(10, 93, 374, 473);
        jpnModificarSala.add(lblNewLabel_1);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\cine 256.png")); // Actualiza la ruta de la imagen

        btnVolverCrearSala = new RoundButton("Volver");
        btnVolverCrearSala.setBounds(773, 23, 159, 48);
        contentPane.add(btnVolverCrearSala);
        btnVolverCrearSala.setText("   Volver");
        btnVolverCrearSala.setBorderPainted(false);
        btnVolverCrearSala.setBackground(new Color(255, 255, 255));
        btnVolverCrearSala.setForeground(new Color(16, 6, 38));
        btnVolverCrearSala.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 21));
    }

    // Getters y Setters
    public RoundButton getBtnCrearSala() {
        return btnCrearSala;
    }

    public RoundButton getBtnVolverCrearSala() {
        return btnVolverCrearSala;
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