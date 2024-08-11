Feature: Cadastro de contas
Como um usuário 
Gostaria de cadastrar contas
Para que eu possa distribuir meu dinheiro de uma forma mais organizada

Background: 
Given que estou acessando a aplicação


Scenario Outline: Deve Cadastrar um usuário com sucesso
Given Que preencho os dados de cadastro com cpf "<cpf>", nome "<nome>", celular "<celular>", email "<email>"
When Marco a confirmação do ceckbox
And clico no botão enviar
Then A conta e criada com sucesso

	Examples:
	  | cpf          | nome            								| celular     | email               				 |
	  | 55455620525  | Maria Marcela Stefany Freitas 	| 69995577502 | maria_freitas@lvnonline.com  |


Scenario: Inserir cpf inválido
When informo um cpf invalido "12312312312"
Then sou notificado que o cpf é inválido

Scenario: Inserindo um nome incompleto
Given informo um cpf "55455620525"
When informo um nome "joão"
Then sou notificado que preciso informar o nome completo