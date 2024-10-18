#language: pt
Funcionalidade: ShoppingCart-Payment-Payments_v1

  Esquema do Cenario: ShoppingCart-Payment-Payments_v1 - <fluxo>
    Dado possuo dados para ShoppingCart - Payment - GetPayments_v1 path:
      | shoppingCartCode | <shoppingCartId> |
    Quando executo ShoppingCart - Payment - GetPayments_v1
    Entao sistema processa ShoppingCart - Payment - GetPayments_v1:
      | statusCode | <statusCode> |
      | message    | <message>    |

    @FB @regressao
    Exemplos:
      | fluxo | shoppingCartId           | statusCode | message |
      | FB    | 5f7db9a12c9b3a7100c3de83 | 200        |         |
    @FE @regressao
    Exemplos:
      | fluxo                         | shoppingCartId           | statusCode | message                 |
      | FE001-Carrinho não encontrado | 5f5cdc5fc544df32ac7c2df1 | 404        | Carrinho não encontrado |