#language: pt
@omnialo-backend
Funcionalidade: OmniAlo-v1-GetAutenticacao


  Esquema do Cenario: OmniAlo-v1-GetAutenticacao - <fluxo>
    Dado efetuo OmniAlo - v1 - PostAutenticacao "<usuario>":
    Quando efetuo OmniAlo - v1 - GetAutenticacao
    Entao  sistema processa OmniAlo - v1 - GetAutenticacao:
      | statusCode | <statusCode> |

    Exemplos:
      | fluxo | usuario           | statusCode |
      | FB    | USUARIO_VALIDO    | 200        |
