# Portaria Live - API

![Status do Projeto](https://img.shields.io/badge/status-em%20desenvolvimento-yellow)
![Java](https://img.shields.io/badge/java-21-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.1-brightgreen)
![Licença](https://img.shields.io/badge/licen%C3%A7a-MIT-informational)

API RESTful para o sistema de controle de acesso de portarias. Este backend é responsável por toda a lógica de negócio, gerenciamento de dados e segurança da aplicação.

## 📋 Tabela de Conteúdos

1.  [Sobre o Projeto](#-sobre-o-projeto)
2.  [Funcionalidades Planejadas](#-funcionalidades-planejadas)
3.  [Tecnologias Utilizadas](#-tecnologias-utilizadas)
4.  [Pré-requisitos](#-pré-requisitos)
5.  [Como Começar](#-como-começar)
6.  [Estrutura do Projeto](#-estrutura-do-projeto)
7.  [Documentação da API](#-documentação-da-api)
8.  [Como Contribuir](#-como-contribuir)
9.  [Licença](#-licença)

## 🎯 Sobre o Projeto

O **Portaria Live** foi desenhado para modernizar e simplificar o controle de entrada e saída em condomínios residenciais e comerciais. Esta API centraliza as informações de moradores, visitantes, veículos e registros de acesso, fornecendo endpoints seguros e eficientes para serem consumidos por uma aplicação frontend.

## ✨ Funcionalidades Planejadas

-   **Gerenciamento de Estrutura:** Cadastro de Blocos e Unidades do condomínio.
-   **Gerenciamento de Pessoas:** Cadastro completo de Moradores e Visitantes.
-   **Gerenciamento de Veículos:** Associação de veículos às unidades.
-   **Controle de Acesso:** Registro detalhado de entradas e saídas de visitantes.
-   **Painel do Operador:** Visualização em tempo real dos visitantes presentes no local e histórico de acessos.
-   **Segurança:** Autenticação e autorização de operadores do sistema baseada em perfis.

## 🚀 Tecnologias Utilizadas

O projeto foi construído utilizando as seguintes tecnologias:

-   **Java 21:** Versão mais recente da linguagem Java.
-   **Spring Boot 3:** Framework para criação de aplicações robustas e independentes.
-   **Spring Data JPA:** Para persistência de dados de forma simplificada.
-   **PostgreSQL:** Banco de dados relacional.
-   **Maven:** Gerenciador de dependências e build do projeto.
-   **Lombok:** Para reduzir código boilerplate (getters, setters, etc).

## ✅ Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina:

-   [JDK 21](https://www.oracle.com/java/technologies/downloads/#jdk21-windows)
-   [Maven](https://maven.apache.org/download.cgi)
-   [Git](https://git-scm.com/downloads)
-   [PostgreSQL](https://www.postgresql.org/download/)

## 🏁 Como Começar

Siga os passos abaixo para executar o projeto localmente.

1.  **Clone o repositório**
    ```bash
    git clone [https://github.com/srmatheusmaciel/sentinella-matheus-maciel-api.git](https://github.com/srmatheusmaciel/sentinella-matheus-maciel-api.git)
    cd sentinella-matheus-maciel-api
    ```

2.  **Configure o Banco de Dados**
    -   Abra o PostgreSQL e crie um novo banco de dados.
    ```sql
    CREATE DATABASE sentinella_db;
    ```
    -   Crie um usuário ou utilize um existente que tenha permissão para acessar este banco.

3.  **Configure as variáveis de ambiente**
    -   Navegue até `src/main/resources` e abra o arquivo `application.properties`.
    -   Altere as propriedades `spring.datasource.username` e `spring.datasource.password` com as suas credenciais do PostgreSQL.
    ```properties
    # URL de conexão com o banco de dados
    spring.datasource.url=jdbc:postgresql://localhost:5432/sentinella_db

    # Usuário e senha do banco de dados
    spring.datasource.username=seu_usuario_postgres
    spring.datasource.password=sua_senha_postgres
    ```

4.  **Execute a aplicação**
    -   Você pode executar o projeto diretamente pela sua IDE (IntelliJ, Eclipse) ou via linha de comando com o Maven.
    ```bash
    mvn spring-boot:run
    ```

A aplicação estará rodando em `http://localhost:8080`.

## 📂 Estrutura do Projeto

O projeto segue uma estrutura padrão para aplicações Spring Boot, com o código fonte principal localizado em `src/main/java`.

```
br.com.portaria.api
├── domain        # Contém as entidades JPA (ex: Bloco, Unidade)
├── repository    # Interfaces do Spring Data JPA para acesso aos dados
├── service       # Lógica de negócio da aplicação
├── controller    # Endpoints da API REST
└── dto           # Objetos de Transferência de Dados para as requisições e respostas
```

## 📚 Documentação da API

A documentação dos endpoints será disponibilizada utilizando Swagger/OpenAPI. Após a implementação, ela poderá ser acessada em:

`http://localhost:8080/swagger-ui.html`

*(Esta seção será atualizada conforme os endpoints forem desenvolvidos.)*

## 🤝 Como Contribuir

Contribuições são o que tornam a comunidade de código aberto um lugar incrível para aprender, inspirar e criar. Qualquer contribuição que você fizer será **muito bem-vinda**.

1.  Faça um *fork* do projeto.
2.  Crie uma *branch* para sua nova funcionalidade (`git checkout -b feature/AmazingFeature`).
3.  Faça o *commit* de suas alterações (`git commit -m 'feat: Add some AmazingFeature'`).
4.  Faça o *push* para a *branch* (`git push origin feature/AmazingFeature`).
5.  Abra um *Pull Request*.

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
