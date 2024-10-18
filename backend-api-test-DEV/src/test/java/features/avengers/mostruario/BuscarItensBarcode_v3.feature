#language: pt
@mostruario-service
Funcionalidade: Busca por código de barras - v3

  Esquema do Cenario: Busca de produtos por código de barras - v3 <fluxo>
    Dado possuo dados para Mostruario - v3 - GetBarcode path :
      | barcode | <barcode> |
    Dado possuo dados para Mostruario - v3 - GetBarcode param :
      | cep        | <cep>        |
      | quantidade | <quantidade> |
    Quando executo Mostruario - v3 - GetBarcode
    Entao sistema processa Mostruario - v3 - GetBarcode:
      | statusCode | <statusCode> |

    @FB @regressao
    Exemplos:
      | fluxo | barcode       | cep      | quantidade | statusCode |
      | FB    | 7791293032436 | 91110020 | 1          | 200        |
    @FE @regressao
    Exemplos:
      | fluxo                  | barcode       | cep      | quantidade | statusCode |
      | FE001 - sem barcode    |               | 91110020 | 3          | 400        |
      | FE002 - sem cep        | 7791293032436 |          | 3          | 400        |
      | FE003 - sem quantidade | 7791293032436 | 91110020 |            | 400        |


