# Descrição
API feita com o framework *Spring Boot* para uma academia de ginástica fictícia. Permite criar, ler, atualizar e deletar dados sobre os alunos da academia em um banco de dados.

---

# Uso

Execute o arquivo `AcademiaDigitalApplication.java` para executar a aplicação localmente.

## Observação
É necessário ter um banco de dados configurado

### Exemplo: configurando postgreSQL

> Obs.: Edite os campos `username` e `password` caso necessário.

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/academia?useTimezone=true&serverTimezone=UTC&useLegacyDate
    username: postgres
    password: 
  jpa:
    show-sql: true
    hibernate:
      ddl-auto: update
    properties:
      hibernate.format_sql: true
```
`/resources/application.yml`

---

# Endpoints

## Aluno (CRUD)

### **Create**
Endpoint: `/alunos`

Método: `POST`

Deve ser passado um objeto json com os seguintes atributos para criar um registro:

Atributo | Tipo
---|---
nome | `string`
cpf | `string`
bairro | `string`
dataDeNascimento | `string`

---

### **Read**

Método | Endpoint | Descrição
---|---|---
GET | `/alunos` | Retorna uma lista com todos os alunos 
GET | `/alunos/{id}` | Retorna um aluno com base no ID

---

### **Update**
Endpoint: `/alunos/{id}`

Método: `PUT`

Deve ser passado um objeto json com os seguintes atributos para atualizar um registro:

Atributo | Tipo
---|---
nome | `string`
bairro | `string`
dataDeNascimento | `string`

---

### **Delete**
Endpoint: `/alunos/{id}`

Método: `DELETE`

---

## Matrícula

### **Create**

Endpoint: `/matriculas`

Método: `POST`

Deve ser passado um objeto json com os seguintes atributos para criar um registro:

Atributo | Tipo
---|---
idAluno | `int`

---

### **Read**

Método | Endpoint | Descrição
---|---|---
GET | `/matriculas` | Retorna uma lista com todas as matrículas
GET | `/matriculas/{id}` | Retorna uma matrícula com base no ID dela

---

### **Delete**

Endpoint: `/matriculas/{id}`

Método: `DELETE`

---

## Avaliação Física (CRUD)

### **Create**

Endpoint: `/avaliacoes`

Método: `POST`

Deve ser passado um objeto json com os seguintes atributos para criar um registro:

Atributo | Tipo
---|---
alunoId | `int`
peso | `double`
altura | `double`

---

### **Read**

Método | Endpoint | Descrição
---|---|---
GET | `/avaliacoes` | Retorna uma lista com todas as avaliações
GET | `/avaliacoes/{id}` | Retorna uma avaliação com base no ID dela

---

### **Update**

Endpoint: `/avaliacoes/{id}`

Método: `PUT`

Deve ser passado um objeto json com os seguintes atributos para atualizar um registro:

Atributo | Tipo
---|---
peso | `double`
altura | `double`

---

### **Delete**

Endpoint: `/avaliacoes/{id}`

Método: `DELETE`