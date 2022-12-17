CREATE TABLE IF NOT EXISTS estudiante (
id SERIAL,
nombre VARCHAR(100) NOT NULL,
apellido VARCHAR(100) NOT NULL,
email VARCHAR (100) NOT NULL,
PRIMARY KEY (id),
UNIQUE(email)
);

CREATE TABLE IF NOT EXISTS clase(
id SERIAL,
descripcion VARCHAR(100) NOT NULL,
link VARCHAR(100) NOT NULL,
duracion VARCHAR (100) NOT NULL,
PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS cuestionario (
id SERIAL,
calificacion DECIMAL(6,2) NOT NULL,
descripcion VARCHAR(100) NOT NULL,
PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS preguntas (
id SERIAL,
pregunta VARCHAR(100) NOT NULL,
respuesta VARCHAR(100) NOT NULL,
cuestionario_id INT NOT NULL,
FOREIGN KEY (cuestionario_id) REFERENCES cuestionario (id),
PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS estudiante_cuestionario (
id SERIAL,
PRIMARY KEY (id),
estudiante_id INT NOT NULL,
FOREIGN KEY (estudiante_id) REFERENCES estudiante (id),
cuestionario_id INT NOT NULL,
FOREIGN KEY (cuestionario_id) REFERENCES cuestionario (id)
);

CREATE TABLE IF NOT EXISTS clase_cuestionario (
id SERIAL,
PRIMARY KEY (id),
clase_id INT NOT NULL,
FOREIGN KEY (clase_id) REFERENCES clase (id),
cuestionario_id INT NOT NULL,
FOREIGN KEY (cuestionario_id) REFERENCES cuestionario (id)
);
