#language: pt

Funcionalidade: Cadastro de contas
  Como um usuário
  Gostaria de cadastrar contas
  Para que eu possa distribuir meu dinheiro de uma forma mais organizada

  Contexto:
    Dado que desejo adicionar uma conta

  Esquema do Cenário: Deve validar regras de cadastro de contas
    Quando adiciono uma <conta>
    Então recebo uma notificação: <mensagem>

    Exemplos:
      | conta            | mensagem                           |
      | Conta de Teste   | Conta adicionada com sucesso!      |
      |                  | Informe o nome da conta            |
      | Conta mesmo nome | Já existe uma conta com esse nome! |
