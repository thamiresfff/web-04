# Sistema de Consultas Médicas

Sistema web desenvolvido em Java com JSP, Servlets e DAO para gerenciamento de consultas médicas.

**Autor:** thamfernandes  
**Versão:** 1.0  
**Ano:** 2025

## 🚀 Funcionalidades

- **Cadastro de Consultas**: Página pública para agendamento de consultas
- **Login de Médicos**: Sistema de autenticação para médicos
- **Dashboard Médico**: Visualização de consultas agendadas
- **Gestão de Consultas**: Detalhamento completo das consultas
- **Prontuário Eletrônico**: Cadastro de sintomas, diagnóstico e tratamento
- **Receituário Digital**: Prescrição de medicamentos
- **Exames**: Registro de exames solicitados e resultados

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **JSP (JavaServer Pages)**
- **Servlets**
- **Arquitetura DAO (Data Access Object)**
- **MySQL**
- **Apache Tomcat**
- **Bootstrap 5**
- **Font Awesome**
- **Maven**

## 📋 Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina:

- [Java JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Apache Tomcat 10](https://tomcat.apache.org/download-10.cgi)
- [MySQL 8.0](https://dev.mysql.com/downloads/mysql/)
- [Maven](https://maven.apache.org/download.cgi)
- IDE de sua preferência (Eclipse, IntelliJ IDEA, VS Code)

## 🎲 Configuração do Banco de Dados

1. **Instale e configure o MySQL**

2. **Execute o script de criação do banco**:
   ```sql
   -- Execute o arquivo database/create_database.sql no MySQL
   source C:/caminho/para/o/projeto/database/create_database.sql
   ```

3. **Configure a conexão no arquivo DatabaseConnection.java**:
   ```java
   // Edite src/main/java/com/consultas/config/DatabaseConnection.java
   private static final String URL = "jdbc:mysql://localhost:3306/sistema_consultas?useSSL=false&serverTimezone=UTC";
   private static final String USERNAME = "root";
   private static final String PASSWORD = "sua_senha"; // Altere para sua senha do MySQL
   ```

## 🚀 Como executar o projeto

### 1. Clone o repositório ou baixe os arquivos

### 2. Compile o projeto com Maven
```bash
cd Web-04
mvn clean compile
```

### 3. Gere o arquivo WAR
```bash
mvn package
```

### 4. Configure o Tomcat

1. Copie o arquivo `target/sistema-consultas.war` para a pasta `webapps` do Tomcat
2. Inicie o Tomcat
3. Acesse: `http://localhost:8080/sistema-consultas`

### Ou execute diretamente no IDE

1. Importe o projeto Maven na sua IDE
2. Configure o servidor Tomcat
3. Execute o projeto

## 👥 Dados de Teste

O sistema já vem com dados pré-cadastrados para demonstração:

### Médicos (Login/Senha):
- **joao.silva@hospital.com** / 123456 - Dr. João Silva (Cardiologia)
- **maria.santos@hospital.com** / 123456 - Dra. Maria Santos (Dermatologia)
- **pedro.costa@hospital.com** / 123456 - Dr. Pedro Costa (Neurologia)
- **ana.oliveira@hospital.com** / 123456 - Dra. Ana Oliveira (Pediatria)
- **carlos.ferreira@hospital.com** / 123456 - Dr. Carlos Ferreira (Ortopedia)

### Pacientes já cadastrados:
- José da Silva, Maria Souza, Carlos Santos, Ana Lima, Pedro Oliveira, Lucia Fernandes, Roberto Costa, Fernanda Silva

## 🎥 Demonstração das Funcionalidades

Para testar o sistema completo:

1. **Acesse a página de cadastro de consultas**: `http://localhost:8080/sistema-consultas/cadastro-consulta`
2. **Cadastre novas consultas** para diferentes médicos
3. **Faça login com um médico** para ver suas consultas
4. **Clique em uma consulta** para ver os detalhes
5. **Cadastre prontuário, receituário e exames**

## 📁 Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── com/consultas/
│   │       ├── config/          # Configuração do banco
│   │       ├── dao/             # Classes DAO
│   │       ├── model/           # Entidades/Modelos
│   │       └── servlet/         # Servlets (Controllers)
│   └── webapp/
│       ├── WEB-INF/
│       │   ├── views/           # Páginas JSP
│       │   └── web.xml          # Configuração web
│       └── static/              # CSS, JS, imagens
└── database/
    └── create_database.sql      # Script do banco
```

## 🔄 Fluxo da Aplicação

1. **Página Inicial**: Formulário de login + Link para cadastro de consultas
2. **Cadastro de Consultas**: Qualquer pessoa pode agendar consultas
3. **Login do Médico**: Autenticação por email e senha
4. **Dashboard**: Médico visualiza suas consultas não realizadas
5. **Detalhes da Consulta**: Informações do paciente e da consulta
6. **Cadastros Médicos**: Prontuário, receituário e exames

## 🚧 Observações Importantes

- **Horários**: Não há validação de conflitos de horário (conforme especificado)
- **Consultas Realizadas**: São marcadas como realizadas quando há prontuário
- **Segurança**: Senhas armazenadas em texto simples (apenas para demonstração)
- **Responsividade**: Interface adaptada para dispositivos móveis

## 🤝 Contribuição

Este é um projeto acadêmico. Sugestões de melhorias são bem-vindas!

## 📝 Licença

Este projeto está sob a licença MIT.

---

Desenvolvido para a disciplina de Desenvolvimento Web 🚀
