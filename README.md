# Sistema de Gerenciamento de Funcionários

Um sistema para gerenciar **funcionários** e **cargos** de uma empresa, desenvolvido com **Spring Boot** e como banco de dados usando o **PostgreSQL**.  
Permite cadastrar funcionários, cargos e gerenciar, seguindo a regra que:

- Um funcionário pode ter **um ou mais cargos**.
- Um cargo pode pertencer a **um ou mais funcionários**.

---

## Tecnologias Utilizadas

- **Java 17 +**  
- **Spring Boot**  
- **Spring Data JPA / Hibernate**
- **Spring Web**
- **PostgreSQL**  
- **Maven**

---

## Funcionalidades

- Listar, cadastrar, atualizar e deletar **funcionários**.  
- Listar, cadastrar, atualizar e deletar **cargos**.  
- Procurar funcionarios ou cargos por id

---

## Configuração do Banco de Dados

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```
