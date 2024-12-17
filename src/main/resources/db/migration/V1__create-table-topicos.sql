CREATE TABLE topicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    mensagem TEXT NOT NULL,
    status VARCHAR(50) NOT NULL DEFAULT 'pendente',  -- Valor default "pendente"
    data_criacao DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,  -- Alteração do nome da coluna e valor default
    curso VARCHAR(100) NOT NULL,
    resposta TEXT DEFAULT NULL,  -- Resposta com valor default NULL
    autor VARCHAR(100),  -- Nova coluna adicionada
    PRIMARY KEY (id)
);
