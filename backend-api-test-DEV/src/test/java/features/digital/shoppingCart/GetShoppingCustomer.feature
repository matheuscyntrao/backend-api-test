#language: pt
Funcionalidade: ShoppingCart-CustomerController-GetCustomer_v1

  Esquema do Cenario: ShoppingCart-CustomerController-GetCustomer_v1 - <fluxo>
    Dado possuo dados para ShoppingCart - Customer - GetCustomer_v1 path:
      | shoppingCartId | <shoppingCartId> |
    Quando executo ShoppingCart - Customer - GetCustomer_v1
    Entao sistema processa ShoppingCart - Customer - GetCustomer_v1:
      | statusCode | <statusCode> |
      | message    | <message>    |

    @FB @regressao
    Exemplos:
      | fluxo | shoppingCartId           | statusCode | message |
      | FB    | 5f7db9a12c9b3a7100c3de83 | 200        |         |
    @FE @regressao
    Exemplos:
      | fluxo                | shoppingCartId           | statusCode | message                 |
      | FE001-Não encontrado | 5f4509c5c544df27a50ea5b1 | 404        | Carrinho não encontrado |