CREATE TABLE topicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(200) NOT NULL UNIQUE,
    mensaje VARCHAR(400) NOT NULL UNIQUE,
    fecha_creacion DATETIME NOT NULL,
    estado tinyint,
    usuario_id BIGINT NOT NULL,
    curso_id BIGINT NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT fk_topicos_usuario_id FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    CONSTRAINT fk_topicos_curso_id FOREIGN KEY (curso_id) REFERENCES cursos(id)
);