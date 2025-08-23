alter table usuarios add column activo tinyint default 1;

alter table libros add column activo tinyint default 1;

-- alter table ejemplares add column activo tinyint default 1;
ALTER TABLE ejemplares
MODIFY COLUMN estado VARCHAR(50) NOT NULL DEFAULT 'DISPONIBLE';

alter table prestamos add column cancelado tinyint default 0, add column fechaCancelacion datetime default null;