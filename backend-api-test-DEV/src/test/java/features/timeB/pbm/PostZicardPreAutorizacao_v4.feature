#language: pt
@pbm-service
Funcionalidade: PbmService-v4-PostZicardPreAutorizacao

  Esquema do Cenario:  PbmService - v4 - PostZicardPreAutorizacao <fluxo>

    Dado possuo dados para PbmService - v4 - PostZicardPreAutorizacao:
      | canalVenda   | origemCanal   | codigoFilial   | tipoPrograma   | cnpjOrigem   | usuario   | nsuPreAutorizacao | cpfBeneficiario   | cpfAtendimento   | codigoPrograma   |
      | <canalVenda> | <origemCanal> | <codigoFilial> | <tipoPrograma> | <cnpjOrigem> | <usuario> | <cnpjOrigem>      | <cpfBeneficiario> | <cpfAtendimento> | <codigoPrograma> |
    E possuo dados para PbmService - v4 - PostZicardPreAutorizacao item:
      | codigoItem   | ean   | quantidadeSolicitada   | precoBruto   | precoLiquido   |
      | <codigoItem> | <ean> | <quantidadeSolicitada> | <precoBruto> | <precoLiquido> |
    Quando executo PbmService - v4 - PostZicardPreAutorizacao
    Entao sistema processa PbmService - v4 - PostZicardPreAutorizacao:
      | statusCode | <statusCode> |


    @FB @regressao
    Exemplos:
      | fluxo | canalVenda | origemCanal | codigoFilial | tipoPrograma | usuario | cnpjOrigem     | cpfBeneficiario | cpfAtendimento | codigoPrograma | codigoItem | ean           | quantidadeSolicitada | precoBruto | precoLiquido | statusCode |
      | FB    | 3          | 1           | 31           | I            | AUTHB2C | 92665611010130 | 04559791031     | 04559791031    | 113            | 116348     | 3337875617765 | 1                    | 89.99      | 89.99        | 200        |
