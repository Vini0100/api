# Projeto de Exemplo de Utilização de APIs do Spring Boot

Este é um projeto desenvolvido com o objetivo de demonstrar o funcionamento e a utilização de diversas APIs oferecidas pelo Spring Boot, um framework popular para o desenvolvimento de aplicativos Java.

## Visão Geral

O Spring Boot é amplamente reconhecido por sua capacidade de simplificar o desenvolvimento de aplicativos Java, fornecendo uma configuração padrão e simplificando tarefas comuns, como a configuração de servidores de aplicativos e a integração com bancos de dados.

Este projeto de exemplo apresenta implementações de várias APIs do Spring Boot, demonstrando suas funcionalidades e como elas podem ser aplicadas em projetos do mundo real.

## APIs Demonstradas

O projeto cobre uma variedade de APIs do Spring Boot, incluindo, mas não se limitando a:

1. **API de Controle de Rotas:** Demonstração de como criar endpoints RESTful para manipulação de recursos, utilizando anotações como `@RestController`, `@GetMapping`, `@PostMapping`, `@PutMapping` e `@DeleteMapping`.

2. **API de Persistência de Dados:** Exemplificação do uso do Spring Data JPA para interagir com bancos de dados, incluindo operações CRUD (Create, Read, Update, Delete), consultas personalizadas e transações.

3. **API de Gerenciamento de Transações:** Ilustração de como usar transações em aplicativos Spring Boot, garantindo consistência e integridade dos dados em operações que envolvem várias etapas.

4. **API de Tratamento de Exceções:** Mostra como lidar com exceções de maneira eficaz em aplicativos Spring Boot, personalizando respostas HTTP de erro e implementando tratamentos globais de exceções.

## Como Utilizar

Para executar este projeto localmente, siga estas etapas:

1. **Clone o Repositório:** Faça uma cópia deste repositório em sua máquina local usando o comando `git clone`.

2. **Configure o Ambiente:** Certifique-se de ter o JDK e o Maven instalados em sua máquina.

3. **Compile o Projeto:** Navegue até o diretório raiz do projeto e execute o comando `mvn clean package` para compilar o projeto e construir o artefato.

4. **Execute o Aplicativo:** Após a conclusão da compilação, execute o aplicativo usando o comando `java -jar nome_do_arquivo.jar`, onde `nome_do_arquivo.jar` é o nome do arquivo JAR gerado no diretório `target`.

5. **Teste as Funcionalidades:** Use uma ferramenta como Postman ou cURL para enviar solicitações HTTP aos endpoints fornecidos pelo aplicativo e observe as respostas retornadas.

## Contribuição

Contribuições para melhorar e expandir este projeto são bem-vindas! Sinta-se à vontade para enviar pull requests com novos recursos, correções de bugs ou melhorias na documentação.

Se você encontrar algum problema ou tiver alguma sugestão, por favor, abra uma issue para que possamos discuti-la.
