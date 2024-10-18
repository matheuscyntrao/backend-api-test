#language: pt
@puc-service
Funcionalidade: puc-service - v1 - GetWalletsItemsValidation

  Esquema do Cenario: Get Wallets Items Validation <fluxo>
    Dado possuo dados para ItemsValidation - v1 - GetWalletsItemsValidation "<fluxo>"
    Quando executo ItemsValidation - v1 - GetWalletsItemsValidation
    Entao sistema processa ItemsValidation - v1 - GetWalletsItemsValidation:
      | statusCode | <statusCode> |
      | message    | <message>    |

    @FB @regressao
    Exemplos:
      | fluxo   | statusCode | message |
      | SUCESSO | 204        |         |

    @FE @regressao
    Exemplos:
      | fluxo                     | statusCode | message                                                                     |
      | PREENCHER_TODOS_CAMPOS    | 400        | É obrigatório o uso de apenas um dos dois parametros: document - clientCode |
      | CAMPO_CLIENTE_OBRIGATORIO | 400        | É obrigatório o uso de apenas um dos dois parametros: document - clientCode |
      | CAMPO_ITEM_OBRIGATORIO    | 400        | itemCode não deve estar nulo.                                                            |
      | TODOS_CAMPOS_NULL         | 400        | itemCode não deve estar nulo.                                                            |
      | ITEM_INVALIDO             | 412        | O item não está ativo                                                       |

