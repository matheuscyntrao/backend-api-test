#language: pt
@shipping-service
Funcionalidade: ShippingService-v1-PostDeliveries
  Definicao da funcionalidade
  http://gitlab.dimed.com.br/varejo/analistas/user-stories/-/issues/41s

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
      | issue      | <issue>      |
    E valido PostDeliveries - v1 - PostDeliveries "<method-type>"
    @FB @regressao
    Exemplos:
      | fluxo                   | date | zipCode    | codeEnum    | statusCode | method-type         | issue |
      | CENARIO 01 - RAPIDA     | 2    | RAPIDA     | COM_ESTOQUE | 200        | RAPIDA-MOTOBOY      |       |
      | CENARIO 05 - PROGRAMADA | 2    | PROGRAMADA | COM_ESTOQUE | 200        | PROGRAMADA-MOTOBOY  |       |
      | CENARIO 06 - CORREIOS   | 2    | CORREIOS   | COM_ESTOQUE | 200        | PAC-PAC,SEDEX-SEDEX |       |
    @FE @regressao
    Exemplos:
      | fluxo                                       | date | zipCode  | codeEnum    | statusCode | method-type                       | issue                                                |
      | FE001 - DATA NAO PODE SER MENOR QUE A ATUAL | -1   | 91050001 | COM_ESTOQUE | 400        | PROGRAMADA-MOTOBOY,RAPIDA-MOTOBOY | Data informada não pode ser menor que a atual        |
      | FE002 - CEP NAO ENCONTRADO                  | 5    | 0        | COM_ESTOQUE | 404        | PROGRAMADA-MOTOBOY,RAPIDA-MOTOBOY | Cep não foi encontrado                               |
      | FE003 - CAMPO CODITEM OBRIGATORIO           | 5    | 91050001 | ITEM_NULL   | 400        | PROGRAMADA-MOTOBOY,RAPIDA-MOTOBOY | O valor "null" é inválido para o campo items[0].code |

  Esquema do Cenario: ShippingService-v1-PostDeliveries - <fluxo> filialDoCep
    Dado que possuo dados para ShippingService - v1 - PostDeliveries valido
    E possuo dados para ShippingService - v1 - PostDeliveries address:
      | number   | placeCode   | zipCode   |
      | <number> | <placeCode> | <zipCode> |
    Quando executo PostDeliveries - v1 - PostDeliveries
    Entao sistema processa PostDeliveries - v1 - PostDeliveries:
      | statusCode | <statusCode> |
      | issue      | <issue>      |
    E valido PostDeliveries - v1 - PostDeliveries filial do cep
    @FB @regressao
    Exemplos:
      | fluxo                       | number | placeCode | zipCode  | statusCode | issue |
      | CENARIO 001 - FILIAL DO CEP | null   | null      | 35260000 | 200        |       |
    @FE @regressao
    Exemplos:
      | fluxo                      | number | placeCode | zipCode  | statusCode | issue                                                  |
      | FE001 - CEP NAO ENCONTRADO | null   | null      | 00000000 | 404        | Cep não foi encontrado                                 |
      | FE002 - CAMPO NULL         | null   | null      | null     | 400        | O valor "null" é inválido para o campo address.zipCode |

    @FA @regressao
    Exemplos:
      | fluxo                    | number | placeCode | zipCode  | statusCode | issue |
      | FA001 - PLACECODE NULL   | 123    | null      | 90680050 | 200        |       |
      | FA002 - NUMBER NULL      | null   | 123       | 90680050 | 200        |       |
      | FA003 - NUMBER EM BRANCO |        | 123       | 90680050 | 200        |       |
      | FA004 - NUMBER NULL      | null   |           | 90680050 | 200        |       |

  Esquema do Cenario: ShippingService-v1-PostDeliveries - <fluxo> <zipCode>
    Dado que possuo dados para ShippingService - v1 - PostDeliveries valido
    E possuo dados para ShippingService - v1 - PostDeliveries address:
      | number   | placeCode   | zipCode   |
      | <number> | <placeCode> | <zipCode> |
    Quando executo PostDeliveries - v1 - PostDeliveries
    Entao sistema processa PostDeliveries - v1 - PostDeliveries:
      | statusCode | <statusCode> |
    E valido PostDeliveries - v1 - PostDeliveries filial de "<zipCode>" do cep
    @FB @regressao
    Exemplos:
      | fluxo                               | number | placeCode | zipCode        | statusCode |
      | CENARIO 002 - FILIAL CONTINGENCIA   | null   | null      | CONTINGENCIA   | 200        |
      | CENARIO 003 - FILIAL CENTRALIZADORA | null   | null      | CENTRALIZADORA | 200        |

  Esquema do Cenario: ShippingService-v1-PostDeliveries - items groupers
    Dado que possuo dados para ShippingService - v1 - PostDeliveries valido
    E  possuo dados para ShippingService - v1 - PostDeliveries items groupers:
      | code   | type   |
      | <code> | <type> |
    Quando executo PostDeliveries - v1 - PostDeliveries
    Entao sistema processa PostDeliveries - v1 - PostDeliveries:
      | statusCode | <statusCode> |
      | issue      | <issue>      |
      | id         | <id>         |
      | message    | <message>    |

    @FB @regressao
    Exemplos:
      | code   | type  | statusCode | issue                                                           | id                  | message                                 |
      | 123456 | TESTE | 400        |                                                                 |                     | O corpo da requisição não pôde ser lido |
      |        | PACK  | 400        | O valor "null" é inválido para o campo items[0].groupers[].code | INVALID_FIELD_VALUE | grouper code is required                |
      | 123456 |       | 400        | O valor "null" é inválido para o campo items[0].groupers[].type | INVALID_FIELD_VALUE | grouper type is required                |
      | null   | PACK  | 400        | O valor "null" é inválido para o campo items[0].groupers[].code | INVALID_FIELD_VALUE | grouper code is required                |
      | 123456 | null  | 400        | O valor "null" é inválido para o campo items[0].groupers[].type | INVALID_FIELD_VALUE | grouper type is required                |
