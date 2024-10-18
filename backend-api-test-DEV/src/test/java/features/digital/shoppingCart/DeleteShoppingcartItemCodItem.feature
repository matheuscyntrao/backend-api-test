#language: pt
@shopping-cart-service
Funcionalidade: ShoppingCart-ShoppingCartController-DeleteItemCodItem_v1

  Esquema do Cenario: ShoppingCart-ShoppingCartController-DeleteItemCodItem_v1 - <fluxo>
    Dado que executo ShoppingCart - ShoppingCart - PutShopping_v1 "NAO_IDENTIFICADO"
    E executo ShoppingCart - ShoppingCart - PatchItemCodItem_v1 path "<codItem>"
    E que possuo dados para ShoppingCart - ShoppingCart - DeleteItemCodItem_v1 path
    Quando executo ShoppingCart - ShoppingCart - DeleteItemCodItem_v1
    Entao sistema processa ShoppingCart - ShoppingCart - DeleteItemCodItem_v1:
      | statusCode | <statusCode> |
      | message    | <message>    |


    @FB @regressao
    Exemplos:
      | fluxo | codItem | statusCode | message |
      | FB    | 502320  | 200        |         |
