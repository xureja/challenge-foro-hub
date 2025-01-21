package com.alura.foro.controllers;

import com.alura.foro.domains.topico.DatosActualizarTopico;
import com.alura.foro.domains.topico.DatosRegistrarTopico;
import com.alura.foro.domains.topico.DatosRespuestaTopico;
import com.alura.foro.domains.topico.TopicoService;
import jakarta.transaction.Transactional;
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
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistrarTopico datosRegistrarTopico,
                                                                UriComponentsBuilder uriComponentsBuilder){
        DatosRespuestaTopico datosRespuestaTopico = topicoService.registrarTopico(datosRegistrarTopico);
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(datosRespuestaTopico.id()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosRespuestaTopico>> listadoTopicos(@RequestParam(name = "cursoId", required = false) Long cursoId,
                                                                     @RequestParam(name = "year", required = false) Integer anio,
                                                                     @PageableDefault(size=10) Pageable paginacion){
        return ResponseEntity.ok(topicoService.buscarTopicos(cursoId, paginacion));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> actualizarTopico(
            @RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        return ResponseEntity.ok(topicoService.actualizarTopico(datosActualizarTopico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        topicoService.borrarTopico(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> retornaDatosTopico(@PathVariable Long id){
        return ResponseEntity.ok(topicoService.buscarTopicoId(id));
    }
}
