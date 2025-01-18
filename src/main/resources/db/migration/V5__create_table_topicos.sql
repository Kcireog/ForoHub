create table topico
(
    id             bigint       not null auto_increment,
    titulo         varchar(100) not null,
    mensaje        text         not null,
    fecha_creacion timestamp default current_timestamp,
    status         tinyint      not null,
    autor_id       bigint       not null,
    curso_id       bigint       not null,

    primary key (id),
    constraint fk_topicos_usuario_id foreign key (autor_id) references usuarios (id),
    constraint fk_topicos_curso_id foreign key (curso_id) references cursos (id)
);