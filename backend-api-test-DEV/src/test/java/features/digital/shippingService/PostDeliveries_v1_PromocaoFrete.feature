#language: pt
@shipping-service
Funcionalidade: ShippingService-v1-PostDeliveries
  Definicao da funcionalidade
  http://gitlab.dimed.com.br/varejo/analistas/user-stories/-/issues/193

  Esquema do Cenario: ShippingService-v1-PostDeliveries - <fluxo>

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

    @FB @regressao
    Exemplos:
      | fluxo                                   | date | zipCode    | codeEnum                | statusCode |
      | 01 - FRETE_GRATIS_RAPIDA                | 2    | RAPIDA     | FRETE_GRATIS_RAPIDA     | 200        |
      | 02 - FRETE_GRATIS_RAPIDA_CEP_PROGRAMADA | 2    | PROGRAMADA | FRETE_GRATIS_RAPIDA     | 200        |
      | 03 - FRETE_GRATIS_CORREIO               | 2    | CORREIOS   | FRETE_GRATIS_RAPIDA     | 200        |
      | 04 - FRETE_GRATIS_PROGRAMADA            | 2    | PROGRAMADA | FRETE_GRATIS_PROGRAMADA | 200        |
      | 05 - FRETE_GRATIS_PROGRAMADA_CEP_RAPIDA | 2    | RAPIDA     | FRETE_GRATIS_PROGRAMADA | 200        |
      | 06 - FRETE_GRATIS_CORREIO               | 2    | CORREIOS   | FRETE_GRATIS_PROGRAMADA | 200        |

