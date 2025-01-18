create table respuestas
(
    id             bigint  not null auto_increment,
    mensaje        text    not null,
    fecha_creacion timestamp default current_timestamp,
    solucion       tinyint not null,
    autor_id       bigint  not null,
    topico_id      bigint  not null,

    primary key (id),
    constraint fk_respuestas_usario_id foreign key (autor_id) references usuarios (id),
    constraint fk_respuestas_topico_id foreign key (topico_id) references topico (id)
);