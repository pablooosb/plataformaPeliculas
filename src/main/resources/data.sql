CREATE OR REPLACE VIEW vista_plataformas_streaming AS
SELECT
    plataforma_streaming_id,
    nombre,
    pais
FROM plataformas_streaming;

INSERT INTO plataformas_streaming (nombre, pais) VALUES
('Netflix', 'USA'),
('HBO Max', 'USA'),
('Disney+', 'USA'),
('Filmin', 'ESPAÑA'),
('Amazon Prime Video', 'USA'),
('Apple TV+', 'USA'),
('Paramount+', 'USA'),
('Peacock', 'USA'),
('Star+', 'USA'),
('Rakuten TV', 'ESPAÑA'),
('Movistar+', 'ESPAÑA'),
('Hulu', 'USA'),
('Crunchyroll', 'USA'),
('Tubi', 'USA'),
('YouTube Premium', 'USA'),
('Sony Liv', 'INDIA'),
('Hotstar', 'INDIA'),
('Vudu', 'USA'),
('Sky Show', 'ITALIA'),
('Mubi', 'ESPAÑA');

CREATE OR REPLACE VIEW vista_directores AS
SELECT
    director_id,
    nombre,
    apellido,
    dni_numero,
    dni_letra,
    nacionalidad,
    fecha_nacimiento_dia,
    fecha_nacimiento_mes,
    fecha_nacimiento_anho,
    activo
FROM directores;

INSERT INTO directores (nombre, apellido, dni_numero, dni_letra, nacionalidad, fecha_nacimiento_dia, fecha_nacimiento_mes, fecha_nacimiento_anho, activo) VALUES
('Lana', 'Wachowski', 12345678, 'Z', 'Estadounidense', 21, 6, 1965, true),
('Lilly', 'Wachowski', 23456789, 'B', 'Estadounidense', 29, 12, 1967, true),
('Francis', 'Coppola', 34567890, 'R', 'Estadounidense', 7, 4, 1939, true),
('Steven', 'Spielberg', 45678901, 'F', 'Estadounidense', 18, 12, 1946, true),
('Christopher', 'Nolan', 56789012, 'S', 'Británico', 30, 7, 1970, true),
('Quentin', 'Tarantino', 67890123, 'R', 'Estadounidense', 27, 3, 1963, true),
('Martin', 'Scorsese', 78901234, 'M', 'Estadounidense', 17, 11, 1942, true),
('Peter', 'Jackson', 89012345, 'P', 'Neozelandés', 31, 10, 1961, true),
('James', 'Cameron', 90123456, 'K', 'Canadiense', 16, 8, 1954, true),
('Ridley', 'Scott', 11223344, 'R', 'Británico', 30, 11, 1937, true),
('George', 'Lucas', 22334455, 'C', 'Estadounidense', 14, 5, 1944, true),
('David', 'Fincher', 33445566, 'E', 'Estadounidense', 28, 8, 1962, true),
('Clint', 'Eastwood', 44556677, 'P', 'Estadounidense', 31, 5, 1930, true),
('Tim', 'Burton', 55667788, 'R', 'Estadounidense', 25, 8, 1958, true),
('Sofia', 'Coppola', 66778899, 'G', 'Estadounidense', 14, 5, 1971, true),
('Guillermo', 'del Toro', 77889900, 'S', 'Mexicano', 9, 10, 1964, true),
('Wes', 'Anderson', 88990011, 'L', 'Estadounidense', 1, 5, 1969, true),
('Joel', 'Coen', 99001122, 'B', 'Estadounidense', 29, 11, 1954, true),
('Ethan', 'Coen', 10111213, 'R', 'Estadounidense', 21, 9, 1957, true),
('Richard', 'Linklater', 11121314, 'C', 'Estadounidense', 30, 7, 1960, true);

CREATE OR REPLACE VIEW vista_actores AS
SELECT
    actor_id,
    nombre,
    apellido,
    dni_numero,
    dni_letra,
    nacionalidad,
    fecha_nacimiento_dia,
    fecha_nacimiento_mes,
    fecha_nacimiento_anho,
    activo
FROM actores;

