#language: pt
Funcionalidade: ShoppingCart-Shipping-GetPickup_v1

  Esquema do Cenario: ShoppingCart-Shipping-GetPickup_v1 - <fluxo>
    Dado possuo dados para ShoppingCart - Shipping - GetPickup_v1 path:
      | shoppingCartId | <shoppingCartId> |
    Dado possuo dados para ShoppingCart - Shipping - GetPickup_v1 param:
      | subsidiaries | <subsidiaries> |
    Quando executo ShoppingCart - Shipping - GetPickup_v1
    Entao sistema processa ShoppingCart - Shipping - GetPickup_v1:
      | statusCode | <statusCode> |
      | message    | <message>    |

    @FB @regressao
    Exemplos:
      | fluxo | shoppingCartId           | subsidiaries | statusCode | message |
      | FB    | 5f7db9a12c9b3a7100c3de83 | 701          | 200        |         |
    @FE @regressao
    Exemplos:
      | fluxo                         | shoppingCartId           | subsidiaries | statusCode | message                                |
      | FE001-Carrinho não encontrado | 5f5cdc5fc544df32ac7c2df1 | 701          | 404        | Carrinho não encontrado                |
      | FE002-Loja inexistente        | 5f5cdc5fc544df32ac7c2dfa | 999          | 404        | Não há lojas disponíveis para retirada |