#language: pt
@omnialo-backend
Funcionalidade: OmniAlo-v1-GetAutenticacaoUsuario


  Esquema do Cenario: OmniAlo-v1-GetFilial - <fluxo>
    Dado que possuo dados para OmniAlo - v1 - GetAutenticacaoUsuario path:
      | codigoUsuario | <codigoUsuario> |
    Quando executo OmniAlo - v1 - GetAutenticacaoUsuario
    Entao  sistema processa OmniAlo - v1 - GetAutenticacaoUsuario:
      | statusCode | <statusCode> |
      | message    | <message>    |

  @FB @regressao
    Exemplos:
      | fluxo | codigoUsuario | statusCode | message |
      | FB    | 3700          | 200        |         |
  @FE @regressao
    Exemplos:
      | fluxo | codigoUsuario | statusCode | message               |
      | FE    | 0             | 401        | Credenciais inválidas |

