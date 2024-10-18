#language: pt
@bank-account-service
Funcionalidade: BankAccountService - v1


  Esquema do Cenario:  BankAccountService - v1 <fluxo>
    Dado possuo dados para BankAccountService - v1 - GetTypeableline:
      | typeableline   |
      | <typeableline> |
    Quando executo BankAccountService - v1 - GetBill
    Entao sistema processa BankAccountService - v1 - GetBillStatus:
      | statusCode | <statusCode> |


    @FB @regressao
    Exemplos:
      | fluxo                      | typeableline                                    | statusCode |
      | FB - Deposito com valor 10 | 23793380296097817589569006333301586120000001000 | 200        |
      | FA - Erro                  | 2379338029609781758956900633330158612000000000  | 500        |


