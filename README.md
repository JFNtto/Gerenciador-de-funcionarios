# Sistema de Gerenciamento de Funcionários

Um sistema para gerenciar **funcionários** e **cargos** de uma empresa, desenvolvido com **Spring Boot** e utilizando **PostgreSQL** como banco de dados.  
O sistema permite cadastrar funcionários e cargos, além de gerenciar o relacionamento entre eles:

- Um funcionário pode ter **um ou mais cargos**.
- Um cargo pode pertencer a **um ou mais funcionários**.

---

## Tecnologias Utilizadas

- **Java 17+**  
- **Spring Boot**  
- **Spring Data JPA / Hibernate**  
- **Spring Web**  
- **PostgreSQL**  
- **Maven**

---

## Funcionalidades

- Listar, cadastrar, atualizar e deletar **funcionários**.  
- Listar, cadastrar, atualizar e deletar **cargos**.  
- Consultar funcionários ou cargos por **ID**.

---

## Configuração do Banco de Dados

Crie um arquivo chamado `application.properties` dentro de `src/main/resources/` com o seguinte conteúdo:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
