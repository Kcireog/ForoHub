package com.kcire.forohub.domain.topico;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        Long idUsuario,
        @NotNull
        Long idCurso) {
    public DatosRegistroTopico(Topico topico) {
        this(topico.getTitulo(), topico.getMensaje(), topico.getAutor().getId(), topico.getCurso().getId());
    }

}

