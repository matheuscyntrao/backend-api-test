#language: pt
@shipping-service
Funcionalidade: ShippingService-v1-PostDeliveries
  Definicao da funcionalidade
  http://gitlab.dimed.com.br/varejo/analistas/user-stories/-/issues/33

  Esquema do Cenario: ShippingService-v1-PostDeliveries bloqueio - <fluxo>

    Dado que possuo dados para ShippingService - v1 - PostDeliveries:
      | date   | operator | origin |
      | <date> | 123456   | SITE   |
    E possuo dados para ShippingService - v1 - PostDeliveries address:
      | number | placeCode | zipCode   |
      | null   | null      | <zipCode> |
    E possuo dados para ShippingService - v1 - PostDeliveries customer:
      | code   | covenant |
      | 123456 | 132456   |
    E possuo dados para ShippingService - v1 - PostDeliveries items:
      | codeEnum   | deliver |
      | <codeEnum> | true    |
    E  possuo dados para ShippingService - v1 - PostDeliveries items groupers:
      | code   | type |
      | 123456 | PACK |
    Quando executo PostDeliveries - v1 - PostDeliveries
    Entao sistema processa PostDeliveries - v1 - PostDeliveries:
      | statusCode | <statusCode> |
    E valido PostDeliveries bloqueio - v1 - PostDeliveries "<validacaoNaoDeveRetornar>"

    @FB @regressao
    Exemplos:
      | fluxo                                       | date | zipCode                        | codeEnum    | statusCode | validacaoNaoDeveRetornar |
      | CENARIO 01 - BLOQUEIO_LOCALIDADE_RAPIDA     | 2    | BLOQUEIO_LOCALIDADE_RAPIDA     | COM_ESTOQUE | 200        | RAPIDA-MOTOBOY           |
      | CENARIO 02 - BLOQUEIO_LOCALIDADE_PROGRAMADA | 2    | BLOQUEIO_LOCALIDADE_PROGRAMADA | COM_ESTOQUE | 200        | PROGRAMADA-MOTOBOY       |
      | CENARIO 03 - BLOQUEIO_BAIRRO_RAPIDA         | 2    | BLOQUEIO_BAIRRO_RAPIDA         | COM_ESTOQUE | 200        | PROGRAMADA-MOTOBOY       |
      | CENARIO 04 - BLOQUEIO_BAIRRO_PROGRAMADA     | 2    | BLOQUEIO_BAIRRO_PROGRAMADA     | COM_ESTOQUE | 200        | PROGRAMADA-MOTOBOY       |
      | CENARIO 05 - BLOQUEIO_LOGRADOURO_RAPIDA     | 2    | BLOQUEIO_LOGRADOURO_RAPIDA     | COM_ESTOQUE | 200        | RAPIDA-MOTOBOY           |
      | CENARIO 06 - BLOQUEIO_LOGRADOURO_PROGRAMADA | 2    | BLOQUEIO_LOGRADOURO_PROGRAMADA | COM_ESTOQUE | 200        | PROGRAMADA-MOTOBOY       |
      | CENARIO 07 - BLOQUEIO_CEP_RAPIDA            | 2    | BLOQUEIO_CEP_RAPIDA            | COM_ESTOQUE | 200        | RAPIDA-MOTOBOY           |
      | CENARIO 08 - BLOQUEIO_CEP_PROGRAMADA        | 2    | BLOQUEIO_CEP_PROGRAMADA        | COM_ESTOQUE | 200        | PROGRAMADA-MOTOBOY       |

  Esquema do Cenario: ShippingService-v1-PostDeliveries alteracao - <fluxo>

    Dado que possuo dados para ShippingService - v1 - PostDeliveries:
      | date   | operator | origin |
      | <date> | 123456   | SITE   |
    E possuo dados para ShippingService - v1 - PostDeliveries address:
      | number | placeCode | zipCode   |
      | null   | null      | <zipCode> |
    E possuo dados para ShippingService - v1 - PostDeliveries customer:
      | code   | covenant |
      | 123456 | 132456   |
    E possuo dados para ShippingService - v1 - PostDeliveries items:
      | codeEnum   | deliver |
      | <codeEnum> | true    |
    E  possuo dados para ShippingService - v1 - PostDeliveries items groupers:
      | code   | type |
      | 123456 | PACK |
    Quando executo PostDeliveries - v1 - PostDeliveries
    Entao sistema processa PostDeliveries - v1 - PostDeliveries:
      | statusCode | <statusCode> |
    E valido ShippingService - v1 - regra para isentar entrega
    E valido ShippingService - v1 - regra de prazo de entrega
    E valido ShippingService - v1 - regra taxa de entrega

    @FB @regressao
    Exemplos:
      | fluxo                                                | date | zipCode                         | codeEnum    | statusCode |
      | CENARIO 09 - ALTERACAO_ENTREGA_RAPIDA_LOCALIDADE     | 2    | ALTERACAO_RAPIDA_LOCALIDADE     | COM_ESTOQUE | 200        |
      | CENARIO 10 - ALTERACAO_ENTREGA_RAPIDA_BAIRRO         | 2    | ALTERACAO_RAPIDA_BAIRRO         | COM_ESTOQUE | 200        |
      | CENARIO 11 - ALTERACAO_ENTREGA_RAPIDA_LOGRADOURO     | 2    | ALTERACAO_RAPIDA_LOGRADOURO     | COM_ESTOQUE | 200        |
      | CENARIO 12 - ALTERACAO_ENTREGA_RAPIDA_CEP            | 2    | ALTERACAO_RAPIDA_CEP            | COM_ESTOQUE | 200        |
      | CENARIO 13 - ALTERACAO_ENTREGA_PROGRAMADA_LOCALIDADE | 2    | ALTERACAO_PROGRAMADA_LOCALIDADE | COM_ESTOQUE | 200        |
      | CENARIO 14 - ALTERACAO_ENTREGA_PROGRAMADA_BAIRRO     | 2    | ALTERACAO_PROGRAMADA_BAIRRO     | COM_ESTOQUE | 200        |
      | CENARIO 15 - ALTERACAO_ENTREGA_PROGRAMADA_LOGRADOURO | 2    | ALTERACAO_PROGRAMADA_LOGRADOURO | COM_ESTOQUE | 200        |
      | CENARIO 16 - ALTERACAO_ENTREGA_PROGRAMADA_CEP        | 2    | ALTERACAO_PROGRAMADA_CEP        | COM_ESTOQUE | 200        |
