create table libros(
    idLibro bigint not null primary key auto_increment,
    titulo varchar(200) not null,
    autor varchar(200) not null,
    isbn varchar(100) not null,
    imagen varchar(255) not null
);