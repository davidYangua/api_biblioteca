create table roles(
    rol_id bigint not null primary key auto_increment,
    rol varchar(25) not null unique
);

insert into roles (rol) values
('ADMIN'),
('USER');