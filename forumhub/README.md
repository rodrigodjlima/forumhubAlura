🚀 ForumHub API
Uma API RESTful para um fórum de discussão desenvolvida com Spring Boot, Spring Security e JWT.

📋 Funcionalidades
✅ Autenticação JWT

✅ CRUD de Tópicos

✅ Validação de Dados

✅ Tratamento de Erros

✅ Segurança com Spring Security

✅ Banco de Dados MySQL

🛠️ Tecnologias
Java 21

Spring Boot 3.5.0

Spring Security

JWT (JSON Web Token)

MySQL

JPA/Hibernate

Maven

📦 Instalação
Clone o repositório:


git clone <url-do-repositorio>
cd forumhub
Configure o banco de dados:

sql (IMPORTANTE)
CREATE DATABASE forumhub;
Configure as credenciais no arquivo application.properties

Execute a aplicação:


./mvnw spring-boot:run

🔐 Autenticação
1. Registrar Usuário
POST http://localhost:8080/auth/register

Body:

json
{
  "username": "seu_usuario",
  "password": "sua_senha"
}
2. Login
POST http://localhost:8080/auth/login

Body:

json
{
  "username": "seu_usuario",
  "password": "sua_senha"
}
Response:

json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
📝 Endpoints dos Tópicos

3. Listar Todos os Tópicos

GET http://localhost:8080/topicos

Headers:

text
Authorization: Bearer <seu_token_jwt>

4. Criar Novo Tópico

POST http://localhost:8080/topicos

Headers:

text
Authorization: Bearer <seu_token_jwt>
Content-Type: application/json
Body:

json
{
  "titulo": "Dúvida sobre Spring Boot",
  "mensagem": "Como configurar o JWT corretamente?",
  "estado": "ABERTO",
  "autor": "seu_usuario",
  "curso": "Java"
}

exemplo testado.:

<img width="1465" height="605" alt="image" src="https://github.com/user-attachments/assets/4c1ff161-59d4-4a49-93b9-d57bb0b3ee16" />


5. Atualizar Tópico
PUT http://localhost:8080/topicos/{id}

Headers:

text
Authorization: Bearer <seu_token_jwt>
Content-Type: application/json
Body:

json
{
  "titulo": "Título atualizado",
  "mensagem": "Mensagem atualizada",
  "estado": "FECHADO",
  "autor": "seu_usuario",
  "curso": "Java"
}
6. Deletar Tópico
DELETE http://localhost:8080/topicos/{id}

Headers:

text
Authorization: Bearer <seu_token_jwt>
7. Health Check
GET http://localhost:8080/ping

Response:

text
pong

🎯 Exemplo de Fluxo no Insomnia/Postman

Registrar usuário → /auth/register

Fazer login → /auth/login (copie o token)

Configurar header de autenticação:

text
Authorization: Bearer <token_obtido_no_login>
Criar tópico → /topicos (POST)

Listar tópicos → /topicos (GET)

Testar health check → /ping (GET)

⚙️ Configuração
application.properties
properties
spring.datasource.url=jdbc:mysql://localhost:3306/forumhub
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
security.jwt.secret=sua_chave_secreta_super_segura
security.jwt.expiration=3600000

🐛 Troubleshooting
Problema: Erro de CORS no Insomnia/Postman

Solução: A API já está configurada com CORS, certifique-se de usar o header Authorization corretamente.

Problema: Erro 401 Unauthorized
Solução: Verifique se o token JWT está válido e no formato Bearer <token>

Problema: Erro de conexão com banco
Solução: Verifique se o MySQL está rodando e as credenciais estão corretas.

📊 Status Codes

200 - Sucesso

201 - Criado com sucesso

400 - Dados inválidos

401 - Não autorizado

404 - Recurso não encontrado

409 - Conflito (dados duplicados)

500 - Erro interno do servidor

📧 Contato

rodrigodjlima@hotmail.com

