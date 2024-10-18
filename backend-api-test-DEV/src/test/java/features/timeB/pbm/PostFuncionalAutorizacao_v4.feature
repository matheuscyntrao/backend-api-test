#language: pt
@pbm-service
Funcionalidade: PbmService-v4-PostFuncionalAutorizacao

  Esquema do Cenario:  PbmService - v4 - PostFuncionalAutorizacao <fluxo>

    Dado possuo dados para PbmService - v4 - PostFuncionalAutorizacao:
      | nsuPreAutorizacao   | identificadorTransacao   |
      | <nsuPreAutorizacao> | <identificadorTransacao> |
    Quando executo PbmService - v4 - PostFuncionalAutorizacao
    Entao sistema processa PbmService - v4 - PostFuncionalAutorizacao:
      | statusCode | <statusCode> |
    
    @FB @regressao
    Exemplos:
      | fluxo | nsuPreAutorizacao | identificadorTransacao | statusCode |
      | FB    | 48046             | 20210118An0cxu00cj1i   | 200        |
