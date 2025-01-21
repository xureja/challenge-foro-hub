package com.alura.foro.domains.topico;

import com.alura.foro.domains.curso.ICursoRepository;
import com.alura.foro.domains.usuario.IUsuarioRepository;
import com.alura.foro.domains.usuario.Usuario;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TopicoService {
    @Autowired
    private ITopicoRepository topicoRepository;
    @Autowired
    private ICursoRepository cursoRepository;
    @Autowired
    private IUsuarioRepository usuarioRepository;


    public DatosRespuestaTopico registrarTopico(DatosRegistrarTopico datosRegistrarTopico){


        var curso = cursoRepository.findByIdActivoTrue(datosRegistrarTopico.idCurso());
        if (curso == null){
            throw new EntityNotFoundException("No se ha encontrado el curso correspondiente al id " + datosRegistrarTopico.idCurso());
        }
        Usuario usuarioEncontrado = usuarioRepository.findById(datosRegistrarTopico.idUsuario()).orElseThrow(() -> new NoSuchElementException("Usuario no encontrado"));;

        Topico nuevoTopico = topicoRepository.save(new Topico(datosRegistrarTopico, usuarioEncontrado, curso));

        DatosRespuestaTopico respuestaTopico = new DatosRespuestaTopico(nuevoTopico.getId(), nuevoTopico.getTitulo(),
                nuevoTopico.getMensaje(),nuevoTopico.getFechaCreacion().toString(), nuevoTopico.getAutor().getNombre(),
                nuevoTopico.getCurso().getNombre());

        return respuestaTopico;
    }

    public Page<DatosRespuestaTopico> buscarTopicos(Long cursoId,
                                     Pageable paginacion) {
        return topicoRepository.findByEstadoTrueOrderByFechaCreacion(paginacion).map(DatosRespuestaTopico::new);


    }

    public DatosRespuestaTopico actualizarTopico(DatosActualizarTopico datosActualizarTopico) {
        Usuario usuario = usuarioRepository.findById(datosActualizarTopico.idUsuario()).orElseThrow(() -> new NoSuchElementException("Usuario no encontrado"));
        var curso = cursoRepository.findByIdActivoTrue(datosActualizarTopico.idCurso());
        if (curso == null){
            throw new EntityNotFoundException("No se ha encontrado el curso correspondiente al id " + datosActualizarTopico.idCurso());
        }
        Topico topico = topicoRepository.findByIdEstadoTrue(datosActualizarTopico.id());
        if (topico == null){
            throw new EntityNotFoundException("Topico correspondiente al id: " + datosActualizarTopico.id() + " no existe.");
        }
        topico.actualizarDatos(datosActualizarTopico, usuario, curso);
        return new DatosRespuestaTopico(topico.getId(), topico.getTitulo(),
                topico.getMensaje(),topico.getFechaCreacion().toString(), topico.getAutor().getNombre(),
                topico.getCurso().getNombre());
    }

    public void borrarTopico(Long id) {

        //Revisa si el tópico existe
        Optional<Topico> topico = topicoRepository.findById(id);
        if (topico.isEmpty()){
            throw new EntityNotFoundException("El topico correspondiente al id:" + id + " no existe");
        }
        topicoRepository.delete(topico.get());
    }

    public DatosRespuestaTopico buscarTopicoId(Long id) {
        Topico topico = topicoRepository.findByIdEstadoTrue(id);
        if (topico == null){
            throw new EntityNotFoundException("El topico correspondiente al id: " + id + ", no existe");
        }
        return new DatosRespuestaTopico(topico);
    }

}
