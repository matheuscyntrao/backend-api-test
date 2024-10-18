#language: pt
Funcionalidade: ShoppingCart-PaymentController-GetShoppingShoppingcartcodePayments_v1

  Esquema do Cenario: Get Shoppingcartcode Payments v1 - <fluxo>
    Dado possuo dados para ShoppingCart - Payment - GetShoppingcartcodePayments_v1 path:
      | shoppingCartCode | <shoppingCartCode> |
    Quando executo ShoppingCart - Payment - GetShoppingcartcodePayments_v1
    Entao sistema processa ShoppingCart - Payment - GetShoppingcartcodePayments_v1:
      | statusCode | <statusCode> |
      | message    | <message>    |

    @FB @regressao
    Exemplos:
      | fluxo | shoppingCartCode         | statusCode | message |
      | FB    | 602e5f1eb6a46d2a780b6dc2 | 200        |         |
    @FE @regressao
    Exemplos:
      | fluxo                  | shoppingCartCode         | statusCode | message                 |
      | FE001 - Não encontrado | 5f3157ddc544df0cfce13f41 | 404        | Carrinho não encontrado |
