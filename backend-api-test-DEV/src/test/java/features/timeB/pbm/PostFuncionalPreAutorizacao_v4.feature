#language: pt
@pbm-service
Funcionalidade: PbmService-v4-PostFuncionalPreAutorizacao

  Esquema do Cenario:  PbmService - v4 - PostFuncionalPreAutorizacao <fluxo>

    Dado possuo dados para PbmService - v4 - PostFuncionalPreAutorizacao:
      | numeroSessao   | estacao   | canalVenda   | origemCanal   | codigoFilial   | tipoPrograma   | usuario   | nsuPreAutorizacao   | identificadorTransacao   | cnpjOrigem   | cpfBeneficiario   | cpfAtendimento   | cartaoBeneficiario   | codigoPrograma   | sequenciaPrograma   |
      | <numeroSessao> | <estacao> | <canalVenda> | <origemCanal> | <codigoFilial> | <tipoPrograma> | <usuario> | <nsuPreAutorizacao> | <identificadorTransacao> | <cnpjOrigem> | <cpfBeneficiario> | <cpfAtendimento> | <cartaoBeneficiario> | <codigoPrograma> | <sequenciaPrograma> |
    E possuo dados para PbmService - v4 - PostFuncionalPreAutorizacao item:
      | codigoItem   | ean   | quantidadeSolicitada   | precoBruto   | precoLiquido   | respostaOperador   |
      | <codigoItem> | <ean> | <quantidadeSolicitada> | <precoBruto> | <precoLiquido> | <respostaOperador> |
    Quando executo PbmService - v4 - PostFuncionalPreAutorizacao
    Entao sistema processa PbmService - v4 - PostFuncionalPreAutorizacao:
      | statusCode   | <statusCode> |


    @FB @regressao
    Exemplos:
      | fluxo | numeroSessao | estacao | canalVenda | origemCanal | codigoFilial | tipoPrograma | usuario               | nsuPreAutorizacao | identificadorTransacao | cnpjOrigem     | cpfBeneficiario | cpfAtendimento | cartaoBeneficiario | codigoPrograma | sequenciaPrograma | codigoItem | ean           | quantidadeSolicitada | precoBruto | precoLiquido | respostaOperador |statusCode|
      | FB    | null         | null    | 2          | null        | 101          | I            | TESTE PRE AUTORIZACAO | null              | null                   | 92665611013406 | 02807802060     | null           | 02807802060        | 107            | null              | 501640     | 7896015518875 | 1                    | 56.54      | 56.54        | null             |200       |
      | FB    | null         | null    | 3          | null        | 101          | I            | TESTE PRE AUTORIZACAO | null              | null                   | 92665611013406 | 02807802060     | null           | 02807802060        | 107            | null              | 501640     | 7896015518875 | 1                    | 56.54      | 56.54        | null             |200       |
