package com.alura.foro.domains.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ITopicoRepository extends JpaRepository<Topico, Long> {
    Page<Topico> findByEstadoTrueOrderByFechaCreacion(Pageable paginacion);
    Page<Topico> findByEstadoTrueAndCursoIdOrderByFechaCreacion(Long cursoId, Pageable paginacion);

    @Query("""
            select t from topico t
            where t.estado = true and
            t.id = :id
            """)
    Topico findByIdEstadoTrue(Long id);
}
