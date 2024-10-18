#language: pt
@omnialo-backend
Funcionalidade: OmniAlo-v1-GetPagamentoPosFilial


  Esquema do Cenario: OmniAlo-v1-GetPagamentoPosFilial - <fluxo>
    Dado que possuo dados para OmniAlo - v1 - GetPagamentoPosFilial path:
      | filial | <filial> |
    Quando executo OmniAlo - v1 - GetPagamentoPosFilial
    Entao  sistema processa OmniAlo - v1 - GetPagamentoPosFilial:
      | statusCode       | <statusCode>       |
      | developerMessage | <developerMessage> |

  @FB @regressao
    Exemplos:
      | fluxo | filial | statusCode | developerMessage                 |
      | FB    | 31     | 200        |                                  |
  @FE @regressao
    Exemplos:
      | fluxo | filial | statusCode | developerMessage                 |
      | FE    | 0      | 400        | Esta Filial não Possui venda POS |

