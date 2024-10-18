#language: pt
@shopping-cart-service
Funcionalidade: ShoppingCart-ShoppingCart-Item

  Esquema do Cenario: ShoppingCart-ShoppingCart-Item - <fluxo>
    Dado que executo ShoppingCart - ShoppingCart - PutShopping_v1 "NAO_IDENTIFICADO"
    E possuo dados para ShoppingCart-ShoppingCart-Item:
      | panvelCode   | quantity   |
      | <panvelCode> | <quantity> |
    Quando executo ShoppingCart-ShoppingCart-Item
    Entao sistema processa ShoppingCart-ShoppingCart-Item:
      | statusCode | <statusCode> |

    @FB @regressao
    Exemplos:
      | fluxo | panvelCode | quantity | statusCode | message |
      | FB    | 84689      | 2        | 200        |         |
