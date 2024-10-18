#language: pt
@pbm-service
Funcionalidade: PbmService-v4-PostFuncionalCancelamento

  Esquema do Cenario:  PbmService - v4 - PostFuncionalCancelamento <fluxo>

    Dado possuo dados para PbmService - v4 - PostFuncionalCancelamento:
      | nsuAutorizacao   | identificadorTransacao   |
      | <nsuAutorizacao> | <identificadorTransacao> |
    Quando executo PbmService - v4 - PostFuncionalCancelamento
    Entao sistema processa PbmService - v4 - PostFuncionalCancelamento:
      | statusCode | <statusCode> |

    @FB @regressao
    Exemplos:
      | fluxo | nsuAutorizacao | identificadorTransacao | statusCode |
      | FB    | 1015857        | 202101200e0YtZ00cj4N   | 200        |
