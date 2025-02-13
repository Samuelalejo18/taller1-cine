package model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sala")

public class Sala {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSala;
	private int numero;
	private String nombre;
	private int cantidadSilla;
	private int filas;
	private int columnas;
	@ManyToOne
	@JoinColumn(name = "idCine") // Nombre de la columna en la tabla 'cine' que actúa como clave foránea
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
