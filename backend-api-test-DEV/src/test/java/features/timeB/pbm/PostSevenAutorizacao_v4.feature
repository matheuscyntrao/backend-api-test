#language: pt
@pbm-service
Funcionalidade: PbmService-v4-PostSevenAutorizacao

  Esquema do Cenario:  PbmService - v4 - PostSevenAutorizacao <fluxo>

    Dado possuo dados para PbmService - v4 - PostSevenAutorizacao:
      | nsuPreAutorizacao   | identificadorTransacao   |
      | <nsuPreAutorizacao> | <identificadorTransacao> |
    Quando executo PbmService - v4 - PostSevenAutorizacao
    Entao sistema processa PbmService - v4 - PostSevenAutorizacao:
      | statusCode | <statusCode> |

    @FB @regressao
    Exemplos:
      | fluxo | nsuPreAutorizacao | identificadorTransacao | statusCode |
      | FB    | 0                 | 20210309An0ktY00clwA   | 200        |
