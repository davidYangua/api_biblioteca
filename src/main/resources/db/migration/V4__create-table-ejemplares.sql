create table ejemplares(
    idEjemplar bigint not null primary key auto_increment,
    idLibro bigint not null,
    codigoUnico varchar(100) not null unique,
    estado varchar(50) not null,

    constraint idLibro_fk foreign key(idLibro) references libros(idLibro)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);