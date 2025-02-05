package model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
@Entity
@Table(name = "director")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Director extends Realizador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDirector;



}

