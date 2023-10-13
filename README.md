# Introdução ao Spring Data JPA
**Projeto criado em conjunto com a aula sobre Springboot do Bootcamp Java e AWS da DIO**
- - -

## Conceitos de ORM e JPA
- - -
### Object Relational Mapping (ORM)
Um recurso que aproxima o paradigma da orientação a objetos ao contexto de bancos
de dados relacionais.

- A ORM é realizada através do mapeamento de objetos para uma tabela por meio de
anotações por uma biblioteca ou framework.

### Java Persistence API (JPA)
Uma especificação baseada em interfaces e que através de um framework, realiza
operações de persistência de objetos em Java. Ou seja, a JPA é uma especificação, 
e é necessário um framework para atende-la.
- Existem alguns frameworks utilizados para essa finalidade
  - Hibernate (Implementação oficial do SpringBoot)
  - Top Link (Oracle)
  - EclipseLink
  - OpenJPA

### Mapeamento do JPA
Existem alguns aspectos das anotações de mapeamento do JPA, como:

- Identificação
  - É necessário uma identificação para a classe
- Definição
  - A classe tem atributos, e nesses atributos conseguimos aplicar definições
onde essas definições estarão diretamente associada ao DDL (Create, Alter, Drop, Truncate),
ou seja, como a tabela será criada e constituida dentro do banco de dados, como obrigatoriedade, primary key,
tamanho máximo, etc.
- Relacionamento
  - Conseguimos aplicar também relacionamentos entre as classes / entidades.
- Herança
  - A herança também pode ser utilizada dentro da JPA, realizando algumas configurações para manter
a integridade entre nossa estrutura de classes e o banco de dados.
- Persistência
  - Existem anotações para realizar as persistências, ou seja, podemos atribuir valores ao atributo que será persistido
no banco de dados.

## Conexão a banco de dados
O Spring Data JPA pode se conectar em qualquer banco ded dados relacional.
- Toda a parte de configuração fica centralizada no arquivo `application.properties`,
inclusive a de banco de dados, abaixo um exemplo de configuração de acesso ao banco de dados
PostgreSQL, porém serve para todos.

```
#Opcional
-> Se deseja exibir todo SQL gerado no console
spring.jpa.show-sql=true

-> O JPA é capaz de criar as tabelas do sistema conforme mapeamento
--> Com o update ele faz o seguinte, ele verifica se já existe a tabela, 
    caso exista, adiciona os campos novos, caso não exista ele cria a nova tabela
spring.jpa.hibernate.ddl-auto=update

#Obrigátorio de acordo com o seu banco de dados

-> Determina a plataforma de interpretação de SQL,  assim como o driver, 
   mantém uma melhor compatibilidade com o banco de dados
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect

-> Driver do bd
spring.datasource.driverClassName=org.postgresql.Driver

-> Local que esta hospedado o banco de dados
spring.datasource.url=jdbc:postgresql://localhost:5432/seu_db

-> Credenciais do banco de dados
spring.datasource.username=seu_user
spring.datasource.password=seu_pass
```

Após, é necessário também incluir no nosso arquivo `pom.xml` a dependencia JDBC do banco de dados utilizado





