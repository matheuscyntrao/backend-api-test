#language: pt
@pedido-ecommerce-service
Funcionalidade: PedidoEcommerce-v1-GetCarrinhoNumerocarrinho

  Select de apoio:
  SELECT
  NUMERO_DO_CARRINHO as numeroCarrinho,
  CODIGO_DA_ENTIDADE_COMERCIAL as codigoEntidadeComercial,
  DATA_DO_CARRINHO as dataCarrinho,
  NOME_DO_CARRINHO as nomeCarrinho
  FROM ECM_CARRINHOS_DE_COMPRAS
  WHERE NUMERO_DO_CARRINHO = 3275207


  Esquema do Cenario: PedidoEcommerce-v1-GetCarrinhoNumerocarrinhoPedidos - <fluxo>
    Dado que possuo dados para PedidoEcommerce - v1 - GetCarrinhoNumerocarrinho path:
      | numeroCarrinho | <numeroCarrinho> |
    Quando executo PedidoEcommerce - v1 - GetCarrinhoNumerocarrinho
    Entao sistema processa PedidoEcommerce - v1 - GetCarrinhoNumerocarrinho:
      | statusCode | <statusCode> |
      | message    | <message>    |

    @FB @regressao
    Exemplos:
      | fluxo | numeroCarrinho | statusCode | message |
      | FB    | 3275207        | 204        |         |
    @FE @regressao
    Exemplos:
      | fluxo                  | numeroCarrinho | statusCode | message                  |
      | FE001 - Nao encontrado | 99999999       | 404        | Carrinho nao encontrado. |

