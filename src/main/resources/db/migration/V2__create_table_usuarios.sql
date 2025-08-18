create table usuarios(
    idUsuario bigint not null primary key auto_increment,
    idRol bigint not null,
    nombre varchar(50) not null,
    email varchar(50) not null unique,
    password varchar(255) not null,

    constraint idRol_fk foreign key(idRol) references roles(idRol)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);