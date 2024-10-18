#language: pt
@pbm-service
Funcionalidade: PbmService-v4-PostZicardAutorizacao

  Esquema do Cenario:  PbmService - v4 - PostZicardAutorizacao <fluxo>

    Dado possuo dados para PbmService - v4 - PostZicardAutorizacao:
      | nsuPreAutorizacao   | identificadorTransacao   |
      | <nsuPreAutorizacao> | <identificadorTransacao> |
    Quando executo PbmService - v4 - PostZicardAutorizacao
    Entao sistema processa PbmService - v4 - PostZicardAutorizacao:
      | statusCode | <statusCode> |

    @FB @regressao
    Exemplos:
      | fluxo | nsuPreAutorizacao | identificadorTransacao | statusCode |
      | FB    | 1016210           | 202101210e0ifX00cj7r   | 200        |
