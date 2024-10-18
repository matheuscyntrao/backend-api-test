#language: pt
@omnialo-backend
Funcionalidade: OmniAlo-v1-GetExtrato


  Esquema do Cenario: OmniAlo-v1-GetExtrato - <fluxo>
    Dado que possuo dados para OmniAlo - v1 - GetExtrato path:
      | cpf | <cpf> |
    Quando executo OmniAlo - v1 - GetExtrato
    Entao  sistema processa OmniAlo - v1 - GetExtrato:
      | statusCode | <statusCode> |

    @FB @regressao
    Exemplos:
      | fluxo | cpf         | statusCode |
      | FB    | 02807802060 | 200        |
      | FE    |             | 404        |


