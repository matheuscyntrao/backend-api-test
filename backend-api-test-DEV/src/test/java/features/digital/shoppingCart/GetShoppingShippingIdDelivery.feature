#language: pt
Funcionalidade: ShoppingCart-ShippingController-GetShippingDelivery_v1

  Esquema do Cenario: Get Shipping Delivery v1 - <fluxo>
    Dado possuo dados para ShoppingCart - Shipping - GetShippingDelivery_v1 path:
      | shoppingCartId | <shoppingCartId> |
    Quando executo ShoppingCart - Shipping - GetShippingDelivery_v1
    Entao sistema processa ShoppingCart - Shipping - GetShippingDelivery_v1:
      | statusCode | <statusCode> |
      | message    | <message>    |

    @FB @regressao
    Exemplos:
      | fluxo | shoppingCartId           | statusCode | message |
      | FB    | 60071ca02c9b3a773102f7cd | 200        |         |
    @FE @regressao
    Exemplos:
      | fluxo                | shoppingCartId           | statusCode | message                 |
      | FE001-Não encontrado | 5f4509c5c544df27a50ea5b1 | 404        | Carrinho não encontrado |