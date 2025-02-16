package view;

import java.awt.Color;
import java.awt.EventQueue;
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
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;
import java.awt.Canvas;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.BoxLayout;


public class ViewPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton btnCliente;
    private JButton btnFuncion;
    private JButton btnPeliculas;
    private JButton btnReserva;

    /**
     * Launch the application.
     */

    private JPanel contentPane1;
    private JPanel jpnSlideBar;
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private JButton btnCine;

	/**
	 * Create the frame.
	 */
	public ViewPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.setSize(1280, 720);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setResizable(false);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(221, 22, 49));
		panel.setBounds(-1, 0, 1281, 62);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnMenu = new JButton("");
		btnMenu.setContentAreaFilled(false);
		btnMenu.setFocusable(false);
		btnMenu.setBackground(new Color(221, 22, 49));
		btnMenu.setFocusTraversalKeysEnabled(false);
		btnMenu.setBorderPainted(false);
		btnMenu.setFocusPainted(false);
		btnMenu.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\menu (1).png"));
		btnMenu.setBounds(0, 0, 86, 64);
		panel.add(btnMenu);

		JPanel jpnSlideBar = new JPanel();
		jpnSlideBar.setBackground(new Color(51, 51, 51));
		jpnSlideBar.setBounds(-1, 62, 300, 619);
		contentPane.add(jpnSlideBar);
		jpnSlideBar.setLayout(null);

		 btnCine = new JButton("    Cine");
		btnCine.setFont(new Font("Raleway ExtraBold", Font.PLAIN, 16));
		btnCine.setHorizontalAlignment(SwingConstants.LEADING);
		btnCine.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\carrete-de-pelicula.png"));
		btnCine.setBounds(0, 122, 300, 48);
		btnCine.setBackground(new Color(51, 51, 51));
		btnCine.setForeground(new Color(159, 159, 159));
		btnCine.setFocusPainted(false);
		btnCine.setBorderPainted(false);
		btnCine.setOpaque(true);
		btnCine.setContentAreaFilled(false); // Elimina destellos blancos
		btnCine.setFocusPainted(false);
		btnCine.setBorderPainted(false);
		btnCine.setOpaque(true);
		btnCine.setContentAreaFilled(false); // Evita el destello blanco

		btnCine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Timer timer = new Timer(50, null);
				timer.addActionListener(new ActionListener() {
					private int step = 0;
					private final int maxSteps = 10;

					@Override
					public void actionPerformed(ActionEvent e) {
						int r = Math.max(0, 51 - (step * 5));
						int g = Math.max(0, 51 - (step * 5));
						int b = Math.max(0, 51 - (step * 5));

						btnCine.setBackground(new Color(r, g, b));
						step++;
						if (step > maxSteps) {
							timer.stop();
						}
					}
				});
				timer.start();
			}
		});


		btnCliente = new JButton("    Cliente");
		btnCliente.setFont(new Font("Raleway ExtraBold", Font.PLAIN, 16));
		btnCliente.setHorizontalAlignment(SwingConstants.LEADING);
		btnCliente.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\nueva-cuenta.png"));
		btnCliente.setBounds(0, 204, 300, 48);
		btnCliente.setOpaque(true);
		btnCliente.setForeground(new Color(159, 159, 159));
		btnCliente.setBackground(new Color(51, 51, 51));
		btnCliente.setFocusPainted(false);
		btnCliente.setContentAreaFilled(false);
		btnCliente.setBorderPainted(false);

		btnCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Timer timer = new Timer(50, null);
				timer.addActionListener(new ActionListener() {
					private int step = 0;
					private final int maxSteps = 10;

					@Override
					public void actionPerformed(ActionEvent e) {
						int r = Math.max(0, 51 - (step * 5));
						int g = Math.max(0, 51 - (step * 5));
						int b = Math.max(0, 51 - (step * 5));

						btnCliente.setBackground(new Color(r, g, b));
						step++;
						if (step > maxSteps) {
							timer.stop();
						}
					}
				});
				timer.start();
			}
		});
		jpnSlideBar.add(btnCliente);






		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalStrut_1.setBounds(7, 7, 12, 20);
		jpnSlideBar.add(verticalStrut_1);

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		verticalStrut_3.setBounds(7, 34, 12, 20);
		jpnSlideBar.add(verticalStrut_3);

		Component verticalStrut_4 = Box.createVerticalStrut(20);
		verticalStrut_4.setBounds(7, 61, 12, 20);
		jpnSlideBar.add(verticalStrut_4);

		Component verticalStrut_10 = Box.createVerticalStrut(20);
		verticalStrut_10.setBounds(7, 91, 12, 20);
		jpnSlideBar.add(verticalStrut_10);
		jpnSlideBar.add(btnCine);

		 btnFuncion = new JButton("    Funciones");
		btnFuncion.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\maiz.png"));
		btnFuncion.setHorizontalAlignment(SwingConstants.LEADING);
		btnFuncion.setFont(new Font("Raleway ExtraBold", Font.PLAIN, 16));
		btnFuncion.setBounds(0, 290, 300, 47);
		btnFuncion.setOpaque(true);
		btnFuncion.setForeground(new Color(159, 159, 159));
		btnFuncion.setFocusPainted(false);
		btnFuncion.setContentAreaFilled(false);
		btnFuncion.setBorderPainted(false);
		btnFuncion.setBackground(new Color(159, 159, 159));
		jpnSlideBar.add(btnFuncion);

		 btnPeliculas = new JButton("    Peliculas");
		btnPeliculas.setHorizontalAlignment(SwingConstants.LEADING);
		btnPeliculas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPeliculas.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\claqueta.png"));
		btnPeliculas.setFont(new Font("Raleway ExtraBold", Font.PLAIN, 16));
		btnPeliculas.setBounds(0, 376, 300, 48);
		btnPeliculas.setOpaque(true);
		btnPeliculas.setForeground(new Color(159, 159, 159));
		btnPeliculas.setFocusPainted(false);
		btnPeliculas.setContentAreaFilled(false);
		btnPeliculas.setBorderPainted(false);
		btnPeliculas.setBackground(new Color(51, 51, 51));
		jpnSlideBar.add(btnPeliculas);

		 btnReserva = new JButton("    Reserva");
		btnReserva.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\entrada-de-cine.png"));
		btnReserva.setHorizontalAlignment(SwingConstants.LEADING);
		btnReserva.setFont(new Font("Raleway ExtraBold", Font.PLAIN, 16));
		btnReserva.setBounds(0, 462, 300, 48);
		btnReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReserva.setOpaque(true);
		btnReserva.setForeground(new Color(159, 159, 159));
		btnReserva.setFocusPainted(false);
		btnReserva.setContentAreaFilled(false);
		btnReserva.setBorderPainted(false);
		btnReserva.setBackground(new Color(51, 51, 51));
		jpnSlideBar.add(btnReserva);

		Component verticalStrut_5 = Box.createVerticalStrut(20);
		verticalStrut_5.setBounds(7, 538, 12, 20);
		jpnSlideBar.add(verticalStrut_5);

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		verticalStrut_2.setBounds(7, 565, 12, 20);
		jpnSlideBar.add(verticalStrut_2);

		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(7, 592, 12, 20);
		jpnSlideBar.add(verticalStrut);

				JLabel lblNewLabel_3 = new JLabel("");
				lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_3.setBounds(0, 7, 300, 108);
				jpnSlideBar.add(lblNewLabel_3);
				lblNewLabel_3.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\Neo_Cine_Logosmall.png"));
				
				JButton btnSala = new JButton("    Salas");
				btnSala.setOpaque(true);
				btnSala.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\pantalla-de-cine.png"));
				btnSala.setHorizontalAlignment(SwingConstants.LEADING);
				btnSala.setForeground(new Color(159, 159, 159));
				btnSala.setFont(new Font("Raleway ExtraBold", Font.PLAIN, 16));
				btnSala.setFocusPainted(false);
				btnSala.setContentAreaFilled(false);
				btnSala.setBorderPainted(false);
				btnSala.setBackground(new Color(51, 51, 51));
				btnSala.setBounds(0, 548, 300, 48);
				jpnSlideBar.add(btnSala);

		Component verticalGlue = Box.createVerticalGlue();
		verticalGlue.setBounds(143, 669, 1, 1);
		contentPane.add(verticalGlue);

		  // Panel central con CardLayout
        mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);
        mainPanel.setBounds(300, 62, 980, 619);
        contentPane.add(mainPanel);
        JPanel emptypanel = new JPanel();
        emptypanel.setBackground(Color.WHITE);
        // Crear paneles de contenido




      //  JPanel jpnCliente = new JPanel();
        //jpnCliente.setBackground(Color.BLUE);
        //JPanel jpnFuncion = new JPanel();
        //jpnFuncion.setBackground(Color.GREEN);
       // JPanel jpnPeliculas = new JPanel();
        //jpnPeliculas.setBackground(Color.YELLOW);
       // JPanel jpnReserva = new JPanel();
        //jpnReserva.setBackground(Color.CYAN);
        //mainPanel.add(emptypanel);
        emptypanel.setLayout(new BoxLayout(emptypanel, BoxLayout.X_AXIS));
        
        Component glue = Box.createGlue();
        emptypanel.add(glue);
        
        JLabel lblNewLabel_3_1 = new JLabel("");
        lblNewLabel_3_1.setIcon(new ImageIcon("D:\\Universidad\\5.Quinto semestre\\NUEVAS TECNOLOGÍAS DE DESARROLLO\\Semana 1 (27 de enero al 02 de febrero 2025)\\taller1-cine\\untitled\\src\\main\\java\\utils\\img\\Neo_Cine_Logo_Transparent__1_-removebg-preview.png"));
        lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
        emptypanel.add(lblNewLabel_3_1);
        
        Component glue_1 = Box.createGlue();
        emptypanel.add(glue_1);
        //mainPanel.add(jpnCine, "Cine");
        //jpnCine.setLayout(null);
       // mainPanel.add(jpnCliente, "Cliente");
        //mainPanel.add(jpnFuncion, "Funciones");
       // mainPanel.add(jpnPeliculas, "Peliculas");
        //mainPanel.add(jpnReserva, "Reserva");

        // Asignar eventos a los botones
        btnCine.addActionListener(e -> cardLayout.show(mainPanel, "Cine"));
        btnCliente.addActionListener(e -> cardLayout.show(mainPanel, "Cliente"));
        btnFuncion.addActionListener(e -> cardLayout.show(mainPanel, "Funciones"));
        btnPeliculas.addActionListener(e -> cardLayout.show(mainPanel, "Pelicula"));
        btnReserva.addActionListener(e -> cardLayout.show(mainPanel, "Reserva"));
		btnSala.addActionListener(e -> cardLayout.show(mainPanel, "Sala"));

		btnMenu.addActionListener(new ActionListener() {
		    private boolean isExpanded = true;
		    private final int expandedWidth = 300;
		    private final int collapsedWidth = 70; // Nuevo ancho al contraer

		    @Override
		    public void actionPerformed(ActionEvent e) {
		        Timer timer = new Timer(10, null);
		        timer.addActionListener(new ActionListener() {
		            private int step = 0;
		            private final int maxSteps = 10;
		            private final int stepSize = (expandedWidth - collapsedWidth) / maxSteps;

		            @Override
		            public void actionPerformed(ActionEvent e) {
		                int newWidth;
		                if (isExpanded) {
		                    newWidth = Math.max(collapsedWidth, jpnSlideBar.getWidth() - stepSize);
		                } else {
		                    newWidth = Math.min(expandedWidth, jpnSlideBar.getWidth() + stepSize);
		                }

		                jpnSlideBar.setBounds(jpnSlideBar.getX(), jpnSlideBar.getY(), newWidth, jpnSlideBar.getHeight());
		                contentPane.repaint();

		                step++;
		                if (step >= maxSteps) {
		                    timer.stop();
		                    isExpanded = !isExpanded; // Cambiar el estado
		                }
		            }
		        });
		        timer.start();
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

    public JButton getBtnCine() {
        return btnCine;
    }

    public void setBtnCine(JButton btnCine) {
        this.btnCine = btnCine;
    }

    public JButton getBtnCliente() {
        return btnCliente;
    }

    public void setBtnCliente(JButton btnCliente) {
        this.btnCliente = btnCliente;
    }

    public JButton getBtnFuncion() {
        return btnFuncion;
    }

    public void setBtnFuncion(JButton btnFuncion) {
        this.btnFuncion = btnFuncion;
    }

    public JButton getBtnPeliculas() {
        return btnPeliculas;
    }

    public void setBtnPeliculas(JButton btnPeliculas) {
        this.btnPeliculas = btnPeliculas;
    }

    public JButton getBtnReserva() {
        return btnReserva;
    }

    public void setBtnReserva(JButton btnReserva) {
        this.btnReserva = btnReserva;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public void setCardLayout(CardLayout cardLayout) {
        this.cardLayout = cardLayout;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JPanel getJpnSlideBar() {
        return jpnSlideBar;
    }

    public void setJpnSlideBar(JPanel jpnSlideBar) {
        this.jpnSlideBar = jpnSlideBar;
    }

    public JPanel getContentPane1() {
        return contentPane1;
    }

    public void setContentPane1(JPanel contentPane1) {
        this.contentPane1 = contentPane1;
    }
}
