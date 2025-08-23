-- Tabla Libros
INSERT INTO libros (titulo, autor, isbn, imagen, activo) VALUES
('Cien años de soledad', 'Gabriel García Márquez', '9780307474728', 'https://m.media-amazon.com/images/I/91TvVQS7loL._SY466_.jpg', 1),
('El nombre del viento', 'Patrick Rothfuss', '9780756404741', 'https://m.media-amazon.com/images/I/7125ljaY0gL._SY466_.jpg', 1),
('Sapiens: De animales a dioses', 'Yuval Noah Harari', '9780062316097', 'https://m.media-amazon.com/images/I/811PTyrckTL._SY466_.jpg', 1);

-- Tabla Ejemplares
INSERT INTO ejemplares (libro_id, codigo_unico, estado) VALUES
-- Libro 1
(1, 'INV-000001', 'DISPONIBLE'),
(1, 'INV-000002', 'PRESTADO'),
(1, 'INV-000003', 'DAÑADO'),
(1, 'INV-000004', 'DISPONIBLE'),
(1, 'INV-000005', 'NO_DISPONIBLE'),
-- Libro 2
(2, 'INV-000006', 'DISPONIBLE'),
(2, 'INV-000007', 'PRESTADO'),
(2, 'INV-000008', 'PRESTADO'),
(2, 'INV-000009', 'DISPONIBLE'),
(2, 'INV-000010', 'PERDIDO'),
(2, 'INV-000011', 'DAÑADO'),
(2, 'INV-000012', 'DISPONIBLE'),
(2, 'INV-000013', 'NO_DISPONIBLE'),
-- Libro 3
(3, 'INV-000014', 'DISPONIBLE'),
(3, 'INV-000015', 'DISPONIBLE'),
(3, 'INV-000016', 'PRESTADO'),
(3, 'INV-000017', 'PRESTADO'),
(3, 'INV-000018', 'DAÑADO'),
(3, 'INV-000019', 'NO_DISPONIBLE');