package view.pelicula;

import view.roundClasses.RoundButton;
import view.roundClasses.RoundedPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class ViewActualizarPelicula extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private RoundedPanel jpnModificarPelicula;
    private RoundedPanel jpnFormulario;
    private JLabel lblNuevoCine;
    private JTextField txtDuracionPelicula;
    private JLabel lblTitulo;
    private JLabel lblDireccion;

    private JTextField txtTituloPeliculaModificar;
    private JLabel lblResennas;
    private JTextField txtPaisOrigenPeliculaModificar;
    private JLabel lblAnnoEstreno;
    private JTextField txtAnnoDeEstrenoPelicula;
    private RoundButton btnModificarPelicula;
    private RoundButton btnVolverModificarPelicula;
    private JLabel lblNewLabel;
    private JTextField txtIDPeliculaModificar;
    private JLabel lblIdCine;
    private JLabel lblNewLabel_1;
    private JTextField textField;
    private JTextField txtIdiomaPeliculaModificar;
    private JLabel lblldioma;
    private JTextField txtSinopsisPeliculaModificar;
    private JTextField txtTipoPeliculaModificar;
    private JLabel lblSinopsis;
    private JTextField txtGeneroPModificar;
    private JLabel lblTipo;
    private JLabel lblGenero;

    /**
     * Launch the application.
     */

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewActualizarPelicula frame = new ViewActualizarPelicula();
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
    public ViewActualizarPelicula() {
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
        jpnFormulario.setBounds(53, 34, 402, 534);
        jpnFormulario.setBackground(new Color(255, 255, 255));
        jpnModificarPelicula.add(jpnFormulario);
        jpnFormulario.setLayout(null);

        lblNuevoCine = new JLabel("Modificar Pelicula");
        lblNuevoCine.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 40));
        lblNuevoCine.setHorizontalAlignment(SwingConstants.CENTER);
        lblNuevoCine.setBounds(2, -2, 402, 63);
        jpnFormulario.add(lblNuevoCine);

        // Crear un panel contenedor para los campos de texto y etiquetas
        JPanel panelContenedor = new JPanel();
        panelContenedor.setBackground(new Color(255, 255, 255));
        panelContenedor.setLayout(null);
        panelContenedor.setPreferredSize(new Dimension(380, 650)); // Ajusta el tamaño según sea necesario

        // Agregar los componentes al panel contenedor
        lblIdCine = new JLabel("ID PELICULA");
        lblIdCine.setHorizontalAlignment(SwingConstants.LEFT);
        lblIdCine.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblIdCine.setBounds(52, 10, 297, 14);
        panelContenedor.add(lblIdCine);

        txtIDPeliculaModificar = new JTextField();
        txtIDPeliculaModificar.setColumns(10);
        txtIDPeliculaModificar.setBounds(52, 30, 297, 34);
        panelContenedor.add(txtIDPeliculaModificar);

        lblTitulo = new JLabel("TITULO PELICULA");
        lblTitulo.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
        lblTitulo.setBounds(52, 80, 297, 14);
        panelContenedor.add(lblTitulo);

        txtTituloPeliculaModificar = new JTextField();
        txtTituloPeliculaModificar.setColumns(10);
        txtTituloPeliculaModificar.setBounds(52, 100, 297, 34);
        panelContenedor.add(txtTituloPeliculaModificar);

        lblDireccion = new JLabel("DURACION");
        lblDireccion.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblDireccion.setHorizontalAlignment(SwingConstants.LEFT);
        lblDireccion.setBounds(52, 150, 297, 14);
        panelContenedor.add(lblDireccion);

        txtDuracionPelicula = new JTextField();
        txtDuracionPelicula.setBounds(52, 170, 297, 34);
        panelContenedor.add(txtDuracionPelicula);

        lblResennas = new JLabel("PAIS DE ORIGEN");
        lblResennas.setHorizontalAlignment(SwingConstants.LEFT);
        lblResennas.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblResennas.setBounds(52, 220, 297, 14);
        panelContenedor.add(lblResennas);

        txtPaisOrigenPeliculaModificar = new JTextField();
        txtPaisOrigenPeliculaModificar.setColumns(10);
        txtPaisOrigenPeliculaModificar.setBounds(52, 240, 297, 34);
        panelContenedor.add(txtPaisOrigenPeliculaModificar);

        lblAnnoEstreno = new JLabel("AÑO DE ESTRENO");
        lblAnnoEstreno.setHorizontalAlignment(SwingConstants.LEFT);
        lblAnnoEstreno.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblAnnoEstreno.setBounds(52, 290, 297, 14);
        panelContenedor.add(lblAnnoEstreno);

        txtAnnoDeEstrenoPelicula = new JTextField();
        txtAnnoDeEstrenoPelicula.setColumns(10);
        txtAnnoDeEstrenoPelicula.setBounds(52, 310, 297, 34);
        panelContenedor.add(txtAnnoDeEstrenoPelicula);

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


        txtIdiomaPeliculaModificar = new JTextField();
        txtIdiomaPeliculaModificar.setColumns(10);
        txtIdiomaPeliculaModificar.setBounds(52, 380, 297, 34);
        panelContenedor.add(txtIdiomaPeliculaModificar);

        lblldioma = new JLabel("IDIOMA");
        lblldioma.setHorizontalAlignment(SwingConstants.LEFT);
        lblldioma.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblldioma.setBounds(52, 355, 297, 14);
        panelContenedor.add(lblldioma);

        lblSinopsis = new JLabel("SINOPSIS");
        lblSinopsis.setHorizontalAlignment(SwingConstants.LEFT);
        lblSinopsis.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblSinopsis.setBounds(52, 425, 297, 14);
        panelContenedor.add(lblSinopsis);

        txtSinopsisPeliculaModificar = new JTextField();
        txtSinopsisPeliculaModificar.setColumns(10);
        txtSinopsisPeliculaModificar.setBounds(52, 450, 297, 34);
        panelContenedor.add(txtSinopsisPeliculaModificar);

        lblTipo = new JLabel("TIPO");
        lblTipo.setHorizontalAlignment(SwingConstants.LEFT);
        lblTipo.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblTipo.setBounds(52, 495, 297, 14);
        panelContenedor.add(lblTipo);

        txtTipoPeliculaModificar = new JTextField();
        txtTipoPeliculaModificar.setColumns(10);
        txtTipoPeliculaModificar.setBounds(52, 520, 297, 34);
        panelContenedor.add(txtTipoPeliculaModificar);

        lblGenero = new JLabel("GENERO");
        lblGenero.setHorizontalAlignment(SwingConstants.LEFT);
        lblGenero.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblGenero.setBounds(52, 565, 297, 14);
        panelContenedor.add(lblGenero);

        txtGeneroPModificar = new JTextField();
        txtGeneroPModificar.setColumns(10);
        txtGeneroPModificar.setBounds(52, 590, 297, 34);
        panelContenedor.add(txtGeneroPModificar);
        scrollPane.setFocusable(false);
        scrollPane.setBounds(2, 59, 401, 381);
        jpnFormulario.add(scrollPane);

        btnModificarPelicula = new RoundButton("Registrarse");
        btnModificarPelicula.setText("Modificar Pelicula");
        btnModificarPelicula.setBounds(110, 465, 165, 43);
        jpnFormulario.add(btnModificarPelicula);
        btnModificarPelicula.setForeground(Color.WHITE);
        btnModificarPelicula.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 15));
        btnModificarPelicula.setBorderPainted(false);
        btnModificarPelicula.setBackground(new Color(177, 7, 24));

        lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\claquetaRoja.png"));
        lblNewLabel_1.setBounds(491, 39, 374, 473);
        jpnModificarPelicula.add(lblNewLabel_1);

        btnVolverModificarPelicula = new RoundButton("Iniciar Sesión");
        btnVolverModificarPelicula.setBounds(773, 23, 159, 48);
        contentPane.add(btnVolverModificarPelicula);
        btnVolverModificarPelicula.setText("   Volver");
        btnVolverModificarPelicula.setBorderPainted(false);
        btnVolverModificarPelicula.setBackground(new Color(255, 255, 255));
        btnVolverModificarPelicula.setForeground(new Color(16, 6, 38));
        btnVolverModificarPelicula.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 21));
    }


    public RoundButton getBtnModificarPelicula() {
        return btnModificarPelicula;
    }

    public RoundButton getBtnVolverModificarPelicula() {
        return btnVolverModificarPelicula;
    }

    public void llenarCampos(int id, String titulo, double duracion, String paisOrigen, int anno, String idioma, String sinopsis, String tipo, String genero) {
        // Asignar los valores a los campos correspondientes
        txtIDPeliculaModificar.setText(String.valueOf(id));
        txtTituloPeliculaModificar.setText(titulo);
        txtDuracionPelicula.setText(String.valueOf(duracion));
        txtPaisOrigenPeliculaModificar.setText(paisOrigen);
        txtAnnoDeEstrenoPelicula.setText(String.valueOf(anno));
        txtIdiomaPeliculaModificar.setText(idioma);
        txtSinopsisPeliculaModificar.setText(sinopsis);
        txtTipoPeliculaModificar.setText(tipo);
        txtGeneroPModificar.setText(genero);
    }

    public void limpiarCampos() {
        txtIDPeliculaModificar.setText("");
        txtTituloPeliculaModificar.setText("");
        txtDuracionPelicula.setText("");
        txtPaisOrigenPeliculaModificar.setText("");
        txtAnnoDeEstrenoPelicula.setText("");
        txtIdiomaPeliculaModificar.setText("");
        txtSinopsisPeliculaModificar.setText("");
        txtTipoPeliculaModificar.setText("");
        txtGeneroPModificar.setText("");
    }

    public String pedirTituloPelicula() {
        String titulo = "";
        try {
            titulo = txtTituloPeliculaModificar.getText().trim(); // Eliminar espacios en blanco
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
            duracionStr = txtDuracionPelicula.getText().trim(); // Eliminar espacios en blanco

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
            pais = txtPaisOrigenPeliculaModificar.getText().trim(); // Eliminar espacios en blanco
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
            annoStr = txtAnnoDeEstrenoPelicula.getText().trim(); // Eliminar espacios en blanco

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
            idioma = txtIdiomaPeliculaModificar.getText().trim(); // Eliminar espacios en blanco

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
            sinopsis = txtSinopsisPeliculaModificar.getText().trim(); // Eliminar espacios en blanco
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
            tipo = txtTipoPeliculaModificar.getText().trim(); // Eliminar espacios en blanco

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
            genero = txtGeneroPModificar.getText().trim(); // Eliminar espacios en blanco

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

    public int pedirId() {
        String idTxt = "";
        int id = 0;
        boolean idValido = false;

        try {

            idTxt = txtIDPeliculaModificar.getText();
            if (idTxt.isEmpty()) {
                idValido = false;
                id = 0;
                throw new NumberFormatException("El campo de id no puede estar vacío.");
            } else {
                id = Integer.parseInt(idTxt);
                idValido = true;

            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un id valido, Solo numeros", "Error",
                    JOptionPane.ERROR_MESSAGE);

        }

        return id;

    }
}
