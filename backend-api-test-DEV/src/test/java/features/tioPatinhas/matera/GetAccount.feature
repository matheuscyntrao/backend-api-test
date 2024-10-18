#language: pt
@bank-account-service
Funcionalidade: Matera - v1 - GetAccount

  Esquema do Cenario:  Matera - v1 - Account -  <fluxo>
    Dado possuo dados para Matera - v1 - GetAccount path:
      | accountId | <accountId> |
    Quando executo Matera - v1 - GetAccount
    Entao sistema processa Matera - v1 - GetAccount:
      | statusCode | <statusCode> |
      | message    | <message>    |

    @FB @regressao
    Exemplos:
      | fluxo                  | accountId                            | statusCode | message |
      | FB - Cadastro de Conta | 07B2B6CE-B38A-343C-D8FC-66CABDFEAAEA | 200        |         |




  Cenario:  Matera - v1 - Account Conta
    Dado efetuo Matera - v1 - GetAccount "07B2B6CE-B38A-343C-D8FC-66CABDFEAAEA"