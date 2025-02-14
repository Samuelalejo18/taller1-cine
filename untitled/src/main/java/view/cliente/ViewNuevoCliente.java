package view.cliente;

import view.roundClasses.RoundButton;
import view.roundClasses.RoundedPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewNuevoCliente extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private RoundedPanel jpnRegistro;
    private RoundedPanel jpnFormulario;
    private JLabel lblNuevoCliente;
    private JTextField txtEmail;
    private JLabel lblNombreCliente;
    private JLabel lblEmail;
    private RoundButton btnVolver;
    private JTextField txtNombreCliente;
    private JLabel lblTelefono;
    private JTextField txtTelefonoCliente;
    private RoundButton btnCrearCliente;
    private JLabel lblNewLabel;
    private JLabel lblUsername;
    private JTextField txtUsername;
    private JLabel lblDocumentoIdentidad;
    private JTextField txtDocumentoIdentidad;

    public ViewNuevoCliente() {
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
        jpnFormulario.setBounds(423, 28, 402, 451);
        jpnFormulario.setBackground(new Color(255, 255, 255));
        jpnRegistro.add(jpnFormulario);
        jpnFormulario.setLayout(null);

        lblNuevoCliente = new JLabel("Nuevo Cliente");
        lblNuevoCliente.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 40));
        lblNuevoCliente.setHorizontalAlignment(SwingConstants.CENTER);
        lblNuevoCliente.setBounds(2, -2, 402, 63);
        jpnFormulario.add(lblNuevoCliente);

        txtEmail = new JTextField();
        txtEmail.setBounds(52, 166, 297, 34);
        jpnFormulario.add(txtEmail);
        txtEmail.setColumns(10);

        lblNombreCliente = new JLabel("NOMBRE CLIENTE");
        lblNombreCliente.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblNombreCliente.setHorizontalAlignment(SwingConstants.LEFT);
        lblNombreCliente.setBounds(52, 70, 297, 14);
        jpnFormulario.add(lblNombreCliente);

        lblEmail = new JLabel("EMAIL");
        lblEmail.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
        lblEmail.setBounds(52, 142, 297, 14);
        jpnFormulario.add(lblEmail);

        txtNombreCliente = new JTextField();
        txtNombreCliente.setColumns(10);
        txtNombreCliente.setBounds(52, 96, 297, 34);
        jpnFormulario.add(txtNombreCliente);

        lblTelefono = new JLabel("TELEFONO");
        lblTelefono.setHorizontalAlignment(SwingConstants.LEFT);
        lblTelefono.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblTelefono.setBounds(52, 209, 297, 14);
        jpnFormulario.add(lblTelefono);

        txtTelefonoCliente = new JTextField();
        txtTelefonoCliente.setColumns(10);
        txtTelefonoCliente.setBounds(52, 228, 297, 34);
        jpnFormulario.add(txtTelefonoCliente);

        btnCrearCliente = new RoundButton("Crear");
        btnCrearCliente.setText("Crear");
        btnCrearCliente.setBounds(121, 397, 165, 43);
        jpnFormulario.add(btnCrearCliente);
        btnCrearCliente.setForeground(Color.WHITE);
        btnCrearCliente.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 15));
        btnCrearCliente.setBorderPainted(false);
        btnCrearCliente.setBackground(new Color(177, 7, 24));

        lblUsername = new JLabel("USERNAME");
        lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
        lblUsername.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblUsername.setBounds(52, 270, 297, 14);
        jpnFormulario.add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setColumns(10);
        txtUsername.setBounds(52, 294, 297, 34);
        jpnFormulario.add(txtUsername);

        lblDocumentoIdentidad = new JLabel("DOCUMENTO IDENTIDAD");
        lblDocumentoIdentidad.setHorizontalAlignment(SwingConstants.LEFT);
        lblDocumentoIdentidad.setFont(new Font("Open Sans", Font.BOLD, 11));
        lblDocumentoIdentidad.setBounds(52, 335, 297, 14);
        jpnFormulario.add(lblDocumentoIdentidad);

        txtDocumentoIdentidad = new JTextField();
        txtDocumentoIdentidad.setColumns(10);
        txtDocumentoIdentidad.setBounds(52, 354, 297, 34);
        jpnFormulario.add(txtDocumentoIdentidad);

        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\experto.png"));
        lblNewLabel_3.setBounds(79, 97, 295, 333);
        jpnRegistro.add(lblNewLabel_3);

        btnVolver = new RoundButton("Volver");
        btnVolver.setBounds(773, 23, 159, 48);
        contentPane.add(btnVolver);
        btnVolver.setText("   Volver");
        btnVolver.setBorderPainted(false);
        btnVolver.setBackground(new Color(255, 255, 255));
        btnVolver.setForeground(new Color(16, 6, 38));
        btnVolver.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 21));
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
    }

    public RoundButton getBtnVolver() {
        return btnVolver;
    }

    public void setBtnVolver(RoundButton btnVolver) {
        this.btnVolver = btnVolver;
    }

    public RoundButton getBtnCrearCliente() {
        return btnCrearCliente;
    }

    public void setBtnCrearCliente(RoundButton btnCrearCliente) {
        this.btnCrearCliente = btnCrearCliente;
    }

    public void limpiarCampos() {
        txtNombreCliente.setText("");
        txtEmail.setText("");
        txtTelefonoCliente.setText("");
        txtUsername.setText("");
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
}