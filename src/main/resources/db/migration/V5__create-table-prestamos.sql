create table prestamos(
    idPrestamos bigint not null primary key auto_increment,
    idUsuario bigint not null,
    idEjemplar bigint not null,
    fechaPrestamo datetime,
    fechaDevolucion datetime,
    fechaDevuelto datetime,

    constraint idUsuario_fk foreign key(idUsuario) references usuarios(idUsuario)
    ON UPDATE CASCADE
    ON DELETE CASCADE,

    constraint idEjemplar_fk foreign key(idEjemplar) references ejemplares(idEjemplar)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);