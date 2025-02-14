package view.Cine;

import view.roundClasses.RoundButton;
import view.roundClasses.RoundedPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ViewActualizarCine extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private RoundedPanel jpnRegistro;
    private RoundedPanel jpnFormulario;
    private JLabel lblNuevoCine;
    private JTextField txtDireccion;
    private JLabel lblNombreCine;
    private JLabel lblDireccion;

    private JTextField txtNombreCine;
    private JLabel lblResennas;
    private JTextField txtReseñas;
    private JLabel lblTelefono;
    private JTextField txtTelefonoCine;
    private RoundButton btnModificarCine;
    private RoundButton btnVolverModificar;
    private JLabel lblNewLabel;
    private JTextField txtIDCine;
    private JLabel lblIdCine;
    private JLabel lblNewLabel_1;
    /**
     * Launch the application.
     */

    /*
     * public static void main(String[] args) { EventQueue.invokeLater(new
     * Runnable() { public void run() { try { ViewRegistro frame = new
     * ViewRegistro(); frame.setVisible(true); } catch (Exception e) {
     * e.printStackTrace(); } } }); }
     */

    /**
     * Create the frame.
     */
    public ViewActualizarCine() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(177, 7, 24));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        this.setSize(1000, 700);
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        this.setResizable(false);
        
        lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(788, 24, 37, 47);
        contentPane.add(lblNewLabel);
        lblNewLabel.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\volver.png"));
        jpnRegistro = new RoundedPanel(50);
        jpnRegistro.setBackground(new Color(0, 0, 0));
        jpnRegistro.setBounds(45, 78, 890, 538);

        contentPane.add(jpnRegistro);
        jpnRegistro.setLayout(null);

        jpnFormulario = new RoundedPanel(50);
        jpnFormulario.setBounds(53, 34, 402, 473);
        jpnFormulario.setBackground(new Color(255, 255, 255));
        jpnRegistro.add(jpnFormulario);
        jpnFormulario.setLayout(null);

        lblNuevoCine = new JLabel("Modificar Cine");
        lblNuevoCine.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 40));
        lblNuevoCine.setHorizontalAlignment(SwingConstants.CENTER);
        lblNuevoCine.setBounds(2, -2, 402, 63);
        jpnFormulario.add(lblNuevoCine);

        txtDireccion = new JTextField();
        txtDireccion.setBounds(52, 230, 297, 34);
        jpnFormulario.add(txtDireccion);
        txtDireccion.setColumns(10);

        lblNombreCine = new JLabel("NOMBRE CINE");
        lblNombreCine.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblNombreCine.setHorizontalAlignment(SwingConstants.LEFT);
        lblNombreCine.setBounds(52, 135, 297, 14);
        jpnFormulario.add(lblNombreCine);

        lblDireccion = new JLabel("DIRECCION CINE");
        lblDireccion.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblDireccion.setHorizontalAlignment(SwingConstants.LEFT);
        lblDireccion.setBounds(52, 205, 297, 14);
        jpnFormulario.add(lblDireccion);

        txtNombreCine = new JTextField();
        txtNombreCine.setColumns(10);
        txtNombreCine.setBounds(52, 160, 297, 34);
        jpnFormulario.add(txtNombreCine);

        lblResennas = new JLabel("RESEÑAS");
        lblResennas.setHorizontalAlignment(SwingConstants.LEFT);
        lblResennas.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblResennas.setBounds(52, 275, 297, 14);
        jpnFormulario.add(lblResennas);

        txtReseñas = new JTextField();
        txtReseñas.setColumns(10);
        txtReseñas.setBounds(52, 300, 297, 34);
        jpnFormulario.add(txtReseñas);

        lblTelefono = new JLabel("TELEFONO CINE");
        lblTelefono.setHorizontalAlignment(SwingConstants.LEFT);
        lblTelefono.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblTelefono.setBounds(52, 345, 297, 14);
        jpnFormulario.add(lblTelefono);

        txtTelefonoCine = new JTextField();
        txtTelefonoCine.setColumns(10);
        txtTelefonoCine.setBounds(52, 370, 297, 34);
        jpnFormulario.add(txtTelefonoCine);

        btnModificarCine = new RoundButton("Registrarse");
        btnModificarCine.setText("Modificar");
        btnModificarCine.setBounds(120, 420, 165, 43);
        jpnFormulario.add(btnModificarCine);
        btnModificarCine.setForeground(Color.WHITE);
        btnModificarCine.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 15));
        btnModificarCine.setBorderPainted(false);
        btnModificarCine.setBackground(new Color(177, 7, 24));
        
        txtIDCine = new JTextField();
        txtIDCine.setColumns(10);
        txtIDCine.setBounds(52, 90, 297, 34);
        jpnFormulario.add(txtIDCine);
        
        lblIdCine = new JLabel("ID CINE");
        lblIdCine.setHorizontalAlignment(SwingConstants.LEFT);
        lblIdCine.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblIdCine.setBounds(52, 65, 297, 14);
        jpnFormulario.add(lblIdCine);
        
        lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\lentes.png"));
        lblNewLabel_1.setBounds(483, 34, 374, 473);
        jpnRegistro.add(lblNewLabel_1);

        btnVolverModificar = new RoundButton("Iniciar Sesión");
        btnVolverModificar.setBounds(773, 23, 159, 48);
        contentPane.add(btnVolverModificar);
        btnVolverModificar.setText("   Volver");
        btnVolverModificar.setBorderPainted(false);
        btnVolverModificar.setBackground(new Color(255, 255, 255));
        btnVolverModificar.setForeground(new Color(16, 6, 38));
        btnVolverModificar.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 21));



    }


    public RoundButton getBtnVolverModificar() {
        return btnVolverModificar;
    }

    public RoundButton getBtnModificarCine() {
        return btnModificarCine;
    }

    public void llenarCampos(int id, String nombre, String direccion, String resennas, String telefono) {
        txtIDCine.setText(String.valueOf(id));
        txtNombreCine.setText(nombre);
        txtDireccion.setText(direccion);
        txtReseñas.setText(resennas);
        txtTelefonoCine.setText(telefono);
    }
    public void limpiarCampos() {
        txtIDCine.setText("");
        txtNombreCine.setText("");
        txtDireccion.setText("");
        txtReseñas.setText("");
        txtTelefonoCine.setText("");
    }


	public String pedirNombreCine() {
        String nombre = "";
        boolean nombreValido = false;

        try {
            nombre = txtNombreCine.getText();
            if (nombre.isEmpty()) {
                nombre = null;
                throw new Exception(" El campo de nombre no puede estar vacio");

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }

        return nombre;
    }

    public String pedirDireccion() {

        String dirreccion = "";
        boolean dirreacionValida = false;
        try {
            dirreccion = txtDireccion.getText();
            if (dirreccion.isEmpty()) {
                dirreccion = null;
                dirreacionValida = false;
                throw new Exception(" El campo de nombre no puede estar vacio");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return dirreccion;
    }

    public String pedirTelefono() {
        String telefono = txtTelefonoCine.getText().trim(); // Eliminar espacios en blanco
        String regex = "\\d+"; // Expresión regular para solo números

        if (telefono.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo de teléfono no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        if (!telefono.matches(regex)) {
            JOptionPane.showMessageDialog(this, "El teléfono solo debe contener números.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        return telefono;
    }
    public String pedirResennas() {
        String resennas = "";
        boolean nombreValido = false;

        try {
            resennas = txtReseñas.getText();
            if ( resennas.isEmpty()) {
                resennas = null;
                throw new Exception(" El campo de  resennas no puede estar vacio");

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }

        return  resennas;
    }


    public int pedirId() {
        String idTxt = "";
        int id = 0;
        boolean idValido = false;

        try {

            idTxt = txtIDCine.getText();
            if (idTxt.isEmpty()) {
                idValido = false;
                id =0 ;
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
