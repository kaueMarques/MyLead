# Sistema de Coleta de Leads

<p align="left">
  <img alt="Node.js" src="https://img.shields.io/badge/Node.js-green?logo=node.js&style=flat-square" />
  <img alt="Spring Boot" src="https://img.shields.io/badge/Spring_Boot-brightgreen?logo=spring&style=flat-square" />
  <img alt="Angular" src="https://img.shields.io/badge/Angular-red?logo=angular&style=flat-square" />
  <img alt="MySQL" src="https://img.shields.io/badge/MySQL-blue?logo=mysql&style=flat-square" />
</p>

Este projeto consiste em um sistema de coleta de leads desenvolvido utilizando Node.js, Spring Boot e Angular.

## Pré-requisitos

Antes de iniciar, certifique-se de ter as seguintes ferramentas instaladas em seu ambiente de desenvolvimento:

- Node.js v20.10.0
- Angular CLI 16.2.11
- NPM 10.2.3
- Java 17
- Servidor MySQL local
- Json Server

## Configuração do Ambiente

Como primeiro passo é necessario deixar iniciado o Json server e o MySQL iniciados

### Configurando o Ambiente do Mock

Certifique-se de ter o arquivo `db.json` configurado com os dados desejados para simular o ambiente do servidor JSON (Json Server).

### Configurando o Ambiente Backend (Spring Boot)

1. Abra o projeto `LeedsDeClientesLojasTal-backend` em sua IDE preferida.
2. Certifique-se de que o Java 17 está configurado como JDK padrão.
3. Execute a aplicação Spring Boot para iniciar o servidor backend.

4. Para o build
```bash
./mvnw clean install
```

5. Para execução
```bash
./mvnw spring-boot:run
```

### Configurando o Ambiente Frontend (Angular)

1. Abra o projeto `LeedsDeClientesLojasTal-frontend` em um terminal.
2. Execute o seguinte comando para instalar as dependências do Angular:

```bash
npm install
```

3. Após a instalação, execute o seguinte comando para iniciar o servidor de desenvolvimento do Angular:

```bash
ng serve
```

## Iniciando o Fluxo da Aplicação

Com todos os ambientes configurados e os servidores em execução, você pode acessar a aplicação web em `http://localhost:4200`. Certifique-se de que o servidor backend está em execução para processar as solicitações da aplicação frontend.

A partir deste ponto, você pode interagir com a aplicação para coletar leads e visualizar as informações armazenadas no servidor JSON.

Lembre-se de ajustar as configurações conforme necessário, especialmente se estiver usando diferentes versões das ferramentas mencionadas.

## Observações

- É importante ressaltar que a aplicação contemplou os requisitos solicitados de maneira literal.

- Foi utilizdo também como ferramenta visual, a biblicoteca de componentes POI-UI
