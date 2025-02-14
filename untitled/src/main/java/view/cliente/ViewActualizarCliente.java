package view.cliente;

import view.roundClasses.RoundButton;
import view.roundClasses.RoundedPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ViewActualizarCliente extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private RoundedPanel jpnRegistro;
    private RoundedPanel jpnFormulario;
    private JLabel lblNuevoCliente;
    private JTextField txtEmail;
    private JLabel lblNombreCliente;
    private JLabel lblEmail;

    private JTextField txtNombreCliente;
    private JLabel lblTelefono;
    private JTextField txtTelefonoCliente;
    private RoundButton btnModificarCliente;
    private RoundButton btnVolverModificar;
    private JLabel lblNewLabel;
    private JTextField txtIDCliente;
    private JLabel lblIdCliente;
    private JLabel lblNewLabel_1;
    private JLabel lblUsername;
    private JTextField txtUsername;
    private JLabel lblDocumentoIdentidad;
    private JTextField txtDocumentoIdentidad;

    public ViewActualizarCliente() {
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
        jpnRegistro = new RoundedPanel(50);
        jpnRegistro.setBackground(new Color(0, 0, 0));
        jpnRegistro.setBounds(45, 78, 890, 614);

        contentPane.add(jpnRegistro);
        jpnRegistro.setLayout(null);

        jpnFormulario = new RoundedPanel(50);
        jpnFormulario.setBounds(53, 34, 402, 542);
        jpnFormulario.setBackground(new Color(255, 255, 255));
        jpnRegistro.add(jpnFormulario);
        jpnFormulario.setLayout(null);

        lblNuevoCliente = new JLabel("Modificar Cliente");
        lblNuevoCliente.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 40));
        lblNuevoCliente.setHorizontalAlignment(SwingConstants.CENTER);
        lblNuevoCliente.setBounds(2, -2, 402, 63);
        jpnFormulario.add(lblNuevoCliente);

        txtEmail = new JTextField();
        txtEmail.setBounds(52, 230, 297, 34);
        jpnFormulario.add(txtEmail);
        txtEmail.setColumns(10);

        lblNombreCliente = new JLabel("NOMBRE CLIENTE");
        lblNombreCliente.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblNombreCliente.setHorizontalAlignment(SwingConstants.LEFT);
        lblNombreCliente.setBounds(52, 135, 297, 14);
        jpnFormulario.add(lblNombreCliente);

        lblEmail = new JLabel("EMAIL");
        lblEmail.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
        lblEmail.setBounds(52, 205, 297, 14);
        jpnFormulario.add(lblEmail);

        txtNombreCliente = new JTextField();
        txtNombreCliente.setColumns(10);
        txtNombreCliente.setBounds(52, 160, 297, 34);
        jpnFormulario.add(txtNombreCliente);

        lblTelefono = new JLabel("TELEFONO");
        lblTelefono.setHorizontalAlignment(SwingConstants.LEFT);
        lblTelefono.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblTelefono.setBounds(52, 275, 297, 14);
        jpnFormulario.add(lblTelefono);

        txtTelefonoCliente = new JTextField();
        txtTelefonoCliente.setColumns(10);
        txtTelefonoCliente.setBounds(52, 300, 297, 34);
        jpnFormulario.add(txtTelefonoCliente);

        btnModificarCliente = new RoundButton("Modificar");
        btnModificarCliente.setText("Modificar");
        btnModificarCliente.setBounds(120, 488, 165, 43);
        jpnFormulario.add(btnModificarCliente);
        btnModificarCliente.setForeground(Color.WHITE);
        btnModificarCliente.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 15));
        btnModificarCliente.setBorderPainted(false);
        btnModificarCliente.setBackground(new Color(177, 7, 24));

        txtIDCliente = new JTextField();
        txtIDCliente.setColumns(10);
        txtIDCliente.setBounds(52, 90, 297, 34);
        jpnFormulario.add(txtIDCliente);

        lblIdCliente = new JLabel("ID CLIENTE");
        lblIdCliente.setHorizontalAlignment(SwingConstants.LEFT);
        lblIdCliente.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblIdCliente.setBounds(52, 65, 297, 14);
        jpnFormulario.add(lblIdCliente);

        lblUsername = new JLabel("USERNAME");
        lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
        lblUsername.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblUsername.setBounds(52, 345, 297, 14);
        jpnFormulario.add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setColumns(10);
        txtUsername.setBounds(52, 370, 297, 34);
        jpnFormulario.add(txtUsername);

        lblDocumentoIdentidad = new JLabel("DOCUMENTO IDENTIDAD");
        lblDocumentoIdentidad.setHorizontalAlignment(SwingConstants.LEFT);
        lblDocumentoIdentidad.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblDocumentoIdentidad.setBounds(52, 415, 297, 14);
        jpnFormulario.add(lblDocumentoIdentidad);

        txtDocumentoIdentidad = new JTextField();
        txtDocumentoIdentidad.setColumns(10);
        txtDocumentoIdentidad.setBounds(52, 440, 297, 34);
        jpnFormulario.add(txtDocumentoIdentidad);

        lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\cliente.png"));
        lblNewLabel_1.setBounds(483, 34, 374, 473);
        jpnRegistro.add(lblNewLabel_1);

        btnVolverModificar = new RoundButton("Volver");
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

    public RoundButton getBtnModificarCliente() {
        return btnModificarCliente;
    }

    public void llenarCampos(int id, String username, String email, String nombre, String telefono, int documentoIdentidad) {
        txtIDCliente.setText(String.valueOf(id));
        txtUsername.setText(username);
        txtEmail.setText(email);
        txtNombreCliente.setText(nombre);
        txtTelefonoCliente.setText(telefono);
        txtDocumentoIdentidad.setText(String.valueOf(documentoIdentidad));
    }

    public void limpiarCampos() {
        txtIDCliente.setText("");
        txtUsername.setText("");
        txtEmail.setText("");
        txtNombreCliente.setText("");
        txtTelefonoCliente.setText("");
        txtDocumentoIdentidad.setText("");
    }

    public String pedirNombreCliente() {
        String nombre = "";
        try {
            nombre = txtNombreCliente.getText();
            if (nombre.isEmpty()) {
                throw new Exception("El campo de nombre no puede estar vacío.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return nombre;
    }

    public String pedirEmail() {
        String email = "";
        try {
            email = txtEmail.getText();
            if (email.isEmpty()) {
                throw new Exception("El campo de email no puede estar vacío.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return email;
    }

    public String pedirTelefono() {
        String telefono = txtTelefonoCliente.getText().trim();
        String regex = "\\d+";

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

    public String pedirUsername() {
        String username = "";
        try {
            username = txtUsername.getText();
            if (username.isEmpty()) {
                throw new Exception("El campo de username no puede estar vacío.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return username;
    }

    public int pedirDocumentoIdentidad() {
        String documento = txtDocumentoIdentidad.getText().trim();
        int documentoIdentidad = 0;

        try {
            if (documento.isEmpty()) {
                throw new Exception("El campo de documento de identidad no puede estar vacío.");
            }
            documentoIdentidad = Integer.parseInt(documento);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El documento de identidad debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return documentoIdentidad;
    }

    public int pedirId() {
        String idTxt = txtIDCliente.getText().trim();
        int id = 0;

        try {
            if (idTxt.isEmpty()) {
                throw new Exception("El campo de ID no puede estar vacío.");
            }
            id = Integer.parseInt(idTxt);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return id;
    }
}