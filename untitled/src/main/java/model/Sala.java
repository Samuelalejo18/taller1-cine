package model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sala")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
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
    @JoinColumn(name = "cine_id") // Nombre de la columna en la tabla 'cine' que actúa como clave foránea
    private Cine cine;

    @OneToMany(mappedBy = "funcion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Funcion> funciones=  new ArrayList<>();
}
