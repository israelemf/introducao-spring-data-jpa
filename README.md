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


