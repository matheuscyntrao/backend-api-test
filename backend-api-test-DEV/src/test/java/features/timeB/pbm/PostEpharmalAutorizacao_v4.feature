#language: pt
@pbm-service
Funcionalidade: PbmService-v4-PostEpharmaAutorizacao

  Esquema do Cenario:  PbmService - v4 - PostEpharmaAutorizacao <fluxo>

    Dado possuo dados para PbmService - v4 - PostEpharmaAutorizacao:
      | nsuPreAutorizacao   | identificadorTransacao   |
      | <nsuPreAutorizacao> | <identificadorTransacao> |
    Quando executo PbmService - v4 - PostEpharmaAutorizacao
    Entao sistema processa PbmService - v4 - PostEpharmaAutorizacao:
      | statusCode | <statusCode> |

    @FB @regressao
    Exemplos:
      | fluxo | nsuPreAutorizacao | identificadorTransacao | statusCode |
      | FB    | 000032402345      | 20210225An0TMt00clPJ   | 200        |
