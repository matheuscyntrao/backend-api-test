#language: pt
@bank-account-service
Funcionalidade: BankAccountService - v1


  Esquema do Cenario:  BankAccountService - v1 <fluxo>
    Dado possuo dados para BankAccountService - v1 - Token
    Quando executo BankAccountService - v1 - PostDepositBill:
      | ammount   | document   |
      | <ammount> | <document> |
    Entao sistema processa BankAccountService - v1 - DepositStatus:
      | statusCode      | <statusCode>      |
      | financialStatus | <financialStatus> |
      | message         | <message>         |

    @FB @regressao
    Exemplos:
      | fluxo                      | document    | ammount | statusCode | message                                             | financialStatus |
      | FB - Deposito com valor 10 | 00703592025 | 10      | 200        |                                                     | CREATED         |
      | FA - Ammount Zero          | 00703592025 | 0       | 400        | Informe um valor maior que 0                        |                 |
      | FA - Conta não encontrada  | 15728537006 | 1       | 404        | Não existe uma conta cadastrada com o cpf informado |                 |

