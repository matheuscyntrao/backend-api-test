#language: pt
Funcionalidade: ShoppingCart-Shopping-GetShoppingShoppingcartid_v1

  Esquema do Cenario: Get Shoppingcartcode Payments v1 - <fluxo>
    Dado possuo dados para ShoppingCart - Shopping - GetShoppinShoppingcartid path:
      | shoppingCartId | <shoppingCartId> |
    Quando executo ShoppingCart - Shopping - GetShoppinShoppingcartid
    Entao sistema processa ShoppingCart - Shopping - GetShoppinShoppingcartid:
      | statusCode | <statusCode> |
      | message    | <message>    |

    @FB @regressao
    Exemplos:
      | fluxo | shoppingCartId           | statusCode | message |
      | FB    | 5f7db9a12c9b3a7100c3de83 | 200        |         |
    @FE @regressao
    Exemplos:
      | fluxo                  | shoppingCartId           | statusCode | message                 |
      | FE001 - Não encontrado | 5f3157ddc544df0cfce13f41 | 404        | Carrinho não encontrado |
