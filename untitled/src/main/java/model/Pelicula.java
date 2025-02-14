package model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



@EqualsAndHashCode
public class Pelicula {

	private int idPelicula;
	private double duracion;
	private String paisOrigen;
	private int anno;
	private String titulo;
	private String idioma;
	private String sinopsis;
	private String tipo;
	private String genero;

	public Pelicula() {
	}

	public Pelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public Pelicula(int idPelicula, double duracion, String paisOrigen, int anno, String titulo, String idioma,
			String sinopsis, String tipo, String genero) {
		this.idPelicula = idPelicula;
		this.duracion = duracion;
		this.paisOrigen = paisOrigen;
		this.anno = anno;
		this.titulo = titulo;
		this.idioma = idioma;
		this.sinopsis = sinopsis;
		this.tipo = tipo;
		this.genero = genero;
	}

	public Pelicula(double duracion, String paisOrigen, int anno, String titulo, String idioma, String sinopsis,
			String tipo, String genero) {
		this.duracion = duracion;
		this.paisOrigen = paisOrigen;
		this.anno = anno;
		this.titulo = titulo;
		this.idioma = idioma;
		this.sinopsis = sinopsis;
		this.tipo = tipo;
		this.genero = genero;
	}


	private List<Director> directores = new ArrayList<>();;

	private List<Actor> actores = new ArrayList<>();

	private List<Funcion> funciones = new ArrayList<>();

	public int getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public List<Director> getDirectores() {
		return directores;
	}

	public void setDirectores(List<Director> directores) {
		this.directores = directores;
	}

	public List<Actor> getActores() {
		return actores;
	}

	public void setActores(List<Actor> actores) {
		this.actores = actores;
	}

	public List<Funcion> getFunciones() {
		return funciones;
	}

	public void setFunciones(List<Funcion> funciones) {
		this.funciones = funciones;
	}
	
	
	
	
	
	
	
	

}
