package model;

import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@MappedSuperclass
public abstract class Realizador {
	protected String nombre;
	protected String nacionalidad;
	protected int cantidadPeliculasRealizadas;

	public Realizador() {

	}

	public Realizador(String nombre, String nacionalidad, int cantidadPeliculasRealizadas) {

		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.cantidadPeliculasRealizadas = cantidadPeliculasRealizadas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public int getCantidadPeliculasRealizadas() {
		return cantidadPeliculasRealizadas;
	}

	public void setCantidadPeliculasRealizadas(int cantidadPeliculasRealizadas) {
		this.cantidadPeliculasRealizadas = cantidadPeliculasRealizadas;
	}

	@Override
	public String toString() {
		return "Realizador [nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", cantidadPeliculasRealizadas="
				+ cantidadPeliculasRealizadas + "]";
	}

}
