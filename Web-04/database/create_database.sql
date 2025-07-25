-- Script para criação do banco de dados do Sistema de Consultas Médicas
-- Execute este script no MySQL para criar as tabelas necessárias

CREATE DATABASE IF NOT EXISTS sistema_consultas;
USE sistema_consultas;

-- Tabela de médicos
CREATE TABLE medicos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    crm VARCHAR(20) NOT NULL UNIQUE,
    especialidade VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabela de pacientes
CREATE TABLE pacientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    data_nascimento DATE NOT NULL,
    telefone VARCHAR(20),
    email VARCHAR(100),
    endereco TEXT,
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabela de consultas
CREATE TABLE consultas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    medico_id INT NOT NULL,
    paciente_id INT NOT NULL,
    data_hora TIMESTAMP NOT NULL,
    observacoes TEXT,
    realizada BOOLEAN DEFAULT FALSE,
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (medico_id) REFERENCES medicos(id),
    FOREIGN KEY (paciente_id) REFERENCES pacientes(id)
);

-- Tabela de prontuários
CREATE TABLE prontuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    consulta_id INT NOT NULL,
    sintomas TEXT NOT NULL,
    diagnostico TEXT NOT NULL,
    tratamento TEXT NOT NULL,
    observacoes TEXT,
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (consulta_id) REFERENCES consultas(id)
);

-- Tabela de receituários
CREATE TABLE receituarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    consulta_id INT NOT NULL,
    medicamentos TEXT NOT NULL,
    dosagem TEXT NOT NULL,
    instrucoes TEXT NOT NULL,
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (consulta_id) REFERENCES consultas(id)
);

-- Tabela de exames
CREATE TABLE exames (
    id INT AUTO_INCREMENT PRIMARY KEY,
    consulta_id INT NOT NULL,
    tipo_exame VARCHAR(100) NOT NULL,
    descricao TEXT NOT NULL,
    resultado TEXT,
    data_exame TIMESTAMP NOT NULL,
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (consulta_id) REFERENCES consultas(id)
);

-- Inserção de dados de teste

-- Médicos
INSERT INTO medicos (nome, crm, especialidade, email, senha) VALUES
('Dr. João Silva', 'CRM12345', 'Cardiologia', 'joao.silva@hospital.com', '123456'),
('Dra. Maria Santos', 'CRM67890', 'Dermatologia', 'maria.santos@hospital.com', '123456'),
('Dr. Pedro Costa', 'CRM11111', 'Neurologia', 'pedro.costa@hospital.com', '123456'),
('Dra. Ana Oliveira', 'CRM22222', 'Pediatria', 'ana.oliveira@hospital.com', '123456'),
('Dr. Carlos Ferreira', 'CRM33333', 'Ortopedia', 'carlos.ferreira@hospital.com', '123456');

-- Pacientes
INSERT INTO pacientes (nome, cpf, data_nascimento, telefone, email, endereco) VALUES
('José da Silva', '123.456.789-01', '1980-05-15', '(11) 99999-1111', 'jose.silva@email.com', 'Rua A, 123 - São Paulo, SP'),
('Maria Souza', '987.654.321-02', '1975-08-22', '(11) 99999-2222', 'maria.souza@email.com', 'Rua B, 456 - São Paulo, SP'),
('Carlos Santos', '111.222.333-03', '1990-12-10', '(11) 99999-3333', 'carlos.santos@email.com', 'Rua C, 789 - São Paulo, SP'),
('Ana Lima', '444.555.666-04', '1985-03-30', '(11) 99999-4444', 'ana.lima@email.com', 'Rua D, 321 - São Paulo, SP'),
('Pedro Oliveira', '777.888.999-05', '1978-11-18', '(11) 99999-5555', 'pedro.oliveira@email.com', 'Rua E, 654 - São Paulo, SP'),
('Lucia Fernandes', '222.333.444-06', '1992-07-25', '(11) 99999-6666', 'lucia.fernandes@email.com', 'Rua F, 987 - São Paulo, SP'),
('Roberto Costa', '555.666.777-07', '1988-01-12', '(11) 99999-7777', 'roberto.costa@email.com', 'Rua G, 159 - São Paulo, SP'),
('Fernanda Silva', '888.999.111-08', '1983-09-05', '(11) 99999-8888', 'fernanda.silva@email.com', 'Rua H, 753 - São Paulo, SP');

