package com.alura.foro.domains.curso;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    @Autowired
    private ICursoRepository cursoRepository;

    public DatosRespuestaCurso registrarCurso(DatosRegistrarCurso datosRegistrarCurso) {
        Curso nuevoCurso = new Curso(datosRegistrarCurso);
        cursoRepository.save(nuevoCurso);
        return new DatosRespuestaCurso(nuevoCurso.getId(), nuevoCurso.getNombre(), nuevoCurso.getCategoria());
    }

    public Page<DatosRespuestaCurso> buscarCursosActivos(Pageable paginacion) {
        return cursoRepository.findByActivoTrue(paginacion).map(DatosRespuestaCurso::new);
    }

    public DatosRespuestaCurso buscarCursoId(Long id) {
        Curso curso = cursoRepository.findByIdActivoTrue(id);
        if(curso == null){
            throw new EntityNotFoundException("Curso with id " + id + " not found");
        }
        return new DatosRespuestaCurso(curso);
    }
}
