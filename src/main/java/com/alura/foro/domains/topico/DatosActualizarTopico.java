package com.alura.foro.domains.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull
        Long id,
        String titulo,
        String mensaje,
        @NotNull
        Long idCurso,
        @NotNull
        Long idUsuario
) {
}
