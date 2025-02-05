package model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
@Entity
@Table(name = "funcion")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Funcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFuncion;
    private LocalDate dia;
    private LocalTime hora;
    @ManyToOne
    @JoinColumn(name = "pelicula_id")// Nombre de la columna en la tabla 'funcion' que actúa como clave foránea
    private Pelicula pelicula;

    @ManyToOne
    @JoinColumn(name = "sala_id")// Nombre de la columna en la tabla 'funcion' que actúa como clave foránea
    private Sala sala;



}
