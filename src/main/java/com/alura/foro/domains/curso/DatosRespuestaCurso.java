package com.alura.foro.domains.curso;

public record DatosRespuestaCurso(
        Long id,
        String nombre,
        String categoria) {

    public DatosRespuestaCurso(Curso curso) {
        this(curso.getId(), curso.getNombre(), curso.getCategoria());
    }
}
