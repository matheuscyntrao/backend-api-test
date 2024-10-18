#language: pt
@filial-virtual-service @marketplace
Funcionalidade: Alteracoes filial-virtual-service Marketplace - v1

  Esquema do Cenario: Alteracoes filial-virtual-service Marketplace - v1 <fluxo>
    Dado possuo dados para FilialVirtual - v1 - GetPedidoFilial path:
      | pedido | <pedido> |
      | filial | <filial> |
    Quando executo FilialVirtual - v1 - GetPedidoFilial
    Entao sistema processa FilialVirtual - v1 - GetPedidoFilial Marketplace:
      | statusCode | <statusCode> |
    E valido FilialVirtual - v1 - GetPedidoFilial Marketplace
      | origemDesconto | <origemDesconto> |

    @FB @regressao
    Exemplos:
      | fluxo | pedido         | origemDesconto | filial | statusCode |
      | FB    | 12003167435003 |                | 200    |            |
      | FB    | 12070167054464 | 22             | 101    | 200        |
