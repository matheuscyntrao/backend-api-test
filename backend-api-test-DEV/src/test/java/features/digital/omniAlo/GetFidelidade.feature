#language: pt
@omnialo-backend
Funcionalidade: OmniAlo-v1-GetFidelidade


  Esquema do Cenario: OmniAlo-v1-GetFidelidade - <fluxo>
    Dado que possuo dados para OmniAlo - v1 - GetFidelidade path:
      | documento | <documento> |
    Dado que possuo dados para OmniAlo - v1 - GetFidelidade param:
      | tipo | <tipo> |
    Quando executo OmniAlo - v1 - GetFidelidade
    Entao  sistema processa OmniAlo - v1 - GetFidelidade:
      | statusCode     | <statusCode>   |
      | messengerError | <mensageError> |
  @FB @regressao
    Exemplos:
      | fluxo | documento        | tipo | statusCode | mensageError                                         |
      | FB    | 02807802060      | 2    | 200        |                                                      |
  @FA @regressao
    Exemplos:
      | fluxo | documento        | tipo | statusCode | mensageError                                         |
      | FA    | 6037230038276298 | 1    | 200        |                                                      |
  @FE @regressao
    Exemplos:
      | fluxo | documento        | tipo | statusCode | mensageError                                         |
      | FB    | 00415559022      | 2    | 200        |                                                      |
      | FB    | 00415559022      | 1    | 500        |                                                      |
      | FA    | 6037230038276298 | 2    | 200        | Não foi possível validar o Fidelidade para este CPF! |



