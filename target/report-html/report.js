$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/cadastrar_conta.feature");
formatter.feature({
  "name": "Cadastro de contas",
  "description": "Como um usuário \nGostaria de cadastrar contas\nPara que eu possa distribuir meu dinheiro de uma forma mais organizada",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Deve Cadastrar um usuário com sucesso",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Que preencho os dados de cadastro com cpf \"\u003ccpf\u003e\", nome \"\u003cnome\u003e\", celular \"\u003ccelular\u003e\", email \"\u003cemail\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "name": "Marco a confirmação do ceckbox",
  "keyword": "When "
});
formatter.step({
  "name": "clico no botão enviar",
  "keyword": "And "
});
formatter.step({
  "name": "A conta e criada com sucesso",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "cpf",
        "nome",
        "celular",
        "email"
      ]
    },
    {
      "cells": [
        "55455620525",
        "Maria Marcela Stefany Freitas",
        "69995577502",
        "maria_freitas@lvnonline.com"
      ]
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "que estou acessando a aplicação",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.CadastrarContaSteps.queEstouAcessandoAAplicação()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Deve Cadastrar um usuário com sucesso",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Que preencho os dados de cadastro com cpf \"55455620525\", nome \"Maria Marcela Stefany Freitas\", celular \"69995577502\", email \"maria_freitas@lvnonline.com\"",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.CadastrarContaSteps.quePreenchoOsDadosDeCadastroComCpfNomeCelularEmail(java.lang.String,java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Marco a confirmação do ceckbox",
  "keyword": "When "
});
formatter.match({
  "location": "steps.CadastrarContaSteps.marcoAConfirmaçãoDoCeckbox()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clico no botão enviar",
  "keyword": "And "
});
formatter.match({
  "location": "steps.CadastrarContaSteps.clicoNoBotãoEnviar()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "A conta e criada com sucesso",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.CadastrarContaSteps.aContaECriadaComSucesso()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "que estou acessando a aplicação",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.CadastrarContaSteps.queEstouAcessandoAAplicação()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Inserir cpf inválido",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "informo um cpf invalido \"12312312312\"",
  "keyword": "When "
});
formatter.match({
  "location": "steps.CadastrarContaSteps.informoUmCpfInvalido(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "sou notificado que o cpf é inválido",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.CadastrarContaSteps.souNotificadoQueOCpfÉInválido()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "que estou acessando a aplicação",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.CadastrarContaSteps.queEstouAcessandoAAplicação()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Inserindo um nome incompleto",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "informo um cpf \"55455620525\"",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.CadastrarContaSteps.informoUmCpf(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "informo um nome \"joão\"",
  "keyword": "When "
});
formatter.match({
  "location": "steps.CadastrarContaSteps.informoUmNome(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "sou notificado que preciso informar o nome completo",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.CadastrarContaSteps.souNotificadoQuePrecisoInformarONomeCompleto()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});