package model;

import jakarta.persistence.*;

@Entity
@Table(name = "empleado")
public class Empleado extends Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmpleado;
    private String password;

    public Empleado() {
    }

    public Empleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;

    }

    public Empleado(String username, String email, String nombre, String telefono, int documentoIdentidad, int idEmpleado, String password) {
        super(username, email, nombre, telefono, documentoIdentidad);
        this.idEmpleado = idEmpleado;
        this.password = password;
    }
    public Empleado(String username, String email, String nombre, String telefono, int documentoIdentidad) {
        super(username, email, nombre, telefono, documentoIdentidad);

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado=" + idEmpleado +
                ", documentoIdentidad=" + documentoIdentidad +
                ", email='" + email + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
