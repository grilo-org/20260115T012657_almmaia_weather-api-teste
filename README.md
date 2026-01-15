# 🌦️ Weather API - Teste Técnico

API REST desenvolvida em Java (Spring Boot) para consulta de dados climáticos, utilizando banco de dados PostgreSQL e conteinerização completa com Docker.

## 🚀 Tecnologias Utilizadas

* **Linguagem:** Java 21
* **Framework:** Spring Boot 3
* **Banco de Dados:** PostgreSQL 15
* **Container:** Docker & Docker Compose
* **Documentação:** Swagger (OpenAPI)
* **Build:** Maven (Multi-Stage Build)

## 📦 Como Rodar o Projeto

Este projeto utiliza **Docker Multi-Stage Build**. Isso garante que a aplicação compile e rode em qualquer máquina apenas com o Docker instalado, sem a necessidade de instalar JDK ou Maven localmente.

### Pré-requisitos

* Docker Desktop instalado e rodando.
* Git instalado.

### Passo a Passo

1. **Clone o repositório:**
   ```bash
   git clone [https://github.com/almmaia/weather-api-teste.git](https://github.com/almmaia/weather-api-teste.git)


   Acesse a pasta do projeto:

Bash

cd weather-api-teste/weather-api
Suba o ambiente (Build Automático + Banco + API):

Bash

docker compose up --build
Aguarde alguns instantes. O Docker irá baixar as dependências, compilar o projeto e iniciar o banco de dados. O sistema estará pronto quando aparecer "Started WeatherApiApplication" no log.

🔌 Como Acessar e Testar
A API utiliza o método POST para buscar e salvar dados climáticos. Por isso, não é possível testar apenas abrindo a URL no navegador (que faz requisições GET). Utilize uma das formas abaixo:

Opção 1: Via Interface Visual (Swagger UI) - Recomendado ✅
Acesse o link abaixo para visualizar a documentação e testar os endpoints clicando em "Try it out": 👉 http://localhost:8080/swagger-ui/index.html

Opção 2: Via Terminal (cURL)
Abra seu terminal e cole o comando abaixo para simular uma requisição:

Exemplo (Buscar clima de Londres):

Bash

curl -X POST http://localhost:8080/weather/London
Exemplo (Buscar clima de São Paulo):

Bash

curl -X POST http://localhost:8080/weather/"Sao Paulo"
Nota para Windows (PowerShell): Se o comando acima der erro, tente usar curl.exe ao invés de apenas curl.

🛠️ Estrutura do Banco de Dados
O projeto utiliza o PostgreSQL. As tabelas são geradas automaticamente pelo Hibernate (JPA) ao iniciar a aplicação.

Tabela: weather_entity (Armazena o histórico de todas as consultas realizadas na API externa).