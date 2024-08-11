# Projeto de Automação de Testes

Este projeto é uma automação de testes para o cadastro de contas em uma aplicação fictícia. Utiliza-se Cucumber para descrever os cenários de teste e Selenium para automação da interface do usuário.

## Estrutura do Projeto

### Funcionalidade

A funcionalidade principal é o cadastro de contas, permitindo que um usuário se registre com informações básicas.

#### Feature: Cadastro de contas

- **Objetivo:** Permitir que um usuário cadastre uma conta para distribuir seu dinheiro de forma organizada.

#### Cenários:

1. **Deve Cadastrar um usuário com sucesso**
    - **Dado** que o usuário está acessando a aplicação
    - **Quando** o usuário preenche os dados de cadastro (CPF, nome, celular, email)
    - **E** marca a confirmação do checkbox
    - **E** clica no botão enviar
    - **Então** a conta é criada com sucesso

2. **Inserir CPF inválido**
    - **Quando** o usuário informa um CPF inválido
    - **Então** é notificado que o CPF é inválido

3. **Inserindo um nome incompleto**
    - **Dado** que o usuário informa um CPF
    - **Quando** o usuário informa um nome incompleto
    - **Então** é notificado que precisa informar o nome completo

### Código Fonte

O código está organizado nas seguintes pastas:

- **`steps`**: Contém os arquivos de implementação dos passos definidos nas features.
- **`runners`**: Contém o runner do Cucumber para executar os testes.

### Dependências

Este projeto utiliza:

- **Selenium**: Para automação de navegação web.
- **Cucumber**: Para definição e execução dos cenários de teste.
- **JUnit**: Para execução dos testes e integração com o Cucumber.
- **Apache Commons IO**: Para manipulação de arquivos.

### Configuração

1. **Driver do Selenium:** O projeto usa o GeckoDriver para o Firefox. Certifique-se de que o caminho para o `geckodriver.exe` esteja correto no código.

2. **Dependências de Maven:** Adicione as seguintes dependências ao seu `pom.xml` (se estiver usando Maven):

    ```xml
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.0.0</version>
    </dependency>
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-java</artifactId>
        <version>7.0.0</version>
    </dependency>
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-junit</artifactId>
        <version>7.0.0</version>
    </dependency>
    <dependency>
        <groupId>commons-io</groupId>
        <artifactId>commons-io</artifactId>
        <version>2.11.0</version>
    </dependency>
    ```

### Execução dos Testes

Para executar os testes:

1. Compile o projeto.
2. Execute a classe `Runner` como uma aplicação Java.

Os relatórios dos testes serão gerados em `target/report-html` (HTML) e `target/report.json` (JSON).

### Contribuição

Se você deseja contribuir com o projeto:

1. Faça um fork do repositório.
2. Crie uma branch para sua feature ou correção.
3. Faça commit das suas alterações.
4. Envie um pull request.

### Licença

Este projeto é licenciado sob a Licença MIT. Veja o arquivo `LICENSE` para mais detalhes.
