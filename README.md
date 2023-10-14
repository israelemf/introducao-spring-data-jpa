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

## Repository

É um padrão de projeto similar ao DAO (Data Access Object), e seu objetivo é abstrair
o acesso a dados de forma genérica a partir do seu modelo de objeto.

O Spring Data JPA facilita a implementação desse padrão Repository, através da Programação
Orientada a Aspectos, que é um paradigma que permite organizar o código fonte de acordo com a
importância de uso na aplicação e separar em módulos.

O Spring Data Jpa nos fornece interfaces para facilitar o acesso aos dados, 
como a interface JpaRepository que nos fornece métodos genéricos de CRUD já preparados.

**Principais métodos que são disponibilizados pelo framework**
- save
  - Insere e atualiza os dados de uma entidade
- findById
  - Retorna o objeto buscando pelo ID
- existsById
  - Verifica a existência de um objeto pelo ID informado, retorna um boolean
- findAll
  - Retorna uma coleção contendo todos os registros da tabela do banco
- delete
  - Deleta um registro da tabela
- count
  - Retorna a quantidade de registros de uma tabela


## Consultas Customizadas

As duas maneiras de realizar consultar customizadas são chamadas de **QueryMethod** e **QueryOverride**

### QueryMethod
O Spring Data JPA se encarrega de interpretar a assinatura de um método (nome + parametros) para montar
a JPQL (Linguagem SQL do JPA, utilizada no contexto de entidades / classes) correspondente.

Exemplo:
```
public interface UserRepository extends Repository<User, Long> {
  List<User> findByEmailAddressAndLastName(String emailAddress, String lastName);
}
```
Com base na sintaxe acima, o JPA já consegue executar a consulta JPQL.

Na documentação do Spring Data JPA existem inúmeras sintaxes para consultas, como and, or, between, equals, distinct, etc;


### Query Override
Agora imaginamos que vamos precisar montar uma query mais avançada e extensa, ficaria inviável utilizar o padrão QueryMethod.

É ai que precisamos definir a consulta de forma manual, através da anotação **@Query**

Exemplo:
```
public interface UserRepository extends Repository<User, Long> {

  //QueryMethod
  List<User> findByEmailAddressAndLastName(String emailAddress, String lastName);
  User user = 
  
  
  // QueryOverride
  @Query("SELECT * FROM user WHERE user.name LIKE %:name%")
  List<User> filterByName(@Param("name") String name);
}
```

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





