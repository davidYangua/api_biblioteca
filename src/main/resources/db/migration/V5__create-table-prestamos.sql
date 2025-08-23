create table prestamos(
    prestamo_id bigint not null primary key auto_increment,
    usuario_id bigint not null,
    ejemplar_id bigint not null,
    fecha_prestamo datetime,
    fecha_devolucion datetime,
    fecha_devuelto datetime,

    constraint usuario_id_fk foreign key(usuario_id) references usuarios(usuario_id)
    ON UPDATE CASCADE
    ON DELETE CASCADE,

    constraint ejemplar_id_fk foreign key(ejemplar_id) references ejemplares(ejemplar_id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);