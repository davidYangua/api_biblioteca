create table ejemplares(
    ejemplar_id bigint not null primary key auto_increment,
    libro_id bigint not null,
    codigo_unico varchar(100) not null unique,
    estado varchar(50) not null,

    constraint libro_id_fk foreign key(libro_id) references libros(libro_id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);