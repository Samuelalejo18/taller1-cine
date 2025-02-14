package controller;

import controller.DAO.PeliculaDAO;
import model.Pelicula;
import view.pelicula.JPanelPelicula;
import view.pelicula.ViewActualizarPelicula;
import view.pelicula.ViewNuevaPelicula;
import view.roundClasses.RoundButton;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;

public class ControllerPelicula implements ActionListener {
    private JPanelPelicula jPanelPelicula;
    private JTable tablePelicula;
    private JButton btnNuevaPelicula;
    private JButton btnModificarPelicula;
    private JButton btnEliminarPelicula;
    private JButton btnIdPelicula;
    private JButton btnTodasPeliculas;
    private Pelicula peliculaSeleccionada;

    private PeliculaDAO peliculaDAO;


    //Crear pelicula
    private RoundButton btnCrearPelicula;
    private RoundButton btnVolverCrearPelicula;
    private ViewNuevaPelicula viewNuevaPelicula;


    //Modificar Cine
    private ViewActualizarPelicula viewActualizarPelicula;
    private RoundButton btnUpdatePelicula;
    private RoundButton btnVolverModificarPelicula;

    public ControllerPelicula() {
        jPanelPelicula = new JPanelPelicula();
        peliculaDAO = new PeliculaDAO();
        tablePelicula = jPanelPelicula.getTablePelicula();
        btnNuevaPelicula = jPanelPelicula.getBtnNuevaPelicula();
        btnEliminarPelicula = jPanelPelicula.getBtnEliminarPelicula();
        btnIdPelicula = jPanelPelicula.getBtnIdPelicula();
        btnModificarPelicula = jPanelPelicula.getBtnModificarPelicula();
        btnTodasPeliculas = jPanelPelicula.getBtnTodos();
        btnTodasPeliculas.addActionListener(this);
        btnNuevaPelicula.addActionListener(this);
        btnEliminarPelicula.addActionListener(this);
        btnIdPelicula.addActionListener(this);
        btnModificarPelicula.addActionListener(this);
        actualizarTablaPelicula();

        //Crear peligula
        viewNuevaPelicula = new ViewNuevaPelicula();
        btnCrearPelicula = viewNuevaPelicula.getBtnCrearPelicula();
        btnVolverCrearPelicula = viewNuevaPelicula.getBtnVolverCrearPelicula();
        btnCrearPelicula.addActionListener(this);
        btnVolverCrearPelicula.addActionListener(this);


        //Modificar Pelicula
        seleccionarPeliculaTable();
        viewActualizarPelicula = new ViewActualizarPelicula();
        btnUpdatePelicula = viewActualizarPelicula.getBtnModificarPelicula();
        btnVolverModificarPelicula = viewActualizarPelicula.getBtnVolverModificarPelicula();
        btnUpdatePelicula.addActionListener(this);
        btnVolverModificarPelicula.addActionListener(this);


        viewActualizarPelicula.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                viewActualizarPelicula.limpiarCampos(); // Borra la información
                peliculaSeleccionada = null; // Resetea la selección
            }
        });


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNuevaPelicula) {
            viewNuevaPelicula.limpiarCampos();
            viewNuevaPelicula.setVisible(true);
            viewNuevaPelicula.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        if (e.getSource() == btnVolverCrearPelicula) {
            viewNuevaPelicula.setVisible(false);
            viewNuevaPelicula.dispose();
            viewNuevaPelicula.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            jPanelPelicula.getTablePelicula().removeAll();
            actualizarTablaPelicula();
        }
        if (e.getSource() == btnCrearPelicula) {
            crearPelicula(crearPeliculaView());
        }

        if (e.getSource() == btnModificarPelicula) {
            if (peliculaSeleccionada != null) {

                viewActualizarPelicula.setVisible(true);
                viewActualizarPelicula.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                viewActualizarPelicula.llenarCampos(peliculaSeleccionada.getIdPelicula(), peliculaSeleccionada.getTitulo(), peliculaSeleccionada.getDuracion(), peliculaSeleccionada.getPaisOrigen(), peliculaSeleccionada.getAnno(), peliculaSeleccionada.getIdioma(), peliculaSeleccionada.getSinopsis(), peliculaSeleccionada.getTipo(), peliculaSeleccionada.getGenero());

            } else {
                viewActualizarPelicula.limpiarCampos();
                viewActualizarPelicula.setVisible(true);
                viewActualizarPelicula.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }

        }

        if (e.getSource() == btnUpdatePelicula) {
            modificarPelicula(modificarPeliculaView());
            peliculaSeleccionada = null;
            viewActualizarPelicula.limpiarCampos();
        }

        if (e.getSource() == btnVolverModificarPelicula) {
            viewActualizarPelicula.setVisible(false);
            viewActualizarPelicula.dispose();
            viewActualizarPelicula.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            jPanelPelicula.getTablePelicula().removeAll();
            actualizarTablaPelicula();
        }

        if (e.getSource() == btnEliminarPelicula) {
            if (peliculaSeleccionada != null) {
                int confirmacion = JOptionPane.showConfirmDialog(jPanelPelicula, "¿Está seguro de que desea eliminar el cine seleccionado?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    eliminarCine(peliculaSeleccionada);
                }
            } else {
                JOptionPane.showMessageDialog(jPanelPelicula, "Seleccione un cine para eliminar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }


        if (e.getSource() == btnIdPelicula) {
            int idPelicula = jPanelPelicula.pedirId();
            Pelicula pelicula = new Pelicula(idPelicula);
            buscarPorId(pelicula);
            if (idPelicula == 0 || pelicula == null) {

                jPanelPelicula.getTablePelicula().removeAll();
                actualizarTablaPelicula();
            }

        }

        if (e.getSource() == btnTodasPeliculas) {
            jPanelPelicula.getTablePelicula().removeAll();
            actualizarTablaPelicula();
        }

    }

    public void actualizarTablaPelicula() {
        List<Pelicula> peliculas = null;
        try {
            peliculas = peliculaDAO.listarTodos();
            DefaultTableModel modelo = jPanelPelicula.getModel();
            modelo.setRowCount(0); // Limpiar datos previos

            for (Pelicula pelicula : peliculas) {
                modelo.addRow(new Object[]{pelicula.getIdPelicula(), pelicula.getTitulo(), pelicula.getDuracion(), pelicula.getPaisOrigen(), pelicula.getAnno(), pelicula.getIdioma(), pelicula.getSinopsis(), pelicula.getTipo(), pelicula.getGenero()});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(jPanelPelicula, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public Pelicula seleccionarPeliculaTable() {
        peliculaSeleccionada = null; // Objeto Pelicula seleccionado

        tablePelicula.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) { // Evitar eventos duplicados
                int selectedRow = tablePelicula.getSelectedRow(); // Obtener la fila seleccionada
                if (selectedRow != -1) { // Si hay una fila seleccionada
                    // Obtener los valores de la fila seleccionada
                    int id = (int) tablePelicula.getValueAt(selectedRow, 0);
                    String titulo = (String) tablePelicula.getValueAt(selectedRow, 1);
                    double duracion = (double) tablePelicula.getValueAt(selectedRow, 2);
                    String paisOrigen = (String) tablePelicula.getValueAt(selectedRow, 3);
                    int anno = (int) tablePelicula.getValueAt(selectedRow, 4);
                    String idioma = (String) tablePelicula.getValueAt(selectedRow, 5);
                    String sinopsis = (String) tablePelicula.getValueAt(selectedRow, 6);
                    String tipo = (String) tablePelicula.getValueAt(selectedRow, 7);
                    String genero = (String) tablePelicula.getValueAt(selectedRow, 8);

                    // Crear el objeto Pelicula con los valores obtenidos
                    peliculaSeleccionada = new Pelicula(id, duracion, paisOrigen, anno, titulo, idioma, sinopsis, tipo, genero);
                    // Asignar el ID de la película
                }
            }
        });

        return peliculaSeleccionada; // Retornar la película seleccionada
    }


    public Pelicula crearPeliculaView() {
        // Obtener los valores usando los métodos pedir...
        Double duracion = viewNuevaPelicula.pedirDuracionPelicula();
        String paisOrigen = viewNuevaPelicula.pedirPaisOrigen();
        Integer anno = viewNuevaPelicula.pedirAnnoEstreno();
        String titulo = viewNuevaPelicula.pedirTituloPelicula();
        String idioma = viewNuevaPelicula.pedirIdioma();
        String sinopsis = viewNuevaPelicula.pedirSinopsis();
        String tipo = viewNuevaPelicula.pedirTipo();
        String genero = viewNuevaPelicula.pedirGenero();
        // Verificar que todos los valores sean válidos (no null)
        if (duracion == null || paisOrigen == null || anno == null || titulo == null || idioma == null || sinopsis == null || tipo == null || genero == null) {
            JOptionPane.showMessageDialog(viewNuevaPelicula, "Error: Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return null; // Si algún campo es inválido, retornar null
        }
        return new Pelicula(duracion, paisOrigen, anno, titulo, idioma, sinopsis, tipo, genero);
    }

    public void crearPelicula(Pelicula pelicula) {

        try {
            boolean agregado = peliculaDAO.agregar(pelicula);
            if (agregado && pelicula != null) {
                JOptionPane.showMessageDialog(jPanelPelicula, "pelicula agregada exitosamente");
                viewNuevaPelicula.setVisible(false);
                viewNuevaPelicula.dispose();
                viewNuevaPelicula.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                peliculaSeleccionada = null;

                viewNuevaPelicula.limpiarCampos();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(viewNuevaPelicula, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            jPanelPelicula.getTablePelicula().removeAll();

            actualizarTablaPelicula();
        }

    }

    public Pelicula modificarPeliculaView() {
        // Obtener los valores usando los métodos pedir...
        int id = viewActualizarPelicula.pedirId();
        Double duracion = viewActualizarPelicula.pedirDuracionPelicula();
        String paisOrigen = viewActualizarPelicula.pedirPaisOrigen();
        Integer anno = viewActualizarPelicula.pedirAnnoEstreno();
        String titulo = viewActualizarPelicula.pedirTituloPelicula();
        String idioma = viewActualizarPelicula.pedirIdioma();
        String sinopsis = viewActualizarPelicula.pedirSinopsis();
        String tipo = viewActualizarPelicula.pedirTipo();
        String genero = viewActualizarPelicula.pedirGenero();

        // Verificar que todos los valores sean válidos (no null)
        if (id == 0 || duracion == null || paisOrigen == null || anno == null || titulo == null || idioma == null || sinopsis == null || tipo == null || genero == null) {
            JOptionPane.showMessageDialog(viewActualizarPelicula, "Error: Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return null; // Si algún campo es inválido, retornar null
        }

        // Crear y retornar el objeto Pelicula
        return new Pelicula(id, duracion, paisOrigen, anno, titulo, idioma, sinopsis, tipo, genero);
    }


    public void modificarPelicula(Pelicula pelicula) {

        try {
            boolean modificado = peliculaDAO.modificar(pelicula);
            if (modificado && pelicula != null) {
                JOptionPane.showMessageDialog(jPanelPelicula, "pelicula  modificada exitosamente");
                viewActualizarPelicula.setVisible(false);
                viewActualizarPelicula.dispose();
                viewActualizarPelicula.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                viewActualizarPelicula.limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(jPanelPelicula, "No se realizaron cambios en la pelicula", "Aviso", JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(viewActualizarPelicula, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            jPanelPelicula.getTablePelicula().removeAll();

            actualizarTablaPelicula();
        }

    }


    public void eliminarCine(Pelicula pelicula) {
        boolean eliminado = false;
        try {
            eliminado = peliculaDAO.eliminar(pelicula);
            if (eliminado) {
                JOptionPane.showMessageDialog(jPanelPelicula, "Pelicula  eliminada exitosamente");
            } else {
                JOptionPane.showMessageDialog(jPanelPelicula, "No se  elimino  la pelicula.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(viewActualizarPelicula, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            jPanelPelicula.getTablePelicula().removeAll();
            actualizarTablaPelicula();
        }

    }

    public void buscarPorId(Pelicula pelicula) {
        boolean buscado = false;
        try {
            buscado = peliculaDAO.buscarPorId(pelicula);
            DefaultTableModel modelo = (DefaultTableModel) jPanelPelicula.getTablePelicula().getModel();
            modelo.setRowCount(0); // Borra todas las filas de la tabla

            if (buscado && pelicula != null) {
                JOptionPane.showMessageDialog(jPanelPelicula, "Pelicula encontrada");
                modelo.addRow(new Object[]{pelicula.getIdPelicula(), pelicula.getTitulo(), pelicula.getDuracion(), pelicula.getPaisOrigen(), pelicula.getAnno(), pelicula.getIdioma(), pelicula.getSinopsis(), pelicula.getTipo(), pelicula.getGenero()});
            } else {
                JOptionPane.showMessageDialog(jPanelPelicula, "No se encontró el cine.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(jPanelPelicula, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }


    public JPanelPelicula getjPanelPelicula() {
        return jPanelPelicula;
    }
}
