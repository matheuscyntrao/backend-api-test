#language: pt
@ifood @ifood-token
Funcionalidade: Ifood - v1 - Bearer Token Validation

  Esquema do Cenario: Ifood - v1 - Bearer Token Validation

    Dado que efetuo Ifood - v1 - Bearer Token Validation "<fluxo>"
    Quando executo Ifood - v1 - Bearer Token Validation
    E sistema processa Ifood - v1 - Bearer Token Validation
      | statusCode | <statusCode> |
    E valido Ifood - v1 - Bearer Token Validation
      | message | <message> |
    @FB @regressao
    Exemplos:
      | fluxo             | statusCode | message |
      | FB - VALIDA_TOKEN | 200        |         |

    @FE @regressao
    Exemplos:
      | fluxo                          | statusCode | message                                                    |
      | FE001 - CLIENT_SECRET_INVALIDO |            | Invalid client secret is provided                          |
      | FE002 - CLIENT_ID_INVALIDO     |            | Não identificamos nenhum usuário vinculado com o client_id |
