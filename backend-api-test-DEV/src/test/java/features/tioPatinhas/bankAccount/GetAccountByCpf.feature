#language: pt
@bank-account-service
Funcionalidade: BankAccountService - v1


  Esquema do Cenario:  BankAccountService - v1 <fluxo>
    Dado possuo dados para BankAccountService - v1 - GetCPFBankAccount:
      | cpf | <cpf> |
    E possuo dados para BankAccountService - v1 - GeraToken
    Quando executo BankAccountService - v1 - GetAccount
    E que efetuo Cliente - v2Pip - GetClientesCpf "<cpf>"
    Entao sistema processa BankAccountService - v1 - GetAccountStatus:
      | statusCode | <statusCode> |
      | message    | <message>    |
    E valido BankAccountService - v1 - ValidaDados



    @FB @regressao
    Exemplos:
      | fluxo                   | cpf         | statusCode | message                                             |
      | FB - Cadastro de Conta  | 00703592025 | 200        |                                                     |
      | FA - CPF não Autorizado | 15728537006 | 404        | Não existe uma conta cadastrada com o cpf informado |

