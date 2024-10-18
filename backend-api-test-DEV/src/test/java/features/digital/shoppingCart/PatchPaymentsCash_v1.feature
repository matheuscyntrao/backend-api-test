#language: pt
Funcionalidade: ShoppingCart-PaymentController-PatchPaymentsCash_v1

  Esquema do Cenario: ShoppingCart-ShoppingCartController-PatchItemCodItem_v1 - <fluxo>
    Dado que possuo dados para ShoppingCart - Payment - PatchPaymentsCash:
      | givenValue   | paymentMethodValue   |
      | <givenValue> | <paymentMethodValue> |
    Dado que possuo dados para ShoppingCart - Payment - PatchPaymentsCash path:
      | shoppingCartCode | <shoppingCartCode> |
    Quando executo ShoppingCart - Payment - PatchItemCodItem_v1
    Entao sistema processa ShoppingCart - Payment - PatchItemCodItem_v1:
      | statusCode | <statusCode> |
      | message    | <message>    |



    @FB @regressao
    Exemplos:
      | fluxo | shoppingCartCode         | givenValue | paymentMethodValue | statusCode | message |
      | FB    | 5f5cc0a3c544df184a76f26c | 50.0       | 22.99              | 200        |         |
