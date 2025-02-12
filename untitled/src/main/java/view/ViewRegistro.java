package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ViewRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private RoundedPanel jpnRegistro;
	private RoundedPanel jpnFormulario;
	private JLabel lblCuentaNueva;
	private JTextField txtUserName;
	private JLabel lblNombre;
	private JLabel lblUserName;
	private RoundButton btnLogin;
	private JTextField txtNombre;
	private JLabel lblId;
	private JTextField txtDI;
	private JLabel lblCorreo;
	private JLabel lblContrasena;
	private JPasswordField passwordField;
	private JTextField txtCorreo;
	private JTextField txtTelefono;
	private JLabel lblNumeroDeTelefono;
	private RoundButton btnRegister;
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
	public ViewRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(177, 7, 24));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.setSize(1280, 800);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setResizable(false);
		jpnRegistro = new RoundedPanel(50);
		jpnRegistro.setBackground(new Color(0, 0, 0));
		jpnRegistro.setBounds(102, 81, 1065, 638);

		contentPane.add(jpnRegistro);
		jpnRegistro.setLayout(null);

		jpnFormulario = new RoundedPanel(50);
		jpnFormulario.setBounds(603, 36, 402, 563);
		jpnFormulario.setBackground(new Color(255, 255, 255));
		jpnRegistro.add(jpnFormulario);
		jpnFormulario.setLayout(null);

		JLabel lblEye = new JLabel("");
		lblEye.setBounds(123, 476, 33, 23); // Establecer el tamaño y la posición del JLabel

		// Cargar y redimensionar la imagen

		lblEye.setIcon(new ImageIcon(
				"D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\ojoOpen.png"));

		JButton toggleButton = new JButton("Mostrar");

		toggleButton.setBackground(new Color(255, 255, 255));
		toggleButton.setBounds(175, 476, 90, 23);
		jpnFormulario.add(toggleButton);

		toggleButton.setBorderPainted(false);

		toggleButton.addActionListener(new ActionListener() {
			private boolean isPasswordVisible = false;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (isPasswordVisible) {
					passwordField.setEchoChar('•'); // Ocultar contraseña
					toggleButton.setText("Mostrar");
					lblEye.setIcon(new ImageIcon(
							"D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\ojoOpen.png"));

				} else {
					passwordField.setEchoChar((char) 0); // Mostrar contraseña
					toggleButton.setText("Ocultar");
					lblEye.setIcon(new ImageIcon(
							"D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\esconder.png"));
				}
				isPasswordVisible = !isPasswordVisible;
			}
		});

		jpnFormulario.add(lblEye);

		lblCuentaNueva = new JLabel("Cuenta Nueva");
		lblCuentaNueva.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 40));
		lblCuentaNueva.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuentaNueva.setBounds(2, -2, 402, 63);
		jpnFormulario.add(lblCuentaNueva);

		txtUserName = new JTextField();
		txtUserName.setBounds(52, 166, 297, 34);
		jpnFormulario.add(txtUserName);
		txtUserName.setColumns(10);

		lblNombre = new JLabel("NOMBRE EMPLEADO");
		lblNombre.setFont(new Font("Open Sans", Font.BOLD, 11));
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setBounds(52, 70, 297, 14);
		jpnFormulario.add(lblNombre);

		lblUserName = new JLabel("USUARIO ");
		lblUserName.setFont(new Font("Open Sans", Font.BOLD, 11));
		lblUserName.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserName.setBounds(52, 142, 297, 14);
		jpnFormulario.add(lblUserName);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(52, 96, 297, 34);
		jpnFormulario.add(txtNombre);

		lblId = new JLabel("DOCUMENTO IDENTIDAD");
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		lblId.setFont(new Font("Open Sans", Font.BOLD, 11));
		lblId.setBounds(52, 209, 297, 14);
		jpnFormulario.add(lblId);

		txtDI = new JTextField();
		txtDI.setColumns(10);
		txtDI.setBounds(52, 228, 297, 34);
		jpnFormulario.add(txtDI);

		lblCorreo = new JLabel("CORREO");
		lblCorreo.setHorizontalAlignment(SwingConstants.LEFT);
		lblCorreo.setFont(new Font("Open Sans", Font.BOLD, 11));
		lblCorreo.setBounds(52, 270, 297, 14);
		jpnFormulario.add(lblCorreo);

		lblContrasena = new JLabel("CONTRASEÑA");
		lblContrasena.setHorizontalAlignment(SwingConstants.LEFT);
		lblContrasena.setFont(new Font("Open Sans", Font.BOLD, 11));
		lblContrasena.setBounds(52, 335, 297, 14);
		jpnFormulario.add(lblContrasena);

		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(52, 294, 297, 34);
		jpnFormulario.add(txtCorreo);

		passwordField = new JPasswordField();
		passwordField.setBounds(52, 360, 297, 32);
		jpnFormulario.add(passwordField);

		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(52, 426, 297, 34);
		jpnFormulario.add(txtTelefono);

		lblNumeroDeTelefono = new JLabel("NÚMERO DE TELÉFONO");
		lblNumeroDeTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumeroDeTelefono.setFont(new Font("Open Sans", Font.BOLD, 11));
		lblNumeroDeTelefono.setBounds(52, 402, 297, 14);
		jpnFormulario.add(lblNumeroDeTelefono);

		btnRegister = new RoundButton("Registrarse");
		btnRegister.setBounds(133, 509, 165, 43);
		jpnFormulario.add(btnRegister);
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 15));
		btnRegister.setBorderPainted(false);
		btnRegister.setBackground(new Color(177, 7, 24));

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(
				"D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\Neo_Cine_Logo_Transparent__1_-removebg-preview.png"));
		lblNewLabel_3.setBounds(50, 82, 515, 489);
		jpnRegistro.add(lblNewLabel_3);

		btnLogin = new RoundButton("Iniciar Sesión");
		btnLogin.setBounds(957, 22, 207, 48);
		contentPane.add(btnLogin);
		btnLogin.setText("Iniciar Sesión ");
		btnLogin.setBorderPainted(false);
		btnLogin.setBackground(new Color(255, 255, 255));
		btnLogin.setForeground(new Color(16, 6, 38));
		btnLogin.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 21));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		// Cargar y redimensionar la imagen

		/*
		 * this.btnLogin.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { ViewRegistro.this.dispose();
		 * ViewAutenticacion viewAutenticacion= new ViewAutenticacion();
		 * viewAutenticacion.setVisible(true);
		 * viewAutenticacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); } });
		 */
	}

	

	public RoundButton getBtnRegister() {
		return btnRegister;
	}



	public void setBtnRegister(RoundButton btnRegister) {
		this.btnRegister = btnRegister;
	}



	public JTextField getTxtApellido() {
		return txtUserName;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtUserName = txtApellido;
	}

	public RoundButton getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(RoundButton btnLogin) {
		this.btnLogin = btnLogin;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtId() {
		return txtDI;
	}

	public void setTxtId(JTextField txtId) {
		this.txtDI = txtId;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public JTextField getTxtCorreo() {
		return txtCorreo;
	}

	public void setTxtCorreo(JTextField txtCorreo) {
		this.txtCorreo = txtCorreo;
	}

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public String pedirNombre() {
		String nombre = "";
		boolean nombreValido = false;

		try {
			nombre = txtNombre.getText();

			if (nombre.isEmpty()) {

				throw new Exception(" El campo de nombre no puede estar vacio");

			}

			if (nombre.matches("[a-zA-ZñÑ ]+")) {
				nombreValido = true;
			} else {
				throw new Exception("Ingrese un nombre válido (solo letras).");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

		}

		return nombre;
	}

	public String pedirUserName() {

		String username = "";
		boolean usernameValido = false;

		try {

			username = txtUserName.getText();
			if (username.isEmpty()) {
				username = null;
				throw new Exception(" El campo de nombre no puede estar vacio");

			}

			if (username.matches("[a-zA-ZñÑ ]+")) {
				usernameValido = true;

			} else {
				username = null;
				throw new Exception("Ingrese un nombre válido (solo letras).");

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

		}

		return username;
	}

	public String pedirEmail() {
		boolean emailValido = false;

		String email = "";

		try {

			email = txtCorreo.getText();

			// Expresión regular para validar el formato de correo electrónico
			String regex = "^[a-zA-Z0-9_+&*-ñÑ]+(?:\\.[a-zA-Z0-9_+&*-ñÑ]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-ZñÑ]{2,7}$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(email);
			if (email.isEmpty()) {
				email = null;
				throw new Exception("El campo de email no puede estar vacío.");

			}

			// Verificar si el email coincide con el formato esperado
			if (matcher.matches()) {
				emailValido = true;
			} else {
				emailValido = false;
				email = null;
				throw new Exception("El correo electrónico no tiene un formato válido.");

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

		}

		return email;
	}

	public int pedirId() {
		String idTxt = "";
		int id = 0;
		boolean idValido = false;

		try {

			idTxt = txtDI.getText();
			if (idTxt.isEmpty()) {
				idValido = false;
				id = Integer.parseInt(null);
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

	public String pedirNumeroTelefono() {
		String txtNumeroTelefono = "";

		String numeroTelefono = "";

		boolean numeroTelefonoValido = false;

		try {
			txtNumeroTelefono = txtTelefono.getText();
			if (txtNumeroTelefono.isEmpty()) {
				numeroTelefono = null;
				throw new NumberFormatException("El campo de telefono no puede estar vacío.");
			} else {
				numeroTelefono = txtNumeroTelefono;
				numeroTelefonoValido = true;

			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Ingrese un telefono valido, Solo numeros", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

		return numeroTelefono;
	}

	public String pedirContrasena() {
		char[] passwordChars = passwordField.getPassword();
		String contrasena = new String(passwordChars);

		try {
			if (contrasena.isEmpty()) {
				java.util.Arrays.fill(passwordChars, ' ');
				contrasena = null;
				throw new Exception("El campo de contraseña no puede estar vacío.");

			}
			java.util.Arrays.fill(passwordChars, ' ');
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

		return contrasena;
	}
}
