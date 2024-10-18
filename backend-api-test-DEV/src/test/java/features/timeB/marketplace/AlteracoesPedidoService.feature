#language: pt
@pedido-service @marketplace
Funcionalidade: Alteracoes pedido-service Marketplace - v1

  Esquema do Cenario: Alteracoes pedido-service Marketplace - v1 <fluxo>
    Dado possuo dados para Pedido - v2 - GetPedido path:
      | pedido | <pedido> |
    Quando executo Pedido - v2 - GetPedido
    Entao sistema processa Pedido - v2 - GetPedido Marketplace:
      | statusCode | <statusCode> |
      | message    | <message>    |
    E valido Pedido - v2 - GetPedido Marketplace
      | origemDesconto | <origemDesconto> |

    @FB @regressao
    Exemplos:
      | fluxo | pedido         | origemDesconto | statusCode | message |
      | FB    | 12003167435003 |                | 200        |         |
      | FB    | 12070167054464 | 22             | 200        |         |


