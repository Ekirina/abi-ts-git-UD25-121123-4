
CREATE table peliculas(
	id int,
    nombre VARCHAR(100),
    calificacion_edad VARCHAR(5),
    primary key (id)
);
CREATE table salas(
	id int,
    nombre VARCHAR(100),
    codigo_pelicula int,
    foreign key (codigo_pelicula) REFERENCES peliculas (id)
	ON DELETE CASCADE ON UPDATE CASCADE,
	primary key (id)
);

INSERT INTO `peliculas` VALUES (1,'Citizen Kane','PG'),(2,'Casablanca','G'),(3,'The Wizard of Oz','G'),(4,'The Quiet Man',NULL),(5,'North by Northwest',NULL),(6,'The Last Tango in Paris','NC-17'),(7,'Some Like it Hot','PG-13'),(8,'A Night at the Opera',NULL),(9,'Citizen King','G');

INSERT INTO `salas` VALUES (1,'Odeon',5),(2,'Imperial',1),(3,'Majestic',NULL),(4,'Royale',6),(5,'Paraiso',3),(6,'Nickelodeon',NULL);
