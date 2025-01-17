package com.kcire.forohub.domain.topico;

import com.kcire.forohub.domain.Respuesta.Respuesta;
import com.kcire.forohub.domain.curso.Curso;
import com.kcire.forohub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensaje;

    private LocalDateTime fechaCreacion;

    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    //muchos topicos pueden pertenecer a un solo curso
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    //un topico puede tener muchas respuestas
    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
    private List<Respuesta> respuestas;


}
