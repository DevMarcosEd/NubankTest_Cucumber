$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("classpath:aprender_cucumber.feature");
formatter.feature({
  "name": "Aprender Cucumber",
  "description": "\tComo um aluno\n\tEu quero aprender a utilizar Cucumber\n\tPara que eu possa automatizar critérios de aceitação",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Deve executar especificação",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "que criei o arquivo corretamente",
  "keyword": "Given "
});
formatter.match({
  "location": "AprenderCucumber.queCrieiOArquivoCorretamente()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "executá-lo",
  "keyword": "When "
});
formatter.match({
  "location": "AprenderCucumber.executáLo()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a especificação deve finalizar com scesso",
  "keyword": "Then "
});
formatter.match({
  "location": "AprenderCucumber.aEspecificaçãoDeveFinalizarComScesso()"
});
formatter.result({
  "status": "passed"
});
});