package controller;

import controller.DAO.EmpleadoDAO;
import model.Empleado;
import model.exepciones.AuntenticacionFallidaException;
import view.ViewAutenticacion;
import view.ViewRegistro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;


public class ControllerAutenticacion implements ActionListener {
    EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    private List<Empleado> empleados;
    static Empleado usuarioAutenticado;

    JButton btnLoginAutenticacion;
    JButton btnLoginRegistro;
    ViewAutenticacion viewAutenticacion;
    ViewRegistro viewRegistro;

    JButton btnRegisterRegistro;
    JButton btnRegisterLogin;

    ControllerViewPrincipal principall;
    public ControllerAutenticacion() {
        viewAutenticacion = new ViewAutenticacion();
        viewRegistro = new ViewRegistro();
        btnLoginAutenticacion = viewAutenticacion.getBtnLogin();
        btnLoginAutenticacion.addActionListener(this);
        mostrarVentanaAutenticacion(true);

        btnLoginRegistro = viewAutenticacion.getBtnRegistrar();
        btnLoginRegistro.addActionListener(this);

        btnRegisterRegistro = viewRegistro.getBtnRegister();
        btnRegisterRegistro.addActionListener(this);
        btnRegisterLogin = viewRegistro.getBtnLogin();
        btnRegisterLogin.addActionListener(this);

        if(usuarioAutenticado != null) {
            principall= new ControllerViewPrincipal();
            principall.mostrarViewPrincipal(true);
            viewAutenticacion.dispose();
            viewAutenticacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }



    }


    public void mostrarVentanaRegistro(boolean visible) {
        viewRegistro.setVisible(true);
        viewRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void mostrarVentanaAutenticacion(boolean visible) {
        viewAutenticacion.setVisible(true);
        viewAutenticacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnLoginAutenticacion) {
            try {

                usuarioAutenticado = autenticarse(viewAutenticacion.pedirEmail(),
                        viewAutenticacion.pedirContrasena());
                JOptionPane.showMessageDialog(viewAutenticacion,
                        "Autenticacion exitosa para " + usuarioAutenticado.getNombre(), "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
                viewAutenticacion.dispose();


            } catch (AuntenticacionFallidaException excepcion) {
                JOptionPane.showMessageDialog(viewAutenticacion, excepcion.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
                excepcion.printStackTrace();
            }
        }

        if (e.getSource() == btnLoginRegistro) {
            viewAutenticacion.dispose();
            mostrarVentanaRegistro(true);
            viewAutenticacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        if (e.getSource() == btnRegisterLogin) {
            viewRegistro.dispose();
            viewAutenticacion.setVisible(true);
            viewRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        if (e.getSource() == btnRegisterRegistro) {

            Empleado Empleado = new Empleado(viewRegistro.pedirUserName(), viewRegistro.pedirEmail(),
                    viewRegistro.pedirNombre(), viewRegistro.pedirTelefono(), viewRegistro.pedirId(), viewRegistro.pedirContrasena());

            registrar(Empleado);

        }

    }


    public boolean registrar(Empleado empleado) {
        if (empleado.getUsername().isEmpty() || empleado.getEmail().isEmpty() ||
                empleado.getNombre().isEmpty() || empleado.getTelefono().isEmpty() ||
                empleado.getPassword().isEmpty()) {

            JOptionPane.showMessageDialog(viewRegistro, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        boolean existeUsuario = false;
        try {
            boolean agregado = empleadoDAO.agregar(empleado);
            if (agregado) {
                existeUsuario = true;
                JOptionPane.showMessageDialog(viewRegistro, "Registro exitoso para el usuario " + empleado.getNombre(),
                        "Éxito", JOptionPane.INFORMATION_MESSAGE);
                empleados.add(empleado);
            } else {
                return false;
            }


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(viewRegistro, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return existeUsuario;
    }


    public Empleado autenticarse(String usuarioEmail, String contrasena) throws AuntenticacionFallidaException {
        Empleado usuarioEncontrado = null;
        try {
            empleados = empleadoDAO.listarTodos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(viewAutenticacion, e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        for (Empleado empleado : empleados) {
            if (empleado.getEmail().equals(usuarioEmail)) {
                usuarioEncontrado = empleado;
                break;
            }
        }

        if (usuarioEncontrado != null) {
            if (usuarioEncontrado.getPassword().equals(contrasena)) {
                usuarioAutenticado = usuarioEncontrado;
                ControllerViewPrincipal principal = new ControllerViewPrincipal();
                principal.mostrarViewPrincipal(true);
                viewAutenticacion.dispose();
                viewAutenticacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                return usuarioAutenticado;
            } else {
                throw new AuntenticacionFallidaException(" ViewAutenticacion fallida");
            }
        } else {
            throw new AuntenticacionFallidaException(" El usuario no existe");
        }
    }


}


