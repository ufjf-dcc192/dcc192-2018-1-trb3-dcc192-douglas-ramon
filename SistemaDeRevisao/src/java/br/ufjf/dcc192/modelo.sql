DROP TABLE avaliacao_item;
DROP TABLE avaliacao_comentario;
DROP TABLE comentario;
DROP TABLE item;
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
    link1 VARCHAR(500) NOT NULL,
    link2 VARCHAR(500) DEFAULT NULL,
    link3 VARCHAR(500) DEFAULT NULL,
    data_insert TIMESTAMP NOT NULL,
    data_update TIMESTAMP DEFAULT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);

CREATE TABLE comentario (
    id_comentario  INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    id_usuario INTEGER NOT NULL,
    id_item INTEGER NOT NULL,
    texto VARCHAR(1000) NOT NULL,
    data_insert TIMESTAMP NOT NULL,
    data_update TIMESTAMP DEFAULT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_item) REFERENCES item(id_item)
);

CREATE TABLE avaliacao_item (
    id_avaliacao  INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    id_usuario INTEGER NOT NULL,
    id_item INTEGER NOT NULL,
    tipo BOOLEAN NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_item) REFERENCES item(id_item)
);

CREATE TABLE avaliacao_comentario (
    id_avaliacao  INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    id_usuario INTEGER NOT NULL,
    id_comentario INTEGER NOT NULL,
    tipo BOOLEAN NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_comentario) REFERENCES comentario(id_comentario)
);

INSERT INTO usuario(nome_completo, nome_usuario, email, senha) VALUES ('Ramon Larivoir', 'RmZ', 'rlarivoir@gmail.com', '123');

INSERT INTO usuario(nome_completo, nome_usuario, email, senha) VALUES ('Douglas Baumgratz', 'doug', 'douglas@gmail.com', '123');

INSERT INTO usuario(nome_completo, nome_usuario, email, senha) VALUES ('Usuário', 'user', 'usuario@gmail.com', '123');

INSERT INTO item(id_usuario, titulo, descricao, link1, data_insert) VALUES (1, 'Google', 'Google é um site de pesquisa online', 'www.google.com', '2018-07-10 09:00:00');

INSERT INTO item(id_usuario, titulo, descricao, link1, link2, link3, data_insert) VALUES (2, 'UFJF', 'UFJF é a universidade federal de juiz de fora', 'www.ufjf.br', 'www.ufjf.br/deptocomputacao/', 'www.ufjf.br/pgmc/2016/03/22/defesa-de-tese-de-doutorado-discente-igor-de-oliveira-knop/', '2018-07-10 12:00:00');

INSERT INTO item(id_usuario, titulo, descricao, link1, link2, data_insert) VALUES (1, 'Youtube', 'Youtube é um site para exibição de vídeos', 'www.youtube.com', 'www.youtube.com/user/igorknop', '2018-07-11 09:00:00');

INSERT INTO item(id_usuario, titulo, descricao, link1, link3, data_insert) VALUES (1, 'Globo', 'Este é o site oficial da emissora Globo', 'www.globo.com', 'www.globoesporte.com', '2018-07-12 09:00:00');

INSERT INTO item(id_usuario, titulo, descricao, link1, link2, data_insert) VALUES (2, 'Techtudo', 'Site de tecnologias', 'www.globo.com', 'www.techtudo.com.br/', '2018-07-13 09:00:00');

INSERT INTO AVALIACAO_ITEM(id_usuario, id_item, tipo) VALUES (1, 1, true);

INSERT INTO AVALIACAO_ITEM(id_usuario, id_item, tipo) VALUES (2, 1, true);

INSERT INTO AVALIACAO_ITEM(id_usuario, id_item, tipo) VALUES (1, 2, false);

INSERT INTO AVALIACAO_ITEM(id_usuario, id_item, tipo) VALUES (2, 2, true);

INSERT INTO AVALIACAO_ITEM(id_usuario, id_item, tipo) VALUES (1, 3, true);

INSERT INTO AVALIACAO_ITEM(id_usuario, id_item, tipo) VALUES (2, 3, false);

INSERT INTO AVALIACAO_ITEM(id_usuario, id_item, tipo) VALUES (1, 4, false);

INSERT INTO AVALIACAO_ITEM(id_usuario, id_item, tipo) VALUES (2, 4, false);

INSERT INTO comentario(id_usuario, id_item, texto, data_insert, data_update) VALUES (1, 1, 'Texto do comentário', '2018-07-10 09:00:00', '2018-07-12 09:00:00');

INSERT INTO comentario(id_usuario, id_item, texto, data_insert) VALUES (2, 1, 'Bla bla bla bla bla bla bla', '2018-07-11 09:00:00');

INSERT INTO comentario(id_usuario, id_item, texto, data_insert) VALUES (1, 1, 'Texto qualquer', '2018-07-12 09:00:00');

INSERT INTO comentario(id_usuario, id_item, texto, data_insert) VALUES (1, 2, 'Lorem ipsum', '2018-07-10 09:00:00');

INSERT INTO comentario(id_usuario, id_item, texto, data_insert) VALUES (1, 2, 'Insira aqui um mensagem inspiradora', '2018-07-11 09:00:00');

