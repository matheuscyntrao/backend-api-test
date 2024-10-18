#language: pt
@marketplace @entrega
Funcionalidade: Entrega - v3 - Correios

  Esquema do Cenario: Entrega - v3 - Correios <fluxo>
    Dado possuo dados para Entrega - v3 - Correios:
      | cepOrigem   | cepEntrega   |
      | <cepOrigem> | <cepEntrega> |
    E possuo dados para Entrega - v3 - Correios itens:
      | codigo   | quantidade   | quantidadeEntregar   | isPack   |
      | <codigo> | <quantidade> | <quantidadeEntregar> | <isPack> |
    Quando executo Entrega - v3 - Correios
    Então sistema processa Entrega - v3 - Correios:
      | statusCode | <statusCode> |

    @FB @regressao
    Exemplos:
      | fluxo | statusCode | cepOrigem | cepEntrega | codigo | quantidade | quantidadeEntregar | isPack |
      | FB    | 200        | 91040360  | 92990000   | 17817  | 1          | 1                  | false  |

    @FA @regressao
    Exemplos:
      | fluxo | statusCode | cepOrigem | cepEntrega | codigo | quantidade | quantidadeEntregar | isPack |
      | FA    | 200        | 91040360  | 8451150    | 17817  | 1          | 1                  |        |

    @FE @regressao
    Exemplos:
      | fluxo | statusCode | cepOrigem | cepEntrega | codigo | quantidade | quantidadeEntregar | isPack |
      | FE    | 400        | 91040360  | 92990000   | 17817  |            | 1                  | false  |
      | FE    | 400        | 91040360  | 92990000   | 17817  | 1          |                    |        |
      | FE    | 400        |           | 92990000   | 17817  | 1          | 1                  | false  |
      | FE    | 400        | 91040360  |            | 17817  | 1          | 1                  | false  |