INSERT INTO estudiante (nombre, correo) VALUES ('Ana Torres', 'ana.torres@correo.edu');
INSERT INTO estudiante (nombre, correo) VALUES ('Luis Gomez', 'luis.gomez@correo.edu');

INSERT INTO libro (titulo, disponible) VALUES ('Clean Code', TRUE);
INSERT INTO libro (titulo, disponible) VALUES ('Patrones de diseno', TRUE);
INSERT INTO libro (titulo, disponible) VALUES ('Refactoring', FALSE);

INSERT INTO prestamo (fecha_prestamo, fecha_devolucion, estudiante_id, libro_id) VALUES (CURRENT_DATE, NULL, 2, 3);
