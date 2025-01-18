create table usuario
(
    id                 bigint       not null auto_increment,
    nombre             varchar(100) not null,
    correo_electronico varchar(150) not null unique,
    contrasena         varchar(200) not null,
    perfil_id          bigint       not null,

    primary key (id),
    constraint fk_usarios_perfil_id foreign key (perfil_id) references perfiles (id)
);