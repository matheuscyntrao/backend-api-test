#language: pt
@order-service
Funcionalidade: Post Order - v1

  Esquema do Cenario: Post Order - v1 <fluxo>
    Dado possuo dados para Order - v1 - PostEcommerceOrders "<order>"
    Quando executo Order - v1 - PostEcommerceOrders
    Entao sistema processa Order - v1 - PostEcommerceOrders:
      | statusCode | <statusCode> |

    @FB @regressao
    Exemplos:
      | fluxo | order         | statusCode |
      | FB    | ORDER_SIMPLES | 200        |
