# Encurtador de URLs

![Java](https://img.shields.io/badge/Java-17-blue?logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green?logo=spring)
![Build](https://img.shields.io/badge/build-passing-brightgreen)
![License](https://img.shields.io/badge/license-MIT-blue)

**Nota:** Este é meu **primeiro projeto** utilizando Java e Spring Boot sem ser guiado por um curso.  
O objetivo foi aprender sobre APIs REST, DTOs, validação e persistência em banco H2.


Um serviço simples de **encurtamento de URLs** construído com **Java** e **Spring Boot**.  
Este serviço permite criar URLs curtas, redirecionar para a URL original e contar quantos cliques cada URL recebeu.

---

## Funcionalidades

- Encurtar URLs longas.
- Redirecionar URLs curtas para a URL original.
- Contar quantas vezes cada URL curta foi acessada.
- Validação de URLs.
- Banco de dados H2 em memória para armazenamento.
- Tratamento de exceções para URLs não encontradas e requisições inválidas.

---

## Tecnologias

- Java 17
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- Banco de dados H2
- Validação com Spring Validation
- Maven

---

## Endpoints

### 1. Criar uma URL curta

- **URL:** `/api/urls`  
- **Método:** `POST`  
- **Corpo da requisição (JSON):**
```json
{
  "originalUrl": "https://www.exemplo.com"
}
```
Successful response (HTTP 200):
```json
{
  "shortUrl": "http://localhost:8080/api/urls/abc123"
}
```
Validation error(HTTP 400):
```json
{
  "timestamp": 1671234567890,
  "status": 400,
  "error": "Validation failed",
  "message": "Original URL is required",
  "path": "/api/urls"
}
```
### 2. Redirecionar para a URL original
H2 console URL: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:testdb

Username: sa

Password: (leave empty)

Pode monitorar as URLs e seu contador de clicks salvos no H2 console.

---

## Rodar o projeto

### 1. Entre na pasta do projeto
```bash
cd Encurtar-Urls
```
### 2. Compile e execute o projeto com Maven
```bash
mvn spring-boot:run
```
### 3 Acesse os endpoints via Postman ou navegador
---
### Licença

Este projeto é open-source. Fique à vontade para usar e modificar.
