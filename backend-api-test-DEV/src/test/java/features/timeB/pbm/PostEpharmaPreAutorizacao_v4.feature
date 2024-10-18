#language: pt
@pbm-service
Funcionalidade: PbmService-v4-PostEpharmaPreAutorizacao

  Esquema do Cenario:  PbmService - v4 - PostEpharmaPreAutorizacao <fluxo>

    Dado possuo dados para PbmService - v4 - PostEpharmaPreAutorizacao:
      | canalVenda   | codigoFilial   | tipoPrograma   | usuario   | cnpjOrigem   | codigoPrograma   | cartaoBeneficiario   | cpfBeneficiario   |
      | <canalVenda> | <codigoFilial> | <tipoPrograma> | <usuario> | <cnpjOrigem> | <codigoPrograma> | <cartaoBeneficiario> | <cpfBeneficiario> |
    E possuo dados para PbmService - v4 - PostEpharmaPreAutorizacao item:
      | codigoItem   | ean   | quantidadeSolicitada   | precoBruto   | precoLiquido   |
      | <codigoItem> | <ean> | <quantidadeSolicitada> | <precoBruto> | <precoLiquido> |
    E possuo dados para PbmService - v4 - PostEpharmaPreAutorizacao receita:
      | codigoProfissional   | dataReceita   | tipoProfissional   | ufProfissional   |
      | <codigoProfissional> | <dataReceita> | <tipoProfissional> | <ufProfissional> |
    Quando executo PbmService - v4 - PostEpharmaPreAutorizacao
    Entao sistema processa PbmService - v4 - PostEpharmaPreAutorizacao:
      | statusCode | <statusCode> |

    @FB @regressao
    Exemplos:
      | fluxo | canalVenda | codigoFilial | tipoPrograma | usuario | cnpjOrigem     | codigoPrograma | cartaoBeneficiario | cpfBeneficiario | codigoItem | ean           | quantidadeSolicitada | precoBruto | precoLiquido | codigoProfissional | dataReceita | tipoProfissional | ufProfissional | statusCode |
      | FB    | 2          | 101          | C            | RGARCIA | 92665611013406 | 88             | 002870000060101019 | null            | 112455     | 7897705202425 | 1                    | 49.64      | 49.64        | 30828              | 15/10/2020  | CRM              | SP             | 200        |
