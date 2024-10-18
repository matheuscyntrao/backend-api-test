#language: pt
@pedido-ecommerce-service
Funcionalidade: PedidoEcommerce-v1-GetPedidoIdentificadorclienteHistorico

  Select de apoio:


  Esquema do Cenario: PedidoEcommerce-v1-GetPedidoIdentificadorclienteHistorico - <fluxo>
    Dado que possuo dados para PedidoEcommerce - v1 - GetPedidoIdentificadorclienteHistorico:
      | identificadorCliente | <identificadorCliente> |
    Quando executo PedidoEcommerce - v1 - GetPedidoIdentificadorclienteHistorico
    Entao sistema processa PedidoEcommerce - v1 - GetPedidoIdentificadorclienteHistorico:
      | statusCode | <statusCode> |
      | message    | <message>    |

    @FB @regressao
    Exemplos:
      | fluxo | identificadorCliente | statusCode | message |
      | FB    | 00415559022          | 200        |         |
