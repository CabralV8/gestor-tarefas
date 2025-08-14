# Microsserviço de Agendamento de Tarefas

Este microsserviço permite criar, listar, atualizar e excluir tarefas, além de agendá-las para execução automática em horários e datas definidos. 
Foi desenvolvido em Java com Spring Boot e utiliza banco de dados relacional para persistência, opera em conjunto com a api de usuário.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Spring Web
- Spring Validation
- MySQL
- Gradlew

## Funcionalidades

- Criar uma nova tarefa com título, descrição, data e hora.
- Listar todas as tarefas.
- Consultar uma tarefa específica por ID.
- Atualizar informações de uma tarefa existente.
- Excluir uma tarefa.
- Agendar execução automática com base em data e hora.
- Documentação interativa com Swagger.

## Variáveis de Ambiente

Para rodar essa aplicação, você precisará de:
Java:JDK 17 ou superior. Gradlew Groovy 3.5.4 ou superior e você precisará adicionar as seguintes variáveis de ambiente no seu `application.properties`:

| Variável                             | Descrição                                      | Valor Padrão                               |
|:-------------------------------------|:-----------------------------------------------|:-------------------------------------------|
| `spring.application.name=`           | Nome da aplicação                              | gestor-tarefas                             |
| `spring.data.mongodb.uri=`           | URI de conexão com o banco MongoDB             | mongodb://localhost:27017/db_agendador     |
| `usuario.url=`                       | URL base do serviço de usuários                | localhost:8080                             |
| `server.port=`                       | Porta onde o servidor Spring Boot será iniciado| 8081                                       |


## Documentação da API - Tarefas

#### Cadastrar nova tarefa
```http
  POST /tarefas
```

| Parâmetro           | Tipo      | Descrição                                                  |
|:--------------------|:----------|:-----------------------------------------------------------|
| `TarefasDTORecord	` | `JSON	`   | **Obrigatório**: Dados da nova tarefa |
| `Authorization	`    | `string	` | **Obrigatório**: Token JWT do usuário |

#### Buscar tarefas agendadas por período

```http
  GET /tarefas/eventos
```

| Parâmetro     | Tipo              | Descrição                                    |
|:--------------|:------------------|:---------------------------------------------|
| `dataInicial` | `datetime (ISO)	` | **Obrigatório**: Data inicial no formato ISO |
| `dataFinal`   | `datetime (ISO)	` | **Obrigatório**: Data final no formato ISO   |

#### Exemplo de requisição:

```http
  GET /tarefas/eventos?dataInicial=2025-08-13T00:00:00&dataFinal=2025-08-20T23:59:59
```
#### Buscar tarefas agendadas por período

```http
  GET /tarefas
```

| Parâmetro       | Tipo      | Descrição                             |
|:----------------|:----------|:--------------------------------------|
| `Authorization` | `string	` | **Obrigatório**: Token JWT do usuário |

#### Deletar tarefa por ID

```http
DELETE /tarefas?id={id}
```

| Parâmetro | Tipo      | Descrição                                     |
|:----------|:----------|:----------------------------------------------|
| `id`      | `string	` | **Obrigatório**: ID da tarefa                 |

#### Alterar status de notificação de uma tarefa

```http
PATCH /tarefas?status={status}&id={id}
```

| Parâmetro | Tipo      | Descrição                                     |
|:----------|:----------|:----------------------------------------------|
| `id`      | `string	` | **Obrigatório**: ID da tarefa                 |

#### Atualizar dados de uma tarefa

```http
PUT /tarefas?id={id}
```

| Parâmetro          | Tipo      | Descrição                                    |
|:-------------------|:----------|:---------------------------------------------|
| `TarefasDTORecord` | `JSON	`   | **Obrigatório**: Dados atualizados da tarefa |
| `id`               | `string	` | **Obrigatório**: ID da tarefa                |


## Feedback

Se você tiver algum feedback ou dúvida, por favor deixe por meio de:

**Email**: valberton77@gmail.com

**GitHub**: https://github.com/CabralV8

**LinkedIn**: www.linkedin.com/in/valbertoncabral

