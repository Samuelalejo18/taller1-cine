package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.roundClasses.RoundButton;
import view.roundClasses.RoundedPanel;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;


public class ViewAutenticacion extends JFrame {

	private JPanel contentPane;
	private RoundedPanel jpnLogin;
	private RoundedPanel jpnFormulario;
	private JLabel lblIniciarSesion;
	private JTextField txtCorreo;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_1;
	private JLabel lblCorreo;
	private JLabel lblC;
	private RoundButton btnRegistrar;
	private RoundButton btnLogin;
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { ViewAutenticacion frame = new
	 * ViewAutenticacion(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */
	/**
	 * Create the frame.
	 */
	public ViewAutenticacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(144, 7, 24));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.setResizable(false);
		this.setSize(1280, 800);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		jpnLogin = new RoundedPanel(50);
		jpnLogin.setBackground(new Color(0, 0, 0));
		jpnLogin.setBounds(96, 87, 1065, 613);

		contentPane.add(jpnLogin);
		jpnLogin.setLayout(null);

		jpnFormulario = new RoundedPanel(50);
		jpnFormulario.setBounds(80, 121, 402, 396);
		jpnFormulario.setBackground(new Color(255, 255, 255));
		jpnLogin.add(jpnFormulario);
		jpnFormulario.setLayout(null);

		lblIniciarSesion = new JLabel("Iniciar Sesión");
		lblIniciarSesion.setBounds(0, 11, 402, 63);
		lblIniciarSesion.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 40));
		lblIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		jpnFormulario.add(lblIniciarSesion);

		txtCorreo = new JTextField();
		txtCorreo.setBounds(54, 153, 297, 34);
		jpnFormulario.add(txtCorreo);
		txtCorreo.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(54, 244, 297, 34);
		jpnFormulario.add(passwordField);

		jpnFormulario.setComponentZOrder(passwordField, 1); // Poner passwordField detrás
		lblNewLabel_1 = new JLabel("Iniciar Sesión Empleado  para continuar");
		lblNewLabel_1.setBounds(0, 85, 402, 14);
		lblNewLabel_1.setFont(new Font("Raleway ExtraBold", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		jpnFormulario.add(lblNewLabel_1);

		lblCorreo = new JLabel("CORREO EMPLEADO");
		lblCorreo.setBounds(54, 128, 297, 14);
		lblCorreo.setFont(new Font("Open Sans", Font.BOLD, 11));
		lblCorreo.setHorizontalAlignment(SwingConstants.LEFT);
		jpnFormulario.add(lblCorreo);

		lblC = new JLabel("CONTRASEÑA EMPLEADO");
		lblC.setBounds(54, 224, 297, 14);
		lblC.setFont(new Font("Open Sans", Font.BOLD, 11));
		lblC.setHorizontalAlignment(SwingConstants.LEFT);
		jpnFormulario.add(lblC);

		// Crear el JLabel
		JLabel lblEye = new JLabel("");
		lblEye.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\ojoOpen.png"));
		lblEye.setBounds(124, 289, 33, 23); // Establecer el tamaño y la posición del JLabel

		jpnFormulario.add(lblEye);

		JButton toggleButton = new JButton("Mostrar");
		toggleButton.setFont(new Font("Raleway ExtraBold", Font.PLAIN, 12));

		toggleButton.setBackground(new Color(255, 255, 255));
		toggleButton.setBounds(158, 289, 90, 23);
		jpnFormulario.add(toggleButton);

		toggleButton.setBorderPainted(false);
		
		btnLogin = new RoundButton("Registrarse");
		btnLogin.setText("Iniciar Sesión");
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 15));
		btnLogin.setBorderPainted(false);
		btnLogin.setBackground(new Color(177, 7, 24));
		btnLogin.setBounds(124, 323, 165, 43);
		jpnFormulario.add(btnLogin);

		toggleButton.addActionListener(new ActionListener() {
			private boolean isPasswordVisible = false;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (isPasswordVisible) {
					passwordField.setEchoChar('•'); // Ocultar contraseña
					toggleButton.setText("Mostrar");
					
						lblEye.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\ojoOpen.png"));
						lblEye.setBounds(124, 289, 33, 23); // Establecer el tamaño y la posición del JLabel
					
				} else {
					passwordField.setEchoChar((char) 0); // Mostrar contraseña
					toggleButton.setText("Ocultar");
					lblEye.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\esconder.png"));
					lblEye.setBounds(124, 289, 33, 23); // Establecer el tamaño y la posición del JLabel
				
				}
				isPasswordVisible = !isPasswordVisible;
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(540, 79, 515, 489);
		jpnLogin.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\Neo_Cine_Logo_Transparent__1_-removebg-preview.png"));
				
						btnRegistrar = new RoundButton("Registrarse");
						btnRegistrar.setBounds(953, 19, 207, 48);
						contentPane.add(btnRegistrar);
						btnRegistrar.setBorderPainted(false);
						btnRegistrar.setBackground(new Color(255, 255, 255));
						btnRegistrar.setForeground(new Color(16, 6, 38));
						btnRegistrar.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 21));

		/*
		 * this.btnRegistrar.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { ViewAutenticacion.this.dispose();
		 * ViewRegistro viewRegistro= new ViewRegistro(); viewRegistro.setVisible(true);
		 * viewRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); } });
		 */
	}

	
	
	
	public RoundButton getBtnLogin() {
		return btnLogin;
	}




	public void setBtnLogin(RoundButton btnLogin) {
		this.btnLogin = btnLogin;
	}




	public JTextField getTxtCorreo() {
		return txtCorreo;
	}

	public void setTxtCorreo(JTextField txtCorreo) {
		this.txtCorreo = txtCorreo;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public RoundButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public void setBtnRegistrar(RoundButton btnRegistrar) {
		this.btnRegistrar = btnRegistrar;
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
				throw new Exception("El campo de email no puede estar vacío.");

			}

			// Verificar si el email coincide con el formato esperado
			if (matcher.matches()) {
				emailValido = true;
			} else {
				emailValido = false;
				throw new Exception("El correo electrónico no tiene un formato válido.");

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

		}

		return email;
	}
	
	

	
	
	public String pedirContrasena() {
		char[] passwordChars = passwordField.getPassword();
		String contrasena = new String(passwordChars);

		try {
			if (contrasena.isEmpty()) {
				java.util.Arrays.fill(passwordChars, ' ');
				throw new Exception("El campo de contraseña no puede estar vacío.");

			}
			java.util.Arrays.fill(passwordChars, ' ');
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

		return contrasena;
	}
}
