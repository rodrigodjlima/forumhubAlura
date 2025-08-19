🖥️ ForumHub

ForumHub é uma aplicação de fórum online desenvolvida em Java Spring Boot, com autenticação JWT e gerenciamento completo de usuários.

🚀 Tecnologias Utilizadas

☕ Java 17+

🌱 Spring Boot 3.5

🔒 Spring Security

🗝️ JWT (JSON Web Token)

🗄️ JPA / Hibernate

🐬 MySQL

📦 Maven

🎯 Funcionalidades

🔑 Autenticação de Usuário

Login via username e senha.

Geração de token JWT para autenticação.

Rotas protegidas somente para usuários autenticados.

🧑‍💻 Cadastro e Gerenciamento de Usuário

Cadastro de novos usuários.

Listagem de usuários.

Atualização de dados do usuário.

Exclusão de usuário.

🛡️ Segurança

Proteção de rotas via JWT.

Senhas armazenadas de forma segura (recomenda-se BCrypt).


🗄 Configuração do Banco de Dados

No arquivo application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/forumhub
spring.datasource.username=root
spring.datasource.password=1234
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


Ajuste a URL, usuário e senha conforme seu ambiente.

🔑 Configuração JWT
security.jwt.secret=MinhaChaveSecretaSuperSegura123
security.jwt.expiration=3600000  # 1 hora em milissegundos


A chave secreta é utilizada para assinatura do token.

▶️ Executando a Aplicação

Clone o repositório:

git clone <URL_DO_REPOSITORIO>


Instale dependências e execute:

mvn clean install
mvn spring-boot:run


A aplicação estará disponível em:

http://localhost:8080


Para endpoints protegidos:
Adicione no Header:

Authorization: Bearer <token>

🧪 Testando no Postman ou Insomnia

Faça login usando /auth/login para gerar o token JWT.

Para todas as requisições protegidas, adicione no Header:

Authorization: Bearer <token>

⚠️ Observações

As senhas devem ser armazenadas de forma segura (recomenda-se BCrypt).

Ajuste a chave JWT (security.jwt.secret) antes de usar em produção.

Rotas protegidas exigem token JWT válido.



Método: POST

URL: http://localhost:8080/auth/login

Body (JSON):

{
"username": "usuario",
"password": "123"
}


Resposta esperada:

{
"token": 
}

🔑 Passo 2 – Usar Token JWT

Copie o valor do "token" retornado no login.

Em qualquer requisição protegida, adicione no Header:

Authorization: Bearer <TOKEN_AQUI>

👥 Testando Usuários no Postman/Insomnia

Criar usuário → POST /usuarios com JSON no body.

Listar usuários → GET /usuarios.

Buscar usuário → GET /usuarios/{id}.

Atualizar → PUT /usuarios/{id} com JSON atualizado.

Excluir → DELETE /usuarios/{id}.

📝 Testando Tópicos no Postman/Insomnia

Criar tópico → POST /topicos com JSON no body.

Listar tópicos → GET /topicos.

Buscar tópico → GET /topicos/{id}.

Atualizar tópico → PUT /topicos/{id} com JSON atualizado.

Excluir tópico → DELETE /topicos/{id}.

