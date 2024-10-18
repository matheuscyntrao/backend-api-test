#language: pt
@omnialo-backend
Funcionalidade: OmniAlo-v1-PostAutenticacao


  Esquema do Cenario: OmniAlo-v1-PostAutenticacao - <fluxo>
    Dado que possuo dados para OmniAlo - v1 - PostAutenticacao:
      | username   | password   |
      | <username> | <password> |
    Quando executo OmniAlo - v1 - PostAutenticacao
    Entao  sistema processa OmniAlo - v1 - PostAutenticacao:
      | statusCode | <statusCode> |
      | message    | <message>    |

  @FB @regressao
    Exemplos:
      | fluxo | username | password | statusCode | message |
      | FB    | rgarcia  | teste123 | 200        |         |
  @FE @regressao
    Exemplos:
      | fluxo | username | password | statusCode | message               |
      | FE    |          | teste123 | 401        | Credenciais inválidas |
      | FE    | rgarcia  |          | 401        | Credenciais inválidas |
