# gs-1-ai-upskilling

## Plataformas de upskilling e reskilling baseadas em IA

### 📋 Membros do Grupo

- **Carolina Teixeira Coelho - RM: 97643**
- **Daniel Marin Palma - RM: 551738**

---

## 📖 Descrição do Tema

Plataformas de upskilling e reskilling baseadas em IA 

Esta plataforma utiliza **Inteligência Artificial** para identificar gaps de competências e recomendar trilhas de aprendizado personalizadas. O sistema analisa o perfil profissional do usuário, suas habilidades atuais e objetivos de carreira para sugerir cursos, treinamentos e certificações alinhados com as demandas do mercado de trabalho.
---

## 🎯 Finalidade da API

API REST desenvolvida em **Java 17 com Spring Boot 3.5.6** que expõe informações sobre o projeto acadêmico. A aplicação fornece um endpoint único que retorna os dados do tema escolhido, membros da equipe e descrição detalhada do projeto.

### Características:
- ✅ Sem banco de dados
- ✅ Porta configurada: **8081**
- ✅ Documentação Swagger/OpenAPI integrada
- ✅ Containerizada com Docker
- ✅ CI/CD automatizado com GitHub Actions

---

## 🚀 Como Executar o Projeto

### Pré-requisitos
- Java 17+
- Maven 3.9+
- Docker

### Execução Local

1. **Clone o repositório:**
```bash
git clone https://github.com/caroolt/gs-1-ai-upskilling.git
cd gs-1-ai-upskilling
```

2. **Compile e execute a aplicação:**
```bash
./mvnw clean package
./mvnw spring-boot:run
```

3. **Acesse a aplicação:**
- API: http://localhost:8081/info
- Swagger UI: http://localhost:8081/swagger-ui.html
- OpenAPI Docs: http://localhost:8081/api-docs

## 🐳 Execução com Docker Compose

Além da execução local com Maven, o projeto pode ser facilmente iniciado utilizando o **Docker Compose**, que sobe a aplicação de forma containerizada na porta **8081**.

### Passos:

1. **Certifique-se de ter o Docker instalado e em execução**

   * [Baixar Docker Desktop](https://www.docker.com/products/docker-desktop/)

2. **Clone o repositório:**

   ```bash
   git clone https://github.com/caroolt/gs-1-ai-upskilling.git
   cd gs-1-ai-upskilling
   ```

3. **Suba os containers com Docker Compose:**

   ```bash
   docker-compose up --build
   ```

4. **Acesse a aplicação:**

   * API: [http://localhost:8081/info](http://localhost:8081/info)
   * Swagger UI: [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)

5. **Parar os containers:**

   ```bash
   docker-compose down
   ```

## 🐳 Docker Hub

**URL da Imagem:** [https://hub.docker.com/r/caroolt/gs-1-ai-upskilling](https://hub.docker.com/r/caroolt/gs-1-ai-upskilling)

```bash
docker pull caroolt/gs-1-ai-upskilling:latest
```

---

## 📡 Endpoints da API

### `GET /info`

Retorna informações sobre o tema do projeto.

**Response (200 OK):**
```json
{
  "tema": "Plataformas de upskilling e reskilling baseadas em IA",
  "membro1": "Carolina Teixeira - RM: 97643",
  "membro2": "Daniel Marin - RM: 551738",
  "descricao": "Esta plataforma utiliza Inteligência Artificial para identificar gaps de competências e recomendar trilhas de aprendizado personalizadas..."
}
```

---

## 🔄 Workflows CI/CD

### 1. **Versioning** (release-please.yaml) - 4 pontos

**Trigger:** Push na branch `main`

**Funcionalidades:**
- ✅ Geração automática de tags no GitHub
- ✅ Criação de CHANGELOG.md
- ✅ Versionamento semântico automático
- ✅ Release notes geradas automaticamente

**Como funciona:**
- Utiliza `googleapis/release-please-action@v4`
- Analisa commits convencionais (feat, fix, docs, etc.)
- Incrementa versão no `pom.xml` automaticamente
- Cria Pull Request de release quando necessário

### 2. **Continuous Integration (CI)** - 3 pontos

**Trigger:** Push nas branches `feature/**`, `release`, `hotfix`

**Pipeline:**
1. ✅ **Checkout** do código
3. ✅ **Build** da aplicação (`mvn clean package`)
4. ✅ **Testes Unitários** (`mvn test`)
5. ✅ **Build da imagem Docker** (verificação)

**Objetivo:** Garantir que o código está compilando e os testes passam antes do merge.

### 3. **Continuous Delivery (CD)** - 3 pontos

**Trigger:** Pull Request para a branch `develop`

**Pipeline:**
1. ✅ **Checkout** do código
2. ✅ **Login no Docker Hub**
3. ✅ **Build e Push** da imagem Docker para o Docker Hub

**Tags geradas:** `caroolt/gs-1-ai-upskilling:latest`

---

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.5.6**
- **Maven**
- **SpringDoc OpenAPI (Swagger)**
- **Docker**
- **GitHub Actions**

---

## 📚 Documentação

A documentação interativa da API está disponível via Swagger UI:

- **Swagger UI:** http://localhost:8081/swagger-ui.html
- **OpenAPI JSON:** http://localhost:8081/api-docs

---

## 🧪 Testes

Execute os testes unitários com:

```bash
./mvnw test
```

---

## 📝 Estrutura do Projeto

```
gs-1-ai-upskilling/
├── .github/
│   └── workflows/
│       ├── ci.yaml              # Continuous Integration
│       ├── cd.yaml              # Continuous Delivery
│       └── release-please.yaml  # Versioning automático
├── src/
│   ├── main/
│   │   ├── java/com/caroolt/upskilling/
│   │   │   ├── controller/
│   │   │   │   └── TemaController.java
│   │   │   └── UpskillingApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── Dockerfile
├── docker-compose.yaml
├── pom.xml
└── README.md
```

---

## 📦 Build e Deploy

### Deploy (via GitHub Actions)
1. Faça push de uma feature branch
2. Crie um PR para `develop`
3. O workflow CD fará o deploy automático no Docker Hub
