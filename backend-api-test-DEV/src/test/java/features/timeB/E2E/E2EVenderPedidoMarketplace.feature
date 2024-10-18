#language: pt
@pedido-service @marketplace @pedidos-marketplace
Funcionalidade: Venda de pedidos Marketplace - v1

  Esquema do Cenario: Venda de pedidos Marketplace - v1 <fluxo>
    Dado que efetuo MarketplaceSeller - v1 - Import de pedidos: "<fluxo>"
      | statusCode | <statusCode> |
      | message    | <message>    |
    Quando efetuo Phw31tst - v1 - Venda
    E sistema processa Phw31tst - v1 - Venda:
      | statusCode | <statusCode> |
      | message    | <message>    |
    E valido Pedido - v2 - GetPedido Marketplace
      | origemDesconto | <origemDesconto> |

    @FB @regressao
    Exemplos:
      | fluxo          | origemDesconto | statusCode | message |
      | PEDIDO_SIMPLES |                | 200        |         |

    @FA
    Exemplos:
      | fluxo               | origemDesconto | statusCode | message |
      | PEDIDO_COM_DESCONTO | 22             | 200        |         |