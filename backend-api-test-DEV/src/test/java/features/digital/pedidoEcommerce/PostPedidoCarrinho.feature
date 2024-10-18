#language: pt
@pedido-ecommerce-service
Funcionalidade: PedidoEcommerce-v1-PostPedidoCarrinho

  Select de apoio:
  INSERT INTO ECM_CARRINHOS_DE_COMPRAS (
  NUMERO_DO_CARRINHO,
  CODIGO_DA_ENTIDADE_COMERCIAL,
  DATA_DO_CARRINHO,
  NOME_DO_CARRINHO)
  VALUES (
  {numeroCarrinho},
  {codigoEntidadeComercial},
  {dataCarrinho, jdbcType=DATE},
  {nomeCarrinho,jdbcType=NVARCHAR} )


  Esquema do Cenario: PedidoEcommerce-v1-PostPedidoCarrinho - <fluxo>
    Dado que possuo dados para PedidoEcommerce - v1 - PostPedidoCarrinho:
      | codigoEntidadeComercial   |
      | <codigoEntidadeComercial> |
    Quando executo PedidoEcommerce - v1 - PostPedidoCarrinho
    Entao sistema processa PedidoEcommerce - v1 - PostPedidoCarrinho:
      | statusCode | <statusCode> |
      | message    | <message>    |

    @FB @regressao
    Exemplos:
      | fluxo | codigoEntidadeComercial | statusCode | message |
      | FB    | 7156451                 | 200        |         |
    @FE @regressao
    Exemplos:
      | fluxo                        | codigoEntidadeComercial | statusCode | message                                             |
      | FE001 - null                 | null                    | 400        | está batendo no banco desnacessariamente            |
      | FE002 - invalido             | -5                      | 400        | está batendo no banco desnacessariamente            |
      | FE003 - Entidade Inexistente | 99                      | 400        | Tentou gravar antes de ver se a entidade era valida |

