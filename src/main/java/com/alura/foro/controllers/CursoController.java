package com.alura.foro.controllers;

import com.alura.foro.domains.curso.CursoService;
import com.alura.foro.domains.curso.DatosRegistrarCurso;
import com.alura.foro.domains.curso.DatosRespuestaCurso;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<DatosRespuestaCurso> registrarNuevoCurso(@RequestBody @Valid DatosRegistrarCurso datosRegistrarCurso,
                                                                   UriComponentsBuilder uriComponentsBuilder){
        DatosRespuestaCurso datosRespuestaCurso = cursoService.registrarCurso(datosRegistrarCurso);
        URI url = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(datosRespuestaCurso.id()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaCurso);
    }

    @GetMapping
    public ResponseEntity<Page<DatosRespuestaCurso>> listadoCursos(@PageableDefault(size = 10) Pageable paginacion){
        return ResponseEntity.ok(cursoService.buscarCursosActivos(paginacion));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaCurso> retornarDatosCurso(@PathVariable Long id){
        return ResponseEntity.ok(cursoService.buscarCursoId(id));
    }



}
