#language: pt
@shopping-cart-service @hookShoppingCartControllerPatchItemCodItem_v1
Funcionalidade: ShoppingCart-ShoppingCartController-PatchItemCodItem_v1

  Esquema do Cenario: ShoppingCart-ShoppingCartController-PatchItemCodItem_v1 - <fluxo>
    Dado que executo ShoppingCart - ShoppingCart - PutShopping_v1 "NAO_IDENTIFICADO"
    Dado executo ShoppingCart - ShoppingCart - PatchItemCodItem_v1 path "<code>"
    Quando executo ShoppingCart - ShoppingCart - PatchItemCodItem_v1
    Entao sistema processa ShoppingCart - ShoppingCart - PatchItemCodItem_v1:
      | statusCode | <statusCode> |
      | message    | <message>    |
    E valido ShoppingCart - ShoppingCart - PatchItemCodItem_v1



    @FB @regressao
    Exemplos:
      | fluxo | code   | statusCode | message |
      | FB    | 502320 | 200        |         |
