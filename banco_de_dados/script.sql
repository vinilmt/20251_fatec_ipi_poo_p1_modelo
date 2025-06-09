-- Active: 1749323484300@@localhost@5432@p2
CREATE DATABASE p2;

CREATE TABLE personagens(
    cod_personagem SERIAL PRIMARY KEY,
    nome VARCHAR(30) NOT NULL,
    prob_construir INT,
    prob_mineirar INT,
    prob_coletar_madeira INT,
    num_vitorias INT,
    num_derrotas INT
)

INSERT INTO personagens(nome, prob_construir, prob_mineirar, prob_coletar_madeira, num_vitorias, num_derrotas)
VALUES
('Steve', 50, 25, 25, 0, 0),
('Alex', 25, 25, 50, 0, 0);

SELECT * FROM personagens;