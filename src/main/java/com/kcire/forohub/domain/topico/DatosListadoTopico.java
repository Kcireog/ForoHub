package com.kcire.forohub.domain.topico;

import java.time.LocalDateTime;

public record DatosListadoTopico(
        String titulo,
        String mensaje,
        LocalDateTime fecha,
        Boolean estado,
        Long idUsuario,
        Long idCurso
) {
}