INSERT INTO actores (nombre, apellido, dni_numero, dni_letra, nacionalidad, fecha_nacimiento_dia, fecha_nacimiento_mes, fecha_nacimiento_anho, activo) VALUES
('Keanu', 'Reeves', 23456780, 'T', 'Canadiense', 2, 9, 1964, true),
('Marlon', 'Brando', 34567891, 'R', 'Estadounidense', 3, 4, 1924, false),
('Tom', 'Hanks', 45678902, 'F', 'Estadounidense', 9, 7, 1956, true),
('Emma', 'Watson', 56789013, 'D', 'Británica', 15, 4, 1990, true),
('Robert', 'Downey Jr.', 67890124, 'H', 'Estadounidense', 4, 4, 1965, true),
('Leonardo', 'DiCaprio', 78901235, 'J', 'Estadounidense', 11, 11, 1974, true),
('Natalie', 'Portman', 89012346, 'Z', 'Israelí', 9, 6, 1981, true),
('Chris', 'Hemsworth', 90123457, 'R', 'Australiano', 11, 8, 1983, true),
('Scarlett', 'Johansson', 11234568, 'B', 'Estadounidense', 22, 11, 1984, true),
('Hugh', 'Jackman', 22345679, 'E', 'Australiano', 12, 10, 1968, true),
('Morgan', 'Freeman', 33456780, 'T', 'Estadounidense', 1, 6, 1937, true),
('Anne', 'Hathaway', 44567891, 'R', 'Estadounidense', 12, 11, 1982, true),
('Christian', 'Bale', 55678902, 'F', 'Británico', 30, 1, 1974, true),
('Gal', 'Gadot', 66789013, 'D', 'Israelí', 30, 4, 1985, true),
('Mark', 'Ruffalo', 77890124, 'H', 'Estadounidense', 22, 11, 1967, true),
('Harrison', 'Ford', 88901235, 'J', 'Estadounidense', 13, 7, 1942, true),
('Jennifer', 'Lawrence', 99012346, 'Z', 'Estadounidense', 15, 8, 1990, true),
('Brad', 'Pitt', 10123457, 'F', 'Estadounidense', 18, 12, 1963, true),
('Matt', 'Damon', 11234568, 'B', 'Estadounidense', 8, 10, 1970, true),
('Emma', 'Stone', 12345679, 'R', 'Estadounidense', 6, 11, 1988, true);

CREATE OR REPLACE VIEW vista_peliculas AS
SELECT
    pelicula_id,
    titulo,
    duracion,
    fecha_estreno,
    genero,
    edad_minima,
    director_id
FROM peliculas;

INSERT INTO peliculas (titulo, duracion, fecha_estreno, genero, edad_minima, director_id) VALUES
('Matrix', 136, '1999-03-31', 'CIENCIA_FICCION', 'PEGI_3', 1),
('Cloud Atlas', 172, '2012-10-26', 'CIENCIA_FICCION', 'PEGI_12', 1),
('V for Vendetta', 132, '2005-03-17', 'ACCION', 'PEGI_16', 2),
('El Padrino', 175, '1972-03-24', 'DRAMA', 'PEGI_16', 3),
('Apocalypse Now', 147, '1979-08-15', 'DRAMA', 'PEGI_18', 3),
('Jurassic Park', 127, '1993-06-11', 'CIENCIA_FICCION', 'PEGI_12', 4),
('E.T.', 115, '1982-06-11', 'CIENCIA_FICCION', 'PEGI_3', 4),
('Inception', 148, '2010-07-16', 'CIENCIA_FICCION', 'PEGI_12', 5),
('Interstellar', 169, '2014-11-07', 'CIENCIA_FICCION', 'PEGI_12', 5),
('Pulp Fiction', 154, '1994-10-14', 'ACCION', 'PEGI_18', 6),
('Kill Bill: Vol.1', 111, '2003-10-10', 'ACCION', 'PEGI_18', 6),
('Goodfellas', 146, '1990-09-21', 'DRAMA', 'PEGI_18', 7),
('The Irishman', 209, '2019-11-01', 'DRAMA', 'PEGI_18', 7),
('The Lord of the Rings: The Fellowship of the Ring', 178, '2001-12-19', 'FANTASIA', 'PEGI_12', 8),
('The Lord of the Rings: The Two Towers', 179, '2002-12-18', 'FANTASIA', 'PEGI_12', 8),
('Avatar', 162, '2009-12-18', 'CIENCIA_FICCION', 'PEGI_12', 9),
('Titanic', 195, '1997-12-19', 'DRAMA', 'PEGI_12', 10),
('Gladiator', 155, '2000-05-05', 'ACCION', 'PEGI_16', 11),
('Star Wars: A New Hope', 121, '1977-05-25', 'CIENCIA_FICCION', 'PEGI_12', 12),
('Fight Club', 139, '1999-10-15', 'DRAMA', 'PEGI_18', 13),
('Gran Torino', 116, '2008-12-12', 'DRAMA', 'PEGI_16', 14),
('Edward Scissorhands', 105, '1990-12-06', 'FANTASIA', 'PEGI_12', 15),
('Lost in Translation', 102, '2003-09-12', 'DRAMA', 'PEGI_12', 16),
('Pan''s Labyrinth', 118, '2006-10-11', 'FANTASIA', 'PEGI_16', 17),
('The Grand Budapest Hotel', 99, '2014-03-28', 'COMEDIA', 'PEGI_12', 18),
('No Country for Old Men', 122, '2007-11-21', 'DRAMA', 'PEGI_18', 19),
('Inside Llewyn Davis', 104, '2013-01-17', 'DRAMA', 'PEGI_12', 20);

