#language: pt
Funcionalidade: ShoppingCart-ShippingController-GetShoppingShipping_v1

  @FB @regressao
  Cenario: Get Shopping Shipping
    Dado possuo dados para ShoppingCart - Shipping - GetShoppingShipping_v1
    Quando executo ShoppingCart - Shipping - GetShoppingShipping_v1
    Entao sistema processa ShoppingCart - Shipping - GetShoppingShipping_v1:
      | statusCode | 200 |

