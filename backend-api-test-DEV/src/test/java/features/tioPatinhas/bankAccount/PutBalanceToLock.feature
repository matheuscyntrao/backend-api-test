#language: pt
@bank-account-service
Funcionalidade: BankAccountService - v1


  Esquema do Cenario:  BankAccountService - v1 <fluxo>
    Dado possuo dados para BankAccountService - v1 - CPFBalanceLock:
      | document   | amount   |
      | <document> | <amount> |
    E possuo dados para BankAccountService - v1 - TokenBalanceLock
    E possuo dados para BankAccountService - v1 - deleteAccountByCpfToBalance <criacaoConta>
    E executo BankAccountService - v1 - PostCreateAccountBalance: <criacaoConta>
      | cpf        |
      | <document> |
    Quando executo BankAccountService - v1 - PutBalanceLock
    Entao sistema processa BankAccountService - v1 - UpdateStatusLock:
      | statusCode | <statusCode> |
      | message    | <message>    |

    @FB @regressao
    Exemplos:
      | fluxo                                                 | document    | amount | statusCode | message                                             | criacaoConta |
      | FB - Saldo bloqueado com sucesso                      | 42555442049 | 1      | 204        |                                                     | 0            |
      | FA1 - Valor menor do que o permitido                  | 42555442049 | 0      | 400        | Valor menor do que o permitido.                     | 0            |
      | FA2 - Cliente não existe                              | 15728537006 | 10     | 404        | Não existe uma conta cadastrada com o cpf informado | 0            |
      | FA3 - Valor bloqueado maior que o saldo               | 42555442049 | 10000  | 500        |                                                     | 0            |
      | FA4 - Conta Recém criada                              | 04343807924 | 10     | 500        |                                                     | 1            |
