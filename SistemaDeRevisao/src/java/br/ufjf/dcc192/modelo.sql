DROP TABLE avaliacao_item;
DROP TABLE avaliacao_comentario;
DROP TABLE link;
DROP TABLE item;
DROP TABLE comentario;
DROP TABLE usuario;

CREATE TABLE usuario (
    id_usuario INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nome_completo VARCHAR(200) NOT NULL,
    nome_usuario VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    senha VARCHAR(20) NOT NULL
);

CREATE TABLE item (
    id_item INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    id_usuario INTEGER NOT NULL,
    titulo VARCHAR(50) NOT NULL,
    descricao VARCHAR(1000) NOT NULL,
    data_insert TIMESTAMP NOT NULL,
    data_update TIMESTAMP,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);

CREATE TABLE link (
    id_link INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    id_item INTEGER NOT NULL,
    nome VARCHAR(500) NOT NULL,
    FOREIGN KEY (id_item) REFERENCES item(id_item)
);

CREATE TABLE comentario (
    id_comentario  INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    id_usuario INTEGER NOT NULL,
    texto VARCHAR(1000) NOT NULL,
    data_insert TIMESTAMP NOT NULL,
    data_update TIMESTAMP,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);

CREATE TABLE avaliacao_item (
    id_avaliacao  INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    id_usuario INTEGER NOT NULL,
    id_item INTEGER,
    tipo BOOLEAN NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_item) REFERENCES item(id_item)
);

CREATE TABLE avaliacao_comentario (
    id_avaliacao  INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    id_usuario INTEGER NOT NULL,
    id_comentario INTEGER,
    tipo BOOLEAN NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_comentario) REFERENCES comentario(id_comentario)
);