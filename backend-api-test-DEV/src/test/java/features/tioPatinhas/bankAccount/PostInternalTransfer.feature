#language: pt
@bank-account-service
Funcionalidade: BankAccountService - v1


  Esquema do Cenario:  BankAccountService - v1 <fluxo>
    Dado possuo dados para BankAccountService - v1 - BuscaCPFTransferBankAccount:
      | receiverDocument   | senderDocument   | ammount   |
      | <receiverDocument> | <senderDocument> | <ammount> |
    E possuo dados para BankAccountService - v1 - GeraTokenTransfer
    Quando executo BankAccountService - v1 - PostInternalTransfer <saveBalance>
    Entao sistema processa BankAccountService - v1 - TransferStatus:
      | statusCode | <statusCode> |
      | message    | <message>    |
    E valido BankAccountService - v1 - ValidaTransfer

    @FB @regressao
    Exemplos:
      | fluxo                         | ammount | receiverDocument | senderDocument | statusCode | message                                             | saveBalance |
      | FB - Tranferência com sucesso | 10      | 04343807924      | 09577093906    | 204        |                                                     | 1           |
      | FA - Valor menor/igual a zero | 0       | 04343807924      | 09577093906    | 400        | Informe um valor maior que 0                        | 0           |
      | FA - Cliente não existe       | 10      | 02903163081      | 09577093906    | 404        | Não existe uma conta cadastrada com o cpf informado | 0           |
      | FA - Saldo insuficiente       | 10      | 04343807924      | 02811055029    | 500        | Insufficient funds                                  | 0           |
