package view.pelicula;

import view.roundClasses.RoundButton;
import view.roundClasses.RoundedPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class ViewNuevaPelicula extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private RoundedPanel jpnModificarPelicula;
    private RoundedPanel jpnFormulario;
    private JLabel lblNuevoCine;
    private JTextField txtDuracionPeliculaCrear;
    private JLabel lblTitulo;
    private JLabel lblDireccion;

    private JTextField txtTituloPeliculaCrear;
    private JLabel lblResennas;
    private JTextField txtPaisOrigenPeliculaCrear;
    private JLabel lblAnnoEstreno;
    private JTextField txtAnnoDeEstrenoPeliculaCrear;
    private RoundButton btnCrearPelicula;
    private RoundButton btnVolverCrearPelicula;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JTextField textField;
    private JTextField txtIdiomaPeliculaCrear;
    private JLabel lblldioma;
    private JTextField txtSinopsisPeliculaCrear;
    private JTextField txtTipoPeliculaCrear;
    private JLabel lblSinopsis;
    private JTextField txtGeneroPCrear;
    private JLabel lblTipo;
    private JLabel lblGenero;

    /**
     * Launch the application.
     */

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewNuevaPelicula frame = new ViewNuevaPelicula();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ViewNuevaPelicula() {
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
        lblNewLabel.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\volver.png"));
        jpnModificarPelicula = new RoundedPanel(50);
        jpnModificarPelicula.setBackground(new Color(0, 0, 0));
        jpnModificarPelicula.setBounds(45, 78, 890, 609);

        contentPane.add(jpnModificarPelicula);
        jpnModificarPelicula.setLayout(null);

        jpnFormulario = new RoundedPanel(50);
        jpnFormulario.setBounds(428, 32, 402, 534);
        jpnFormulario.setBackground(new Color(255, 255, 255));
        jpnModificarPelicula.add(jpnFormulario);
        jpnFormulario.setLayout(null);

        lblNuevoCine = new JLabel("Crear Pelicula");
        lblNuevoCine.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 40));
        lblNuevoCine.setHorizontalAlignment(SwingConstants.CENTER);
        lblNuevoCine.setBounds(2, -2, 402, 63);
        jpnFormulario.add(lblNuevoCine);

        // Crear un panel contenedor para los campos de texto y etiquetas
        JPanel panelContenedor = new JPanel();
        panelContenedor.setBackground(new Color(255, 255, 255));
        panelContenedor.setLayout(null);
        panelContenedor.setPreferredSize(new Dimension(380, 600));

        lblTitulo = new JLabel("TITULO PELICULA");
        lblTitulo.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
        lblTitulo.setBounds(52, 80 - 70, 297, 14); // Restar 70 a la coordenada y
        panelContenedor.add(lblTitulo);

        txtTituloPeliculaCrear = new JTextField();
        txtTituloPeliculaCrear.setColumns(10);
        txtTituloPeliculaCrear.setBounds(52, 100 - 70, 297, 34); // Restar 70 a la coordenada y
        panelContenedor.add(txtTituloPeliculaCrear);

        lblDireccion = new JLabel("DURACION");
        lblDireccion.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblDireccion.setHorizontalAlignment(SwingConstants.LEFT);
        lblDireccion.setBounds(52, 150 - 70, 297, 14); // Restar 70 a la coordenada y
        panelContenedor.add(lblDireccion);

        txtDuracionPeliculaCrear = new JTextField();
        txtDuracionPeliculaCrear.setBounds(52, 170 - 70, 297, 34); // Restar 70 a la coordenada y
        panelContenedor.add(txtDuracionPeliculaCrear);

        lblResennas = new JLabel("PAIS DE ORIGEN");
        lblResennas.setHorizontalAlignment(SwingConstants.LEFT);
        lblResennas.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblResennas.setBounds(52, 220 - 70, 297, 14); // Restar 70 a la coordenada y
        panelContenedor.add(lblResennas);

        txtPaisOrigenPeliculaCrear = new JTextField();
        txtPaisOrigenPeliculaCrear.setColumns(10);
        txtPaisOrigenPeliculaCrear.setBounds(52, 240 - 70, 297, 34); // Restar 70 a la coordenada y
        panelContenedor.add(txtPaisOrigenPeliculaCrear);

        lblAnnoEstreno = new JLabel("AÑO DE ESTRENO");
        lblAnnoEstreno.setHorizontalAlignment(SwingConstants.LEFT);
        lblAnnoEstreno.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblAnnoEstreno.setBounds(52, 290 - 70, 297, 14); // Restar 70 a la coordenada y
        panelContenedor.add(lblAnnoEstreno);

        txtAnnoDeEstrenoPeliculaCrear = new JTextField();
        txtAnnoDeEstrenoPeliculaCrear.setColumns(10);
        txtAnnoDeEstrenoPeliculaCrear.setBounds(52, 310 - 70, 297, 34); // Restar 70 a la coordenada y
        panelContenedor.add(txtAnnoDeEstrenoPeliculaCrear);

        txtIdiomaPeliculaCrear = new JTextField();
        txtIdiomaPeliculaCrear.setColumns(10);
        txtIdiomaPeliculaCrear.setBounds(52, 380 - 70, 297, 34); // Restar 70 a la coordenada y
        panelContenedor.add(txtIdiomaPeliculaCrear);

        lblldioma = new JLabel("IDIOMA");
        lblldioma.setHorizontalAlignment(SwingConstants.LEFT);
        lblldioma.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblldioma.setBounds(52, 355 - 70, 297, 14); // Restar 70 a la coordenada y
        panelContenedor.add(lblldioma);

        lblSinopsis = new JLabel("SINOPSIS");
        lblSinopsis.setHorizontalAlignment(SwingConstants.LEFT);
        lblSinopsis.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblSinopsis.setBounds(52, 425 - 70, 297, 14); // Restar 70 a la coordenada y
        panelContenedor.add(lblSinopsis);

        txtSinopsisPeliculaCrear = new JTextField();
        txtSinopsisPeliculaCrear.setColumns(10);
        txtSinopsisPeliculaCrear.setBounds(52, 450 - 70, 297, 34); // Restar 70 a la coordenada y
        panelContenedor.add(txtSinopsisPeliculaCrear);

        lblTipo = new JLabel("TIPO");
        lblTipo.setHorizontalAlignment(SwingConstants.LEFT);
        lblTipo.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblTipo.setBounds(52, 495 - 70, 297, 14); // Restar 70 a la coordenada y
        panelContenedor.add(lblTipo);

        txtTipoPeliculaCrear = new JTextField();
        txtTipoPeliculaCrear.setColumns(10);
        txtTipoPeliculaCrear.setBounds(52, 520 - 70, 297, 34); // Restar 70 a la coordenada y
        panelContenedor.add(txtTipoPeliculaCrear);

        lblGenero = new JLabel("GENERO");
        lblGenero.setHorizontalAlignment(SwingConstants.LEFT);
        lblGenero.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblGenero.setBounds(52, 565 - 70, 297, 14); // Restar 70 a la coordenada y
        panelContenedor.add(lblGenero);

        txtGeneroPCrear = new JTextField();
        txtGeneroPCrear.setColumns(10);
        txtGeneroPCrear.setBounds(52, 590 - 70, 297, 34); // Restar 70 a la coordenada y
        panelContenedor.add(txtGeneroPCrear);

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
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(8, 0)); // Más delgada
        scrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 8));

        scrollPane.setFocusable(false);
        scrollPane.setBounds(2, 59, 401, 381);
        jpnFormulario.add(scrollPane);

        btnCrearPelicula = new RoundButton("Registrarse");
        btnCrearPelicula.setText("Crear Pelicula");
        btnCrearPelicula.setBounds(130, 465, 165, 43);
        jpnFormulario.add(btnCrearPelicula);
        btnCrearPelicula.setForeground(Color.WHITE);
        btnCrearPelicula.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 15));
        btnCrearPelicula.setBorderPainted(false);
        btnCrearPelicula.setBackground(new Color(177, 7, 24));

        lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setBounds(10, 93, 374, 473);
        jpnModificarPelicula.add(lblNewLabel_1);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\premio-de-cine.png"));

        btnVolverCrearPelicula = new RoundButton("Iniciar Sesión");
        btnVolverCrearPelicula.setBounds(773, 23, 159, 48);
        contentPane.add(btnVolverCrearPelicula);
        btnVolverCrearPelicula.setText("   Volver");
        btnVolverCrearPelicula.setBorderPainted(false);
        btnVolverCrearPelicula.setBackground(new Color(255, 255, 255));
        btnVolverCrearPelicula.setForeground(new Color(16, 6, 38));
        btnVolverCrearPelicula.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 21));
    }

    public RoundButton getBtnCrearPelicula() {
        return btnCrearPelicula;
    }

    public RoundButton getBtnVolverCrearPelicula() {
        return btnVolverCrearPelicula;
    }

    public void limpiarCampos() {

        txtTituloPeliculaCrear.setText("");
        txtDuracionPeliculaCrear.setText("");
        txtPaisOrigenPeliculaCrear.setText("");
        txtAnnoDeEstrenoPeliculaCrear.setText("");
        txtIdiomaPeliculaCrear.setText("");
        txtSinopsisPeliculaCrear.setText("");
        txtTipoPeliculaCrear.setText("");
        txtGeneroPCrear.setText("");
    }

    public String pedirTituloPelicula() {
        String titulo = "";
        try {
            titulo = txtTituloPeliculaCrear.getText().trim(); // Eliminar espacios en blanco
            if (titulo.isEmpty()) {

                throw new Exception("El campo de título no puede estar vacío.");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return titulo;
    }

    public Double pedirDuracionPelicula() {
        String duracionStr = "";
        double duracion = 0.0;

        try {
            duracionStr = txtDuracionPeliculaCrear.getText().trim(); // Eliminar espacios en blanco

            // Validar que el campo no esté vacío
            if (duracionStr.isEmpty()) {
                throw new Exception("El campo de duración no puede estar vacío.");
            }

            // Validar que solo contenga números (enteros o decimales)
            if (!duracionStr.matches("\\d+(\\.\\d+)?")) {
                throw new Exception("La duración debe ser un número válido (ejemplo: 120 o 120.5).");
            }

            // Convertir a double
            duracion = Double.parseDouble(duracionStr);

            // Validar que la duración sea positiva
            if (duracion <= 0) {
                throw new Exception("La duración debe ser un número positivo.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Formato de duración inválido. Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        return duracion;
    }

    public String pedirPaisOrigen() {
        String pais = "";
        try {
            pais = txtPaisOrigenPeliculaCrear.getText().trim(); // Eliminar espacios en blanco
            if (pais.isEmpty()) {
                throw new Exception("El campo de país de origen no puede estar vacío.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return pais;
    }

    public Integer pedirAnnoEstreno() {
        String annoStr = "";
        int anno = 0;

        try {
            annoStr = txtAnnoDeEstrenoPeliculaCrear.getText().trim(); // Eliminar espacios en blanco

            // Validar que el campo no esté vacío
            if (annoStr.isEmpty()) {
                throw new Exception("El campo de año de estreno no puede estar vacío.");
            }

            // Validar que sea un número de 4 dígitos
            if (!annoStr.matches("\\d{4}")) {
                throw new Exception("El año de estreno debe ser un número de 4 dígitos.");
            }

            // Convertir a int
            anno = Integer.parseInt(annoStr);

            // Obtener el año actual
            int añoActual = java.time.Year.now().getValue();

            // Validar que el año sea razonable (entre 1900 y el año actual)
            if (anno < 1900 || anno > añoActual) {
                throw new Exception("El año de estreno debe estar entre 1900 y " + añoActual + ".");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Formato de año inválido. Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        return anno;
    }

    public String pedirIdioma() {
        String idioma = "";
        try {
            idioma = txtIdiomaPeliculaCrear.getText().trim(); // Eliminar espacios en blanco

            // Validar que el campo no esté vacío
            if (idioma.isEmpty()) {
                throw new Exception("El campo de idioma no puede estar vacío.");
            }

            // Validar que solo contenga letras y espacios
            if (!idioma.matches("^[A-Za-z\\s]+$")) {
                throw new Exception("El campo de idioma solo puede contener letras y espacios.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return idioma;
    }
    public String pedirSinopsis() {
        String sinopsis = "";
        try {
            sinopsis = txtSinopsisPeliculaCrear.getText().trim(); // Eliminar espacios en blanco
            if (sinopsis.isEmpty()) {
                throw new Exception("El campo de sinopsis no puede estar vacío.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return sinopsis;
    }

    public String pedirTipo() {
        String tipo = "";
        try {
            tipo = txtTipoPeliculaCrear.getText().trim(); // Eliminar espacios en blanco

            // Validar que el campo no esté vacío
            if (tipo.isEmpty()) {
                throw new Exception("El campo de tipo no puede estar vacío.");
            }

            // Validar que solo contenga letras y espacios
            if (!tipo.matches("^[A-Za-z\\s]+$")) {
                throw new Exception("El campo de tipo solo puede contener letras y espacios.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return tipo;
    }

    public String pedirGenero() {
        String genero = "";
        try {
            genero = txtGeneroPCrear.getText().trim(); // Eliminar espacios en blanco

            // Validar que el campo no esté vacío
            if (genero.isEmpty()) {
                throw new Exception("El campo de género no puede estar vacío.");
            }

            // Validar que solo contenga letras y espacios
            if (!genero.matches("^[A-Za-z\\s]+$")) {
                throw new Exception("El campo de género solo puede contener letras y espacios.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return genero;
    }
}
