#language: pt
@pedido-ecommerce-service
Funcionalidade: PedidoEcommerce-v1-GetCarrinhoNumerocarrinhoPedidos

  Select de apoio:
  SELECT NUMERO_DO_PEDIDO, CODIGO_DA_SITUACAO_PEDIDO, NUMERO_DO_CARRINHO
  FROM ALO_PEDIDOS ALO
  WHERE NUMERO_DO_CARRINHO = #{numeroCarrinho}


  Esquema do Cenario: PedidoEcommerce-v1-GetCarrinhoNumerocarrinhoPedidos - <fluxo>
    Dado que possuo dados para PedidoEcommerce - v1 - GetCarrinhoNumerocarrinhoPedidos path:
      | numeroCarrinho | <numeroCarrinho> |
    Quando executo PedidoEcommerce - v1 - GetCarrinhoNumerocarrinhoPedidos
    Entao sistema processa PedidoEcommerce - v1 - GetCarrinhoNumerocarrinhoPedidos:
      | statusCode   | <statusCode>   |
      | statusPedido | <statusPedido> |
      | message      | <message>      |

    @FB @regressao
    Exemplos:
      | fluxo         | numeroCarrinho | statusCode | statusPedido | message |
      | FB - Status 7 | 3275207        | 200        | 7            |         |
    @FA @regressao
    Exemplos:
      | fluxo             | numeroCarrinho | statusCode | statusPedido | message |
      | FA001 - Status 11 | 3278715        | 200        | 11           |         |
      | FA002 - Status 6  | 4148293        | 200        | 6            |         |
      | FA003 - Status 10 | 4148287        | 200        | 10           |         |
    @FE @regressao
    Exemplos:
      | fluxo                 | numeroCarrinho | statusCode | statusPedido | message                        |
      | FE001 - Nao Existente | -2             | 404        |              | Não há pedidos para o carrinho |

