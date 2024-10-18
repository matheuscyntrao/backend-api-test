#language: pt
@pbm-service
Funcionalidade: PbmService-v5-PostZicardConfirmacao

  Esquema do Cenario:  PbmService - v5 - PostZicardConfirmacao <fluxo>

    Dado possuo dados para PbmService - v5 - PostZicardConfirmacao:
      | cnpj   | estacao   | numeroCupom   |
      | <cnpj> | <estacao> | <numeroCupom> |
    E possuo dados para PbmService - v5 - PostZicardConfirmacao autorizacoes:
      | nsuAutorizacao   | identificadorTransacao   |
      | <nsuAutorizacao> | <identificadorTransacao> |
    E possuo dados para PbmService - v5 - PostZicardConfirmacao autorizacoes itens:
      | codigoItem   | valorDesconto   |
      | <codigoItem> | <valorDesconto> |
    Quando executo PbmService - v5 - PostZicardConfirmacao
    Entao sistema processa PbmService - v5 - PostZicardConfirmacao:
      | statusCode | <statusCode> |
      | message    | <message>    |


    @FB @regressao
    Exemplos:
      | fluxo | cnpj           | estacao | numeroCupom | nsuAutorizacao | identificadorTransacao | codigoItem | valorDesconto | statusCode | message |
      | FB    | 92665611010130 | tes123  | te123123    | 1016210        | 202101210e0ifX00cj7r   | 116348     | 89.99         | 200        |         |

    @FE @regressao
    Exemplos:
      | fluxo | cnpj           | estacao | numeroCupom | nsuAutorizacao | identificadorTransacao | codigoItem | valorDesconto | statusCode | message                                                         |
      | FE    | 92665611013406 | teste   | 81243       | 568324         | 20210114An0irT00cjxm   | 116348     | 89.99         | 400        | Erro ao consultar serviço da Zicard: S2 - Transação Indefinida. |
