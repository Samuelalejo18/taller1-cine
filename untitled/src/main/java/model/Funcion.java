package model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "funcion")

@EqualsAndHashCode
public class Funcion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFuncion;
	private LocalDate dia;
	private LocalTime hora;
	@ManyToOne
	@JoinColumn(name = "idPelicula") // Nombre de la columna en la tabla 'funcion' que actúa como clave foránea
	private Pelicula pelicula;

	@ManyToOne
	@JoinColumn(name = "idSala") // Nombre de la columna en la tabla 'funcion' que actúa como clave foránea
	private Sala sala;

	public Funcion() {

	}

	public Funcion(int idFuncion) {
		this.idFuncion = idFuncion;
	}

	public Funcion(int idFuncion, LocalDate dia, LocalTime hora, Sala sala, Pelicula pelicula) {
		this.idFuncion = idFuncion;
		this.dia = dia;
		this.hora = hora;
		this.sala = sala;
		this.pelicula = pelicula;
	}

	public Funcion(LocalTime hora, LocalDate dia, Pelicula pelicula, Sala sala) {
		this.hora = hora;
		this.dia = dia;
		this.pelicula = pelicula;
		this.sala = sala;
	}

	public LocalDate getDia() {
		return dia;
	}

	public void setDia(LocalDate dia) {
		this.dia = dia;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public int getIdFuncion() {
		return idFuncion;
	}

	public void setIdFuncion(int idFuncion) {
		this.idFuncion = idFuncion;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	@Override
	public String toString() {
		return "Funcion{" + "idFuncion=" + idFuncion + ", hora=" + hora + ", dia=" + dia + ", pelicula=" + pelicula
				+ ", sala=" + sala + '}';
	}
}
