#language: pt
@bank-account-service
Funcionalidade: BankAccountService - v1


  Esquema do Cenario:  BankAccountService - v1 <fluxo>
    Dado possuo dados para BankAccountService - v1 - GetCPFBalance:
      | cpf   |<cpf> |
    E possuo dados para BankAccountService - v1 - TokenBalance
    Quando executo BankAccountService - v1 - GetBalance
    Entao sistema processa BankAccountService - v1 - GetBalanceStatus:
      | statusCode | <statusCode> |
      | message    | <message>    |

    @FB @regressao
    Exemplos:
      | fluxo                  | cpf         | statusCode | message                                             |
      | FB - Consulta de saldo | 00703592025 | 200        |                                                     |
      | FA - CPF inexistente   | 15728537006 | 404        | Não existe uma conta cadastrada com o cpf informado |

