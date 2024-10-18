#language: pt
@bank-account-service
Funcionalidade: BankAccountService - v1

  Esquema do Cenario:  BankAccountService - v1 <fluxo>
    Dado possuo dados para BankAccountService - v1 - CPFBalanceUnlock:
      | document   | transactionId   |
      | <document> | <transactionId> |
    E possuo dados para BankAccountService - v1 - TokenBalanceUnlock
    Quando executo BankAccountService - v1 - PutBalanceUnlock
    Entao sistema processa BankAccountService - v1 - UpdateStatusUnlock:
      | statusCode | <statusCode> |
      | message    | <message>    |

    @FB @regressao
    Exemplos:
      | fluxo                                 | document    | transactionId                        | statusCode | message                                             |
      | FB - Desbloqueio de saldo com sucesso | 42555442049 | 77EC2328-1347-6CF0-DE41-8673AC8F8464 | 204        |                                                     |
      | FA - TransacctionId nulo              | 15728537006 |                                      | 400        | O transationId é obrigatório                        |
      | FA - CPF não Cadastrado               | 15728537006 | 10                                   | 404        | Não existe uma conta cadastrada com o cpf informado |
