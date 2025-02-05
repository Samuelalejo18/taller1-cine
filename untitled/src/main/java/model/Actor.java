package model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "actor")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Actor extends Realizador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idActor;
    @ManyToMany(mappedBy = "actores")
    private List<Pelicula> peliculas = new ArrayList<Pelicula>();



}
