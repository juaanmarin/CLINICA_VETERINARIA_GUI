create database bd_clinica;
use bd_clinica;

CREATE TABLE persona(
id_persona int(11) NOT NULL,
nombre_persona varchar(45) DEFAULT NULL,
profesion_persona varchar(45) DEFAULT NULL,
telefono_persona varchar(45) DEFAULT NULL,
tipo_persona int(2) NOT NULL,
nacimiento_id int(11) NOT NULL,
PRIMARY KEY (id_persona)
);

CREATE TABLE nacimiento(
id_nacimiento int(11) NOT NULL AUTO_INCREMENT ,
ciudad_nacimiento varchar(45) DEFAULT NULL,
departamento_nacimiento varchar(45) DEFAULT NULL,
fecha_nacimiento date DEFAULT NULL,
pais_nacimiento varchar(45) DEFAULT NULL,
PRIMARY KEY (id_nacimiento)
);

CREATE TABLE mascota(
id_mascota bigint(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
color VARCHAR(45),
nombre VARCHAR (45),
raza VARCHAR (45),
sexo VARCHAR (45),
persona_id INT
);

CREATE TABLE personas_productos(
persona_id int,
producto_id int
);

CREATE TABLE productos(
id_producto INT PRIMARY KEY NOT NULL,
nombre_producto VARCHAR (45),
precio_producto DOUBLE
);



ALTER TABLE mascota ADD CONSTRAINT FK_mascota_persona FOREIGN KEY (persona_id) REFERENCES persona (id_persona);

ALTER TABLE personas_productos ADD CONSTRAINT FK_personasProductos_persona FOREIGN KEY (persona_id) REFERENCES persona (id_persona);
ALTER TABLE personas_productos ADD CONSTRAINT FK_personasProductos_productos FOREIGN KEY (producto_id) REFERENCES productos (id_producto) ON DELETE CASCADE;

ALTER TABLE persona ADD INDEX fk_persona_nacimiento (nacimiento_id ASC);
;
ALTER TABLE persona
ADD CONSTRAINT fk_persona_nacimiento
FOREIGN KEY (nacimiento_id)
REFERENCES nacimiento (id_nacimiento)
ON DELETE NO ACTION
ON UPDATE NO ACTION;