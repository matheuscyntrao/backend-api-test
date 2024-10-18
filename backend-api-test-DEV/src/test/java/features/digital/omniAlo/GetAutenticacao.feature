#language: pt
@omnialo-backend
Funcionalidade: OmniAlo-v1-GetAutenticacao


  Esquema do Cenario: OmniAlo-v1-GetAutenticacao - <fluxo>
    Dado que possuo dados para OmniAlo - v1 - GetAutenticacao header:
      | token | <token> |
    Quando executo OmniAlo - v1 - GetAutenticacao
    Entao  sistema processa OmniAlo - v1 - GetAutenticacao:
      | statusCode | <statusCode> |
      | message    | <message>    |

  @FB @regressao
    Exemplos:
      | fluxo | token                                                                                                                                                                    | statusCode | message |
      | FB    | eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFM1MTIifQ.eyJzdWIiOiIzNzAwIiwiZXhwIjoxNjE2NDMxNzc5fQ.1kQB1cStXzaLhCMXCqr-hAp4SEV_CZQZgCYL2BhHAn8zjprW6kUetodzkSJCltuEhHV-8-dyjlNlpruqkGMBOQ | 200        |         |
  @FE @regressao
    Exemplos:
      | fluxo | token    | statusCode | message                                 |
      | FE    | invalido | 500        | Ocorreu um erro inesperado na aplicação |
