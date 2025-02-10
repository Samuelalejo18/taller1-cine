package model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "director")

public class Director extends Realizador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDirector;

	public Director() {
		super();
	}

	public Director(String nombre, String nacionalidad, int cantidadPeliculasRealizadas, int idDirector) {
		super(nombre, nacionalidad, cantidadPeliculasRealizadas);
		this.idDirector = idDirector;
	}

	@ManyToMany(mappedBy = "directores")
	private List<Pelicula> peliculas = new ArrayList<Pelicula>();

	public Director(String nombre, String nacionalidad, int cantidadPeliculasRealizadas) {
		super(nombre, nacionalidad, cantidadPeliculasRealizadas);

	}

	public Director(int idDirector) {
		this.idDirector = idDirector;
	}

	public int getIdDirector() {
		return idDirector;
	}

	public void setIdDirector(int idDirector) {
		this.idDirector = idDirector;
	}

	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	@Override
	public String toString() {
		return "Director [idDirector=" + idDirector + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad
				+ ", cantidadPeliculasRealizadas=" + cantidadPeliculasRealizadas + "]";

	}
}

	