CREATE OR REPLACE VIEW vista_peliculas_plataformas AS
SELECT
    peliculas_plataformas_id,
    pelicula_id,
    plataforma_streaming_id,
    fecha_estreno_en_plataforma,
    precio_alquiler,
    moneda_alquiler,
    precio_compra,
    moneda_compra,
    calidad
FROM peliculas_plataformas;

INSERT INTO peliculas_plataformas (pelicula_id, plataforma_streaming_id, fecha_estreno_en_plataforma, precio_alquiler, moneda_alquiler, precio_compra, moneda_compra, calidad) VALUES
(1, 1, '2023-01-15', 3.99, 'USD', 12.99, 'USD', 'HD'),
(2, 2, '2023-03-20', 4.99, 'USD', 14.99, 'USD', 'FHD'),
(3, 3, '2023-05-10', 2.99, 'USD', 9.99, 'USD', 'SD'),
(4, 4, '2023-06-12', 3.49, 'USD', 11.49, 'USD', 'HD'),
(5, 5, '2023-07-18', 4.49, 'USD', 13.49, 'USD', 'FHD'),
(6, 1, '2023-08-05', 3.99, 'USD', 12.99, 'USD', 'UHD'),
(7, 2, '2023-09-01', 2.99, 'USD', 10.99, 'USD', 'HD'),
(8, 3, '2023-09-20', 4.99, 'USD', 14.99, 'USD', 'FHD'),
(9, 4, '2023-10-10', 3.49, 'USD', 11.49, 'USD', 'UHD'),
(10, 5, '2023-11-05', 2.99, 'USD', 9.99, 'USD', 'HD'),
(11, 6, '2023-11-20', 3.99, 'USD', 12.99, 'USD', 'FHD'),
(12, 7, '2023-12-01', 4.49, 'USD', 13.49, 'USD', 'UHD'),
(13, 8, '2023-12-10', 3.49, 'USD', 11.49, 'USD', 'HD'),
(14, 9, '2023-12-20', 2.99, 'USD', 10.99, 'USD', 'FHD'),
(15, 10, '2024-01-05', 4.99, 'USD', 14.99, 'USD', 'UHD'),
(16, 11, '2024-01-12', 3.99, 'USD', 12.99, 'USD', 'HD'),
(17, 12, '2024-01-20', 2.99, 'USD', 10.99, 'USD', 'FHD'),
(18, 13, '2024-02-01', 3.49, 'USD', 11.49, 'USD', 'UHD'),
(19, 14, '2024-02-10', 4.49, 'USD', 13.49, 'USD', 'HD'),
(20, 15, '2024-02-20', 2.99, 'USD', 9.99, 'USD', 'FHD');

CREATE OR REPLACE VIEW vista_actuaciones AS
SELECT
    actor_id,
    pelicula_id
FROM actuaciones;

INSERT INTO actuaciones (actor_id, pelicula_id) VALUES
(1,1),
(3,1),
(2,2),
(6,2),
(3,3),
(4,3),
(5,5),
(8,5),
(6,6),
(7,6),
(9,7),
(10,7),
(11,8),
(12,8),
(13,9),
(14,9),
(15,10),
(16,10),
(17,11),
(18,11);