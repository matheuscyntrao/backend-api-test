#language: pt
@pbm-service
Funcionalidade: Pbm - v4 - Seven - PreAutorizacao POST

  Esquema do Cenario: Pbm - v4 - Seven - PreAutorizacao POST <fluxo>
    Dado possuo dados para Pbm - v4 - SevenPreAutorizacao:
      | canalVenda   | tipoPrograma   | usuario   | codigoFilial   | cnpjOrigem   | cpfBeneficiario   | cpfAtendimento   | codigoPrograma   |
      | <canalVenda> | <tipoPrograma> | <usuario> | <codigoFilial> | <cnpjOrigem> | <cpfBeneficiario> | <cpfAtendimento> | <codigoPrograma> |
    E possuo dados para Pbm - v4 - SevenPreAutorizacao itens:
      | codigoItem | ean           | quantidadeSolicitada | precoBruto | precoLiquido | respostaOperador |
      | 880550     | 7896658030451 | 1                    | 61.99      | 61.99        |                  |
    Quando executo Pbm - v4 - SevenPreAutorizacao
    Entao sistema processa Pbm - v4 - SevenPreAutorizacao:
      | statusCode | <statusCode> |
      | field      | <field>      |
      | message    | <message>    |

    @FB @regressao
    Exemplos:
      | fluxo | canalVenda | tipoPrograma | usuario | codigoFilial | cnpjOrigem     | cpfBeneficiario | cpfAtendimento | codigoPrograma | statusCode | field | message |
      | FB    | 2          | I            | RGARCIA | 701          | 92665611019277 | 02344745050     | 02344745050    | 117            | 200        |       |         |
