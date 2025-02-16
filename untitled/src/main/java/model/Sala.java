package model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;


public class Sala {

    private int idSala;
    private int numero;
    private String nombre;
    private int cantidadSilla;
    private int filas;
    private int columnas;

    private Cine cine;

    public Sala() {

    }

    public Sala(int numero, String nombre, int cantidadSilla, int filas, int columnas, Cine cine) {
        this.numero = numero;
        this.nombre = nombre;
        this.cantidadSilla = cantidadSilla;
        this.filas = filas;
        this.columnas = columnas;
        this.cine = cine;
    }

    public Sala(int numero, String nombre, int cantidadSilla, int filas, int columnas) {
        this.numero = numero;
        this.nombre = nombre;
        this.cantidadSilla = cantidadSilla;
        this.filas = filas;
        this.columnas = columnas;

    }

    public Sala(int idSala, int numero, String nombre, int cantidadSilla, int filas, int columnas, Cine cine) {
        this.idSala = idSala;
        this.numero = numero;
        this.nombre = nombre;
        this.cantidadSilla = cantidadSilla;
        this.filas = filas;
        this.columnas = columnas;
        this.cine = cine;
    }

    public Sala(int idSala, int numero, String nombre, int cantidadSilla, int filas, int columnas) {
        this.idSala = idSala;
        this.numero = numero;
        this.nombre = nombre;
        this.cantidadSilla = cantidadSilla;
        this.filas = filas;
        this.columnas = columnas;
    }

    public Sala(int idSala) {
        this.idSala = idSala;
    }

    @OneToMany(mappedBy = "funcion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Funcion> funciones = new ArrayList<>();


    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadSilla() {
        return cantidadSilla;
    }

    public void setCantidadSilla(int cantidadSilla) {
        this.cantidadSilla = cantidadSilla;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public Cine getCine() {
        return cine;
    }

    public void setCine(Cine cine) {
        this.cine = cine;
    }

    public List<Funcion> getFunciones() {
        return funciones;
    }

    public void setFunciones(List<Funcion> funciones) {
        this.funciones = funciones;
    }

    @Override
    public String toString() {
        return "Sala [idSala=" + idSala + ", numero=" + numero + ", nombre=" + nombre + ", cantidadSilla="
                + cantidadSilla + ", filas=" + filas + ", columnas=" + columnas + ", cine=" + cine + ", funciones="
                + funciones + "]";
    }


}
