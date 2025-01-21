package com.alura.foro.domains.curso;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "cursos")
@Entity(name = "curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String categoria;
    private Boolean activo;

    public Curso(DatosRegistrarCurso datosRegistrarCurso) {
            this.nombre = datosRegistrarCurso.nombre();
            this.categoria = datosRegistrarCurso.categoria();
            this.activo = true;
    }
}
