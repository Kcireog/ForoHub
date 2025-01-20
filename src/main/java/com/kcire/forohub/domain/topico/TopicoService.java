package com.kcire.forohub.domain.topico;

import com.kcire.forohub.domain.curso.CursoRepository;
import com.kcire.forohub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TopicoService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private TopicoRepository topicoRepository;

    public DatosRegistroTopico registrar(DatosRegistroTopico datos) {

        // Verificar si ya existe un tópico con el mismo título y mensaje
        boolean existeDuplicado = topicoRepository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje());
        if (existeDuplicado) {
            throw new IllegalArgumentException("Ya existe un tópico con el mismo título y mensaje.");
        }

        var curso = cursoRepository.findById(datos.idCurso()).get();
        var autor = usuarioRepository.findById(datos.idUsuario()).get();
        var fecha = LocalDateTime.now();

        var topico = new Topico(null, datos.titulo(), datos.mensaje(), fecha, false, autor, curso, List.of());

        topicoRepository.save(topico);

        return new DatosRegistroTopico(topico);

    }

}
