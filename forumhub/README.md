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

🗂 Estrutura do Projeto
src/main/java/com/forumhub/
├─ model/            # Entidades do banco de dados (Usuario.java)
├─ repository/       # Interfaces JPA (UsuarioRepository.java)
├─ service/          # Lógica de negócio (UsuarioService.java)
├─ security/         # JWT, filtros e serviços de autenticação (TokenService.java, JWTFilter.java)
├─ controller/       # Endpoints REST (AuthController.java, UsuarioController.java)
└─ config/           # Configurações de segurança (SecurityConfig.java, AuthUserDetailsService.java)

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

📋 Endpoints e Testes
Emoji	Método	Endpoint	Body (JSON)	Autorização	Descrição
📝	POST	/auth/login	{ "username": "usuario", "password": "123" }	❌ Não	Login e geração de token JWT
📝	POST	/usuarios	{ "username": "novo_usuario", "password": "123" }	✅ Sim	Cadastro de novo usuário
🔍	GET	/usuarios	-	✅ Sim	Listar todos os usuários
🔍	GET	/usuarios/{id}	-	✅ Sim	Buscar usuário por ID
✏️	PUT	/usuarios/{id}	{ "username": "atualizado", "password": "1234" }	✅ Sim	Atualizar usuário
🗑️	DELETE	/usuarios/{id}	-	✅ Sim	Deletar usuário

Para endpoints protegidos:
Adicione no Header:

Authorization: Bearer <token>

🧪 Testando no Postman ou Insomnia

Faça login usando /auth/login para gerar o token JWT.

Para todas as requisições protegidas, adicione no Header:

Authorization: Bearer <token>


Teste todos os endpoints usando os métodos indicados pelos emojis na tabela.

🌈 Representação Visual do Fluxo
[Usuário]
│
│ POST /auth/login
▼
[Token JWT gerado]
│
│ Usar token nos Headers
▼
[Endpoints Protegidos: /usuarios/...]
│
├─ 🔍 GET - Listar / Buscar
├─ 📝 POST - Criar
├─ ✏️ PUT - Atualizar
└─ 🗑️ DELETE - Remover

⚠️ Observações

As senhas devem ser armazenadas de forma segura (recomenda-se BCrypt).

Ajuste a chave JWT (security.jwt.secret) antes de usar em produção.

Rotas protegidas exigem token JWT válido.

Se você quiser, posso criar também um esquema visual em imagem mostrando como o token circula entre front-end, back-end e banco, para colocar direto no README do GitHub, tornando ainda mais didático.

Quer que eu faça isso?

Você disse:
Pode refazer por favor mostrando também como usar funções no Postman ou Insomnia para topicos
O ChatGPT disse:

Ótimo ponto! 👏
Você está me dizendo que além da parte de usuários/autenticação, também tem a parte de tópicos do fórum (CRUD de tópicos). Então vamos refazer o README completo incluindo as instruções de como usar tudo no Postman/Insomnia (usuários + tópicos).

🖥️ ForumHub

ForumHub é uma aplicação de fórum online desenvolvida em Java Spring Boot, com autenticação JWT e gerenciamento completo de usuários e tópicos.

🚀 Tecnologias Utilizadas

☕ Java 17+

🌱 Spring Boot 3.5

🔒 Spring Security

🗝️ JWT (JSON Web Token)

🗄️ JPA / Hibernate

🐬 MySQL

📦 Maven

🎯 Funcionalidades
🔑 Autenticação

Login via username e senha.

Geração de token JWT.

Rotas protegidas (usuário deve estar autenticado).

👥 Usuários

Criar usuário.

Listar todos usuários.

Buscar usuário por ID.

Atualizar usuário.

Deletar usuário.

📝 Tópicos

Criar novo tópico.

Listar todos os tópicos.

Buscar tópico por ID.

Atualizar tópico.

Deletar tópico.

🗂 Estrutura do Projeto
src/main/java/com/forumhub/
├─ model/            # Entidades (Usuario.java, Topico.java)
├─ repository/       # Interfaces JPA (UsuarioRepository.java, TopicoRepository.java)
├─ service/          # Lógica de negócio (UsuarioService.java, TopicoService.java)
├─ security/         # JWT e autenticação (TokenService.java, JWTFilter.java)
├─ controller/       # Endpoints REST (AuthController.java, UsuarioController.java, TopicoController.java)
└─ config/           # Configurações (SecurityConfig.java, AuthUserDetailsService.java)

📋 Endpoints
🔑 Autenticação
Método	Endpoint	Body (JSON)	Autorização	Descrição
📝 POST	/auth/login	{ "username": "usuario", "password": "123" }	❌ Não	Gera um token JWT
👥 Usuários
Método	Endpoint	Body (JSON)	Autorização	Descrição
📝 POST	/usuarios	{ "username": "novo", "password": "123" }	✅ Sim	Criar usuário
🔍 GET	/usuarios	-	✅ Sim	Listar todos usuários
🔍 GET	/usuarios/1	-	✅ Sim	Buscar usuário por ID
✏️ PUT	/usuarios/1	{ "username": "editado", "password": "1234" }	✅ Sim	Atualizar usuário
🗑 DELETE	/usuarios/1	-	✅ Sim	Deletar usuário
📝 Tópicos
Método	Endpoint	Body (JSON)	Autorização	Descrição
📝 POST	/topicos	{ "titulo": "Primeiro Tópico", "mensagem": "Conteúdo do tópico", "autorId": 1 }	✅ Sim	Criar tópico
🔍 GET	/topicos	-	✅ Sim	Listar todos tópicos
🔍 GET	/topicos/1	-	✅ Sim	Buscar tópico por ID
✏️ PUT	/topicos/1	{ "titulo": "Atualizado", "mensagem": "Novo conteúdo" }	✅ Sim	Atualizar tópico
🗑 DELETE	/topicos/1	-	✅ Sim	Deletar tópico
🧪 Testando no Postman ou Insomnia
🔑 Passo 1 – Login

Método: POST

URL: http://localhost:8080/auth/login

Body (JSON):

{
"username": "usuario",
"password": "123"
}


Resposta esperada:

{
"token": "eyJhbGciOiJIUzI1NiJ9..."
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

🌈 Fluxo Visual
[Usuário]
│
│ POST /auth/login
▼
[Token JWT gerado]
│
│ Usar token nos Headers
▼
[Endpoints Protegidos]
├─ 👥 Usuários
│   ├─ 📝 POST /usuarios
│   ├─ 🔍 GET /usuarios
│   ├─ ✏️ PUT /usuarios/{id}
│   └─ 🗑 DELETE /usuarios/{id}
│
└─ 📝 Tópicos
├─ 📝 POST /topicos
├─ 🔍 GET /topicos
├─ ✏️ PUT /topicos/{id}
└─ 🗑 DELETE /topicos/{id}