package model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "actor")

public class Actor extends Realizador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idActor;
	@ManyToMany(mappedBy = "actores")
	private List<Pelicula> peliculas = new ArrayList<Pelicula>();

	public Actor() {
		super();
	}

	public Actor(int idActor) {
		this.idActor = idActor;
	}

	public Actor(String nombre, String nacionalidad, int cantidadPeliculasRealizadas, int idActor) {
		super(nombre, nacionalidad, cantidadPeliculasRealizadas);
		this.idActor = idActor;
	}

	public Actor(String nombre, String nacionalidad, int cantidadPeliculasRealizadas) {
		super(nombre, nacionalidad, cantidadPeliculasRealizadas);

	}


	public int getIdActor() {
		return idActor;
	}

	public void setIdActor(int idActor) {
		this.idActor = idActor;
	}

	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	@Override
	public String toString() {
		return "Actor [idActor=" + idActor +  ", nombre=" + nombre + ", nacionalidad="
				+ nacionalidad + ", cantidadPeliculasRealizadas=" + cantidadPeliculasRealizadas + "]";
	}



	
	
	
}
