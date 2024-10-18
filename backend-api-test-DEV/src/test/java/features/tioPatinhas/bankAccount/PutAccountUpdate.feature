#language: pt
@bank-account-service
Funcionalidade: BankAccountService - v1


  Esquema do Cenario:  BankAccountService - v1 <fluxo>
    Dado possuo dados para BankAccountService - v1 - CPFBankAccount:
      | cpf   |
      | <cpf> |
    E possuo dados para BankAccountService - v1 - GerarToken
    Quando executo BankAccountService - v1 - UpdateAccount:
      | email   | phoneNumber   |
      | <email> | <phoneNumber> |
    Entao sistema processa BankAccountService - v1 - UpdateStatus:
      | statusCode | <statusCode> |
      | message    | <message>    |

    @FB @regressao
    Exemplos:
      | fluxo                   | cpf         | email                     | phoneNumber | statusCode | message                                             |
      | FB - Alteração de dados | 00703592025 | RAALVES@GRUPODIMED.COM.BR | 51981392884 | 200        |                                                     |
      | FA - CPF não Autorizado | 15728537006 | RAALVES@GRUPODIMED.COM.BR | 51981392884 | 404        | Não existe uma conta cadastrada com o cpf informado |


