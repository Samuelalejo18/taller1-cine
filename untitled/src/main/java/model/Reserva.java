package model;

import model.Cliente;
import model.Empleado;

import java.util.Date;

public class Reserva {
    private int idReserva;
    private Cliente cliente;
    private Empleado empleado;
    private int idFuncion;
    private Date fechaReserva;
    private int cantidadBoletos;
    private double totalPago;

    public Reserva(int idReserva, Cliente cliente, Empleado empleado, int idFuncion, Date fechaReserva, int cantidadBoletos, double totalPago) {
        this.idReserva = idReserva;
        this.cliente = cliente;
        this.empleado = empleado;
        this.idFuncion = idFuncion;
        this.fechaReserva = fechaReserva;
        this.cantidadBoletos = cantidadBoletos;
        this.totalPago = totalPago;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public int getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(int idFuncion) {
        this.idFuncion = idFuncion;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

}