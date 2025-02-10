package model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cine")

public class Cine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCine;
	private String nombre;
	private String direccion;
	private String resennas;
	private String telefono;

	public Cine() {

	}

	public Cine(int idCine) {
		this.idCine = idCine;
	}

	public Cine(String nombre, String direccion, String resennas, String telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.resennas = resennas;
		this.telefono = telefono;

	}

	public Cine(int idCine, String nombre, String direccion, String resennas, String telefono) {
		this.direccion = direccion;
		this.idCine = idCine;
		this.nombre = nombre;
		this.resennas = resennas;
		this.telefono = telefono;
	}

	@OneToMany(mappedBy = "Cine", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Sala> salas = new ArrayList<>();

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getIdCine() {
		return idCine;
	}

	public void setIdCine(int idCine) {
		this.idCine = idCine;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getResennas() {
		return resennas;
	}

	public void setResennas(String resennas) {
		this.resennas = resennas;
	}

	public List<Sala> getSalas() {
		return salas;
	}

	public void setSalas(List<Sala> salas) {
		this.salas = salas;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Cine [idCine=" + idCine + ", nombre=" + nombre + ", direccion=" + direccion + ", resennas=" + resennas
				+ ", telefono=" + telefono + ", salas=" + salas + "]";
	}

}
