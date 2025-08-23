create table usuarios(
    usuario_id bigint not null primary key auto_increment,
    rol_id bigint not null,
    nombre varchar(50) not null,
    email varchar(50) not null unique,
    password varchar(255) not null,

    constraint rol_id_fk foreign key(rol_id) references roles(rol_id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);