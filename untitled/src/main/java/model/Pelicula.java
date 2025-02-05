package model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "pelicula")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPelicula;
    private double duracion;
    private String paisOrigen;
    private int anno;
    private String titulo;
    private String idioma;
    private String sinopsis;
    private String tipo;
    private String genero;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name="pelicula_director",
            joinColumns=@JoinColumn(name="pelicula_id"),
            inverseJoinColumns = @JoinColumn(name="director_id")
    )
    private List<Director> directores;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name="pelicula_actor",
            joinColumns=@JoinColumn(name="pelicula_id"),
            inverseJoinColumns = @JoinColumn(name="actor_id")
    )
    private List<Actor> actores= new ArrayList<>();
    @OneToMany(mappedBy = "funcion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Funcion> funciones=  new ArrayList<>();



}
