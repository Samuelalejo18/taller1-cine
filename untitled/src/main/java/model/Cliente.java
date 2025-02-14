package model;

import com.mysql.cj.xdevapi.Client;
import jakarta.persistence.*;


public class Cliente extends Persona {

    private int idCliente;

    public Cliente() {
    }

    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(String username, String email, String nombre, String telefono, int documentoIdentidad, int idCliente) {
        super(username, email, nombre, telefono, documentoIdentidad);
        this.idCliente = idCliente;
    }

    public Cliente( String username, String email, String nombre, String telefono, int documentoIdentidad) {
        super( username, email, nombre, telefono, documentoIdentidad);
    }


    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", documentoIdentidad=" + documentoIdentidad +
                ", email='" + email + '\'' +
                ", nombre='" + nombre + '\'' +
                ", username='" + username + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
