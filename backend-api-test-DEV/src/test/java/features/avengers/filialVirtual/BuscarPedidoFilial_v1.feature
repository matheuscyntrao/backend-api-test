#language: pt
@filial-virtual-service
Funcionalidade: Buscar pedido por filial - v1

  Esquema do Cenario: Busca de pedido por filial - v1 <fluxo>
    Dado possuo dados para FilialVirtual - v1 - GetPedidoFilial path:
      | pedido | <pedido> |
      | filial | <filial> |
    Quando executo FilialVirtual - v1 - GetPedidoFilial
    Entao sistema processa FilialVirtual - v1 - GetPedidoFilial:
      | statusCode | <statusCode> |

    @FB @regressao
    Exemplos:
      | fluxo | pedido   | filial | statusCode |
      | FB    | 18841116 | 101    | 200        |
