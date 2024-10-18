#language: pt
@puc-service
Funcionalidade: puc-service - v1 - GetClients

  Esquema do Cenario: Get Clients <fluxo>
    Dado possuo dados para clients - v1 - GetClients "<fluxo>"
    Quando executo GetClients - v1 - GetClients
    Entao sistema processa GetClients - v1 - GetClients:
      | statusCode | <statusCode> |
      | message    | <message>    |

    @FB @regressao
    Exemplos:
      | fluxo            | statusCode | message |
      | SUCESSO_CODE     | 200        |         |
      | SUCESSO_DOCUMENT | 200        |         |

    @FE @regressao
    Exemplos:
      | fluxo            | statusCode | message                                        |
      | CLIENTE_NULL     | 400        | Deve ser informado o cpf ou código do cliente. |
