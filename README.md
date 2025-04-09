# Consulta de CEP

Sistema de consulta de CEP com armazenamento de histórico em arquivo JSON.

## Descrição

Este projeto implementa uma aplicação Java que permite ao usuário consultar informações de endereços a partir de um CEP, utilizando uma API pública de consulta. Os dados consultados são exibidos na tela e também armazenados em um arquivo JSON para consultas futuras.

## Funcionalidades

- Consulta de endereços por CEP utilizando API pública
- Menu interativo para o usuário
- Armazenamento do histórico de consultas em arquivo JSON
- Visualização de consultas anteriores

## Estrutura do Projeto

```
src/
├── com/
│   └── alura/
│       ├── model/
│       │   └── Address.java           # Record que representa um endereço
│       ├── service/
│       │   ├── CepService.java        # Serviço para consulta de CEP na API
│       │   └── FileService.java       # Serviço para manipulação de arquivos JSON
│       ├── repository/
│       │   └── AddressRepository.java # Repositório para gerenciar endereços
│       ├── ui/
│       │   └── Menu.java              # Interface com o usuário via console
│       └── Main.java                  # Classe principal da aplicação
```

## Tecnologias Utilizadas

- Java 21+
- HttpRequest para requisições HTTP
- Gson para manipulação de JSON
- Maven/Gradle para gerenciamento de dependências

## Como Executar

1. Clone o repositório
2. Configure as dependências no arquivo pom.xml (Maven) ou build.gradle (Gradle)
3. Execute a classe `Main.java`

## Dependências

Adicione estas dependências ao seu arquivo pom.xml (Maven):

```xml
<dependencies>
    <!-- Gson para manipulação de JSON -->
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.10.1</version>
    </dependency>
</dependencies>
```

Ou ao seu build.gradle (Gradle):

```gradle
dependencies {
    implementation 'com.google.code.gson:gson:2.10.1'
}
```

## Fluxo de Funcionamento

1. O usuário inicia a aplicação e é apresentado a um menu
2. Ao escolher consultar um CEP, o sistema:
   - Solicita o CEP desejado
   - Utiliza o `CepService` para consultar a API
   - Exibe os dados do endereço
   - Utiliza o `FileService` para salvar o endereço em um arquivo cep.json
3. O usuário pode consultar o histórico de CEPs já pesquisados no arquivo
4. O usuário pode encerrar a aplicação

## Arquitetura

O projeto segue uma arquitetura em camadas com separação clara de responsabilidades:

- **Model**: Contém a representação dos dados (Endereco)
- **Service**: Implementa a lógica de negócio (consulta à API e manipulação de arquivos)
- **Repository**: Gerencia o acesso e persistência dos dados
- **UI**: Interface com o usuário

Esta separação facilita a manutenção e testes da aplicação.
