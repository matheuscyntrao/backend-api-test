#language: pt
@pbm-service
Funcionalidade: PbmService-v4-PostZicardCancelamento

  Esquema do Cenario:  PbmService - v4 - PostZicardCancelamento <fluxo>

    Dado possuo dados para PbmService - v4 - PostZicardCancelamento:
      | nsuAutorizacao   | identificadorTransacao   |
      | <nsuAutorizacao> | <identificadorTransacao> |
    Quando executo PbmService - v4 - PostZicardCancelamento
    Entao sistema processa PbmService - v4 - PostZicardCancelamento:
      | statusCode | <statusCode> |

    @FB @regressao
    Exemplos:
      | fluxo | nsuAutorizacao | identificadorTransacao | statusCode |
      | FB    | 1015871        | 202101200e0Z6d00cj4O   | 204        |
