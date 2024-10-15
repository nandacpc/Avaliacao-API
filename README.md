# API RESTful de Cadastro de Currículos

## Descrição

Esta API foi desenvolvida para gerenciar informações de candidatos a vagas em processos seletivos. O sistema permite o cadastro, consulta, atualização e remoção de currículos, além de possibilitar a filtragem de candidatos por vaga desejada e escolaridade.

## Funcionalidades

- Cadastro de novos candidatos com informações detalhadas.
- Atualização de status do currículo.
- Filtragem de candidatos por vaga desejada e escolaridade.
- Operações básicas de CRUD (Create, Read, Update, Delete) para candidatos.
- Separação clara entre DTOs e entidades.

## Tecnologias Utilizadas

- **Java 17**: Linguagem de programação utilizada no desenvolvimento.
- **Spring Boot**: Framework principal da API.
- **Spring Data JPA**: Para o gerenciamento e mapeamento de dados no banco de dados.
- **H2 Database/PostgreSQL/MySQL**: Banco de dados para armazenar as informações dos candidatos.
- **Maven**: Gerenciamento de dependências.
- **Git**: Controle de versão.

## Endpoints da API
GET /curriculos: Retorna a lista de todos os candidatos.

POST /curriculos: Adiciona um novo candidato.

GET /curriculos/{id}: Retorna um candidato pelo seu ID.

PUT /curriculos/{id}: Atualiza as informações de um candidato.

DELETE /curriculos/{id}: Remove um candidato.

GET /curriculos/vaga/ANALISTA: Filtra candidatos por vaga desejada.

GET /curriculos/escolaridade/GRADUACAO: Filtra candidatos por escolaridade.

GET /curriculos/status/APROVADO: Filtra candidatos por status do currículo.

## Estrutura do Projeto
### Modelos
*Candidato:* Representa os dados dos candidatos.
*Enums:*
*Escolaridade:* [MEDIO, FUNDAMENTAL, GRADUACAO, POS_GRADUACAO, ESPECIALIZACAO]
*VagaDesejada:* [ANALISTA, QA, DEV, TECH_LEAD, SUPORTE, UX]
*StatusCurriculo:* [EM_ANALISE, REPROVADO, APROVADO]

### DTO
O DTO é usado para transferir dados entre as camadas da API, evitando vazamentos de informações e separando a lógica de negócios da apresentação.

### Repositório
O repositório fornece a camada de abstração para interagir com o banco de dados, realizando operações CRUD e consultas personalizadas (Derived Queries) para filtrar candidatos por vaga e escolaridade.

### Serviço
O serviço contem a lógica de negócios, incluindo a manipulação de currículos, adição de novos candidatos e atualizações de status.

### Controlador
O controlador recebe as requisições HTTP e delegam a execução para os serviços apropriados, retornando os resultados em formato JSON.


