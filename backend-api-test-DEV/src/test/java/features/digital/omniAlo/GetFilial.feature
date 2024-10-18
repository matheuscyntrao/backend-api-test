#language: pt
@omnialo-backend
Funcionalidade: OmniAlo-v1-GetFilial


  Esquema do Cenario: OmniAlo-v1-GetFilial - <fluxo>
    Dado que possuo dados para OmniAlo - v1 - GetFilial path:
      | filial | <filial> |
    Quando executo OmniAlo - v1 - GetFilial
    Entao  sistema processa OmniAlo - v1 - GetFilial:
      | statusCode | <statusCode> |
      | message    | <message>    |

  @FB @regressao
    Exemplos:
      | fluxo | filial | statusCode | message                |
      | FB    | 31     | 200        |                        |
  @FE @regressao
    Exemplos:
      | fluxo | filial | statusCode | message                |
      | FE    | 0      | 404        | Filial não encontrada. |