-- Consultas para demonstração
INSERT INTO consultas (medico_id, paciente_id, data_hora, observacoes, realizada) VALUES
-- Consultas para Dr. João Silva (Cardiologia)
(1, 1, '2025-01-25 09:00:00', 'Consulta de rotina - controle de pressão arterial', FALSE),
(1, 3, '2025-01-25 10:30:00', 'Paciente com dores no peito', FALSE),
(1, 5, '2025-01-26 14:00:00', 'Retorno - exames do coração', FALSE),

-- Consultas para Dra. Maria Santos (Dermatologia)
(2, 2, '2025-01-25 11:00:00', 'Consulta para avaliação de manchas na pele', FALSE),
(2, 4, '2025-01-26 09:30:00', 'Tratamento de acne', FALSE),
(2, 6, '2025-01-27 15:00:00', 'Consulta preventiva', FALSE),

-- Consultas para Dr. Pedro Costa (Neurologia)
(3, 7, '2025-01-25 16:00:00', 'Paciente com dores de cabeça frequentes', FALSE),
(3, 8, '2025-01-26 10:00:00', 'Consulta de acompanhamento neurológico', FALSE),

-- Consultas para Dra. Ana Oliveira (Pediatria)
(4, 1, '2025-01-27 09:00:00', 'Consulta pediátrica de rotina', FALSE),
(4, 3, '2025-01-28 11:00:00', 'Vacinação infantil', FALSE),

-- Consultas para Dr. Carlos Ferreira (Ortopedia)
(5, 2, '2025-01-26 08:30:00', 'Dor nas costas', FALSE),
(5, 4, '2025-01-27 13:30:00', 'Lesão no joelho', FALSE),
(5, 6, '2025-01-28 16:00:00', 'Fisioterapia de acompanhamento', FALSE);

-- Algumas consultas já realizadas (com prontuários)
INSERT INTO consultas (medico_id, paciente_id, data_hora, observacoes, realizada) VALUES
(1, 2, '2025-01-20 09:00:00', 'Consulta cardiológica', TRUE),
(2, 1, '2025-01-21 10:00:00', 'Dermatite', TRUE);

-- Prontuários para consultas realizadas
INSERT INTO prontuarios (consulta_id, sintomas, diagnostico, tratamento, observacoes) VALUES
(14, 'Dores no peito, falta de ar durante exercícios', 'Hipertensão arterial leve', 'Medicação anti-hipertensiva, dieta baixa em sódio, exercícios leves', 'Retorno em 30 dias para reavaliação'),
(15, 'Coceira e vermelhidão na pele do rosto', 'Dermatite seborreica', 'Creme antifúngico tópico, shampoo medicamentoso', 'Evitar produtos com fragrância');

-- Receituários
INSERT INTO receituarios (consulta_id, medicamentos, dosagem, instrucoes) VALUES
(14, 'Losartana 50mg', '1 comprimido pela manhã', 'Tomar sempre no mesmo horário, preferencialmente em jejum'),
(15, 'Cetoconazol creme 2%', 'Aplicar 2x ao dia na região afetada', 'Aplicar após higienização da pele, durante 15 dias');

-- Exames
INSERT INTO exames (consulta_id, tipo_exame, descricao, resultado, data_exame) VALUES
(14, 'Eletrocardiograma', 'ECG de repouso para avaliação cardíaca', 'ECG normal, sem alterações significativas', '2025-01-20 10:30:00'),
(15, 'Micológico Direto', 'Exame de raspado de pele para fungos', 'Presença de esporos fúngicos compatíveis com dermatite seborreica', '2025-01-21 11:00:00');

COMMIT;

-- Query para verificar os dados inseridos
SELECT 'Médicos cadastrados:' as Info, COUNT(*) as Total FROM medicos
UNION ALL
SELECT 'Pacientes cadastrados:', COUNT(*) FROM pacientes
UNION ALL
SELECT 'Consultas agendadas:', COUNT(*) FROM consultas WHERE realizada = FALSE
UNION ALL
SELECT 'Consultas realizadas:', COUNT(*) FROM consultas WHERE realizada = TRUE;
