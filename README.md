# 🔐 Auth API

Uma API de autenticação segura desenvolvida em Java com Spring Boot. Essa aplicação permite registrar usuários, autenticar via JWT, proteger rotas e realizar logout com segurança.

---

## ✨ Funcionalidades

- ✅ Registro de usuários
- 🔑 Login com geração de token JWT
- 🔒 Logout com invalidação de sessão
- 🔐 Proteção de rotas com autenticação JWT
- 🧱 Arquitetura baseada em **MVC** e **DDD**

---

## 🛠️ Tecnologias Utilizadas

- **Java 24**
- **Spring Boot 3.4.5**
- **Spring Security**
- **Spring OAuth2 Resource Server**
- **Spring Data JPA**
- **Spring Mail**
- **JWT (JSON Web Token)**
- **Docker** (para banco de dados MySQL)
- **BCrypt** (criptografia de senhas)
- **Lombok**

---

## 📁 Estrutura do Projeto

A aplicação segue uma separação clara de responsabilidades com base nos princípios de **Domain-Driven Design (DDD)** e arquitetura **MVC**:

src/
├── application/
│ └── services/
├── domain/
│ └── models/
├── infrastructure/
│ └── security/
├── interfaces/
│ └── controllers/
├── repositories/
└── config/


---

## 📌 Endpoints Principais

| Método | Rota             | Descrição              | Protegida |
|--------|------------------|------------------------|-----------|
| POST   | `/auth/register` | Registro de usuário    | ❌        |
| POST   | `/auth/login`    | Autenticação (JWT)     | ❌        |
| POST   | `/auth/logout`   | Logout                 | ✅        |
| GET    | `/user/me`       | Dados do usuário logado| ✅        |

---

## 🧪 Testes

A API pode ser testada facilmente utilizando ferramentas como **Postman** ou **Insomnia**. Você pode importar uma coleção com os endpoints principais.

---

## 🔐 Segurança

- Senhas armazenadas com **BCrypt**
- Tokens JWT enviados no header:  
  `Authorization: Bearer <token>`
- Proteção de rotas baseada em roles
- CORS configurado
- Logout invalida o token
- Suporte a OAuth2 Resource Server

---


## 🚀 Como Executar

### Pré-requisitos

- Java 24
- Maven
- Docker e Docker Compose

### 1. Suba o banco de dados

Execute o seguinte comando na raiz do projeto:

```bash
docker compose up -d



<!--
## 🔐 Variáveis de Ambiente

Em breve...
-->

## 📝 Licença

Este projeto está licenciado sob a licença **MIT**. Sinta-se livre para usar e modificar.

---

## 🙋 Sobre

Desenvolvido por Andrey Cesar como parte de estudos em autenticação segura com Java e Spring.
