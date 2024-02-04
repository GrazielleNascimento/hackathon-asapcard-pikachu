# Projeto Blog Pessoal

<br />

<div align="center">
    <img src="https://i.imgur.com/w8tTOuT.png" title="source: imgur.com" /> 
</div>

<br />


Acesse a API aqui: [Blog Pessoal API](https://blogpessoal-wah0.onrender.com/)

O Blog Pessoal é uma API desenvolvida com foco acadêmico, empregando conceitos e boas práticas no desenvolvimento de uma API Rest por meio do Framework Spring. O projeto abrange as principais camadas do padrão MVC, além de incluir camadas adicionais, como Security, Service e Test. Destinado ao estudo dos conceitos fundamentais do CRUD, a API permite o cadastro de usuários (com camadas de segurança), postagens e temas inter-relacionados.

## Como testar o projeto?

1.  Ao acessar o site, será solicitado um usuário, que provavelmente ainda não foi criado.
2.  Para criar um usuário, utilize o endpoint https://blogpessoal-wah0.onrender.com/usuarios/cadastrar.
3.  No corpo da requisição, envie as informações no formato JSON:
    
    jsonCopy code
    
    `{
      "nome": "user",
      "usuario": "user@user.com",
      "senha": "user123",
      "foto": "https://i.imgur.com/Tk9f10K.png"
    }` 
    
4. Após o cadastro, insira essas mesmas informações na sessão de login e explore toda a documentação da API.
5. Se quiser utilizar os outros HTTP Methods da Api, faça login e guarde seu token (ele será exigido nas outras requisições) 

Observação: O carregamento do site pode ser inicialmente lento devido à hospedagem gratuita; o Render desliga a aplicação se não houver acessos nos últimos 15 minutos.

## Arquitetura do projeto

-   **Framework:** Baseado no Spring, Spring Security e JUnit.
-   **Persistência de Dados:** Utiliza o MySQL para ambiente de desenvolvimento e PostgreSQL para produção (devido a configurações específicas do Render).
-   **Transmissão de Dados:** Adota o padrão JSON para envio e recebimento de dados na API.
-   **Arquitetura:** Segue o padrão MVC com uma abordagem Web Spring API.
-   **Segurança:** Implementa todas as camadas de segurança por meio do Spring Security.
-   **Ambiente de testes:** Utiliza JUnit para testes unitários dos principais métodos da classe Usuário.
-   **Dependências:** Incluem Spring Web, Spring Boot Devtools, Validation, Spring Data JPA, MySQL Driver, Spring Security, MySQL, JSON Web Token, JUnit, H2 Database, Spring Doc e PostgreSQL.
-   **Documentação:** Utiliza o Swagger UI para documentação da API.
  
<br />

## Diagrama de Classes

```mermaid
classDiagram
class Tema {
  - id : Long
  - descricao : String
  - postagem : List ~Postagem~
  + getAll()
  + getById(Long id)
  + getByDescricao(String descricao)
  + postTema(Tema tema)
  + putTema(Tema tema)
  + deleteTema(Long id)
}
class Postagem {
  - id : Long
  - titulo : String
  - texto: String
  - data: LocalDateTime
  - tema : Tema
  - usuario : Usuario
  + getAll()
  + getById(Long id)
  + getByTitulo(String titulo)
  + postPostagem(Postagem postagem)
  + putPostagem(Postagem postagem)
  + deleteTema(Long id)
}
class Usuario {
  - id : Long
  - nome : String
  - usuario : String
  - senha : String
  - foto : String
  - postagem : List ~Postagem~
  + getAll()
  + getById(Long id)
  + autenticarUsuario(UsuarioLogin usuarioLogin)
  + cadastrarUsuario(Usuario usuario)
  + atualizarUsuario(Usuario usuario)
}
class UsuarioLogin{
  - id : Long
  - nome : String
  - usuario : String
  - senha : String
  - foto : String
  - token : String
}
Tema --> Postagem
Usuario --> Postagem
```

<br /><br />
