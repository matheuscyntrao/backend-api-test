#language: pt
Funcionalidade: ShoppingCart-PaymentController-GetShoppingShoppingcartcodePaymentsPos_v1

  Esquema do Cenario: Get Shoppingcartcode Payments Pos v1 - <fluxo>
    Dado possuo dados para ShoppingCart - Payment - GetShoppingcartcodePaymentsPos_v1 path:
      | shoppingCartCode | <shoppingCartCode> |
    Quando executo ShoppingCart - Payment - GetShoppingcartcodePaymentsPos_v1
    Entao sistema processa ShoppingCart - Payment - GetShoppingcartcodePaymentsPos_v1:
      | statusCode | <statusCode> |
      | message    | <message>    |
      | issue      | <issue>      |

    @FB @regressao
    Exemplos:
      | fluxo | shoppingCartCode         | statusCode | message |
      | FB    | 5f8db155c544df503252f363 | 200        |         |
    @FE @regressao
    Exemplos:
      | fluxo                           | shoppingCartCode         | statusCode | message                 | issue                              |
      | FE001 - Não encontrado          | 5f5cdc5fc544df32ac7c2df1 | 404        | Carrinho não encontrado |                                    |
      | FE002 - Entrega nao permite POS | 5f8db155c544df503252f363 | 400        |                         | Entrega não permite pagamento POS. |
