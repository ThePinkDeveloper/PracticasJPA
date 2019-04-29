create table if not exists Alumno (
	dni varchar(10),
    nombre varchar(20),
    apellidos varchar(20),
    edad int,
    PRIMARY KEY (dni)
)	ENGINE = INNODB;

create table if not exists Curso (
	id varchar(10),
    titulo varchar(20),
    duracion int,
    precio int,
    alumno_dni varchar(10),
    PRIMARY KEY (id)
)	ENGINE = INNODB;