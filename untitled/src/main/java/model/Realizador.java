package model;

import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@MappedSuperclass
public abstract class Realizador {
    protected String nombre;
    protected String nacionalidad;
    protected int cantidadPeliculasRealizadas;




}
