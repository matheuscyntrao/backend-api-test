#language: pt
@pbm-service
Funcionalidade: PbmService-v4-PostEpharmaCancelamento

  Esquema do Cenario:  PbmService - v4 - PostEpharmaCancelamento <fluxo>

    Dado possuo dados para PbmService - v4 - PostEpharmaCancelamento:
      | nsuAutorizacao   | identificadorTransacao   |
      | <nsuAutorizacao> | <identificadorTransacao> |
    Quando executo PbmService - v4 - PostEpharmaCancelamento
    Entao sistema processa PbmService - v4 - PostEpharmaCancelamento:
      | statusCode | <statusCode> |

    @FB @regressao
    Exemplos:
      | fluxo | nsuAutorizacao | identificadorTransacao | statusCode |
      | FB    | 1015857        | 202101200e0YtZ00cj4N   | 200        |
