#language: pt
@order-service
Funcionalidade: Post Order - v1 - EcommerceOrders

  Esquema do Cenario: Post Order - v1 - EcommerceOrders <fluxo>
    Dado efetuo Cliente - v2 - PostCliente generate do tipo "<TIPO_CLIENTE>"
    E possuo dados para Post Order - v1 - EcommerceOrders generate:
      | TIPO_PEDIDO  | <TIPO_PEDIDO>  |
      | TIPO_ENTREGA | <TIPO_ENTREGA> |
    Quando executo Post Order - v1 - EcommerceOrders
    Entao sistema processa Post Order - v1 - EcommerceOrders:
      | statusCode | <statusCode> |

    @FB @regressao
    Exemplos:
      | fluxo | TIPO_CLIENTE     | TIPO_PEDIDO    | TIPO_ENTREGA       |
      | FB    | CLIENTE_COMPLETO | PEDIDO_SIMPLES | ENTREGA_PROGRAMADA |

