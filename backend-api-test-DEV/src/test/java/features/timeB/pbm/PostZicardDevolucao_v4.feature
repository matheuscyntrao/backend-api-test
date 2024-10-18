#language: pt
@pbm-service
Funcionalidade: PbmService-v4-PostZicardDevolucao

  Esquema do Cenario:  PbmService - v4 - PostZicardDevolucao <fluxo>

    Dado possuo dados para PbmService - v4 - PostZicardDevolucao:
      | nsuConfirmacao   | identificadorTransacao   | cpfResponsavel   | cnpjEstabelecimento   | estacao   |
      | <nsuConfirmacao> | <identificadorTransacao> | <cpfResponsavel> | <cnpjEstabelecimento> | <estacao> |
    E possuo dados para PbmService - v4 - PostZicardDevolucao itens:
      | ean   | quantidadeCancelar   |
      | <ean> | <quantidadeCancelar> |
    Quando executo PbmService - v4 - PostZicardDevolucao
    Entao sistema processa PbmService - v4 - PostZicardDevolucao:
      | statusCode | <statusCode> |
      | message    | <message>    |

    @FE @regressao
    Exemplos:
      | fluxo | nsuConfirmacao | identificadorTransacao | cpfResponsavel | cnpjEstabelecimento | estacao | ean           | quantidadeCancelar | statusCode | message                                         |
      | FE    | 1016027        | 202101200e0jeD00cj5T   | 02807802060    | 92665611010130      | teste   | 3337875617765 | 1                  | 400        | Identificador 202101200e0jeD00cj5T já cancelado |
