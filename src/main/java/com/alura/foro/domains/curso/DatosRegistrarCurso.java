package com.alura.foro.domains.curso;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistrarCurso(
        @NotBlank
        String nombre,
        @NotBlank
        String categoria
) {
}
