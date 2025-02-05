package model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "cine")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Cine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCine;
    private String nombre;
    private String direccion;
    private String resennas;
    private String telefono;

    @OneToMany(mappedBy = "Cine", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sala> salas=  new ArrayList<>();





}
